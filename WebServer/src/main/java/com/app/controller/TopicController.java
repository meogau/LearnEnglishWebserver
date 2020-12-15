package com.app.controller;

import com.app.DTO.TopicDTO;
import com.app.entity.Topic;
import com.app.requestEntity.AddTopicRequest;
import com.app.service.TopicService;
import com.app.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/content")
public class TopicController {
	@Autowired
	private TopicService topicService;
	@Autowired
	private WordService wordService;


	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/add-topic")
	public ResponseEntity<?> addTopic(@RequestBody AddTopicRequest addTopicRequest) {
		return ResponseEntity.ok(topicService.addTopic(addTopicRequest));
	}
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	@RequestMapping("/get-list-topic/{levelId}")
	public ResponseEntity<?> getListGrammar(@PathVariable int levelId) {
		return ResponseEntity.ok(topicService.getListTopic(levelId));
	}

	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	@RequestMapping("/get-list-topic-by-user")
	public ResponseEntity<?> getListGrammarByUser(@RequestParam int userId,@RequestParam int levelId) {
		List<Topic> topicList = topicService.getListTopic(levelId);
		List<TopicDTO> topicDTOList = new ArrayList<>();
        for(Topic topic : topicList){
        	TopicDTO topicDTO = new TopicDTO(topic);
        	topicDTO.setStatus(wordService.getTopicStatus(topic.getTopicId(),userId));
        	topicDTOList.add(topicDTO);
		}

		return ResponseEntity.ok(topicDTOList);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/delete-topic/{topicId}")
	public ResponseEntity<?> deleteTopic(@PathVariable int topicId  ) {
			return ResponseEntity.ok(topicService.deleteTopic(topicId));
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/find-topic-by-id/{topicId}")
	public ResponseEntity<?> findTopicById(@PathVariable int topicId  ) {
			return ResponseEntity.ok(topicService.findTopicById(topicId));
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/update-topic")
	public ResponseEntity<?> findTopicById(@RequestBody Topic topic  ) {
		return ResponseEntity.ok(topicService.updateTopic(topic));
	}

}
