package com.example.demo.bills;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {
		
		@Autowired
		private BillService billService;
		
		@RequestMapping("/bills")
		public List<Bill> listAllBills() {
			return billService.getAllBills();
		}
		
		@RequestMapping("/bills/{id}")
		public Bill getBillById(@PathVariable int id) {
			return billService.getBillById(id);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/bills")
		public void addBill(@RequestBody Bill bill) {
			billService.addBill(bill);
		}

		@RequestMapping(method=RequestMethod.POST, value="/bills/{id}/settle")
		public void settleBill(@PathVariable int id) {
			billService.settleBill(id);
		}
}
