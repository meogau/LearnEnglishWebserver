package com.app.serviceImpl;

import com.app.DAO.*;
import com.app.DTO.QuestionDTO;
import com.app.entity.GrammarQuestion;
import com.app.entity.Word;
import com.app.entity.WordQuestion;
import com.app.requestEntity.AddQuestionRequest;
import com.app.requestEntity.Answer;
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
	@Autowired
	private GrammarLeanrtDAO grammarLeanrtDAO;
	@Autowired
	private UserInfoDAO userInfoDAO;
	@Autowired
	WordDAO wordDAO;
	@Autowired
	WordLearntDAO wordLearntDAO;

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

	@Override
	public int markGrammarQuestion( List<Answer> listAnswer) {
		int point =0;
		for(Answer answer :listAnswer){
			if(grammarQuestionDAO.checkAnswer(answer.getQuestionId(),answer.getAnswer())) point++;
		}
		return point;
	}

	@Override
	public List<GrammarQuestion> getListGrammarQuestionByAdmin(int grammarId) {
		return grammarQuestionDAO.getListQuestion(grammarId);
	}

	@Override
	public List<WordQuestion> getListWordQuestionByAdmin(int wordId) {
		return wordQuestionDAO.getListQuestion(wordId);
	}

	@Override
	public int markTopicQuestion(List<Answer> listAnswer, int topicId, int userId) {
		int point = 0;
		List<Word> wordList = wordDAO.getListWord(topicId);
		//cham diem cho tung word
		for(Word word : wordList){
			int pointPerWord = wordQuestionDAO.markWord(listAnswer,word.getWordId());
			point += pointPerWord;
			int numOfQuestionPerWord = wordQuestionDAO.getListQuestion(word.getWordId()).size();
			if(pointPerWord>=(0.75)*numOfQuestionPerWord) wordLearntDAO.addWordLearnt(word.getWordId(),userId);
		}

		return point;
	}

	@Override
	public WordQuestion findWordQuestionById(int id) {
		return wordQuestionDAO.findQuestionById(id);
	}

	@Override
	public WordQuestion updateWordQuestion(WordQuestion wordQuestion) {
		return wordQuestionDAO.updateQuestion(wordQuestion);
	}

	@Override
	public GrammarQuestion findGrammarQuestionById(int id) {
		return grammarQuestionDAO.findQuestionById(id);
	}

	@Override
	public GrammarQuestion updateGrammarQuestion(GrammarQuestion grammarQuestion) {
		return grammarQuestionDAO.updateGrammarQuestion(grammarQuestion);
	}

	@Override
	public WordQuestion addWordQuestion(int wordId, int type, String question, String answerA, String answerB, String answerC, String answerD, String correctAnswer) {
		return wordQuestionDAO.addQuestion(wordId,type, question, answerA ,answerB, answerC , answerD, correctAnswer);
	}


}
