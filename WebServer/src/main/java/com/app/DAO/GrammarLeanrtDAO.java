package com.app.DAO;

import com.app.entity.GrammarLearnt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
@Repository
public class GrammarLeanrtDAO {
	@Autowired
	private EntityManager entityManager;
	
	public boolean addGrammarLearnt(int userId,int grammarId) {
		GrammarLearnt grammarLearnt = new GrammarLearnt(userId, grammarId) ;
		entityManager.persist(grammarLearnt);
		return true;
	}
	
	public List<GrammarLearnt> getListGrammarLearnt(int userId){
		String hql ="FROM GrammarLearnt g WHERE g.userId = "+ userId;
		return entityManager.createQuery(hql,GrammarLearnt.class).getResultList();
	}

	
	
}