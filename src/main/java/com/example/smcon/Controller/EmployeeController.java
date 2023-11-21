package com.example.smcon.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smcon.DTO.EmployeeDto;
import com.example.smcon.Service.EmployeeService;

@RestController
@RequestMapping("api/")
public class EmployeeController {
    @Autowired
    private EmployeeService empService;

    @GetMapping("all")
    public ResponseEntity<?> getAllEmployee(){
        return empService.getAllUsers();
    }
    
    @PostMapping("add")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employee){
        return empService.createEmployee(employee);
    }

    @GetMapping(value = {"/{email}"})
    public ResponseEntity<?> getByEmail(@PathVariable String email){
        return empService.getByEmail(email);
    }
    
    @PostMapping("update")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDto employee){
        return empService.updateEmployee(employee);
    }
}
