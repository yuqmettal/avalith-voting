package com.yuqmettal.voting.repository;

import com.yuqmettal.voting.model.Employe;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<Employe, Long> {
    public Employe findByUsername(String username);
}