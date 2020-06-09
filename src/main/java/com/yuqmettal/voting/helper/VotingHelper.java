package com.yuqmettal.voting.helper;

import java.util.Calendar;

import com.yuqmettal.voting.entity.VoteEntity;
import com.yuqmettal.voting.model.Area;
import com.yuqmettal.voting.model.Employee;
import com.yuqmettal.voting.repository.AreaRepository;
import com.yuqmettal.voting.repository.EmployeeRepository;
import com.yuqmettal.voting.repository.UserRepository;
import com.yuqmettal.voting.repository.VotedAreaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class VotingHelper {
    @Autowired
    private static AreaRepository areaRepository;

    @Autowired
    private static EmployeeRepository employeeRepository;

    @Autowired
    private static UserRepository userRepository;

    @Autowired
    private static VotedAreaRepository votedAreaRepository;

    public static VotingStatus validate(VoteEntity vote) {
        if (!areaRepository.existsById(vote.getAreaId())) {
            return VotingStatus.AreaDoesNotExists;
        }
        if (!employeeRepository.existsById(vote.getEmployeeId())) {
            return VotingStatus.EmployeeDoesNotExists;
        }

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Employee user = userRepository.findByUsername(userDetails.getUsername());
        if (vote.getEmployeeId().equals(user.getId())) {
            return VotingStatus.OwnVoteError;
        }

        Area area = areaRepository.getOne(vote.getAreaId());
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        if(votedAreaRepository.existsByAreaAndVoterAndYearAndMonth(area, user, year, month)){
            return VotingStatus.AlreadyVoted;
        }

        return VotingStatus.Valid;
    }
}