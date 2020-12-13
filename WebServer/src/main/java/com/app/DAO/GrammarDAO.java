package com.app.DAO;


import com.app.entity.Grammar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
@Repository
public class GrammarDAO {
	@Autowired
	private EntityManager entityManager;


	
	public Grammar addGrammar(int levelId, String name, String theories, String example) {
		Grammar grammar = new Grammar(levelId, name, theories, example);
		entityManager.persist(grammar);
		entityManager.flush();
		return grammar;
	}
	public List<Grammar> getListGrammarInLevel(int levelId){
		String hql ="FROM Grammar g WHERE g.levelId = "+ levelId;
		return entityManager.createQuery(hql,Grammar.class).getResultList();
	}

	public Grammar findGrammarById(int grammarId){
		String hql ="FROM Grammar g WHERE g.grammarId = "+ grammarId;
		List<Grammar> listResult = entityManager.createQuery(hql,Grammar.class).getResultList();
		if(listResult.size()==0) return null;
		else return listResult.get(0);
	}
	public Grammar deleteGrammar(int grammarId){
		Grammar grammar = findGrammarById(grammarId);
		if(!grammar.equals(null)) entityManager.remove(grammar);
		return grammar;
	}

	public Grammar updateGrammar(Grammar grammar){
		entityManager.merge(grammar);
		return grammar;
	}

}
