package com.yuqmettal.voting.repository;

import com.yuqmettal.voting.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Employee, Long> {
    public Employee findByUsername(String username);
}