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

    public List<Answer> getAnswerList() {
        return listAnswer ;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.listAnswer = answerList;
    }
}
