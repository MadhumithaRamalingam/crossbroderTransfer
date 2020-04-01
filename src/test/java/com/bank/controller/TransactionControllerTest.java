package com.bank.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.bank.constant.Constant;
import com.bank.dto.TransactionRequestDto;
import com.bank.dto.TransactionResponseDto;
import com.bank.entity.Account;
import com.bank.exception.AccountNotFoundException;
import com.bank.exception.FundTransferLimitExceededException;
import com.bank.service.TransactionService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionControllerTest {
	
	@InjectMocks
	TranscationController transcationController;
	
	@Mock
	TransactionService transactionService;
	Account account=new Account();
	Account account2=new Account();
	TransactionRequestDto transactionRequestDto=new TransactionRequestDto();
	TransactionResponseDto transactionResponseDto=new TransactionResponseDto();
	
	@Before
	public void before()
	{
		
		account.setAccountId(1L);
		account.setAccountNumber(1L);
		account.setAccountType("savings");
		account.setAccountHolderName("madhu");
		account.setIfscCode("SBI001");
		account.setAccountBalance(20000.00);
		account.setCountry("india");
		
		
		account2.setAccountId(2L);
		account2.setAccountNumber(2L);
		account2.setAccountType("savings");
		account2.setAccountHolderName("charles");
		account2.setIfscCode("CBRT001");
		account2.setAccountBalance(20000.00);
		account2.setCountry("australia");
		
		
		transactionRequestDto.setFromAccount(1L);
		transactionRequestDto.setToAccount(2L);
		transactionRequestDto.setTransferAmount(2000.00);
		
		
		transactionResponseDto.setMessage(Constant.Success_Message);
		transactionResponseDto.setStatusCode(Constant.Success_Code);
	}
	
	@Test
	public void testTransferFund() throws AccountNotFoundException, FundTransferLimitExceededException
	{
		Mockito.when(transactionService.transferAmount(transactionRequestDto)).thenReturn(transactionResponseDto);
		ResponseEntity<TransactionResponseDto> response=transcationController.transferAmount(transactionRequestDto);
		assertNotNull(response);
	}

}
