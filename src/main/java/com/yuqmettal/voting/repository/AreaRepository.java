package com.yuqmettal.voting.repository;

import com.yuqmettal.voting.model.Area;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
}