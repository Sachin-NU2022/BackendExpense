package com.NUExpenseManagementSystem.Models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Data
@Entity
@Table (name="Expense")
//@SQLDelete(sql = "UPDATE expense SET del_flg = true WHERE expense_id=?")
//@Where(clause = "del_flg = false")
public class ExpenseInfoModel {
	@Id
	@GeneratedValue
	private Long expense_id;
    private String app_depart_id;
    private String app_division_id;
    private Date application_date;
    private Date app_date;
    private Date pay_date;
    private Integer payment_status;
    private String payment_destination;
    private Integer approval_status;
    private String description;
    private String entraining_point;
    private String arrival_station;
    private Integer amount;
    private String note;
    private Boolean del_flg = Boolean.FALSE;
    private String application_user_name;
    private String staff_id;
   
 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "application_user_id", referencedColumnName="employee_id")
	@Fetch(FetchMode.JOIN)
	private User user;
   
}
    
