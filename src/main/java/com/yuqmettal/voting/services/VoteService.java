package com.yuqmettal.voting.services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import com.yuqmettal.voting.entity.VoteEntity;
import com.yuqmettal.voting.helper.VotingHelper;
import com.yuqmettal.voting.helper.VotingStatus;
import com.yuqmettal.voting.model.Area;
import com.yuqmettal.voting.model.Employee;
import com.yuqmettal.voting.model.Vote;
import com.yuqmettal.voting.model.VotedArea;
import com.yuqmettal.voting.repository.AreaRepository;
import com.yuqmettal.voting.repository.EmployeeRepository;
import com.yuqmettal.voting.repository.UserRepository;
import com.yuqmettal.voting.repository.VoteRepository;
import com.yuqmettal.voting.repository.VotedAreaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VotedAreaRepository votedAreaRepository;

    public List<Vote> getAll() {
        return (List<Vote>) this.voteRepository.findAll();
    }

    public Vote create(VoteEntity voteEntity) throws Exception {
        VotingHelper votingHelper = new VotingHelper(areaRepository, employeeRepository, userRepository, votedAreaRepository);
        VotingStatus validateStatus = votingHelper.validate(voteEntity);
        if (!validateStatus.equals(VotingStatus.Valid)) {
            throw new Exception(validateStatus.getMessage());
        }
        Area area = areaRepository.getOne(voteEntity.getAreaId());
        Employee employee = employeeRepository.getOne(voteEntity.getEmployeeId());
        Vote vote = new Vote(area, employee, voteEntity.getComments());

        createVotedArea(area);

        return voteRepository.save(vote);
    }

    public void delete(Long id) {
        this.voteRepository.deleteById(id);
    }

    public Vote update(Long id, Vote vote) {
        vote.setId(id);
        return voteRepository.save(vote);
    }

    private void createVotedArea(Area area) {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Employee user = userRepository.findByUsername(userDetails.getUsername());

        votedAreaRepository.save(new VotedArea(area, user, year, month));
    }

    public Vote getById(Long id) {
        Optional<Vote> vote = voteRepository.findById(id);
        if (!vote.isPresent()) {
            return null;
        }
        return vote.get();
    }
}