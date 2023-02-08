package com.NUExpenseManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.NUExpenseManagementSystem.Models.ExpenseCategory;

public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory, Long>{
     	 @Query(value = "SELECT * FROM expense_category c WHERE c.expense_category_name LIKE %?1%", nativeQuery = true)
     	 List<ExpenseCategory> searchExpenseCategoriesSQL(String query);

		
}
