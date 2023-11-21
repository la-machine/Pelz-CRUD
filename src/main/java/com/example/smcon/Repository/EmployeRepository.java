package com.example.smcon.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smcon.Model.Employee;
import com.example.smcon.Model.Role;

public interface EmployeRepository extends JpaRepository<Employee, Long>{
    Employee findByEmail(String email);
    List<Employee> findByRole(Role role);
}
