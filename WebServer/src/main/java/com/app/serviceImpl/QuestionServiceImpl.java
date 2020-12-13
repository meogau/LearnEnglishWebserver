package com.app.serviceImpl;

import com.app.DAO.GrammarQuestionDAO;
import com.app.DAO.WordQuestionDAO;
import com.app.DTO.QuestionDTO;
import com.app.entity.GrammarQuestion;
import com.app.entity.Word;
import com.app.entity.WordQuestion;
import com.app.requestEntity.AddQuestionRequest;
import com.app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private GrammarQuestionDAO grammarQuestionDAO;
	@Autowired
	private WordQuestionDAO wordQuestionDAO;

	@Override
	public boolean addGrammarQuestion(AddQuestionRequest addQuestionRequest) {
		
		return grammarQuestionDAO.addQuestion(addQuestionRequest.getGrammarId(), addQuestionRequest.getQuestion(), addQuestionRequest.getAnswerA(),
				addQuestionRequest.getAnswerB(), addQuestionRequest.getAnswerC(), addQuestionRequest.getAnswerC(), addQuestionRequest.getAnswerD());
	}

	@Override
	public List<QuestionDTO> getListGrammarQuestion(int grammarId) {
		List<GrammarQuestion> grammarQuestionList= grammarQuestionDAO.getListQuestion(grammarId);
		List<QuestionDTO> questionDTOList = new ArrayList<>();
		for(GrammarQuestion grammarQuestion : grammarQuestionList){
			questionDTOList.add(new QuestionDTO(grammarQuestion));
		}
		return questionDTOList;
	}

	@Override
	public GrammarQuestion deleteGrammarQuestion(int questionId) {
		return grammarQuestionDAO.deleteQuestion(questionId);
	}

	@Override
	public boolean addWordQuestion(AddQuestionRequest addQuestionRequest) {
		return false;
	}

	@Override
	public List<QuestionDTO> getListWordQuestion(int wordId) {
		List<WordQuestion> wordQuestionList = wordQuestionDAO.getListQuestion(wordId);
		List<QuestionDTO> questionDTOList = new ArrayList<>();
		for(WordQuestion wordQuestion : wordQuestionList){
			questionDTOList.add(new QuestionDTO(wordQuestion));
		}
		return questionDTOList;
	}

	@Override
	public WordQuestion deleteWordQuestion(int questionId) {
		return wordQuestionDAO.deleteQuestion(questionId);
	}

	@Override
	public boolean checkAnswerWordQuestion(int questionId, String answer) {
		return wordQuestionDAO.checkAnswer(questionId,answer);
	}

	@Override
	public boolean checkAnswerGrammarQuestion(int questionId, String answer) {
		return grammarQuestionDAO.checkAnswer(questionId,answer);
	}


}