package com.players.app.apis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.players.app.apis.model.Sport;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long>{
	
	@Query(value="select name,count(player_id) from sport group by name having count(player_id) >=2",nativeQuery = true)
	List<Object[]> findSportRegisterdWithMultpilePlayers();
	
	@Query("from Sport where name=:name")
	List<Sport> findByName(@Param("name") String name);
}
