package com.NUExpenseManagementSystem.Services;

import java.util.List;

import com.NUExpenseManagementSystem.Models.Employee;
import com.NUExpenseManagementSystem.Models.ExpenseInfoModel;
import com.NUExpenseManagementSystem.Models.User;

public interface UserService {
	
                     public List<User> getStaff();
                     
                     public List<User> searchEmployee(String query);
                     
                     public List<User> searchEmployees(String query1, String query2);
                     
                     public User getStaffList(Long searchId);
                     
                     public User updateStaff(User user, Long updateId);
                     
                     public User deleteStaff(User user, Long deleteId);
                     
                    // public void deleteEmployee(Long deleteId);
}
