package com.app.controller;

import com.app.requestEntity.AddWordRequest;
import com.app.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/content")
public class WordController {

	@Autowired
	private WordService wordService;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/add-word")
	public ResponseEntity<?> addWord(@RequestBody AddWordRequest addWordRequest) {
		wordService.addWord(addWordRequest);
		return ResponseEntity.ok(HttpStatus.OK);
	}


	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	@GetMapping("/get-list-word/{topicId}")
	public ResponseEntity<?> getListGrammar(@PathVariable int topicId) {

		return ResponseEntity.ok(wordService.getListWord(topicId));
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/delete-word/{wordId}")
	public ResponseEntity<?> deleteWord(@PathVariable int wordId) {
		return ResponseEntity.ok(wordService.deleteWord(wordId));
	}
}