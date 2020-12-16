package com.app.requestEntity;

import java.util.List;

public class AnswerFirstTestRequest {
    int userId;
    List<Answer> listAnswer;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Answer> getListAnswer() {
        return listAnswer;
    }

    public void setListAnswer(List<Answer> listAnswer) {
        this.listAnswer = listAnswer;
    }
}
