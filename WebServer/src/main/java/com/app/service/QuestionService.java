package com.app.service;

import com.app.DTO.QuestionDTO;
import com.app.entity.GrammarQuestion;
import com.app.entity.WordQuestion;
import com.app.requestEntity.AddQuestionRequest;
import com.app.requestEntity.Answer;

import java.util.List;

public interface QuestionService {
	 public boolean addGrammarQuestion(AddQuestionRequest addQuestionRequest);
	 public List<QuestionDTO> getListGrammarQuestion(int grammarId);
	public GrammarQuestion deleteGrammarQuestion (int questionId);
	public boolean addWordQuestion(AddQuestionRequest addQuestionRequest);
	public List<QuestionDTO> getListWordQuestion(int wordId);
	public WordQuestion deleteWordQuestion (int questionId);
	public boolean checkAnswerWordQuestion(int questionId,String answer);
	public boolean checkAnswerGrammarQuestion(int questionId, String answer);
	public int markGrammarQuestion( List<Answer> listAnswer);
}
