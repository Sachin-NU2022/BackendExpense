package com.NUExpenseManagementSystem.Services;

import java.util.List;

import com.NUExpenseManagementSystem.Models.Employee;

public interface EmployeeService{
   
	public List<Employee> getStaff();
	
	public List<Employee> searchEmployee(String query, String query1, String query2);
	
	public Employee getStaffList(Long searchId);
	
	public Employee registerStaff(Employee employee);
	
	public Employee updateStaff(Employee employee, Long updateId);
	
}

