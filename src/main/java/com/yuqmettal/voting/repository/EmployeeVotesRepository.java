package com.yuqmettal.voting.repository;

import java.util.List;

import com.yuqmettal.voting.entity.EmployeeVotesEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeVotesRepository extends JpaRepository<EmployeeVotesEntity, Long> {

    @Query(value = "SELECT e.id, e.username as username, e.first_name || ' ' || e.last_name as name, count(*) as votes "
            + " FROM vote as v " 
            + " JOIN employes as e on v.employee_id=e.id "
			+ " WHERE date_part('year', v.date) = date_part('year', CURRENT_DATE) and  date_part('month', v.date) = :month "
			+ " GROUP BY e.id, e.username, e.first_name, e.last_name order by votes DESC limit 10", nativeQuery = true)
    List<EmployeeVotesEntity> findTopVotedByMonth(int month);

    @Query(value = "SELECT e.id, e.username as username, e.first_name || ' ' || e.last_name as name, count(*) as votes "
            + " FROM vote as v " 
            + " JOIN employes as e on v.employee_id=e.id "
			+ " WHERE v.area_id = :areaId "
			+ " GROUP BY e.id, e.username, e.first_name, e.last_name order by votes DESC limit 10", nativeQuery = true)
    List<EmployeeVotesEntity> findTopVotedByArea(Long areaId);
    
}