package com.players.app.apis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.players.app.apis.dto.PlayerRequest;
import com.players.app.apis.model.Sport;
import com.players.app.apis.service.SportService;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin  - By passing all ingress-proxy traffic
public class SportController {
	@Autowired
	private SportService sportService;

	@GetMapping("/sports")
	public ResponseEntity<List<Sport>> getAllPlayers() {
		return new ResponseEntity<List<Sport>>(sportService.findAll(), HttpStatus.OK);
		// TODO:: need to handle error response as well
	}

	@GetMapping("/sports/{id}")
	public ResponseEntity<Optional<Sport>> findById(@PathVariable Long id) {
		return new ResponseEntity<Optional<Sport>>(sportService.findById(id), HttpStatus.OK);
		// TODO:: need to handle error response as well
	}

	@GetMapping("/sports/findSportsRegisterdWithMultpilePlayers")
	public List<Object[]> findSportRegisterdWithMultpilePlayers() {
		return sportService.findSportRegisterdWithMultpilePlayers();
	}

	@GetMapping("/sports/findByName")
	public List<Sport> findByName(@RequestParam("name") String name) {
		return sportService.findByName(name);
	}

	@PostMapping("/sports")
	public Sport savesportsData(@RequestBody PlayerRequest playerRequest) {
		return sportService.save(playerRequest);
	}

	@PutMapping("/sports/{id}")
	public Sport updatesportsData(@RequestBody PlayerRequest playerRequest, @PathVariable Long id) {
		return sportService.update(playerRequest, id);
	}

	@DeleteMapping("/sports/{id}")
	public void delete(@PathVariable long id) {
		sportService.delete(id);
	}
}
