package com.yuqmettal.voting.repository;

import java.util.List;

import com.yuqmettal.voting.entity.EmployeeEntity;
import com.yuqmettal.voting.model.Employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}