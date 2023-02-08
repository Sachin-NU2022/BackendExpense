package com.NUExpenseManagementSystem.Services;

import java.util.List;

import com.NUExpenseManagementSystem.Models.ExpenseInfoModel;

public interface ExpenseService{
	
	public List<ExpenseInfoModel> getExpense();
	
	public ExpenseInfoModel getExpenseList(long searchId);
	
	public List<ExpenseInfoModel> findByDateBetween(String query, String query1, String query2, String query3, String query4, String query5);
	
	public ExpenseInfoModel updateExpense(ExpenseInfoModel expenseInfoModel, Long updateId);

	public ExpenseInfoModel registerExpense(ExpenseInfoModel expenseModel, String userData);
	
	public List<ExpenseInfoModel> searchExpense(String query6, String query7);
	
	public List<ExpenseInfoModel> searchExpenseByStatus(String query8);
	
	public ExpenseInfoModel deleteExpense(ExpenseInfoModel expenseInfoModel, Long deleteId);

//	public void deleteExpense(Long deleteId);


	

	
}
