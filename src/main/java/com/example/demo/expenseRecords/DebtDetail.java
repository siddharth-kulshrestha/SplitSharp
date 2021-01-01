package com.example.demo.expenseRecords;

public class DebtDetail {
	private String user;
	private long amount;
	
	public DebtDetail() {}
	
	public DebtDetail(String user, long amount) {
		this.user = user;
		this.amount = amount;
	}
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
}