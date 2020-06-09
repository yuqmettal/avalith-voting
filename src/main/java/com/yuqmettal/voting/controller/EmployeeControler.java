package com.yuqmettal.voting.controller;

import java.util.List;

import com.yuqmettal.voting.entity.EmployeeEntity;
import com.yuqmettal.voting.model.Employee;
import com.yuqmettal.voting.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee createdEmployee = this.employeeService.create(employee);
        return new ResponseEntity<Employee>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> update(@PathVariable("id") Long id) {
        Employee employee = this.employeeService.getById(id);
        EmployeeEntity entity = new EmployeeEntity(employee.getId(), employee.getFirstName(), employee.getLastName());
        return new ResponseEntity<EmployeeEntity>(entity, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@RequestBody Employee employee, @PathVariable("id") Long id) {
        Employee updatedEmployee = this.employeeService.update(id, employee);
        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@RequestBody Employee employee, @PathVariable("id") Long id) {
        this.employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}