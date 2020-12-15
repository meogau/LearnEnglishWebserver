package com.app.controller;


import com.app.DTO.GrammarDTO;
import com.app.entity.Grammar;
import com.app.requestEntity.AddGrammarRequest;
import com.app.service.GrammarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/content")
public class GrammarController {
	@Autowired
	private GrammarService grammarService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/add-grammar")
  public ResponseEntity<?> addGrammar(@RequestBody AddGrammarRequest addGrammarRequest){
	  return ResponseEntity.ok( grammarService.addGrammar(addGrammarRequest));
  }
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/get-list-grammar/{levelId}")
  public ResponseEntity<?> getListGrammar(@PathVariable int levelId){
	  return ResponseEntity.ok(grammarService.getListGrammarInLevel(levelId));
  }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/delete-grammar/{grammarId}")
    public ResponseEntity<?> deleteGrammar(@PathVariable int grammarId){
        return ResponseEntity.ok(grammarService.deleteGrammar(grammarId));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/find-grammar-by-id/{grammarId}")
    public ResponseEntity<?> findGrammarById(@PathVariable int grammarId){
        return ResponseEntity.ok(grammarService.findGrammarById(grammarId));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/update-grammar")
    public ResponseEntity<?> updateGrammar(@RequestBody Grammar grammar){
        return ResponseEntity.ok(grammarService.updateGrammar(grammar));
    }

  @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
  @GetMapping("/get-list-grammar-by-user")
  public ResponseEntity<?> getListGrammar(@RequestParam int levelId,@RequestParam int userId){
    List<Grammar> grammarList = grammarService.getListGrammarInLevel(levelId);
    List<GrammarDTO> grammarDTOList = new ArrayList<>();
    for(Grammar grammar : grammarList){
      GrammarDTO grammarDTO = new GrammarDTO(grammar);
      if(grammarService.checkGrammarLearnt(userId,grammar.getGrammarId())) grammarDTO.setStatus(1);
      grammarDTOList.add(grammarDTO);
    }
    return ResponseEntity.ok(grammarDTOList);
  }
}
