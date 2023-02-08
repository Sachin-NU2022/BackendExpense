package com.NUExpenseManagementSystem.Controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.NUExpenseManagementSystem.Models.ExpenseCategory;
import com.NUExpenseManagementSystem.Services.ExpenseCatService;

@RestController
@CrossOrigin
@RequestMapping("/api/expensecat")
public class ExpenseCategoryController {
	
	@Autowired
	private ExpenseCatService expenseCatService;
	
	@GetMapping("/search")
	public List<ExpenseCategory> getExpenseCatList() {
		return this.expenseCatService.getExpenseCat();
	}
	
	@GetMapping("/search/{searchId}")
	public ExpenseCategory getSingleExpenseCat(@PathVariable String searchId) {
		return this.expenseCatService.getExpenseCatList(Long.parseLong(searchId));
	}
	
	@GetMapping("/kensaku")
	public ResponseEntity<List<ExpenseCategory>> searchExpenseCategories(@RequestParam("query") String query){
		return ResponseEntity.ok(expenseCatService.searchExpenseCategories(query));
	}
	
	@PostMapping("/register")
	public ExpenseCategory registerExpenseCat(@RequestBody ExpenseCategory expenseCategory) {
		return this.expenseCatService.registerExpenseCat(expenseCategory);
	}
	
	@PutMapping("/update/{updateId}")
	public ExpenseCategory updateExpenseCat(@RequestBody ExpenseCategory expenseCategory, @PathVariable String updateId) {
		return this.expenseCatService.updateExpenseCat(expenseCategory, Long.parseLong(updateId));
	}
	
	@PutMapping("/delete/{deleteId}")
	public ExpenseCategory deleteExpenseCat(@RequestBody ExpenseCategory expenseCategory, @PathVariable String deleteId) {
		return this.expenseCatService.deleteExpenseCat(expenseCategory, Long.parseLong(deleteId));
	}
	
//	@DeleteMapping("/delete/{deleteId}")
//	public void deleteExpenseCat(@PathVariable String deleteId) {
//		expenseCatService.deleteExpenseCat(Long.parseLong(deleteId));
//	}
//	

	
}