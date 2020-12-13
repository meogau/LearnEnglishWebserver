package com.app.service;

import com.app.entity.Topic;
import com.app.requestEntity.AddTopicRequest;

import java.util.List;

public interface TopicService {
	 public boolean addTopic(AddTopicRequest addTopicRequest);
	 public List<Topic> getListTopic(int levelId);
	public boolean deleteTopic(int topicId);
}
