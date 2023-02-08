






package com.NUExpenseManagementSystem.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.NUExpenseManagementSystem.Models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long employee_id;
	 private String staffNumber;
     private String username;
     private String staff_kana;
     private String department_name;
     private String division_name;
     private String email;
     
     @JsonIgnore
     private String password;
	
	private Collection<? extends GrantedAuthority> authorities;
		

	public UserDetailsImpl(Long employee_id, String staffNumber, String username, String staff_kana,
			String department_name, String division_name, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.employee_id = employee_id;
		this.staffNumber = staffNumber;
		this.username = username;
		this.staff_kana = staff_kana;
		this.department_name = department_name;
		this.division_name = division_name;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	
	
	public static UserDetails build(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    return authorities;
	}

	@Override
	public String getPassword() {
	    return this.password;
	}

	@Override
	public String getUsername() {
	    return this.staffNumber;
	}

	@Override
	public boolean isAccountNonExpired() {
	    return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	    return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
	    return true;
	}

	@Override
	public boolean isEnabled() {
	    return true;
	}

	

	

}
