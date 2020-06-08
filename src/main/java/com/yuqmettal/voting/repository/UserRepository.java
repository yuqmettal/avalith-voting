package com.yuqmettal.voting.repository;

import com.yuqmettal.voting.model.Employee;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<Employee, Long> {
    public Employee findByUsername(String username);
}