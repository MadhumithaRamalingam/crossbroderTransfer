package com.bank.exception;

import com.bank.constant.Constant;

public class FundTransferLimitExceededException extends Exception {

	private static final long serialVersionUID = 1L;
public Integer statusCode=Constant.Error_Status;
	
	public FundTransferLimitExceededException(Double amount)
	{
		super("Transfer Amount: "+ amount+" is exceed the daily limit");
	}
	 public static Integer getStatusCode()
	 {
		 return getStatusCode();
	 }

}
