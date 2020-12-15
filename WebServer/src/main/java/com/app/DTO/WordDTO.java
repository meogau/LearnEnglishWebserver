package com.app.DTO;

import com.app.entity.Word;

import javax.persistence.Column;

public class WordDTO {
    private int wordId;
    private int topicId;
    private String word;
    private String image;
    private String description;
    private String translation;
    private String audio;
    private int status;

    public WordDTO(Word word) {
        this.wordId= word.getWordId();
        this.topicId = word.getTopicId();
        this.word = word.getWord();
        this.image =word.getImage();
        this.description = word.getDescription();
        this.translation = word.getTranslation();
        this.audio = word.getAudio();
        this.status=0;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
