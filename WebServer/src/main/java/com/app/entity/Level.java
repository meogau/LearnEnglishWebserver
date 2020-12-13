package com.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "LEVEL")

public class Level {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LEVEL_ID")
	private int levelId;
	private String type;
	private int number;
	private String description;

	public Level(String type, int number, String description) {
		super();
		this.type = type;
		this.number = number;
		this.description = description;
	}

	public Level() {
		super();
	}

	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
