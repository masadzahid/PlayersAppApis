package com.players.app.apis.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long playerId;
	@Column(name = "email", nullable = false)
	private String email;	
	@Range(min=1, max=10)
	@Column(name = "level", nullable = false )
	private int level;
	@Column(name = "age", nullable = false)
	private int age;
	@Pattern(regexp = "male|female", flags = Pattern.Flag.CASE_INSENSITIVE)
	@Column(name = "gender", nullable = false)
	private String gender;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "player")
	private List<Sport> sport;

	public Player() {
	}

	public Player(long playerId, String email, int level, int age, String gender, List<Sport> sport) {
		super();
		this.playerId = playerId;
		this.email = email;
		this.level = level;
		this.age = age;
		this.gender = gender;
		this.sport = sport;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Sport> getSport() {
		return sport;
	}

	public void setSport(List<Sport> sport) {
		this.sport = sport;
	}

}
