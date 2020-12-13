package com.app.controller;


import com.app.requestEntity.AddGrammarRequest;
import com.app.service.GrammarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/content")
public class GrammarController {
	@Autowired
	private GrammarService grammarService;


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/add-grammar")
  public ResponseEntity<?> addGrammar(@RequestBody AddGrammarRequest addGrammarRequest){
	  grammarService.addGrammar(addGrammarRequest);
	  return ResponseEntity.ok(HttpStatus.OK);
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
}
