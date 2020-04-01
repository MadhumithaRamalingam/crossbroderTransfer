package com.bank.dto;

public class TransactionRequestDto {
	
	private Long fromAccount;
	private Long toAccount;
	private Double transferAmount;
	
	public Long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Long getToAccount() {
		return toAccount;
	}
	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}
	public Double getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(Double transferAmount) {
		this.transferAmount = transferAmount;
	}
	
	
	public TransactionRequestDto() {
		super();
	}
	@Override
	public String toString() {
		return "TransactionRequestDto [fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", transferAmount="
				+ transferAmount + "]";
	}
	
	
	

}
