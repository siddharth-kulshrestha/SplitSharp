package com.example.demo.expenseRecords;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.bills.Bill;
import com.example.demo.expenseRecords.ExpenseRecord;

@Service
public class ExpenseService {
		List<ExpenseRecord> expenseRecords = Arrays.asList(
					new ExpenseRecord("Sumit", "Tany", 500, null, new Date()),
					new ExpenseRecord("Sid", "Tany", 500, null, new Date()),
					new ExpenseRecord("Tany", "Ash", 500, null, new Date()),
					new ExpenseRecord("Ash", "Martand", 500, null, new Date())
				);
		
		public List<ExpenseRecord> listAllExpenseRecords() {
			return expenseRecords;
		}
		
		public List<ExpenseRecord> getAllExpenseRecordsByFrom(String from) {
			return expenseRecords.stream().filter(expRec -> expRec.getFrom().equals(from)).collect(Collectors.toList());
		}
		
		public List<ExpenseRecord> getAllExpenseRecordsByTo(String to) {
			return expenseRecords.stream().filter(expRec -> expRec.getTo().equals(to)).collect(Collectors.toList());
		}
		
		public List<ExpenseRecord> getAllExpenseRecordsByBill(Bill bill) {
			return expenseRecords.stream().filter(expRec -> expRec.getBill().getId() == bill.getId()).collect(Collectors.toList());
		}
		
		public void generateExpenseRecordsForBill(Bill bill) {
			long amt = bill.getAmount()/bill.getMembers().size();
			List<String> members = bill.getMembers();
			String paidBy = bill.getCreatedBy();
			
			for(String member: bill.getMembers()) {
				expenseRecords.add(new ExpenseRecord(paidBy, member, amt, bill, new Date()));
			}
		}
		
		public void addExpenseRecord(String paidBy, String paidTo, long amount, Bill bill, Date date) {
			expenseRecords.add(new ExpenseRecord(paidBy, paidTo, amount, bill, date));
		}
		
		public ExpenseOverview calculateSummaryOnUser(String user) {
			List<ExpenseRecord> userToExpenseRecords = this.getAllExpenseRecordsByTo(user);
			List<ExpenseRecord> userFromExpenseRecords = this.getAllExpenseRecordsByFrom(user);
			HashMap<String, Long>  userReducedAmount = new HashMap<String, Long>();
			for (ExpenseRecord er : userToExpenseRecords) {
				if (userReducedAmount.containsKey(er.getFrom())) {
						userReducedAmount.put(er.getFrom(), userReducedAmount.get(er.getFrom()) - er.getAmount());
				} else {
					userReducedAmount.put(er.getFrom(), -1 * er.getAmount());
				}
			}
			for (ExpenseRecord er : userFromExpenseRecords) {
				if (userReducedAmount.containsKey(er.getTo())) {
						userReducedAmount.put(er.getTo(), userReducedAmount.get(er.getTo()) + er.getAmount());
				} else {
					userReducedAmount.put(er.getTo(), er.getAmount());
				}
			}
			return new ExpenseOverview(user, userReducedAmount);
		} 
}
