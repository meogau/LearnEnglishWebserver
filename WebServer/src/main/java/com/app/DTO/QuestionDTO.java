package com.app.DTO;

import com.app.entity.GrammarQuestion;
import com.app.entity.WordQuestion;

public class QuestionDTO {
    private int questionId;
    private int type;
    private  String question;
    private  String answerA;
    private  String answerB;
    private  String answerC;
    private  String answerD;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
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

    public QuestionDTO(GrammarQuestion grammarQuestion) {
        this.questionId= grammarQuestion.getQuestionId();
        this.type= 0;
        this.question = grammarQuestion.getQuestion();
        this.answerA = grammarQuestion.getAnswerA();
        this.answerB = grammarQuestion.getAnswerB();
        this.answerC = grammarQuestion.getAnswerC();
        this.answerD = grammarQuestion.getAnswerD();

    }
    public QuestionDTO(WordQuestion wordQuestion) {
        this.questionId= wordQuestion.getQuestionID();
        this.type= wordQuestion.getType();
        this.question = wordQuestion.getQuestion();
        this.answerA = wordQuestion.getAnswerA();
        this.answerB = wordQuestion.getAnswerB();
        this.answerC = wordQuestion.getAnswerC();
        this.answerD = wordQuestion.getAnswerD();
    }
}
