package com.NUExpenseManagementSystem.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NUExpenseManagementSystem.Models.Department;
import com.NUExpenseManagementSystem.Models.Division;
import com.NUExpenseManagementSystem.Repository.DivisionRepository;

@Service
public class DivisionServiceImpl implements DivisionService {
	
	@Autowired
	private DivisionRepository divisionRepository;
	
	@Override
	public List<Division> getDivisionList() {
		return divisionRepository.findAll();
	}
	
	@Override
	public Division getSingleDivision(long division_id) {
		return this.divisionRepository.findById(division_id).get();
	}

	@Override
	public Division registerDivision(Division division) {
		division.setDel_flg(false);
		divisionRepository.save(division);
		return division;
	}

	@Override
	public Division updateDivision(Division division, long division_id) {
		Division div = divisionRepository.findById(division_id).orElseThrow();
		div.setDepartment_name(division.getDepartment_name());
		div.setDivision_name(division.getDivision_name());
		div.setAuth_user_edit(division.getAuth_user_edit());
		div.setAuth_expense_category(division.getAuth_expense_category());
		div.setAuth_payment_edit(division.getAuth_payment_edit());
		divisionRepository.save(div);
		return div;
	}

	@Override
	public List<Division> searchDivision(String query) {
		List<Division> divisions = divisionRepository.searchDivision(query);
	    return divisions;
	}

	@Override
	public Division deleteDivision(Division division, Long deleteId) {
		Division div = divisionRepository.findById(deleteId).get();
		div.setDel_flg(!division.getDel_flg());
		return divisionRepository.save(div);
	}

	
}
 