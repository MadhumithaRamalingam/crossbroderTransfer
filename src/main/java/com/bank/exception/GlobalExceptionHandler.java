package com.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bank.constant.Constant;
import com.bank.dto.TransactionResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AccountNotFoundException.class)
	ResponseEntity<TransactionResponseDto> accountNotFoundException(AccountNotFoundException exception)
	{
		TransactionResponseDto responseDto=new TransactionResponseDto();
		responseDto.setMessage(exception.getMessage());
		responseDto.setStatusCode(Constant.Error_Status);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);	
	}
	
	@ExceptionHandler(FundTransferLimitExceededException.class)
	ResponseEntity<TransactionResponseDto> fundTransferLimitExceededException(FundTransferLimitExceededException exception)
	{
		TransactionResponseDto responseDto=new TransactionResponseDto();
		responseDto.setMessage(exception.getMessage());
		responseDto.setStatusCode(Constant.Error_Status);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);	
	}


}
