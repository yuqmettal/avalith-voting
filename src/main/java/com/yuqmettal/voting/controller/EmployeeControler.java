package com.yuqmettal.voting.controller;

import java.util.List;

import com.yuqmettal.voting.entity.EmployeeEntity;
import com.yuqmettal.voting.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeControler {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAll() {
        List<EmployeeEntity> employees = this.employeeService.getAll();
        return new ResponseEntity<List<EmployeeEntity>>(employees, HttpStatus.OK);
    }
}