package com.example.smcon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smcon.Model.Employee;

public interface EmployeRepository extends JpaRepository<Employee, Long>{
    Employee findByEmail(String email);
}
