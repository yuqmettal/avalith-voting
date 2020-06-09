package com.yuqmettal.voting.repository;

import com.yuqmettal.voting.model.Vote;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}