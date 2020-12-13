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
	
	
	public Topic addTopic(int levelId, String name) {
		
		Topic topic = new Topic(levelId, name);
		entityManager.persist(topic);
		entityManager.flush();
		return topic;
	}
	
	public List<Topic> getListTopic(int levelId){
		String hql ="FROM Topic t WHERE t.levelId = "+ levelId;
		return entityManager.createQuery(hql,Topic.class).getResultList();
	}

	public Topic findTopicById(int topicId){
		String hql ="FROM Topic t WHERE t.topicId = "+ topicId;
		 List<Topic> result = entityManager.createQuery(hql,Topic.class).getResultList();
		 if(result.size()==0) return null;
		 else return result.get(0);
	}

	public Topic deleteTopic(int topicId){
		Topic topic = findTopicById(topicId);
		if(topic.equals(null)) return null;
		else{
			entityManager.remove(topic);
			return topic;
		}

	}
	
}
