package com.NUExpenseManagementSystem.Models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Data
@Table(name="Employee")
@SQLDelete(sql = "UPDATE employee SET del_flg = true WHERE staff_id=?")
@Where(clause = "del_flg = false")
public class Employee {
	      @Id
	      @GeneratedValue(strategy = GenerationType.IDENTITY)
          private Long staff_id;
          private String staff_pswd;
          private String staff_name;
          private String staff_kana;
          private String department_name;
          private String division_name;
          private String staff_email;
          private Boolean manager_flg;
          private Boolean del_flg = Boolean.FALSE;
          private String application_name;
}
