package com.app.service;

import com.app.entity.Topic;
import com.app.requestEntity.AddTopicRequest;

import java.util.List;

public interface TopicService {
	 public Topic addTopic(AddTopicRequest addTopicRequest);
	 public List<Topic> getListTopic(int levelId);
	public Topic deleteTopic(int topicId);
	public Topic findTopicById(int topicId);
	public Topic updateTopic(Topic topic);

}
