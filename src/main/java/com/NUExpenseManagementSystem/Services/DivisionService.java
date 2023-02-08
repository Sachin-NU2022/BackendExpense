package com.NUExpenseManagementSystem.Services;

import java.util.List;


import com.NUExpenseManagementSystem.Models.Division;
import com.NUExpenseManagementSystem.Models.ExpenseCategory;

public interface DivisionService {

	public List<Division> getDivisionList();
	
	public List<Division> searchDivision(String query);

	public Division registerDivision(Division division);

	public Division getSingleDivision(long division_id);

	public Division updateDivision(Division division, long division_id);
	
	public Division deleteDivision(Division division, Long deleteId);
	
	// public void deleteDivision(Long deleteId);

}
