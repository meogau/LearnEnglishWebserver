package com.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "LEVEL_COMPLETE")
public class LevelComplete {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LEVEL_COMPLETE_ID")
	private int levelCompleteId;
	@Column(name = "LEVEL_ID")
	private int levelId;
	@Column(name = "USER_ID")
	private int userId;

	
	
	public LevelComplete() {
		super();
	}

	public LevelComplete(int levelId, int userId) {
		super();
		this.levelId = levelId;
		this.userId = userId;
	}

	public int getLevelCompleteId() {
		return levelCompleteId;
	}

	public void setLevelCompleteId(int levelCompleteId) {
		this.levelCompleteId = levelCompleteId;
	}

	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
