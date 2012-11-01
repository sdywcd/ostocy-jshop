package com.jshop.entity;

// Generated 2012-10-24 9:30:38 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * OutsideGoodsT generated by hbm2java
 */
public class OutsideGoodsT implements java.io.Serializable {

	private String id;
	private String goodsname;
	private String nname;
	private String lname;
	private String sname;
	private String fname;
	private String navid;
	private String ltypeid;
	private String stypeid;
	private String pictureurl;
	private String salestate;
	private int sort;
	private String linkUrl;
	private Date createtime;
	private String creatorid;
	private Date updatetime;
	private Integer versiont;

	public OutsideGoodsT() {
	}

	public OutsideGoodsT(String id, String goodsname, String nname,
			String lname, String sname, String fname, String navid,
			String ltypeid, String stypeid, String pictureurl,
			String salestate, int sort, String linkUrl, Date createtime,
			String creatorid, Date updatetime) {
		this.id = id;
		this.goodsname = goodsname;
		this.nname = nname;
		this.lname = lname;
		this.sname = sname;
		this.fname = fname;
		this.navid = navid;
		this.ltypeid = ltypeid;
		this.stypeid = stypeid;
		this.pictureurl = pictureurl;
		this.salestate = salestate;
		this.sort = sort;
		this.linkUrl = linkUrl;
		this.createtime = createtime;
		this.creatorid = creatorid;
		this.updatetime = updatetime;
	}

	public OutsideGoodsT(String id, String goodsname, String nname,
			String lname, String sname, String fname, String navid,
			String ltypeid, String stypeid, String pictureurl,
			String salestate, int sort, String linkUrl, Date createtime,
			String creatorid, Date updatetime, Integer versiont) {
		this.id = id;
		this.goodsname = goodsname;
		this.nname = nname;
		this.lname = lname;
		this.sname = sname;
		this.fname = fname;
		this.navid = navid;
		this.ltypeid = ltypeid;
		this.stypeid = stypeid;
		this.pictureurl = pictureurl;
		this.salestate = salestate;
		this.sort = sort;
		this.linkUrl = linkUrl;
		this.createtime = createtime;
		this.creatorid = creatorid;
		this.updatetime = updatetime;
		this.versiont = versiont;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getNname() {
		return this.nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getNavid() {
		return this.navid;
	}

	public void setNavid(String navid) {
		this.navid = navid;
	}

	public String getLtypeid() {
		return this.ltypeid;
	}

	public void setLtypeid(String ltypeid) {
		this.ltypeid = ltypeid;
	}

	public String getStypeid() {
		return this.stypeid;
	}

	public void setStypeid(String stypeid) {
		this.stypeid = stypeid;
	}

	public String getPictureurl() {
		return this.pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}

	public String getSalestate() {
		return this.salestate;
	}

	public void setSalestate(String salestate) {
		this.salestate = salestate;
	}

	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getLinkUrl() {
		return this.linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
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

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getVersiont() {
		return this.versiont;
	}

	public void setVersiont(Integer versiont) {
		this.versiont = versiont;
	}

}
