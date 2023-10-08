package com.players.app.apis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.players.app.apis.dto.PlayerRequest;
import com.players.app.apis.model.Player;
import com.players.app.apis.model.Sport;
import com.players.app.apis.repository.PlayerRepository;
import com.players.app.apis.repository.SportRepository;

@Service
public class SportService {

	@Autowired
	private SportRepository sportRepository;

	@Autowired
	private PlayerRepository playerRepository;

	public List<Sport> findAll() {
		return sportRepository.findAll();
	}

	public Optional<Sport> findById(Long id) {
		return sportRepository.findById(id);
	}

	public List<Sport> findByName(String name) {
		return sportRepository.findByName(name);
	}

	public List<Object[]> findSportRegisterdWithMultpilePlayers() {
		return sportRepository.findSportRegisterdWithMultpilePlayers();
	}

	public Sport save(PlayerRequest req) {
		Player player = playerRepository.findById(req.getPlayerId()).get();
		Sport sport = new Sport();
		sport.setName(req.getName());
		sport.setPlayer(player);
		return sportRepository.save(sport);
	}

	public Sport update(PlayerRequest req,Long id) {
		Player player = playerRepository.findById(req.getPlayerId()).get();
		Sport sport = sportRepository.findById(id).get();
		if (player !=null) {			
			sport.setName(req.getName());
			sport.setPlayer(player);
			return sportRepository.save(sport);
		}
		else
		{
			return new Sport();
		}
	}
	
	public void delete(long id) {
		sportRepository.deleteById(id);
	}
	
	

}
