package com.NUExpenseManagementSystem.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NUExpenseManagementSystem.Models.Department;
import com.NUExpenseManagementSystem.Models.Employee;
import com.NUExpenseManagementSystem.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getStaff() {
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee getStaffList(Long searchId) {
		return employeeRepository.findById(searchId).get();
	}
	
	@Override
	public Employee registerStaff(Employee employee) {
		employee.setDel_flg(false);
		employee.setManager_flg(true);
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public Employee updateStaff(Employee employee, Long updateId) {
		Employee employ = employeeRepository.findById(updateId).get();
		employ.setStaff_pswd(employee.getStaff_pswd());
		employ.setStaff_name(employee.getStaff_name());
		employ.setStaff_kana(employee.getStaff_kana());
		employ.setDepartment_name(employee.getDepartment_name());
		employ.setDivision_name(employee.getDivision_name());
		employ.setStaff_email(employee.getStaff_email());
		return employeeRepository.save(employ);
	}

	@Override
	public List<Employee> searchEmployee(String query, String query1, String query2) {
	    List<Employee> employees = employeeRepository.searchEmployee(query, query1, query2);
	    return employees;
	}

	

	
}
