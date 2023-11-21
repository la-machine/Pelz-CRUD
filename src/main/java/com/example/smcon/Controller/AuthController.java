package com.example.smcon.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smcon.DTO.AuthRequest;
import com.example.smcon.DTO.EmployeeDto;
import com.example.smcon.Service.EmployeeService;
import com.example.smcon.Service.ManagerService;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {
    @Autowired
    private EmployeeService empService;
    @Autowired
    private ManagerService mngService;

    @PostMapping("add")
    public ResponseEntity<?> addManager(@RequestBody EmployeeDto manager){
        return mngService.createManager(manager);
    }

    @PostMapping
    public String authenticate(@RequestBody AuthRequest authRequest){
        return empService.authenticate(authRequest);
    }

    @GetMapping
    public ResponseEntity<?> getEmployee(){
        return mngService.getAllEmployee();
    }
}
