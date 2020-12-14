package com.app.serviceImpl;

import com.app.DAO.GrammarDAO;
import com.app.DAO.GrammarLeanrtDAO;
import com.app.entity.Grammar;
import com.app.requestEntity.AddGrammarRequest;
import com.app.service.GrammarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GrammarServiceImpl implements GrammarService {
	@Autowired
	private GrammarDAO grammarDAO;
	@Autowired
	GrammarLeanrtDAO grammarLeanrtDAO;

	@Override
	public Grammar addGrammar(AddGrammarRequest addGrammarRequest) {

		return grammarDAO.addGrammar(addGrammarRequest.getLevelId(), addGrammarRequest.getName(),
				addGrammarRequest.getTheories(), addGrammarRequest.getExample());
	}

	@Override
	public List<Grammar> getListGrammarInLevel(int levelId) {

		return grammarDAO.getListGrammarInLevel(levelId);
	}

	@Override
	public Grammar deleteGrammar(int grammarId) {
		return grammarDAO.deleteGrammar(grammarId);
	}

	@Override
	public Grammar findGrammarById(int grammarId) {
		return grammarDAO.findGrammarById(grammarId);
	}

	@Override
	public Grammar updateGrammar(Grammar grammar) {
		return grammarDAO.updateGrammar(grammar);
	}

	@Override
	public void addGrammarLenarnt(int useId, int grammarId) {
		grammarLeanrtDAO.addGrammarLearnt(useId,grammarId);
	}

}
