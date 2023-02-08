package com.NUExpenseManagementSystem.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.NUExpenseManagementSystem.Models.Department;
import com.NUExpenseManagementSystem.Models.ExpenseCategory;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	   @Query(value = "SELECT * FROM department d WHERE d.department_name LIKE %?1%", nativeQuery = true)
 	   List<Department> searchDepartment(String query);
	   
}
