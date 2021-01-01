package com.example.demo.expenseRecords;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseRecordController {
	
		@Autowired
		private ExpenseService expenseService;
		
		@RequestMapping("/expenseRecords")
		public List<ExpenseRecord> listAllExpenseRecords() {
			return expenseService.listAllExpenseRecords();
		}
		
		@RequestMapping("/summary/{userName}")
		public ExpenseOverview getSummaryOfUser(@PathVariable String userName) {
			System.out.print("User name in request: ");
			System.out.println(userName);
			return expenseService.calculateSummaryOnUser(userName);
		}
}
