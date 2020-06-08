package com.yuqmettal.voting.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.yuqmettal.voting.model.Employe;
import com.yuqmettal.voting.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employe employe = userRepository.findByUsername(username);
        // List<GrantedAuthority> authorities = employe.getRoles().stream()
		// 			.map(role -> new SimpleGrantedAuthority(role.getName()))
        //             .collect(Collectors.toList());
        return new User(
            employe.getUsername(),
            employe.getPassword(),
            employe.getEnabled(),
            true, true, true, new ArrayList<>()
        );
    }
    
}