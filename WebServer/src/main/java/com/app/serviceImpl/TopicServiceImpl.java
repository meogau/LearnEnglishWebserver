package com.app.serviceImpl;

import com.app.DAO.TopicDAO;
import com.app.DAO.WordDAO;
import com.app.entity.Topic;
import com.app.entity.Word;
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
	@Autowired
	private WordDAO wordDAO;
	
	@Override
	public Topic addTopic(AddTopicRequest addTopicRequest) {
		return topicDAO.addTopic(addTopicRequest.getLevelId(), addTopicRequest.getName());
	}

	@Override
	public List<Topic> getListTopic(int levelId) {
		
		return topicDAO.getListTopic(levelId);
	}

	@Override
	public Topic deleteTopic(int topicId) {
		return topicDAO.deleteTopic(topicId);
	}

	@Override
	public Topic findTopicById(int topicId) {
		return topicDAO.findTopicById(topicId);
	}

	@Override
	public Topic updateTopic(Topic topic) {
		return topicDAO.updateTopic(topic);
	}


}
