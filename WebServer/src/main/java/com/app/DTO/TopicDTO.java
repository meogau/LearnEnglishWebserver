package com.app.DTO;

import com.app.entity.Topic;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DecimalFormat;

public class TopicDTO {
    private static final DecimalFormat df = new DecimalFormat("#.####");

    private int topicId;
    private int levelId;
    private String name;
    private float status;

    public TopicDTO(Topic topic) {
        this.topicId = topic.getTopicId();
        this.levelId = topic.getLevelId();
        this.name = topic.getName();
        this.status =0;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
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

    public float getStatus() {
        return status;
    }

    public void setStatus(float status) {
        this.status = (status);
    }
}
