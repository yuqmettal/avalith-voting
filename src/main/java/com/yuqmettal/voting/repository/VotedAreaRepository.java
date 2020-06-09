package com.yuqmettal.voting.repository;

import com.yuqmettal.voting.model.VotedArea;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VotedAreaRepository extends JpaRepository<VotedArea, Long> {
}