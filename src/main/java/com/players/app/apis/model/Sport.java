package com.players.app.apis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Sport")
public class Sport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sportId;

	@Column(name = "name", nullable = false)
	private String name;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "player_id", nullable = false)
	private Player player;

	public Sport() {
	}

	public Sport(long sportId, String name, Player player) {
		super();
		this.sportId = sportId;
		this.name = name;
		this.player = player;
	}

	public long getSportId() {
		return sportId;
	}

	public void setSportId(long sportId) {
		this.sportId = sportId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
