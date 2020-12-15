package com.app.responseEntity;

public class MessageAnswerResponse {
    float status;
    int point ;
    int plusMark;

    public MessageAnswerResponse(int status, int point, int plusMark) {
        this.status = status;
        this.point = point;
        this.plusMark = plusMark;
    }

    public MessageAnswerResponse() {
    }

    public MessageAnswerResponse(float status, int point, int plusMark) {
        this.status = status;
        this.point = point;
        this.plusMark = plusMark;
    }

    public float getStatus() {
        return status;
    }

    public void setStatus(float status) {
        this.status = status;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPlusMark() {
        return plusMark;
    }

    public void setPlusMark(int plusMark) {
        this.plusMark = plusMark;
    }
}
