package com.esp.Sp_kafkaProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.esp.Sp_kafkaProject.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.matchRequest = :request")
	List<User> findByMatchRequest (String request);
}
