package com.app.service;

import com.app.entity.Level;
import com.app.requestEntity.AddLevelRequest;

import java.util.List;

public interface LevelService {
 public Level addLevel(AddLevelRequest addLevelRequest);
 public List<Level> getListLevel();
 public Level findLevelById(int levelId);
 public Level deleteLevel(int levelId);
 public Level updateLevel(Level level);
}
