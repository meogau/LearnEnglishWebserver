package com.app.DAO;

import com.app.entity.WordLearnt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
@Repository
public class WordLearntDAO {
	@Autowired
	private EntityManager entityManager;
	
	public boolean addWordLearnt(int wordId, int userId) {
		WordLearnt wordLearnt = new WordLearnt(wordId, userId);
		entityManager.persist(wordLearnt);
		return true;
	}

	public List<WordLearnt> getListWordLearnt(int userId) {
		String hql = "FROM WordLearnt w WHERE w.userId = " + userId;
		return entityManager.createQuery(hql, WordLearnt.class).getResultList();
	}

}
