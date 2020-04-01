package com.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.TransactionRequestDto;
import com.bank.dto.TransactionResponseDto;
import com.bank.exception.AccountNotFoundException;
import com.bank.exception.FundTransferLimitExceededException;
import com.bank.service.TransactionService;


@RestController
public class TranscationController {
	
	Logger log=LoggerFactory.getLogger(TranscationController.class);
	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/bank/fund")
	ResponseEntity<TransactionResponseDto> transferAmount(@RequestBody TransactionRequestDto transactionRequestDto) throws AccountNotFoundException, FundTransferLimitExceededException
	{
		TransactionResponseDto responseDto=transactionService.transferAmount(transactionRequestDto);
		return new ResponseEntity<TransactionResponseDto>(responseDto, HttpStatus.OK);
		
	}

}
