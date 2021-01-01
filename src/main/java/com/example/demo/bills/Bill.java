package com.example.demo.bills;

import java.util.List;

public class Bill {
	private int id;
	private String createdBy;
	private String paidBy;
	private List<String> members; // List<Splitter> --> Splitter can be User or Group
	private boolean isSettled;
	private long amount;

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Bill() {
		
	}
	
	public Bill(int id, String createdBy, String paidBy, List<String> members, long amount) {
		super();
		this.id = id;
		this.createdBy = createdBy;
		this.paidBy = paidBy;
		this.members = members;
		this.amount = amount;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getPaidBy() {
		return paidBy;
	}
	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}
	public List<String> getMembers() {
		return members;
	}
	public void setMembers(List<String> members) {
		this.members = members;
	}
	public boolean isSettled() {
		return isSettled;
	}
	public void setSettled(boolean isSettled) {
		this.isSettled = isSettled;
	}
}
