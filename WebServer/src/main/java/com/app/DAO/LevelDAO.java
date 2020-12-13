package com.app.DAO;

import com.app.entity.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
@Repository
public class LevelDAO {
	@Autowired
	private EntityManager entityManager;
	
	public Level addLevel(String type, int number,String description) {
		Level level = new Level(type, number, description);
		entityManager.persist(level);
		entityManager.flush();
		return level;
		
	}
	public List<Level> getListLevel(){
		String hql = "SELECT level FROM Level level";
		return entityManager.createQuery(hql, Level.class).getResultList();
	}
	public Level findLevelById(int levelId){
		String hql = "SELECT level FROM Level level WHERE level.levelId = "+ levelId;
		List<Level> listResult= entityManager.createQuery(hql, Level.class).getResultList();
		if(listResult.size()==0) return null;
		else return listResult.get(0);
	}
	public Level deleteLevel(int levelId){
		Level level = findLevelById(levelId);
		if(level.equals(null)) return null;
		entityManager.remove(level);
		return level;

	}

}
