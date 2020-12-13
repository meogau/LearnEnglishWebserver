package com.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "WORD")
public class Word {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WORD_ID")
	private int wordId;
	@Column(name = "TOPIC_ID")
	private int topicId;

	private String word;
	private String image;
	private String description;
	private String translation;
	private String audio;

	public Word() {
		super();
	}

	public Word(int topicId, String word, String image, String description, String translation, String audio) {
		super();
		this.topicId = topicId;
		this.word = word;
		this.image = image;
		this.description = description;
		this.translation = translation;
		this.audio = audio;
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

}
