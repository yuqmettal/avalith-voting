package com.yuqmettal.voting.repository;

import com.yuqmettal.voting.model.Area;
import com.yuqmettal.voting.model.Employee;
import com.yuqmettal.voting.model.VotedArea;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotedAreaRepository extends JpaRepository<VotedArea, Long> {

    Boolean existsVotedAreaByAreaAndVoterAndYearAndMonth(Area area, Employee voter, int year, int month);
    
}