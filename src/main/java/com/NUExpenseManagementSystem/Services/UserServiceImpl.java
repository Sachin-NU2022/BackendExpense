package com.NUExpenseManagementSystem.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.NUExpenseManagementSystem.Models.User;
import com.NUExpenseManagementSystem.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Override
	public List<User> getStaff() {
		return userRepository.findAll();
	}

	@Override
	public User getStaffList(Long searchId) {
		return userRepository.findById(searchId).get();
	}

	@Override
	public User updateStaff(User user, Long updateId) {
		User employ = userRepository.findById(updateId).get();
		employ.setStaffNumber(user.getStaffNumber());
		//employ.setPassword(passwordEncoder.encode(user.getPassword()));
		employ.setUsername(user.getUsername());
		employ.setStaff_kana(user.getStaff_kana());
		employ.setDepartment_name(user.getDepartment_name());
		employ.setDivision_name(user.getDivision_name());
		employ.setEmail(user.getEmail());
		return userRepository.save(employ);
	}
	
	@Override
	public List<User> searchEmployee(String query) {
	    List<User> users = userRepository.searchEmployee(query);
	    return users;
	}

	@Override
	public List<User> searchEmployees(String query1, String query2) {
		 List<User> employees = userRepository.searchEmployeesSQL(query1, query2);
		 return employees;
	}

	@Override
	public User deleteStaff(User user, Long deleteId) {
	    User employ = userRepository.findById(deleteId).get();
	    employ.setDel_flg(!user.getDel_flg());
		return userRepository.save(employ);
	}

//	@Override
//	public void deleteEmployee(Long deleteId) {
//	   	userRepository.deleteById(deleteId);
//	}


}
