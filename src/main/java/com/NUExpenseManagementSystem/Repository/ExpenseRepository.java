package com.NUExpenseManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.NUExpenseManagementSystem.Models.Employee;
import com.NUExpenseManagementSystem.Models.ExpenseCategory;
import com.NUExpenseManagementSystem.Models.ExpenseInfoModel;

public interface ExpenseRepository extends JpaRepository<ExpenseInfoModel, Long>{
	
	@Query(value = "SELECT * FROM expense e where e.application_date >=:startDate AND e.application_date <=:endDate OR e.app_date >=:startDate2 AND e.app_date <=:endDate2 OR e.pay_date >=:startDate3 AND e.pay_date <=:endDate3", nativeQuery = true)
	List<ExpenseInfoModel> findByDateBetween(
			@Param("startDate") String startDate, @Param("endDate") String endDate,
			@Param("startDate2") String startDate2, @Param("endDate2") String endDate2,
			@Param("startDate3") String startDate3, @Param("endDate3") String endDate3
			);
	
      @Query(value = "SELECT * FROM expense e WHERE e.application_user_name=?1 OR e.staff_id=?2", nativeQuery = true)
      List<ExpenseInfoModel> searchExpensesSQL(String query6, String query7);
      
      @Query(value = "SELECT * FROM expense e WHERE e.approval_status=?1", nativeQuery = true)
      List<ExpenseInfoModel> searchExpensesSQL2(String query8);
}