package com.NUExpenseManagementSystem.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.NUExpenseManagementSystem.Models.Employee;
import com.NUExpenseManagementSystem.Models.ExpenseCategory;
import com.NUExpenseManagementSystem.Models.ExpenseInfoModel;
import com.NUExpenseManagementSystem.Models.User;


public interface UserRepository extends JpaRepository<User, Long>{
         Optional<User> findByEmail(String email);
         Optional<User> findByUsernameOrEmail(String username, String email);
         User findByUsername(String username);
       
         User findBystaffNumber(String staffNumber);
         
         
         Boolean existsBystaffNumber(String staffNumber);
         
         Boolean existsByUsername(String username);
         Boolean existsByEmail(String email);
         
         
       	@Query(value = "SElECT * FROM users u WHERE u.username LIKE CONCAT('%', :name, '%')", nativeQuery = true)
	 	List<User> searchEmployee(@Param("name") String name);
       	
        @Query(value = "SELECT * FROM users u WHERE u.department_name=?1 OR u.division_name=?2", nativeQuery = true)
        List<User> searchEmployeesSQL(String query1, String query2);
       	
     
       
	  
}
