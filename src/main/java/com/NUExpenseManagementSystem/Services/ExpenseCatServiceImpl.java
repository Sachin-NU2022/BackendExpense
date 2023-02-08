package com.NUExpenseManagementSystem.Services;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.NUExpenseManagementSystem.Models.ExpenseCategory;
import com.NUExpenseManagementSystem.Repository.ExpenseCategoryRepository;


@Service
public class ExpenseCatServiceImpl implements ExpenseCatService {
	
	@Autowired
	private ExpenseCategoryRepository expenseCategoryRepository;
	
	@Autowired
	
	
	public ExpenseCatServiceImpl() {
	}
	@Override
	public List<ExpenseCategory> getExpenseCat() {
	    return expenseCategoryRepository.findAll();
	}
    
	@Override
	public ExpenseCategory getExpenseCatList(Long searchId) {
		return expenseCategoryRepository.findById(searchId).get();
	}

	@Override
	public ExpenseCategory registerExpenseCat(ExpenseCategory expenseCategory) {
		expenseCategory.setDel_flg(false);
		expenseCategoryRepository.save(expenseCategory);
		return expenseCategory;
	}

	@Override
	public ExpenseCategory updateExpenseCat(ExpenseCategory expenseCategory, Long updateId) {
		ExpenseCategory expcat = expenseCategoryRepository.findById(updateId).get();
		expcat.setExpense_category_name(expenseCategory.getExpense_category_name());
		return expenseCategoryRepository.save(expcat);
		
	}

	@Override
	public List<ExpenseCategory> searchExpenseCategories(String query) {
		List<ExpenseCategory> categories = expenseCategoryRepository.searchExpenseCategoriesSQL(query);
		return categories;
	}


	@Override
	public ExpenseCategory deleteExpenseCat(ExpenseCategory expenseCategory, Long deleteId) {
		ExpenseCategory expcat = expenseCategoryRepository.findById(deleteId).get();
		expcat.setDel_flg(!expenseCategory.getDel_flg());
		return expenseCategoryRepository.save(expcat);
	}




}
