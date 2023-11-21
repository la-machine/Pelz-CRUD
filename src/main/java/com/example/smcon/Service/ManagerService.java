package com.example.smcon.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.smcon.DTO.EmployeeDto;
import com.example.smcon.Model.Employee;
import com.example.smcon.Model.Role;
import com.example.smcon.Repository.EmployeRepository;

@Service
public class ManagerService {
    @Autowired
    private EmployeRepository employeRepository;

    public ResponseEntity<?> createManager(EmployeeDto employee){
        Employee employeeExist = employeRepository.findByEmail(employee.getEmail());
        if(employeeExist != null){
            return ResponseEntity.status(400).body("Employee already exist");
        }
        Employee emp = Employee.builder().name(employee.getName()).email(employee.getEmail())
            .age(employee.getAge()).password(employee.getPassword()).role(Role.Manager).build();
        employeRepository.save(emp);
        return ResponseEntity.status(200).body("Employee saved successfully : " + emp);
    }

    public ResponseEntity<?> getAllEmployee(){
        return ResponseEntity.status(200).body(employeRepository.findByRole(Role.Employee));
    }
}
