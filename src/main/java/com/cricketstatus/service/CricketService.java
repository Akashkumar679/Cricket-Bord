package com.cricketstatus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cricketstatus.entity.Player;
import com.cricketstatus.repository.PlayerRepository;

@Service
public class CricketService {

	@Autowired
	private PlayerRepository repository;
	
	public Player savePlayer(Player player) {
		return repository.save(player);
	}

	public List<Player> savePlayers(Double x) {
		return repository.saveAll(x);
	}

	public Player playerGetById(Long playerId) {
		return repository.findById((long) playerId ).orElse(null);
	}

	public List<Player> playerfindAll() {
		return repository.findAll();
	}

	public List<String> playerGetByCountry(String country) {
		return repository.findByCountry(country);
	}

	public String playerDeletebyid(Long playerid){
		repository.deleteById((long) playerid);
		return "product deleted successfully" + playerid;
	}

	public Player updatePlayer(Player player) {
		Player existingItem = repository.findById(player.getId()).orElse(null);
		existingItem.setName(player.getName());
		existingItem.setCountry(player.getCountry());
		existingItem.setDateofBirth(player.getDateofBirth());
		return repository.save(existingItem);
	}
}
