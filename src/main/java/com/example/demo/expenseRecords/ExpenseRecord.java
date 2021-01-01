package com.example.demo.expenseRecords;

import java.util.Date;

import com.example.demo.bills.Bill;

public class ExpenseRecord {

	private String from;
	private String to;
	private long amount;
	private Bill bill;
	private Date createdOn;
	
	public ExpenseRecord() {}
	
	public ExpenseRecord(String from, String to, long amount, Bill bill, Date createdOn) {
	 super();
	 this.from = from;
	 this.to = to;
	 this.amount = amount;
	 this.bill = bill;
	 this.createdOn = createdOn;
	}

	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
