package com.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "GRAMMAR")
public class Grammar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GRAMMAR_ID")
	private int grammarId;

	@Column(name = "LEVEL_ID")
	private int levelId;
	private String name;
	private String theories;
	private String example;

	public Grammar(int levelId, String name, String theories, String example) {
		super();
		this.levelId = levelId;
		this.name = name;
		this.theories = theories;
		this.example = example;
	}

	public Grammar() {
		super();
	}

	public int getGrammarId() {
		return grammarId;
	}

	public void setGrammarId(int grammarId) {
		this.grammarId = grammarId;
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

	public String getTheories() {
		return theories;
	}

	public void setTheories(String theories) {
		this.theories = theories;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

}
