package com.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "WORD_LEARNT")
public class WordLearnt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WORD_LEARNT_ID")
	private int wordLearntId;
	@Column(name = "WORD_ID")
	private int wordId;
	@Column(name = "USER_ID")
	private int userId;

	public WordLearnt() {
		super();
	}

	public WordLearnt(int wordId, int userId) {
		super();
		this.wordId = wordId;
		this.userId = userId;
	}

	public int getWordLearntId() {
		return wordLearntId;
	}

	public void setWordLearntId(int wordLearntId) {
		this.wordLearntId = wordLearntId;
	}

	public int getWordId() {
		return wordId;
	}

	public void setWordId(int wordId) {
		this.wordId = wordId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
