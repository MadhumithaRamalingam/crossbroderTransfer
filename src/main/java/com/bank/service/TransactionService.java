package com.bank.service;

import com.bank.dto.TransactionRequestDto;
import com.bank.dto.TransactionResponseDto;
import com.bank.exception.AccountNotFoundException;
import com.bank.exception.FundTransferLimitExceededException;

public interface TransactionService {

	public TransactionResponseDto transferAmount(TransactionRequestDto transactionRequestDto)
			throws AccountNotFoundException, FundTransferLimitExceededException;

}
