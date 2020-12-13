package com.app.DAO;

import com.app.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
@Repository
public class WordDAO {
	@Autowired
	private EntityManager entityManager;

	public Word addWord(int topicId, String word, String image, String description, String translation,
			String audio) {

		Word w = new Word(topicId, word, image, description, translation, audio);
		entityManager.persist(w);
		entityManager.flush();
		return w;
	}

	public List<Word> getListWord(int topicId) {
		String hql = "FROM Word w WHERE w.topicId = " + topicId;
		return entityManager.createQuery(hql, Word.class).getResultList();
	}

	public Word findWordById(int wordId){
		String hql = "FROM Word w WHERE w.wordId = " + wordId;
		return entityManager.createQuery(hql, Word.class).getResultList().get(0);
	}

	public Word deleteWord(int wordId ){
		Word word = findWordById(wordId);
       if(!word.getWord().equals(null))
       entityManager.remove(word);
       return word;
	}

	public Word updateWord(Word word){
		entityManager.merge(word);
		return word;
	}

}
