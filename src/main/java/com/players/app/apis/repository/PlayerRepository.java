package com.players.app.apis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.players.app.apis.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{
	
	@Query("from Player where gender=:gender and level=:level and age=:age")
	List<Player> findPlayers(@Param("gender") String gender,@Param("level")int level,@Param("age")int age);
	
	@Query(value="select * from Player p where p.player_id <> (select player_id from sport)",nativeQuery = true)
	List<Object[]> findPlayersWithNoSports();

}
