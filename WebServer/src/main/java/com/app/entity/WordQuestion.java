package com.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "word_question")
public class WordQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTION_ID")
    private int questionID;
    @Column(name = "WORD_ID")
    private int wordId;
    @Column(name = "TYPE")
    private int type;
    private String question;
    @Column(name = "ANSWER_A")
    private String answerA;
    @Column(name = "ANSWER_B")
    private String answerB;
    @Column(name = "ANSWER_C")
    private String answerC;
    @Column(name = "ANSWER_D")
    private String answerD;
    @Column(name = "CORRECT_ANSWER")
    private String correctAnswer;

    public WordQuestion() {
    }

    public WordQuestion(int wordId, int type, String question, String answerA, String answerB, String answerC, String answerD, String correctAnswer) {

        this.wordId = wordId;
        this.type = type;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
    }

    public WordQuestion(int wordId, int type, String question, String answerB, String answerC, String answerD, String correctAnswer) {
        this.wordId = wordId;
        this.type = type;
        this.question = question;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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