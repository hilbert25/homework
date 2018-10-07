package com.homework.pojo;

public class Homework {
	private int id;
	private String stuId;
	private String stuName;
	private String homeWorkTitle;
	private String homeWorkPath;
	private String homeWorkSubmitTime;
	private int homeWorkIndex;

//	public Homework(int id, int stuId, String stuName, String homeWorkTitle, String homeWorkPath,
//			String homeWorkSubmitTime, int homeWorkIndex) {
//		super();
//		this.id = id;
//		this.stuId = stuId;
//		this.stuName = stuName;
//		this.homeWorkTitle = homeWorkTitle;
//		this.homeWorkPath = homeWorkPath;
//		this.homeWorkSubmitTime = homeWorkSubmitTime;
//		this.homeWorkIndex = homeWorkIndex;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getHomeWorkTitle() {
		return homeWorkTitle;
	}

	public void setHomeWorkTitle(String homeWorkTitle) {
		this.homeWorkTitle = homeWorkTitle;
	}

	public String getHomeWorkPath() {
		return homeWorkPath;
	}

	public void setHomeWorkPath(String homeWorkPath) {
		this.homeWorkPath = homeWorkPath;
	}

	public String getHomeWorkSubmitTime() {
		return homeWorkSubmitTime;
	}

	public void setHomeWorkSubmitTime(String homeWorkSubmitTime) {
		this.homeWorkSubmitTime = homeWorkSubmitTime;
	}

	public int getHomeWorkIndex() {
		return homeWorkIndex;
	}

	public void setHomeWorkIndex(int homeWorkIndex) {
		this.homeWorkIndex = homeWorkIndex;
	}

}
