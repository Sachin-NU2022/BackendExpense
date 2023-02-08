package com.NUExpenseManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.NUExpenseManagementSystem.Models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	 	@Query(value = "SElECT * FROM employee e WHERE e.staff_name LIKE CONCAT('%', :name, '%') OR e.department_name LIKE CONCAT('%', :department, '%') OR e.division_name LIKE CONCAT('%', :division, '%')", nativeQuery = true)
	 	List<Employee> searchEmployee(@Param("name") String name, @Param("department") String department, @Param("division") String division);
	     
}
