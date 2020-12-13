package com.app.controller;

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
		topicService.addTopic(addTopicRequest);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	@GetMapping("/get-list-topic/{levelId}")
	public ResponseEntity<?> getListGrammar(@PathVariable int levelId) {
		return ResponseEntity.ok(topicService.getListTopic(levelId));
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/delete-topic/{topicId}")
	public ResponseEntity<?> deleteTopic(@PathVariable int topicId  ) {
		if(topicService.deleteTopic(topicId))
			return ResponseEntity.ok(HttpStatus.OK);
		else
			return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
	}

}
