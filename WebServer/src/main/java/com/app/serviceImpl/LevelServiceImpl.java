package com.app.serviceImpl;

import com.app.DAO.*;
import com.app.entity.Grammar;
import com.app.entity.Level;
import com.app.entity.Topic;
import com.app.entity.Word;
import com.app.requestEntity.AddLevelRequest;
import com.app.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LevelServiceImpl implements LevelService {
@Autowired
private LevelDAO levelDAO;
@Autowired
private WordDAO wordDAO;
@Autowired
private WordLearntDAO wordLearntDAO;
@Autowired
private TopicDAO topicDAO;
@Autowired
private GrammarDAO grammarDAO;
@Autowired
private GrammarLeanrtDAO grammarLeanrtDAO;

	
	
	@Override
	public Level addLevel(AddLevelRequest addLevelRequest) {
		return levelDAO.addLevel(addLevelRequest.getType(), addLevelRequest.getNumber(), addLevelRequest.getDescription());
	}

	@Override
	public List<Level> getListLevel() {
		return levelDAO.getListLevel();
		
	}

	@Override
	public Level findLevelById(int levelId) {
		return levelDAO.findLevelById(levelId);
	}

	@Override
	public Level deleteLevel(int levelId) {
		return levelDAO.deleteLevel(levelId);
	}

	@Override
	public Level updateLevel(Level level) {
		return levelDAO.updateLevel(level);
	}

	@Override
	public List<Level> getListLevelByUser(int leverUnlock) {
		return levelDAO.getListLevelByUser(leverUnlock);
	}

	@Override
	public boolean checkPassLevel(int userId, int LevelId) {
		List<Topic> topicList = topicDAO.getListTopic(LevelId);
		for(Topic topic : topicList){
			if(getTopicStatus(topic.getTopicId(),userId)<0.75) return false;
		}
		List<Grammar> grammarList = grammarDAO.getListGrammarInLevel(LevelId);
		for(Grammar grammar : grammarList){
			if(grammarLeanrtDAO.checkGrammarLearnt(userId,grammar.getGrammarId())!=true) return false;
		}
		return true;
	}
	public float getTopicStatus(int topicId, int userId) {
		List<Word> wordList = wordDAO.getListWord(topicId);
		int point =0;
		for(Word word : wordList){
			if(wordLearntDAO.checkWordLearnt(userId,word.getWordId())) point++;
		}
		float status = (float) point /(float) (wordList.size());
		return status;
	}

}
