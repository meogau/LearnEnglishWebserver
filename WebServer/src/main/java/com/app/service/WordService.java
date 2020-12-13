package com.app.service;

import com.app.entity.Word;
import com.app.requestEntity.AddWordRequest;

import java.util.List;

public interface WordService {
	public boolean addWord(AddWordRequest addWordRequest);
	public List<Word> getListWord(int topicId);
	public Word deleteWord(int wordId );
	public Word findWordById(int wordId);
}
