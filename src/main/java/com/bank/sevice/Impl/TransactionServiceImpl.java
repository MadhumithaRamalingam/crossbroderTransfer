package com.bank.sevice.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.TransactionRequestDto;
import com.bank.dto.TransactionResponseDto;
import com.bank.entity.Account;
import com.bank.exception.AccountNotFoundException;
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
	public TransactionResponseDto transferAmount(TransactionRequestDto transactionRequestDto) throws AccountNotFoundException {
		Optional<Account> account=accountRepository.findByAccountNumber(transactionRequestDto.getFromAccount());
		if(!account.isPresent())
		{
			throw new AccountNotFoundException(transactionRequestDto.getFromAccount());
		}
		return null;
	}

}
