package com.esp.Sp_kafkaProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.esp.Sp_kafkaProject.entities.MatchHistory;

@Repository
public interface MatchHistoryRepository extends JpaRepository<MatchHistory, Integer>{

	@Query("SELECT m FROM MatchHistory m WHERE m.matchName = :name ")
	List<MatchHistory> findByMatchName(String name);
	
	
}
