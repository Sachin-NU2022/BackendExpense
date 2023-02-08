package com.NUExpenseManagementSystem.payload;

import java.util.Set;

import lombok.Data;

@Data
public class SignUpDto {
			     private String staffNumber;
	             private String password;
	             private String username;
	             private String staff_kana;
	             private String department_name;
	             private String division_name;
	             private String email;
	             private Boolean manager_flg;
	             private Boolean del_flg = Boolean.FALSE;
	             private Set<String> role;
}
