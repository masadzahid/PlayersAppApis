package com.players.app.apis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.players.app.apis.model.Player;
import com.players.app.apis.service.PlayerService;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin  - By passing all ingress-proxy traffic
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@GetMapping("/players")
	public ResponseEntity<List<Player>> getAllPlayers() {
		return new ResponseEntity<List<Player>>(playerService.findAll(), HttpStatus.OK);		
		// TODO:: need to handle error response as well
	}

	@GetMapping("/players/{id}")
	public ResponseEntity<Optional<Player>> findById(@PathVariable Long id) {
		return new ResponseEntity<Optional<Player>>(playerService.findById(id), HttpStatus.OK);
		// TODO:: need to handle error response as well
	}

	@GetMapping("/playersList")
	public List<Player> getAllPlayersPagination(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return playerService.findAll(pageable);
	}

	@GetMapping("/players/findPlayers")
	public List<Player> findPlayers(@RequestParam("gender") String gender, @RequestParam("level") int level,@RequestParam("age") int age) {
		return playerService.findPlayers(gender, level, age);
	}

	@GetMapping("/players/findPlayersWithNoSports")
	public List<Object[]> findPlayersWithNoSports() {
		return playerService.findPlayersWithNoSports();
	}

	@PostMapping("/players")
	public Player createPlayer(@RequestBody Player player) {
		return playerService.save(player);
	}

	@DeleteMapping("/players/{id}")
	public void delete(@PathVariable long id) {
		playerService.delete(id);
	}
}
