package com.app.service;

import com.app.DTO.QuestionDTO;
import com.app.entity.Grammar;
import com.app.entity.GrammarQuestion;
import com.app.entity.WordQuestion;
import com.app.requestEntity.AddQuestionRequest;
import com.app.requestEntity.Answer;

import java.util.List;

public interface QuestionService {
	 public boolean addGrammarQuestion(AddQuestionRequest addQuestionRequest);
	 public List<QuestionDTO> getListGrammarQuestion(int grammarId);
	public GrammarQuestion deleteGrammarQuestion (int questionId);
	public List<QuestionDTO> getListWordQuestion(int wordId);
	public WordQuestion deleteWordQuestion (int questionId);
	public boolean checkAnswerWordQuestion(int questionId,String answer);
	public boolean checkAnswerGrammarQuestion(int questionId, String answer);
	public int markGrammarQuestion( List<Answer> listAnswer);
	public List<GrammarQuestion> getListGrammarQuestionByAdmin(int grammarId);
	public List<WordQuestion> getListWordQuestionByAdmin(int wordId);
	public int markTopicQuestion( List<Answer> listAnswer,int topicId,int userId);
	public WordQuestion findWordQuestionById(int id);
	public WordQuestion updateWordQuestion(WordQuestion wordQuestion);
	public GrammarQuestion findGrammarQuestionById(int id);
	public GrammarQuestion updateGrammarQuestion(GrammarQuestion grammarQuestion);
	public WordQuestion addWordQuestion(int wordId,int type, String question, String answerA, String answerB, String answerC, String answerD,
									String correctAnswer);
	public List<WordQuestion> getListQuestionInTopic(int topicId);
}
