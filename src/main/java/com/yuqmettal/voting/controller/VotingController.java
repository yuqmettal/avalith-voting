package com.yuqmettal.voting.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class VotingController {

    @GetMapping
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<String>("Hola", HttpStatus.OK);
    }
    
}