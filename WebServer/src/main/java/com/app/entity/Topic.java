package com.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "TOPIC")
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TOPIC_ID")
	private int topicId;
	@Column(name = "LEVEL_ID")
	private int levelId;
	private String name;

	public Topic() {
		super();
	}

	public Topic(int levelId, String name) {
		super();
		this.levelId = levelId;
		this.name = name;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
