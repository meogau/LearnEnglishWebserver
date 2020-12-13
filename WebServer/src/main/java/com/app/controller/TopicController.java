package com.app.controller;

import com.app.entity.Topic;
import com.app.requestEntity.AddTopicRequest;
import com.app.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/content")
public class TopicController {
	@Autowired
	private TopicService topicService;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/add-topic")
	public ResponseEntity<?> addTopic(@RequestBody AddTopicRequest addTopicRequest) {
		return ResponseEntity.ok(topicService.addTopic(addTopicRequest));
	}
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	@GetMapping("/get-list-topic/{levelId}")
	public ResponseEntity<?> getListGrammar(@PathVariable int levelId) {
		return ResponseEntity.ok(topicService.getListTopic(levelId));
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/delete-topic/{topicId}")
	public ResponseEntity<?> deleteTopic(@PathVariable int topicId  ) {
			return ResponseEntity.ok(topicService.deleteTopic(topicId));
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/find-topic-by-id/{topicId}")
	public ResponseEntity<?> findTopicById(@PathVariable int topicId  ) {
			return ResponseEntity.ok(topicService.findTopicById(topicId));
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/update-topic")
	public ResponseEntity<?> findTopicById(@RequestBody Topic topic  ) {
		return ResponseEntity.ok(topicService.updateTopic(topic));
	}

}
