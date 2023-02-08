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
@Table(name="division", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"division_name"})
})

//@SQLDelete(sql = "UPDATE division SET del_flg = true WHERE division_id=?")
//@Where(clause = "del_flg = false")
public class Division {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long division_id;
	private String department_name;
	private String division_name;
	private Boolean auth_user_edit = Boolean.FALSE;
	private Boolean auth_expense_category  = Boolean.FALSE;
	private Boolean auth_payment_edit = Boolean.FALSE;
	private Boolean del_flg = Boolean.FALSE;
	
}
