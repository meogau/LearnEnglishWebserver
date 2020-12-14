package com.app.service;

import com.app.entity.Word;
import com.app.entity.WordLearnt;
import com.app.requestEntity.AddWordRequest;
import com.app.requestEntity.Answer;

import java.util.List;

public interface WordService {
	public Word addWord(AddWordRequest addWordRequest);
	public List<Word> getListWord(int topicId);
	public Word deleteWord(int wordId );
	public Word findWordById(int wordId);
	public Word updateWord(Word word);
	public List<Word> getListWordLearnt(int userId);

}
