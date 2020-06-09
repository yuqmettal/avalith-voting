package com.yuqmettal.voting.services;

import java.util.List;
import java.util.Optional;

import com.yuqmettal.voting.entity.VoteEntity;
import com.yuqmettal.voting.helper.VotingHelper;
import com.yuqmettal.voting.helper.VotingStatus;
import com.yuqmettal.voting.model.Area;
import com.yuqmettal.voting.model.Employee;
import com.yuqmettal.voting.model.Vote;
import com.yuqmettal.voting.repository.AreaRepository;
import com.yuqmettal.voting.repository.EmployeeRepository;
import com.yuqmettal.voting.repository.VoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Vote> getAll() {
        return (List<Vote>) this.voteRepository.findAll();
    }

    public Vote create(VoteEntity voteEntity) throws Exception {
        VotingStatus validateStatus = VotingHelper.validate(voteEntity);
        if (!validateStatus.equals(VotingStatus.Valid)) {
            throw new Exception(validateStatus.getMessage());
        }
        Area area = areaRepository.getOne(voteEntity.getAreaId());
        Employee employee = employeeRepository.getOne(voteEntity.getEmployeeId());
        Vote vote = new Vote(area, employee, voteEntity.getComments());
        return voteRepository.save(vote);
    }

    public void delete(Long id) {
        this.voteRepository.deleteById(id);
    }

    public Vote update(Long id, Vote vote) {
        vote.setId(id);
        return voteRepository.save(vote);
    }

    public Vote getById(Long id) {
        Optional<Vote> vote = voteRepository.findById(id);
        if (!vote.isPresent()) {
            return null;
        }
        return vote.get();
    }
}