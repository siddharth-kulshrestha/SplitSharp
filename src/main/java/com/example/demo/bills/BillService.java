package com.example.demo.bills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bills.Bill;
import com.example.demo.expenseRecords.ExpenseService;

@Service
public class BillService {
	
	@Autowired
	 private ExpenseService expenseService;
	
	 List<Bill> bills = new ArrayList<Bill>(
			Arrays.asList(
				new	Bill(0, "Sid", "Tany", Arrays.asList("Sid", "Sumit", "Ash", "Martand"), 500),
				new Bill(1, "Tany", "Sid", Arrays.asList("Tany", "Sumit", "Ash", "Martand"), 600),
				new Bill(2, "Ash", "Martand", Arrays.asList("Tany", "Sumit", "Ash", "Sid"), 700))
			 );
	 
	 public List<Bill> getAllBills() {
		 return bills;
	 }
	 
	 public Bill getBillById(int id) {
		 return bills.stream().filter(bill -> bill.getId() == id).findFirst().get();
	 }
	 
	 //int id, String createdBy, String paidBy, List<String> members, long amount
	 public void addBill(Bill bill) {
		 bills.add(bill);
		 expenseService.generateExpenseRecordsForBill(bill);
	 }
	 
	 public void settleBill(int id) {
		 for(int i=0; i<bills.size(); i++) {
			 Bill billAtIdx = bills.get(i);
			 if (billAtIdx.getId() == id) {
				 billAtIdx.setSettled(true);
				 return;
			 }
		 }
	 }
}
