package com.app.service;

import com.app.entity.Level;
import com.app.requestEntity.AddLevelRequest;

import java.util.List;

public interface LevelService {
 public boolean addLevel(AddLevelRequest addLevelRequest);
 public List<Level> getListLevel();
}
