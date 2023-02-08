package com.NUExpenseManagementSystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NUExpenseManagementSystem.Models.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
       Optional<Role> findByName(String name);
}
