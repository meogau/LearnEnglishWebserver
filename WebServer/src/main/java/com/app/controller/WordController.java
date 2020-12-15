package com.app.controller;

import com.app.DTO.WordDTO;
import com.app.entity.Word;
import com.app.requestEntity.AddWordRequest;
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
public class WordController {

	@Autowired
	private WordService wordService;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/add-word")
	public ResponseEntity<?> addWord(@RequestBody AddWordRequest addWordRequest) {
		return ResponseEntity.ok(wordService.addWord(addWordRequest));
	}


	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	@RequestMapping("/get-list-word/{topicId}")
	public ResponseEntity<?> getListWord(@PathVariable int topicId) {

		return ResponseEntity.ok(wordService.getListWord(topicId));
	}

	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	@RequestMapping("/get-list-word-by-user")
	public ResponseEntity<?> getListWordByUser(@RequestParam int topicId,@RequestParam int userId) {
		List<Word> wordList = wordService.getListWord(topicId);
		List<WordDTO> wordDTOList = new ArrayList<>();
		for(Word word : wordList){
			WordDTO wordDTO = new WordDTO(word);
			if(wordService.checkWordLearnt(userId,word.getWordId())) wordDTO.setStatus(1);
			wordDTOList.add(wordDTO);
		}
		return ResponseEntity.ok(wordDTOList);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/delete-word/{wordId}")
	public ResponseEntity<?> deleteWord(@PathVariable int wordId) {
		return ResponseEntity.ok(wordService.deleteWord(wordId));
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/find-word-by-id/{wordId}")
	public ResponseEntity<?> findWordById(@PathVariable int wordId) {
		return ResponseEntity.ok(wordService.findWordById(wordId));
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/update-word")
	public ResponseEntity<?> updateWord(@RequestBody Word word) {
		return ResponseEntity.ok(wordService.updateWord(word));
	}
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	@RequestMapping("/get-list-word-learnt/{userId}")
	public ResponseEntity<?> getListWordLearnt(@PathVariable int userId) {
		return ResponseEntity.ok(wordService.getListWordLearnt(userId));
	}

}
