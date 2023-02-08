package com.NUExpenseManagementSystem.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NUExpenseManagementSystem.Models.Department;
import com.NUExpenseManagementSystem.Models.ExpenseCategory;
import com.NUExpenseManagementSystem.Repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;	
 	
	@Override
	public List<Department> getDepartmentList() {
		return departmentRepository.findAll();
	}
	
	@Override
	public Department getSingleDepartment(long department_id) {
		return departmentRepository.findById(department_id).get();
	}

	@Override
	public Department registerDepartment(Department department) {
		department.setDel_flg(false);
		departmentRepository.save(department);
		return department;		
	}

	@Override
	public Department updateDepartment(Department department, long department_id) {
		Department depart = departmentRepository.findById(department_id).get();
		depart.setDepartment_name(department.getDepartment_name());
		depart.setAuth_user_edit(department.getAuth_user_edit());
		depart.setAuth_expense_category(department.getAuth_expense_category());
		depart.setAuth_payment_edit(department.getAuth_payment_edit());
		departmentRepository.save(depart);
		return depart;
	}

	@Override
	public List<Department> searchDepartment(String query) {
		List<Department> departments = departmentRepository.searchDepartment(query);
	    return departments;
	}

	@Override
	public Department deleteDepartment(Department department, Long deleteId) {
		Department depart = departmentRepository.findById(deleteId).get();
		depart.setDel_flg(!department.getDel_flg());
		return departmentRepository.save(depart);
	}



}
