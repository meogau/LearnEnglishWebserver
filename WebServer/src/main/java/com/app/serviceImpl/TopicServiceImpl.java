package com.app.serviceImpl;

import com.app.DAO.TopicDAO;
import com.app.entity.Topic;
import com.app.requestEntity.AddTopicRequest;
import com.app.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicDAO topicDAO;
	
	@Override
	public boolean addTopic(AddTopicRequest addTopicRequest) {
		return topicDAO.addTopic(addTopicRequest.getLevelId(), addTopicRequest.getName());
	}

	@Override
	public List<Topic> getListTopic(int levelId) {
		
		return topicDAO.getListTopic(levelId);
	}

	@Override
	public boolean deleteTopic(int topicId) {
		return topicDAO.deleteTopic(topicId);
	}

}
