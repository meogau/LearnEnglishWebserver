package com.app.controller;

import com.app.requestEntity.AddQuestionRequest;
import com.app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/content")
public class QuestionController {
	@Autowired
	private QuestionService questionService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  @GetMapping("/add-grammar-question")
  public ResponseEntity<?> addGrammarQuestion(@RequestBody AddQuestionRequest addQuestionRequest){
	  questionService.addGrammarQuestion(addQuestionRequest);
	  return ResponseEntity.ok(HttpStatus.OK);
  }
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
  @GetMapping("/get-list-grammar-question/{grammarId}")
  public ResponseEntity<?> getListGrammarQuestion(@PathVariable int grammarId){
	 
	  return ResponseEntity.ok(questionService.getListGrammarQuestion(grammarId));
  }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/delete-grammar-question/{questionId}")
    public ResponseEntity<?> deleteGrammarQuestion(@PathVariable int questionId ){
        questionService.deleteGrammarQuestion(questionId);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/get-list-word-question/{wordId}")
    public ResponseEntity<?> getListWordQuestion(@PathVariable int wordId){

        return ResponseEntity.ok(questionService.getListWordQuestion(wordId));
    }
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/check-answer-word-question")
    public ResponseEntity<Boolean> checkAnswer(@RequestParam int questionId, @RequestParam String answer){
        return ResponseEntity.ok(questionService.checkAnswerWordQuestion(questionId,answer));
    }
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/check-answer-grammar-question")
    public ResponseEntity<Boolean> checkAnswerGrammar(@RequestParam int questionId, @RequestParam String answer){
        return ResponseEntity.ok(questionService.checkAnswerGrammarQuestion(questionId,answer));
    }
}
