package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "USER_INFO")
public class UserInfo {
	@Id
	@Column(name = "USER_ID")
	private int userId;
	private String name;
	private String gender;
	private Date birthday;
	@Column(name = "UNLOCK_LEVEL")
	private int unlockLevel;
	private int score;

	public UserInfo() {
		super();
	}

	public UserInfo(int userId, String name, String gender, Date birthday) {
		super();
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.unlockLevel = 0;
		this.score = 0;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getUnlockLevel() {
		return unlockLevel;
	}

	public void setUnlockLevel(int unlockLevel) {
		this.unlockLevel = unlockLevel;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
