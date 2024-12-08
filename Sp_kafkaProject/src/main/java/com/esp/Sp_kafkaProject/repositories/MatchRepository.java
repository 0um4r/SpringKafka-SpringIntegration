package com.esp.Sp_kafkaProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.esp.Sp_kafkaProject.entities.BasketMatch;

@Repository
public interface MatchRepository extends JpaRepository<BasketMatch, Integer> {

	@Query("SELECT b FROM BasketMatch b WHERE b.matchName = :basket")
	BasketMatch findByMatchName(String basket);
}
