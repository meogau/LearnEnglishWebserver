package com.app.controller;

import com.app.DAO.GrammarDAO;
import com.app.DAO.TopicDAO;
import com.app.DTO.QuestionDTO;
import com.app.entity.GrammarQuestion;
import com.app.entity.WordQuestion;
import com.app.requestEntity.*;

import com.app.responseEntity.MessageAnswerResponse;
import com.app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

	@Autowired
    LevelService levelService;
	@Autowired
    TopicService topicService;


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  @RequestMapping("/add-grammar-question")
  public ResponseEntity<?> addGrammarQuestion(@RequestBody AddQuestionRequest addQuestionRequest){
	  questionService.addGrammarQuestion(addQuestionRequest);
	  return ResponseEntity.ok(HttpStatus.OK);
  }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping("/add-word-question")
    public ResponseEntity<?> addWordQuestion(@RequestBody AddWordQuestionRequest addWordQuestionRequest){
        questionService.addWordQuestion(addWordQuestionRequest.getWordId(),addWordQuestionRequest.getType(), addWordQuestionRequest.getQuestion(),
                addWordQuestionRequest.getAnswerA(), addWordQuestionRequest.getAnswerB(),addWordQuestionRequest.getAnswerC(), addWordQuestionRequest.getAnswerD(),addWordQuestionRequest.getCorrectAnswer()
        );
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
  @RequestMapping("/get-list-grammar-question-by-user/{grammarId}")
  public ResponseEntity<?> getListGrammarQuestion(@PathVariable int grammarId){
	  return ResponseEntity.ok(questionService.getListGrammarQuestion(grammarId));
  }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping("/delete-grammar-question/{questionId}")
    public ResponseEntity<?> deleteGrammarQuestion(@PathVariable int questionId ){
        questionService.deleteGrammarQuestion(questionId);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @RequestMapping("/get-list-word-question-by-user/{topicId}")
    public ResponseEntity<?> getListWordQuestion(@PathVariable int topicId){
        List<WordQuestion> wordQuestionList = questionService.getListQuestionInTopic(topicId);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for(WordQuestion wordQuestion : wordQuestionList){
            questionDTOList.add(new QuestionDTO(wordQuestion));
        }
        return ResponseEntity.ok(questionDTOList);
    }
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @RequestMapping("/check-answer-word-question")
    public ResponseEntity<Boolean> checkAnswer(@RequestParam int questionId, @RequestParam String answer){
        return ResponseEntity.ok(questionService.checkAnswerWordQuestion(questionId,answer));
    }
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @RequestMapping("/check-answer-grammar-question")
    public ResponseEntity<Boolean> checkAnswerGrammar(@RequestParam int questionId, @RequestParam String answer){
        return ResponseEntity.ok(questionService.checkAnswerGrammarQuestion(questionId,answer));
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @RequestMapping(value = "/mark-answer-grammar-question",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> markGrammarQuestion(@RequestBody AnswerGrammarRequest answerRequest){
       List<Answer> answerList = answerRequest.getListAnswer();
       int userId = answerRequest.getUserId();
       int grammarId = answerRequest.getGrammarId();
        //check level status----------
        int levelId = grammarService.findGrammarById(grammarId).getLevelId();
        boolean levelStatusBefore = levelService.checkPassLevel(userId,levelId);
        //----------------------------
        MessageAnswerResponse messageAnswerResponse = new MessageAnswerResponse();
        int point = questionService.markGrammarQuestion(answerList);
        messageAnswerResponse.setPoint(point);
        if(point>=(0.7*(answerList.size()))) {
            grammarService.addGrammarLenarnt(userId,grammarId);
            messageAnswerResponse.setStatus(1);
            messageAnswerResponse.setPlusMark(25);
            userService.updatePoint(userId,25);
        }

        //check level status after-----------------------------------------------
        boolean levelStatusAfter = levelService.checkPassLevel(userId,levelId);
        if(levelStatusAfter!=levelStatusBefore) userService.unlockLevel(userId);

        return ResponseEntity.ok(messageAnswerResponse);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping("/get-list-word-question/{wordId}")
    public ResponseEntity<?> getListWordQuestionByAd(@PathVariable int wordId){

        return ResponseEntity.ok(questionService.getListWordQuestionByAdmin(wordId));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping("/get-list-grammar-question/{grammarId}")
    public ResponseEntity<?> getListGrammarQuestionByAdmin(@PathVariable int grammarId){
        return ResponseEntity.ok(questionService.getListGrammarQuestionByAdmin(grammarId));
    }
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @RequestMapping(value = "/mark-answer-topic-question",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> markTopicQuestion(@RequestBody AnswerTopicRequest answerRequest){

        List<Answer> answerList = answerRequest.getListAnswer();
        int userId = answerRequest.getUserId();
        int topicId = answerRequest.getTopicId();
        //check level status----------
        int levelId = topicService.findTopicById(topicId).getLevelId();
        boolean levelStatusBefore = levelService.checkPassLevel(userId,levelId);
        //----------------------------------------------
        int point = questionService.markTopicQuestion(answerList,topicId,userId);
        float status = wordService.getTopicStatus(topicId, userId);
        int plusMark = (int ) (status*30);
        userService.updatePoint(userId,plusMark);
        //check level status after-----------------------------------------------
        boolean levelStatusAfter = levelService.checkPassLevel(userId,levelId);
        if(levelStatusAfter!=levelStatusBefore) userService.unlockLevel(userId);


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

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @RequestMapping("/get-question-for-first-test")
public ResponseEntity<?> getQuestionForFirstTest(){
        List<GrammarQuestion> grammarQuestionList = questionService.getListFirstTest();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for(GrammarQuestion grammarQuestion : grammarQuestionList){
            QuestionDTO questionDTO = new QuestionDTO(grammarQuestion);
            questionDTOList.add(questionDTO);
        }
        return ResponseEntity.ok(questionDTOList);
    }
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @RequestMapping("/mark-question-for-first-test")
    public ResponseEntity<?> markQuestionForFirstTest(@RequestBody AnswerFirstTestRequest answerFirstTestRequest){
        int userId = answerFirstTestRequest.getUserId();
        List<Answer> answerList = answerFirstTestRequest.getListAnswer();
        int point = questionService.markFirstTest(answerList);
        float status = (float)point/(float)(answerList.size());
        int levelUnlock =0;
        if(status>0.75) levelUnlock=4;
        else if (status>0.5) levelUnlock =3;
        else levelUnlock =2;
        userService.updateUnlockLevlel(userId,levelUnlock);

        MessageAnswerResponse messageAnswerResponse = new MessageAnswerResponse();
        messageAnswerResponse.setPoint(point);
        messageAnswerResponse.setStatus(status);
        messageAnswerResponse.setPlusMark(levelUnlock);

        return ResponseEntity.ok(messageAnswerResponse);
    }
}
