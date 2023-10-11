package com.cricketstatus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cricketstatus.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long>{

	List<String> findByCountry(String country);

	List<Player> saveAll(Double x);


	
}
