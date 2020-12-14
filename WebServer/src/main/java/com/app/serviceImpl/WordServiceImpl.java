package com.app.serviceImpl;

import com.app.DAO.TopicDAO;
import com.app.DAO.WordDAO;
import com.app.DAO.WordLearntDAO;
import com.app.entity.Word;
import com.app.entity.WordLearnt;
import com.app.requestEntity.AddWordRequest;
import com.app.requestEntity.Answer;
import com.app.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class WordServiceImpl implements WordService {

	@Autowired
	private WordDAO wordDAO;
	@Autowired
	private WordLearntDAO wordLearntDAO;
	@Autowired
	private TopicDAO topicDAO;
	
	@Override
	public Word addWord(AddWordRequest addWordRequest) {
		return wordDAO.addWord( addWordRequest.getTopicId(),  addWordRequest.getWord(),  addWordRequest.getImage(),  addWordRequest.getDescription(),
				addWordRequest.getTranslation(),  addWordRequest.getAudio());
	}

	@Override
	public List<Word> getListWord(int topicId) {
		return wordDAO.getListWord(topicId);
	}

	@Override
	public Word deleteWord(int wordId) {
		return wordDAO.deleteWord(wordId);
	}

	@Override
	public Word findWordById(int wordId) {
		return wordDAO.findWordById(wordId);
	}

	@Override
	public Word updateWord(Word word) {
		return wordDAO.updateWord(word);
	}

	@Override
	public List<Word> getListWordLearnt(int userId) {
		List<Word> listWord = new ArrayList<>();
		List<WordLearnt> wordLearntList = wordLearntDAO.getListWordLearnt(userId);
		for(WordLearnt wordLearnt : wordLearntList){
			listWord.add(wordDAO.findWordById(userId));
		}

		return listWord;
	}



}
