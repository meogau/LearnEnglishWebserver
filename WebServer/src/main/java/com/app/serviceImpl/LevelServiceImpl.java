package com.app.serviceImpl;

import com.app.DAO.LevelDAO;
import com.app.entity.Level;
import com.app.requestEntity.AddLevelRequest;
import com.app.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LevelServiceImpl implements LevelService {
@Autowired
private LevelDAO levelDAO;
	
	
	@Override
	public boolean addLevel(AddLevelRequest addLevelRequest) {
		return levelDAO.addLevel(addLevelRequest.getType(), addLevelRequest.getNumber(), addLevelRequest.getDescription());
	}

	@Override
	public List<Level> getListLevel() {
		return levelDAO.getListLevel();
		
	}

}