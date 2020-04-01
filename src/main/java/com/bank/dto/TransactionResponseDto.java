package com.bank.dto;

public class TransactionResponseDto {

	private Integer statusCode;
	private String message;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "TransactionResponseDto [statusCode=" + statusCode + ", message=" + message + "]";
	}

	public TransactionResponseDto() {
		super();
	}

}
