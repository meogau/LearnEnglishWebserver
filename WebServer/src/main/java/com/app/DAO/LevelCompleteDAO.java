package com.app.DAO;

import com.app.entity.LevelComplete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
@Repository
public class LevelCompleteDAO {
	@Autowired
	private EntityManager entityManager;
	
	
	public boolean addLevelComplete(int levelId,int userId) {
		LevelComplete levelComplete = new LevelComplete(levelId, userId) ;
		entityManager.persist(levelComplete);
		return true;
	}
	
	public List<LevelComplete> getListLevelComplete(int userId){
		String hql ="FROM LevelComplete l WHERE l.userId = "+ userId;
		return entityManager.createQuery(hql,LevelComplete.class).getResultList();
	}
}
