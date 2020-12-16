package com.app.DAO;

import com.app.entity.GrammarQuestion;
import com.app.entity.WordQuestion;
import com.app.requestEntity.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
@Repository
public class WordQuestionDAO {
    @Autowired
    private EntityManager entityManager;
    public WordQuestion addQuestion(int wordId,int type, String question, String answerA, String answerB, String answerC, String answerD,
                               String correctAnswer) {

        WordQuestion ques = new WordQuestion(wordId,type, question, answerA, answerB, answerC, answerD, correctAnswer);
        entityManager.persist(ques);
        entityManager.flush();
        return ques;
    }

    public List<WordQuestion> getListQuestion(int wordId){
        String hql ="FROM WordQuestion q WHERE q.wordId = "+ wordId;
        return entityManager.createQuery(hql, WordQuestion.class).getResultList();
    }

    public WordQuestion findQuestionById(int id){
        String hql ="FROM WordQuestion q WHERE q.questionID = "+ id;
        List<WordQuestion> result = entityManager.createQuery(hql, WordQuestion.class).getResultList();
        if(result.size()==0) return null;
        else  return result.get(0);

    }
    public WordQuestion deleteQuestion (int questionId){
        WordQuestion question = findQuestionById(questionId);
        if(!question.equals(null))entityManager.remove(question);
        return question;
    }

        public WordQuestion updateQuestion(WordQuestion wordQuestion){
        entityManager.merge(wordQuestion);
        entityManager.flush();
        return wordQuestion;
    }
    public boolean checkAnswer(int questionId,String answer){
        WordQuestion wordQuestion = findQuestionById(questionId);
        if(wordQuestion.equals(null)) return false;
        if(wordQuestion.getCorrectAnswer().equals(answer)) return true;
        else return false;
    }
    public int markWord(List<Answer> answerList,int wordId){
        int point = 0;
        for(Answer answer: answerList){
            if(checkAnswer(answer.getQuestionId(),answer.getAnswer())&&(findQuestionById(answer.getQuestionId()).getWordId()==wordId)) point++;
        }
         return point;
    }



}
