package com.yuqmettal.voting.helper;

import java.util.Calendar;

import com.yuqmettal.voting.entity.VoteEntity;
import com.yuqmettal.voting.model.Area;
import com.yuqmettal.voting.model.Employee;
import com.yuqmettal.voting.repository.AreaRepository;
import com.yuqmettal.voting.repository.EmployeeRepository;
import com.yuqmettal.voting.repository.UserRepository;
import com.yuqmettal.voting.repository.VotedAreaRepository;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class VotingHelper {
    private AreaRepository areaRepository;
    private EmployeeRepository employeeRepository;
    private UserRepository userRepository;
    private VotedAreaRepository votedAreaRepository;

    public VotingHelper(AreaRepository areaRepository, EmployeeRepository employeeRepository,
            UserRepository userRepository, VotedAreaRepository votedAreaRepository) {
        this.areaRepository = areaRepository;
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
        this.votedAreaRepository = votedAreaRepository;
    }

    public VotingStatus validate(VoteEntity vote) {
        if (vote.getAreaId() == null || !areaRepository.existsById(vote.getAreaId())) {
            return VotingStatus.AreaDoesNotExists;
        }
        if (vote.getEmployeeId() == null || !employeeRepository.existsById(vote.getEmployeeId())) {
            return VotingStatus.EmployeeDoesNotExists;
        }

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Employee user = userRepository.findByUsername(userDetails.getUsername());
        if (vote.getEmployeeId().equals(user.getId())) {
            return VotingStatus.OwnVoteError;
        }

        Area area = areaRepository.findById(vote.getAreaId()).get();
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        if (votedAreaRepository.existsVotedAreaByAreaAndVoterAndYearAndMonth(area, user, year, month)) {
            return VotingStatus.AlreadyVoted;
        }

        return VotingStatus.Valid;
    }
}