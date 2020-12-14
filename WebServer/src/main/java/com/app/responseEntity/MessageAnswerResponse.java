package com.app.responseEntity;

public class MessageAnswerResponse {
    boolean passStatus;
    int point ;
    int plusMark;

    public MessageAnswerResponse(boolean passStatus, int point, int plusMark) {
        this.passStatus = passStatus;
        this.point = point;
        this.plusMark = plusMark;
    }

    public MessageAnswerResponse() {
    }

    public boolean isPassStatus() {
        return passStatus;
    }

    public void setPassStatus(boolean passStatus) {
        this.passStatus = passStatus;
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
