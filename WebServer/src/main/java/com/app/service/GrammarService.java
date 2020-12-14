package com.app.service;

import com.app.entity.Grammar;
import com.app.requestEntity.AddGrammarRequest;

import java.util.List;

public interface GrammarService {
 public Grammar addGrammar(AddGrammarRequest addGrammarRequest);
 public List<Grammar> getListGrammarInLevel(int levelId);
 public Grammar deleteGrammar(int grammarId);
 public Grammar findGrammarById(int grammarId);
 public Grammar updateGrammar(Grammar grammar);
 public void addGrammarLenarnt(int useId,int grammarId);
}
