package com.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "grammar_question")
public class GrammarQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUESTION_ID")
	private int questionId;
	@Column(name = "GRAMMAR_ID")
	private int grammarId;
	private String question;
	@Column(name = "ANSWER_A")
	private String answerA;
	@Column(name = "ANSWER_B")
	private String answerB;
	@Column(name = "ANSWER_C")
	private String answerC;
	@Column(name = "ANSWER_D", insertable=false, updatable=false)
	private String answerD;
	@Column(name = "CORRECT_ANSWER" , insertable=false, updatable=false)
	private String correctAnswer;

	
	
	public GrammarQuestion() {
		super();
	}

	public GrammarQuestion(int grammarId, String question, String answerA, String answerB, String answerC, String answerD,
						   String correctAnswer) {
		super();
		this.grammarId = grammarId;
		this.question = question;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.answerD = answerD;
		this.correctAnswer = correctAnswer;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getGrammarId() {
		return grammarId;
	}

	public void setGrammarId(int grammarId) {
		this.grammarId = grammarId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswerA() {
		return answerA;
	}

	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}

	public String getAnswerB() {
		return answerB;
	}

	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}

	public String getAnswerC() {
		return answerC;
	}

	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}

	public String getAnswerD() {
		return answerD;
	}

	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

}
