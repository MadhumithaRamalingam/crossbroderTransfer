package com.bank.exception;

import com.bank.constant.Constant;

public class AccountNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public Integer statusCode=Constant.Error_Status;
	
	public AccountNotFoundException(Long accountNumber)
	{
		super("AccountNumber: "+ accountNumber+" is not found");
	}
	 public static Integer getStatusCode()
	 {
		 return getStatusCode();
	 }

}
