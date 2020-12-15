package com.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "GRAMMAR_LEARNT")
public class GrammarLearnt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GRAMMAR_LEARNT_ID")
     private int grammarLearnId;
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "GRAMMAR_ID")
	private int grammarId;
	
	
	
	
	public GrammarLearnt() {
		super();
	}
	public GrammarLearnt(int userId, int grammarId) {
		super();
		this.userId = userId;
		this.grammarId = grammarId;
	}
	public int getGrammarLearnId() {
		return grammarLearnId;
	}
	public void setGrammarLearnId(int grammarLearnId) {
		this.grammarLearnId = grammarLearnId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGrammarId() {
		return grammarId;
	}
	public void setGrammarId(int grammarId) {
		this.grammarId = grammarId;
	}
	
}
