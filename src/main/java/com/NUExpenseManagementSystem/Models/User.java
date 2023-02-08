package com.NUExpenseManagementSystem.Models;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"staffNumber"}),
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})

public class User{
				  
	              @Id
				  @GeneratedValue(strategy = GenerationType.IDENTITY)
	              private Long employee_id;
				  private String staffNumber;
		          private String password;
			      private String username;
		          private String staff_kana;
		          private String department_name;
		          private String division_name;
		          private String email;
		          private Boolean manager_flg;
		          private Boolean del_flg = Boolean.FALSE;
		          @JsonIgnore
				  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
				  @JoinTable(name = "user_roles",
				     joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "employee_id"),
				     inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
				  private Set<Role> roles;
		         
			
}
