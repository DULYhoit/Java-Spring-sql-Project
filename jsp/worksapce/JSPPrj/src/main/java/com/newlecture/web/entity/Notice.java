package com.newlecture.web.entity;

import java.sql.Date;

public class Notice {
	private String title;
	private String writer_id;
	private Date regdate;
	private int hit;
	private String files;
	private String content;
	
	public Notice() {
	}
	
	public Notice(String title, String writer_id, Date regdate, int hit, String files, String content) {
		this.title = title;
		this.writer_id = writer_id;
		this.regdate = regdate;
		this.hit = hit;
		this.files = files;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Notice [title=" + title + ", writer_id=" + writer_id + ", regdate=" + regdate + ", hit=" + hit
				+ ", files=" + files + ", content=" + content + "]";
	}
	
	
}
