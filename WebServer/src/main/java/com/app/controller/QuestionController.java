package com.app.controller;

import com.app.requestEntity.AddQuestionRequest;
import com.app.requestEntity.Answer;
import com.app.requestEntity.AnswerGrammarRequest;

import com.app.responseEntity.MessageAnswerResponse;
import com.app.service.GrammarService;
import com.app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/content")
public class QuestionController {
	@Autowired
	private QuestionService questionService;

	@Autowired
    private GrammarService grammarService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  @GetMapping("/add-grammar-question")
  public ResponseEntity<?> addGrammarQuestion(@RequestBody AddQuestionRequest addQuestionRequest){
	  questionService.addGrammarQuestion(addQuestionRequest);
	  return ResponseEntity.ok(HttpStatus.OK);
  }
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
  @GetMapping("/get-list-grammar-question-by-user/{grammarId}")
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
    @GetMapping("/get-list-word-question-by-user/{wordId}")
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

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @RequestMapping(value = "/mark-answer-grammar-question",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> markGrammarQuestion(@RequestBody AnswerGrammarRequest answerRequest){
       List<Answer> answerList = answerRequest.getListAnswer();
       int userId = answerRequest.getUserId();
       int grammarId = answerRequest.getGrammarId();
        MessageAnswerResponse messageAnswerResponse = new MessageAnswerResponse();
        int point = questionService.markGrammarQuestion(answerList);
        messageAnswerResponse.setPoint(point);
        if(point>=(0.7*(answerList.size()))) {
            grammarService.addGrammarLenarnt(userId,grammarId);
            messageAnswerResponse.setPassStatus(true);
            messageAnswerResponse.setPlusMark(25);
        }
      return ResponseEntity.ok(messageAnswerResponse);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/get-list-word-question/{wordId}")
    public ResponseEntity<?> getListWordQuestionByAd(@PathVariable int wordId){

        return ResponseEntity.ok(questionService.getListWordQuestionByAdmin(wordId));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/get-list-grammar-question/{grammarId}")
    public ResponseEntity<?> getListGrammarQuestionByAdmin(@PathVariable int grammarId){

        return ResponseEntity.ok(questionService.getListGrammarQuestionByAdmin(grammarId));
    }
}
