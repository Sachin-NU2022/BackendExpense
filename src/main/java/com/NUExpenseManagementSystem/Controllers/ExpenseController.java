package com.NUExpenseManagementSystem.Controllers;



import java.security.Principal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.NUExpenseManagementSystem.Models.ExpenseCategory;
import com.NUExpenseManagementSystem.Models.ExpenseInfoModel;
import com.NUExpenseManagementSystem.Models.User;
import com.NUExpenseManagementSystem.Repository.ExpenseRepository;
import com.NUExpenseManagementSystem.Repository.UserRepository;
import com.NUExpenseManagementSystem.Services.ExpenseService;

@CrossOrigin
@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;

	@GetMapping("/search")
	public List<ExpenseInfoModel> getExpense() {
		return this.expenseService.getExpense();
	}
	
	@GetMapping("/search/{searchId}")
	public ExpenseInfoModel getExpenseList(@PathVariable String searchId) {
		return this.expenseService.getExpenseList(Long.parseLong(searchId));
	}
	
	@GetMapping("/kensaku")
	public ResponseEntity<List<ExpenseInfoModel>> findByDateBetween(@RequestParam("query") String query, @RequestParam("query1")   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String query1,
		@RequestParam("query2") String query2, @RequestParam("query3")   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String query3,
		@RequestParam("query4") String query4, @RequestParam("query5")   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String query5){
		return ResponseEntity.ok(expenseService.findByDateBetween(query, query1, query2, query3, query4, query5));
	}
	
	@PostMapping("/fetch")
	public ResponseEntity<List<ExpenseInfoModel>> searchExpense(@RequestParam("query6") String query6, @RequestParam("query7") String query7){
		return ResponseEntity.ok(expenseService.searchExpense(query6, query7));
	}
	
	
	@PostMapping("/fetching")
	public ResponseEntity<List<ExpenseInfoModel>> searchExpense(@RequestParam("query8") String query8){
		return ResponseEntity.ok(expenseService.searchExpenseByStatus(query8));
	}
	
	
	@PostMapping("/register/{userData}")
	public ExpenseInfoModel registerExpense(@RequestBody ExpenseInfoModel expenseModel, @PathVariable String userData) {
		return this.expenseService.registerExpense(expenseModel, userData);
	}
	
	@PutMapping("/update/{updateId}")
	public ExpenseInfoModel upateExpense(@RequestBody ExpenseInfoModel expenseModel, @PathVariable String updateId) {
		return this.expenseService.updateExpense(expenseModel, Long.parseLong(updateId));
	}
	
	@PutMapping("/delete/{deleteId}")
	public ExpenseInfoModel deleteExpense(@RequestBody ExpenseInfoModel expenseModel, @PathVariable String deleteId) {
		return this.expenseService.deleteExpense(expenseModel, Long.parseLong(deleteId));
	}
	
//	
//	@DeleteMapping("/delete/{deleteId}")
//	public void deleteExpense(@PathVariable String deleteId) {
//		expenseService.deleteExpense(Long.parseLong(deleteId));
//	}
//	
    @RequestMapping(value = "/username", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserName(Principal principal) {
	       return principal.getName();
	}
    

}
