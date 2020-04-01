package com.bank.sevice.Impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.constant.Constant;
import com.bank.dto.TransactionRequestDto;
import com.bank.dto.TransactionResponseDto;
import com.bank.entity.Account;
import com.bank.entity.Transaction;
import com.bank.exception.AccountNotFoundException;
import com.bank.exception.FundTransferLimitExceededException;
import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionRepository;
import com.bank.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public TransactionResponseDto transferAmount(TransactionRequestDto transactionRequestDto)
			throws AccountNotFoundException, FundTransferLimitExceededException 
	{
		Account account = accountRepository.findByAccountNumber(transactionRequestDto.getFromAccount());
		if (account==null) {
			throw new AccountNotFoundException(transactionRequestDto.getFromAccount());
		}

		Account account2 = accountRepository.findByAccountNumber(transactionRequestDto.getToAccount());
		if (account2 == null) {
			throw new AccountNotFoundException(transactionRequestDto.getToAccount());
		}
		if (transactionRequestDto.getTransferAmount() >= Constant.Transfer_Limit)
		{
			throw new FundTransferLimitExceededException(transactionRequestDto.getTransferAmount());
		}
			Double balance;
			if (transactionRequestDto.getTransferAmount() >= 1 && transactionRequestDto.getTransferAmount() <= 1000) {
				balance = (account.getAccountBalance() * 0.4) / 100;
				account.setAccountBalance(
						account.getAccountBalance() - transactionRequestDto.getTransferAmount() - balance);
				accountRepository.save(account);
				balance = transactionRequestDto.getTransferAmount() - Constant.Exchange_Rate;
				account2.setAccountBalance(account2.getAccountBalance() - balance);
				accountRepository.save(account2);
			} else if (transactionRequestDto.getTransferAmount() >= 1001
					&& transactionRequestDto.getTransferAmount() <= 2500) {
				balance = (account.getAccountBalance() * 0.3) / 100;
				account.setAccountBalance(
						account.getAccountBalance() - transactionRequestDto.getTransferAmount() - balance);
				accountRepository.save(account);
				balance = transactionRequestDto.getTransferAmount() - Constant.Exchange_Rate;
				account2.setAccountBalance(account2.getAccountBalance() - balance);
				accountRepository.save(account2);
			} else if (transactionRequestDto.getTransferAmount() >= 2501
					&& transactionRequestDto.getTransferAmount() <= 5000) {
				balance = (account.getAccountBalance() * 0.2) / 100;
				account.setAccountBalance(
						account.getAccountBalance() - transactionRequestDto.getTransferAmount() - balance);
				accountRepository.save(account);
				balance = transactionRequestDto.getTransferAmount() - Constant.Exchange_Rate;
				account2.setAccountBalance(account2.getAccountBalance() - balance);
				accountRepository.save(account2);
			} else {
				balance = (account.getAccountBalance() * 0.1) / 100;
				account.setAccountBalance(
						account.getAccountBalance() - transactionRequestDto.getTransferAmount() - balance);
				accountRepository.save(account);
				balance = transactionRequestDto.getTransferAmount() - Constant.Exchange_Rate;
				account2.setAccountBalance(account2.getAccountBalance() - balance);
				accountRepository.save(account2);
			}
			
			Transaction transaction=new Transaction();
			transaction.setFromAccount(transactionRequestDto.getFromAccount());
			transaction.setToAccount(transactionRequestDto.getToAccount());
			transaction.setTransferAmount(transactionRequestDto.getTransferAmount());
			transaction.setTransferDate(LocalDateTime.now());
			transactionRepository.save(transaction);

		TransactionResponseDto responseDto=new TransactionResponseDto();
		responseDto.setMessage(Constant.Success_Message);
		responseDto.setStatusCode(Constant.Success_Code);
		
		return responseDto;
	}

}
