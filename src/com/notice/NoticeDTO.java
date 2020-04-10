package com.notice;

import java.sql.Date;

public class NoticeDTO {
	private int no;
	private String sub;
	private String contents;
	private Date nodate;
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getNodate() {
		return nodate;
	}
	public void setNodate(Date nodate) {
		this.nodate = nodate;
	}
	
	
	
}
