package com.jshop.entity;

// Generated 2012-10-24 9:30:38 by Hibernate Tools 3.4.0.CR1

/**
 * OutsidegoodsTm generated by hbm2java
 */
public class OutsidegoodsTm implements java.io.Serializable {

	private int id;
	private String outsidegoodsid;
	private String pictureurl;
	private String goodsname;
	private String sort;
	private String linkUrl;

	public OutsidegoodsTm() {
	}

	public OutsidegoodsTm(int id, String outsidegoodsid, String pictureurl,
			String goodsname, String sort, String linkUrl) {
		this.id = id;
		this.outsidegoodsid = outsidegoodsid;
		this.pictureurl = pictureurl;
		this.goodsname = goodsname;
		this.sort = sort;
		this.linkUrl = linkUrl;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOutsidegoodsid() {
		return this.outsidegoodsid;
	}

	public void setOutsidegoodsid(String outsidegoodsid) {
		this.outsidegoodsid = outsidegoodsid;
	}

	public String getPictureurl() {
		return this.pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}

	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getSort() {
		return this.sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getLinkUrl() {
		return this.linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

}
