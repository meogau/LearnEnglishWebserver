package com.app.DAO;

import com.app.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
@Repository
public class TopicDAO {
	@Autowired
	private EntityManager entityManager;
	
	
	public boolean addTopic(int levelId, String name) {
		
		Topic topic = new Topic(levelId, name);
		entityManager.persist(topic);
		
		return true;
	}
	
	public List<Topic> getListTopic(int levelId){
		String hql ="FROM Topic t WHERE t.levelId = "+ levelId;
		return entityManager.createQuery(hql,Topic.class).getResultList();
	}

	private Topic findTopicById(int topicId){
		String hql ="FROM Topic t WHERE t.topicId = "+ topicId;
		 List<Topic> result = entityManager.createQuery(hql,Topic.class).getResultList();
		 if(result.size()==0) return null;
		 else return result.get(0);
	}

	public boolean deleteTopic(int topicId){
		Topic topic = findTopicById(topicId);
		if(topic.equals(null)) return false;
		else{
			entityManager.remove(topic);
			return true;
		}

	}
	
}
