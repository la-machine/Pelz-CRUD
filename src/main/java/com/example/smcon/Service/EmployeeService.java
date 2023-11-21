package com.example.smcon.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.smcon.DTO.AuthRequest;
import com.example.smcon.DTO.EmployeeDto;
import com.example.smcon.Model.Employee;
import com.example.smcon.Model.Role;
import com.example.smcon.Repository.EmployeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    public ResponseEntity<?> createEmployee(EmployeeDto employee){
        Employee employeeExist = employeRepository.findByEmail(employee.getEmail());
        if(employeeExist != null){
            return ResponseEntity.status(400).body("Employee already exist");
        }
        Employee emp = Employee.builder().name(employee.getName()).email(employee.getEmail())
            .age(employee.getAge()).password(employee.getPassword()).role(Role.Employee).build();
        employeRepository.save(emp);
        return ResponseEntity.status(200).body("Employee saved successfully : " + emp);
    }

    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.status(200).body(employeRepository.findAll());
    }

    public ResponseEntity<?> getByEmail(String email){
        Employee emp = employeRepository.findByEmail(email);
        if(emp == null){
            return ResponseEntity.status(400).body("There is no employee with this email " + email);
        }

        return ResponseEntity.status(200).body(emp);
    }

    public ResponseEntity<?> updateEmployee(EmployeeDto employee){
        Employee employeeExist = employeRepository.findByEmail(employee.getEmail());
        if(employeeExist == null){
            return ResponseEntity.status(400).body("There is no employee with this email " + employee.getEmail());
        }
        employeeExist.setAge(employee.getAge());
        employeeExist.setName(employee.getName());
        employeRepository.save(employeeExist);
        return ResponseEntity.status(200).body("Employee updated");
    }

    public String authenticate(AuthRequest request){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        Employee emp = employeRepository.findByEmail(request.getEmail());

        String jwtToken = jwtService.generateToken(emp);
        return jwtToken;
    }
}
