package com.NUExpenseManagementSystem.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Data
@Entity
@Table(name="department", uniqueConstraints = {
	                      @UniqueConstraint(columnNames = {"department_name"})
})
//@SQLDelete(sql = "UPDATE department SET del_flg = true WHERE department_id=?")
//@Where(clause = "del_flg = false")

public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long department_id;
	private String department_name;
	private Boolean auth_user_edit = Boolean.FALSE;
	private Boolean auth_expense_category = Boolean.FALSE;
	private Boolean auth_payment_edit = Boolean.FALSE;
	private Boolean del_flg = Boolean.FALSE;
}