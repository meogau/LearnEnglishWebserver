package com.app.controller;

import com.app.entity.GrammarQuestion;
import com.app.entity.WordQuestion;
import com.app.requestEntity.AddQuestionRequest;
import com.app.requestEntity.Answer;
import com.app.requestEntity.AnswerGrammarRequest;

import com.app.requestEntity.AnswerTopicRequest;
import com.app.responseEntity.MessageAnswerResponse;
import com.app.service.GrammarService;
import com.app.service.QuestionService;
import com.app.service.UserService;
import com.app.service.WordService;
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

	@Autowired
    private WordService wordService;

	@Autowired
    private UserService userService;

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
            messageAnswerResponse.setStatus(1);
            messageAnswerResponse.setPlusMark(25);
            userService.updatePoint(userId,25);
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
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @RequestMapping(value = "/mark-answer-topic-question",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> markTopicQuestion(@RequestBody AnswerTopicRequest answerRequest){
        List<Answer> answerList = answerRequest.getListAnswer();
        int userId = answerRequest.getUserId();
        int topicId = answerRequest.getTopicId();
        int point = questionService.markTopicQuestion(answerList,topicId,userId);
        float status = wordService.getTopicStatus(topicId, userId);
        int plusMark = (int ) (status*30);
        userService.updatePoint(userId,plusMark);
        MessageAnswerResponse messageAnswerResponse = new MessageAnswerResponse(status,point,plusMark);
        return ResponseEntity.ok(messageAnswerResponse);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping(value = "find-grammar-question-by-id/{id}")
    public ResponseEntity<?> findGrammarQuestionById(@PathVariable int id) {
        return ResponseEntity.ok(questionService.findGrammarQuestionById(id));

    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping(value = "find-word-question-by-id/{id}")
    public ResponseEntity<?> findWordQuestionById(@PathVariable int id) {
        return ResponseEntity.ok(questionService.findWordQuestionById(id));

    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping(value = "update-grammar-question")
    public ResponseEntity<?> updateGrammarQuestion(@RequestBody GrammarQuestion grammarQuestion) {
        return ResponseEntity.ok(questionService.updateGrammarQuestion(grammarQuestion));

    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping(value = "update-word-question")
    public ResponseEntity<?> updateWordQuestion(@RequestBody WordQuestion wordQuestion) {
        return ResponseEntity.ok(questionService.updateWordQuestion(wordQuestion));
    }
}
