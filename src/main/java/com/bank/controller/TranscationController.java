package com.bank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.TransactionRequestDto;
import com.bank.dto.TransactionResponseDto;

@RestController
public class TranscationController {
	
	ResponseEntity<TransactionResponseDto> transferAmount(@RequestBody TransactionRequestDto transactionRequestDto)
	{
		return null;
		
	}

}
