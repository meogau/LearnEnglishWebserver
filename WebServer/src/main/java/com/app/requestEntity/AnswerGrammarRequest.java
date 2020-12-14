package com.app.requestEntity;

import java.util.List;

public class AnswerGrammarRequest {
    int userId;
    int grammarId;
    List<Answer> listAnswer;

    public int getGrammarId() {
        return grammarId;
    }

    public void setGrammarId(int grammarId) {
        this.grammarId = grammarId;
    }

    public List<Answer> getListAnswer() {
        return listAnswer;
    }

    public void setListAnswer(List<Answer> listAnswer) {
        this.listAnswer = listAnswer;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
