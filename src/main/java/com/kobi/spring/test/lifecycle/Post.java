package com.kobi.spring.test.lifecycle;

public class Post {
	
	private String title;
	private String user;
	private String content;
	
	public Post(String title, String user, String content) {
		this.title = title;
		this.user = user;
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "제목 : " + title + "\n작성자 : " + user + "\n" + content;
	}

	public String getTitle() {
		return title;
	}

	public String getUser() {
		return user;
	}

	public String getContent() {
		return content;
	}
	

}
