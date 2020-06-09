package com.yuqmettal.voting.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.yuqmettal.voting.entity.EmployeeEntity;
import com.yuqmettal.voting.model.Employee;
import com.yuqmettal.voting.repository.EmployeeRepository;
import com.yuqmettal.voting.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<EmployeeEntity> getAll() {
        return ((List<Employee>) this.employeeRepository.findAll()).stream()
                .map(employee -> new EmployeeEntity(employee.getId(), employee.getFirstName(), employee.getLastName()))
                .collect(Collectors.toList());
    }

    public Employee create(Employee employee) {
        Employee userEmployee = this.userRepository.findByUsername(employee.getUsername());
        if (userEmployee != null) {
            throw new RuntimeException("Employee already exist.");
        }
        employee.setEnabled(true);
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return this.employeeRepository.save(employee);
    }

    public void delete(Long id) {
        this.employeeRepository.deleteById(id);
    }

    public Employee update(Long id, Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public Employee getById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()) {
            return null;
        }
        return employee.get();
    }
}