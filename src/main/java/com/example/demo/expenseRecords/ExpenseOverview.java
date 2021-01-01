package com.example.demo.expenseRecords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExpenseOverview {

	private String user;

	private long totalOwe;
	private long  totalOwed;
	private List<DebtDetail> oweDetails;
	private List<DebtDetail> owedDetails;
	
	public ExpenseOverview() {}
	
	public ExpenseOverview(String user, HashMap<String, Long> userReducedAmount) {
		Iterator itr = userReducedAmount.entrySet().iterator();
		oweDetails = new ArrayList<DebtDetail>();
		owedDetails = new ArrayList<DebtDetail>();
		totalOwed = 0;
		totalOwe = 0;
		while(itr.hasNext()) {
			Map.Entry pair = (Map.Entry)itr.next();
			if ((Long)pair.getValue() > 0) {
				oweDetails.add(new DebtDetail((String)pair.getKey(), (long)pair.getValue()));
				totalOwe += (long)pair.getValue();
			} else if ((Long)pair.getValue() < 0) {
				owedDetails.add(new DebtDetail((String)pair.getKey(), -1 * (long)pair.getValue()));
				totalOwed += (long)pair.getValue();
			}
		}
		totalOwed *= -1;
		this.user = user;			
	}	
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public long getTotalOwe() {
		return totalOwe;
	}

	public void setTotalOwe(long totalOwe) {
		this.totalOwe = totalOwe;
	}

	public long getTotalOwed() {
		return totalOwed;
	}

	public void setTotalOwed(long totalOwed) {
		this.totalOwed = totalOwed;
	}

	public List<DebtDetail> getOweDetails() {
		return oweDetails;
	}

	public void setOweDetails(List<DebtDetail> oweDetails) {
		this.oweDetails = oweDetails;
	}

	public List<DebtDetail> getOwedDetails() {
		return owedDetails;
	}

	public void setOwedDetails(List<DebtDetail> owedDetails) {
		this.owedDetails = owedDetails;
	}

}
