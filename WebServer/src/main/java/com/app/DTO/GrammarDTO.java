package com.app.DTO;


import com.app.entity.Grammar;

public class GrammarDTO {
    private int grammarId;
    private int levelId;
    private String name;
    private String theories;
    private String example;
    private int status;

    public GrammarDTO(Grammar grammar) {
        this.grammarId=grammar.getGrammarId();
        this.levelId= grammar.getLevelId();
        this.name=grammar.getName();
        this.theories = grammar.getTheories();
        this.example = grammar.getExample();
        this.status =0;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public int getGrammarId() {
        return grammarId;
    }

    public void setGrammarId(int grammarId) {
        this.grammarId = grammarId;
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
