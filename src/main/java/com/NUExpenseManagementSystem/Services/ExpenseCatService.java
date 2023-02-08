package com.NUExpenseManagementSystem.Services;


import java.util.List;

import com.NUExpenseManagementSystem.Models.ExpenseCategory;
import com.NUExpenseManagementSystem.Models.User;

public interface ExpenseCatService {
		
	public List<ExpenseCategory> getExpenseCat();
	
	public List<ExpenseCategory> searchExpenseCategories(String query);
	
	public ExpenseCategory getExpenseCatList(Long searchId);
	
	public ExpenseCategory registerExpenseCat(ExpenseCategory expenseCategory);
	
	public ExpenseCategory updateExpenseCat(ExpenseCategory expenseCategory, Long updateId);
	
    public ExpenseCategory deleteExpenseCat(ExpenseCategory expenseCategory, Long deleteId);
	
//    public void deleteExpenseCat(Long deleteId);

}