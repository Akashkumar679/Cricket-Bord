package com.cricketstatus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cricketstatus.entity.Player;
import com.cricketstatus.service.CricketService;

@RestController
public class PlayerController {

	@Autowired
	private CricketService service;
	
	@PostMapping("/add")
	public ResponseEntity<String> addPlayer(@RequestBody Player player){
		service.savePlayer(player);
		return ResponseEntity.ok("Player added Successfully");
	}
	
	@PutMapping("/update/{playerid}")
	public ResponseEntity<String> upDatePlayer(@PathVariable Long playerId,@RequestBody Player player){
		service.updatePlayer(player);
		
		return ResponseEntity.ok("Player update successfully");
	}
	
	@DeleteMapping("/delet/{playerId}")
	public ResponseEntity<String> deletPlayer(@PathVariable Long playerId){
		service.playerDeletebyid(playerId);
		return ResponseEntity.ok("Player Deleted Successfully");
	}
	
	@GetMapping("/{playerId}")
	public ResponseEntity<Player> getplayerByid(@PathVariable Long playerId){
		Player player = service.playerGetById(playerId);
		
		return ResponseEntity.ok(player);
	}
	@GetMapping("/averagescore/{x}")
	public ResponseEntity<List<Player>> getPlayerWithAverageScoreGreaterThan(@PathVariable Double x){
		service.savePlayers(x);
		return new ResponseEntity<List<Player>>(HttpStatus.OK);
	}
	@GetMapping("/byCountry/{country}")
	public ResponseEntity<List<Player>> getPlayerByCountry(@PathVariable String country){
		service.playerGetByCountry(country);
		return new ResponseEntity<List<Player>>(HttpStatus.OK);
	}
}
