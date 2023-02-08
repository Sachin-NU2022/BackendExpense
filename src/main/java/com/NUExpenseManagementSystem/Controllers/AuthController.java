package com.NUExpenseManagementSystem.Controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.NUExpenseManagementSystem.Models.ExpenseInfoModel;
import com.NUExpenseManagementSystem.Models.Role;
import com.NUExpenseManagementSystem.Models.User;
import com.NUExpenseManagementSystem.payload.LoginDto;
import com.NUExpenseManagementSystem.payload.SignUpDto;
import com.NUExpenseManagementSystem.Repository.RoleRepository;
import com.NUExpenseManagementSystem.Repository.UserRepository;
import com.NUExpenseManagementSystem.Services.UserService;
@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
   	private UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getStaffNumber(), loginDto.getPassword()));
        authentication.getAuthorities();
        SecurityContextHolder.getContext().setAuthentication(authentication);
      
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){

        // add check for username exists in a DB
        if(userRepository.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        
        // add check for staff_id exists in DB
        if(userRepository.existsBystaffNumber(signUpDto.getStaffNumber())) {
        	return new ResponseEntity<>("Staff id is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setStaffNumber(signUpDto.getStaffNumber());
        user.setUsername(signUpDto.getUsername());
        user.setStaff_kana(signUpDto.getStaff_kana());
        user.setDepartment_name(signUpDto.getDepartment_name());
        user.setDivision_name(signUpDto.getDivision_name());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setManager_flg(true);
        user.setDel_flg(false);
        Role roles = roleRepository.findByName("ROLE_USER").get();
        user.setRoles(Collections.singleton(roles));
        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
   
	@GetMapping("/search")
	public List<User> getStaffList() {
		return this.userService.getStaff();
	}
	
	@GetMapping("/search/{searchId}")
	public User getSingleStaff(@PathVariable String searchId) {
		return this.userService.getStaffList(Long.parseLong(searchId));
	}
	
	
	@PutMapping("/update/{updateId}")
	public User updateStaff(@RequestBody User user, @PathVariable String updateId) {
		return this.userService.updateStaff(user, Long.parseLong(updateId));
	}
	
	@GetMapping("/kensaku")
	public ResponseEntity<List<User>> searchEmployee(@RequestParam("query") String query){
		return ResponseEntity.ok(userService.searchEmployee(query));
	}
	
	@PostMapping("/fetch")
	public ResponseEntity<List<User>> searchEmployees(@RequestParam("query1") String query1, @RequestParam("query2") String query2){
		return ResponseEntity.ok(userService.searchEmployees(query1, query2));
	}
	
	@PutMapping("/delete/{deleteId}")
	public User deleteStaff(@RequestBody User user, @PathVariable String deleteId) {
		return this.userService.deleteStaff(user, Long.parseLong(deleteId));
	}
	

	

}