package com.NUExpenseManagementSystem.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.NUExpenseManagementSystem.Models.Department;
import com.NUExpenseManagementSystem.Models.ExpenseCategory;
import com.NUExpenseManagementSystem.Services.DepartmentService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/search")
	public List<Department> getDepartmentList() {
		return this.departmentService.getDepartmentList();
	}

	@GetMapping("/search/{department_id}")
	public Department getSingleDepartment(@PathVariable String department_id) {
		return this.departmentService.getSingleDepartment(Long.parseLong(department_id));
	}
	
	@GetMapping("/kensaku")
	public ResponseEntity<List<Department>> searchDepartment(@RequestParam("query") String query){
		return ResponseEntity.ok(departmentService.searchDepartment(query));
	}

	
	@PostMapping("/register")
	public Department registerDepartment(@RequestBody Department department) {
		return this.departmentService.registerDepartment(department);
	}	
	
	@PutMapping("/update/{department_id}")
	public Department upateDepartment(@RequestBody Department department, @PathVariable Long department_id) {
		return this.departmentService.updateDepartment(department, department_id);
	}
	
	@PutMapping("/delete/{deleteId}")
	public Department deleteDepartment(@RequestBody Department department, @PathVariable String deleteId) {
		return this.departmentService.deleteDepartment(department, Long.parseLong(deleteId));
	}
	
	
//	@DeleteMapping("/delete/{deleteId}")
//	public void deleteDepartment(@PathVariable String deleteId) {
//		departmentService.deleteDepartment(Long.parseLong(deleteId));
//	}
	
}
