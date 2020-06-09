package com.yuqmettal.voting.controller;

import java.security.Principal;
import java.util.List;

import com.yuqmettal.voting.entity.VoteEntity;
import com.yuqmettal.voting.model.Vote;
import com.yuqmettal.voting.services.VoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/voting")
public class VotingController {

    @Autowired
    private VoteService voteService;

    @GetMapping
    public ResponseEntity<List<Vote>> getAll(Principal principal) {
        List<Vote> votes = voteService.getAll();
        return new ResponseEntity<List<Vote>>(votes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> vote(@RequestBody VoteEntity voteEntity) {
        try {
            voteService.create(voteEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
}