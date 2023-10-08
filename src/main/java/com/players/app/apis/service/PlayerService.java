package com.players.app.apis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.players.app.apis.model.Player;
import com.players.app.apis.repository.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;

	
	public List<Player> findAll() {
        return playerRepository.findAll();
    }

	public List<Player> findAll(Pageable pageable) {
        Page<Player> playerPage = playerRepository.findAll(pageable);
        List<Player> playerList = playerPage.getContent();
        return playerList;
    }
	
    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }
    
    public List<Player> findPlayers(String gender,int level,int age) {
        return playerRepository.findPlayers(gender,level,age);
    }
    
    public List<Object[]> findPlayersWithNoSports(){
		return playerRepository.findPlayersWithNoSports();
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public void delete(long id) {
    	playerRepository.deleteById(id);
	}
}
