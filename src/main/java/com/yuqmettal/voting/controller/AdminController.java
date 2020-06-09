package com.yuqmettal.voting.controller;

import java.util.List;

import com.yuqmettal.voting.entity.EmployeeEntity;
import com.yuqmettal.voting.entity.EmployeeVotesEntity;
import com.yuqmettal.voting.repository.EmployeeRepository;
import com.yuqmettal.voting.repository.EmployeeVotesRepository;
import com.yuqmettal.voting.repository.VoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeVotesRepository employeeVotesRepository;

    @GetMapping(value="/employee-count")
    public ResponseEntity<Long> getEmployeeCount() {
        Long employeeCount = employeeRepository.count();
        return new ResponseEntity<Long>(employeeCount, HttpStatus.OK);
    }

    @GetMapping(value = "/month/{month}/top-voted")
    public ResponseEntity<List<EmployeeVotesEntity>> getTopVotedByMonth(@PathVariable("month") int month) {
        List<EmployeeVotesEntity> employees = employeeVotesRepository.findTopVotedByMonth(month);
        return new ResponseEntity<List<EmployeeVotesEntity>>(employees, HttpStatus.OK);
    }

    @GetMapping(value = "/area/{areaId}/top-voted")
    public ResponseEntity<List<EmployeeVotesEntity>> getTopVotedByArea(@PathVariable("areaId") Long areaId) {
        List<EmployeeVotesEntity> employees = employeeVotesRepository.findTopVotedByArea(areaId);
        return new ResponseEntity<List<EmployeeVotesEntity>>(employees, HttpStatus.OK);
    }
    
}