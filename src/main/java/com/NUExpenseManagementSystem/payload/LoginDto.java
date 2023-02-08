package com.NUExpenseManagementSystem.payload;


import lombok.Data;

@Data
public class LoginDto {
   // private String usernameOrEmail;
    private String staffNumber;
	private String password;
}
