package com.NUExpenseManagementSystem.Services;

import java.util.List;

import com.NUExpenseManagementSystem.Models.Department;
import com.NUExpenseManagementSystem.Models.ExpenseCategory;

public interface DepartmentService {
	
	public List<Department> getDepartmentList();
	
	public List<Department> searchDepartment(String query);
	
	public Department getSingleDepartment(long department_id);

	public Department registerDepartment(Department department);

	public Department updateDepartment(Department department, long department_id);
	
	public Department deleteDepartment(Department department, Long deleteId);
	
	//public void deleteDepartment(Long deleteId);
		
}
