package com.app.requestEntity;

public class AddGrammarRequest {
private int levelId;
private String name;
private String theories;
private String example;
public int getLevelId() {
	return levelId;
}
public void setLevelId(int levelId) {
	this.levelId = levelId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTheories() {
	return theories;
}
public void setTheories(String theories) {
	this.theories = theories;
}
public String getExample() {
	return example;
}
public void setExample(String example) {
	this.example = example;
}

}
