package com.jshop.entity;

// Generated 2012-5-31 15:44:56 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * NoticeT generated by hbm2java
 */
public class NoticeT implements java.io.Serializable {

	private String noticeid;
	private String title;
	private String content;
	private Date createtime;
	private String creatorid;
	private String noticenlname;
	private String noticenlid;

	public NoticeT() {
	}

	public NoticeT(String noticeid, String title, String content,
			Date createtime, String creatorid, String noticenlname,
			String noticenlid) {
		this.noticeid = noticeid;
		this.title = title;
		this.content = content;
		this.createtime = createtime;
		this.creatorid = creatorid;
		this.noticenlname = noticenlname;
		this.noticenlid = noticenlid;
	}

	public String getNoticeid() {
		return this.noticeid;
	}

	public void setNoticeid(String noticeid) {
		this.noticeid = noticeid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public String getNoticenlname() {
		return this.noticenlname;
	}

	public void setNoticenlname(String noticenlname) {
		this.noticenlname = noticenlname;
	}

	public String getNoticenlid() {
		return this.noticenlid;
	}

	public void setNoticenlid(String noticenlid) {
		this.noticenlid = noticenlid;
	}

}
