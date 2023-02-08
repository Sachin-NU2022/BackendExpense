package com.NUExpenseManagementSystem.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.NUExpenseManagementSystem.Models.Role;
import com.NUExpenseManagementSystem.Models.User;
import com.NUExpenseManagementSystem.Repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String staffNumber) throws UsernameNotFoundException {
	User user = userRepository.findBystaffNumber(staffNumber);
	 if (null == user) {
	        throw new UsernameNotFoundException("Number " + staffNumber + " not found");
	 }
	return new org.springframework.security.core.userdetails.User(user.getUsername(),
				    user.getPassword(),mapRolesToAuthorities(user.getRoles()));
	}
    
    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
	        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
	


}
