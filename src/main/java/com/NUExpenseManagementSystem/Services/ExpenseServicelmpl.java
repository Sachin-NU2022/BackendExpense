package com.NUExpenseManagementSystem.Services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NUExpenseManagementSystem.Models.ExpenseCategory;
import com.NUExpenseManagementSystem.Models.ExpenseInfoModel;
import com.NUExpenseManagementSystem.Models.User;
import com.NUExpenseManagementSystem.Repository.ExpenseRepository;
import com.NUExpenseManagementSystem.Repository.UserRepository;


@Service
public class ExpenseServicelmpl implements ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<ExpenseInfoModel> getExpense() {
		return expenseRepository.findAll();
	}
	
	@Override
	public ExpenseInfoModel getExpenseList(long searchId) {
		return expenseRepository.findById(searchId).get();
	
	}
	
	@Override
	public ExpenseInfoModel updateExpense(ExpenseInfoModel expenseInfoModel, Long updateId) {
		ExpenseInfoModel expinfmodel = expenseRepository.findById(updateId).get();
		expinfmodel.setApp_depart_id(expenseInfoModel.getApp_depart_id());
		expinfmodel.setApp_division_id(expenseInfoModel.getApp_division_id());
		
		expinfmodel.setApplication_date(expenseInfoModel.getApplication_date());
		expinfmodel.setApp_date(expenseInfoModel.getApp_date());
		expinfmodel.setPay_date(expenseInfoModel.getPay_date());
		expinfmodel.setPayment_status(expenseInfoModel.getPayment_status());
		expinfmodel.setApproval_status(expenseInfoModel.getApproval_status());
		expinfmodel.setDescription(expenseInfoModel.getDescription());
		expinfmodel.setEntraining_point(expenseInfoModel.getEntraining_point());
		expinfmodel.setArrival_station(expenseInfoModel.getArrival_station());
		expinfmodel.setAmount(expenseInfoModel.getAmount());
		expinfmodel.setNote(expenseInfoModel.getNote());
		return expenseRepository.save(expinfmodel);
	}


	@Override
	public List<ExpenseInfoModel> findByDateBetween(String query, String query1, String query2, String query3, String query4, String query5) {
		 List<ExpenseInfoModel> expenses = expenseRepository.findByDateBetween(query, query1, query2, query3, query4, query5);
		 return expenses;
	}

	@Override
	public ExpenseInfoModel registerExpense(ExpenseInfoModel expenseModel, String userData) {
	    User user = userRepository.findBystaffNumber(userData);
		Date date = new Date();
		expenseModel.setUser(user);
		expenseModel.setPayment_status(0);
		expenseModel.setDel_flg(false);
		expenseModel.setApproval_status(0);
		expenseModel.setApplication_date(date);
		expenseModel.setApplication_user_name(user.getUsername());
		expenseModel.setStaff_id(userData);
		expenseRepository.save(expenseModel);
		return expenseModel;
	}

	@Override
	public List<ExpenseInfoModel> searchExpense(String query6, String query7) {
		   List<ExpenseInfoModel> expenses = expenseRepository.searchExpensesSQL(query6, query7);
		   return expenses;
	}

	@Override
	public List<ExpenseInfoModel> searchExpenseByStatus(String query8) {
	    List<ExpenseInfoModel> expenses = expenseRepository.searchExpensesSQL2(query8);
		return expenses;
	}

	@Override
	public ExpenseInfoModel deleteExpense(ExpenseInfoModel expenseInfoModel, Long deleteId) {
		ExpenseInfoModel expenseInfo = expenseRepository.findById(deleteId).get();		
		expenseInfo.setDel_flg(!expenseInfoModel.getDel_flg());
		return expenseRepository.save(expenseInfo);
		
	}

}

	
	 
