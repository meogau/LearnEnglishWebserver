package com.app.DAO;

import com.app.entity.Grammar;
import com.app.entity.GrammarQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
@Repository
public class GrammarQuestionDAO {
	@Autowired
	private EntityManager entityManager;
	
	public boolean addQuestion(int grammarId, String question, String answerA, String answerB, String answerC, String answerD,
			String correctAnswer) {
		
		GrammarQuestion ques = new GrammarQuestion(grammarId, question, answerA, answerB, answerC, answerD, correctAnswer);
		entityManager.persist(ques);
		return true;
	}
	
	public List<GrammarQuestion> getListQuestion(int grammarId){
		String hql ="FROM GrammarQuestion q WHERE q.grammarId = "+ grammarId;
		return entityManager.createQuery(hql, GrammarQuestion.class).getResultList();
	}
	 public GrammarQuestion findQuestionById(int id){
		 String hql ="FROM GrammarQuestion q WHERE q.questionId = "+ id;
		 List<GrammarQuestion> listResult= entityManager.createQuery(hql, GrammarQuestion.class).getResultList();
		 if(listResult.size()==0) return null;
		 else return listResult.get(0);
	 }
    public GrammarQuestion deleteQuestion (int questionId){
		GrammarQuestion question = findQuestionById(questionId);
		if(!question.equals(null))entityManager.remove(question);
		return question;
	}
	public GrammarQuestion updateGrammarQuestion(GrammarQuestion grammarQuestion){
		entityManager.merge(grammarQuestion);
		entityManager.flush();
		return grammarQuestion;
	}
	public boolean checkAnswer(int questionId, String answer){
		GrammarQuestion grammarQuestion = findQuestionById(questionId);
		if(grammarQuestion.equals(null)) return false;
		if(grammarQuestion.getCorrectAnswer().equals(answer)) return true;
		else return false;
	}
}
