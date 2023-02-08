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

import com.NUExpenseManagementSystem.Models.Department;
import com.NUExpenseManagementSystem.Models.Employee;
import com.NUExpenseManagementSystem.Models.ExpenseInfoModel;
import com.NUExpenseManagementSystem.Repository.EmployeeRepository;
import com.NUExpenseManagementSystem.Services.EmployeeService;
@RestController
@CrossOrigin
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/search")
	public List<Employee> getStaffList() {
		return this.employeeService.getStaff();
	}
	@GetMapping("/search/{searchId}")
	public Employee getSingleStaff(@PathVariable String searchId) {
		return this.employeeService.getStaffList(Long.parseLong(searchId));
	}
	
	@GetMapping("/kensaku")
	public ResponseEntity<List<Employee>> searchEmployee(@RequestParam("query") String query, @RequestParam("query1") String query1, @RequestParam("query2") String query2){
		return ResponseEntity.ok(employeeService.searchEmployee(query, query1, query2));
	}
	
	
	
	@PostMapping("/register")
	public Employee registerStaff(@RequestBody Employee employee) {
		return this.employeeService.registerStaff(employee);
	}
	
	@PutMapping("/update/{updateId}")
	public Employee updateStaff(@RequestBody Employee employee, @PathVariable String updateId) {
		return this.employeeService.updateStaff(employee, Long.parseLong(updateId));
	}
	
}
