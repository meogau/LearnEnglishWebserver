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
	
	public boolean addLevel(String type, int number,String description) {
		Level level = new Level(type, number, description);
		entityManager.persist(level);
		return true;
		
	}
	
	public List<Level> getListLevel(){
		String hql = "SELECT level FROM Level level";
		return entityManager.createQuery(hql, Level.class).getResultList();
	}
}