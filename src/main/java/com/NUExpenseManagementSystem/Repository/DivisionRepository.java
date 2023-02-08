package com.NUExpenseManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.NUExpenseManagementSystem.Models.Division;

public interface DivisionRepository extends JpaRepository<Division, Long>{
	   @Query(value = "SELECT * FROM division d WHERE d.division_name LIKE %?1%", nativeQuery = true)
 	   List<Division> searchDivision(String query);
}
