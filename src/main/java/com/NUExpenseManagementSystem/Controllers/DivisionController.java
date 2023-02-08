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
import com.NUExpenseManagementSystem.Models.Division;
import com.NUExpenseManagementSystem.Models.ExpenseCategory;
import com.NUExpenseManagementSystem.Services.DivisionService;

@CrossOrigin
@RestController
@RequestMapping("/api/division")
public class DivisionController {
	
	@Autowired
	private DivisionService divisionService;
	
	@GetMapping("/search")
	public List<Division> getDivisionList() {
		return this.divisionService.getDivisionList();
	}
	
	@GetMapping("/search/{division_id}")
	public Division getSingleDivision(@PathVariable Long division_id) {
		return this.divisionService.getSingleDivision(division_id);
	}
	
	@GetMapping("/kensaku")
	public ResponseEntity<List<Division>> searchDivision(@RequestParam("query") String query){
		return ResponseEntity.ok(divisionService.searchDivision(query));
	}

	
	@PostMapping("/register")
	public Division registerDivision(@RequestBody Division division) {
		return this.divisionService.registerDivision(division);
	}
	
	@PutMapping("/update/{division_id}")
	public Division updateDivision(@RequestBody Division division, @PathVariable Long division_id) {
		return this.divisionService.updateDivision(division, division_id);
	}
	
	@PutMapping("/delete/{deleteId}")
	public Division deleteDivision(@RequestBody Division division, @PathVariable String deleteId) {
		return this.divisionService.deleteDivision(division, Long.parseLong(deleteId));
	}
	
//	@DeleteMapping("/delete/{deleteId}")
//	public void deleteDivision(@PathVariable String deleteId) {
//		divisionService.deleteDivision(Long.parseLong(deleteId));
//	}
	
}
