package com.jshop.entity;

// Generated 2012-10-24 9:30:38 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * SalegoodsT generated by hbm2java
 */
public class SalegoodsT implements java.io.Serializable {

	private String salegoodsid;
	private String salegoodsname;
	private String salegoodsnumber;
	private String salegoodspictureurl;
	private String salegoodsinformation;
	private String salegoodsstate;
	private Date begingtime;
	private Date endingtime;
	private String salepeople;
	private double salestartingprice;
	private int salejoinpeople;
	private String salebudget;
	private String realname;
	private String userid;
	private double saleprice;

	public SalegoodsT() {
	}

	public SalegoodsT(String salegoodsid, String salegoodsname,
			String salegoodsnumber, String salegoodspictureurl,
			String salegoodsstate, String salepeople, double salestartingprice,
			int salejoinpeople, String realname, String userid, double saleprice) {
		this.salegoodsid = salegoodsid;
		this.salegoodsname = salegoodsname;
		this.salegoodsnumber = salegoodsnumber;
		this.salegoodspictureurl = salegoodspictureurl;
		this.salegoodsstate = salegoodsstate;
		this.salepeople = salepeople;
		this.salestartingprice = salestartingprice;
		this.salejoinpeople = salejoinpeople;
		this.realname = realname;
		this.userid = userid;
		this.saleprice = saleprice;
	}

	public SalegoodsT(String salegoodsid, String salegoodsname,
			String salegoodsnumber, String salegoodspictureurl,
			String salegoodsinformation, String salegoodsstate,
			Date begingtime, Date endingtime, String salepeople,
			double salestartingprice, int salejoinpeople, String salebudget,
			String realname, String userid, double saleprice) {
		this.salegoodsid = salegoodsid;
		this.salegoodsname = salegoodsname;
		this.salegoodsnumber = salegoodsnumber;
		this.salegoodspictureurl = salegoodspictureurl;
		this.salegoodsinformation = salegoodsinformation;
		this.salegoodsstate = salegoodsstate;
		this.begingtime = begingtime;
		this.endingtime = endingtime;
		this.salepeople = salepeople;
		this.salestartingprice = salestartingprice;
		this.salejoinpeople = salejoinpeople;
		this.salebudget = salebudget;
		this.realname = realname;
		this.userid = userid;
		this.saleprice = saleprice;
	}

	public String getSalegoodsid() {
		return this.salegoodsid;
	}

	public void setSalegoodsid(String salegoodsid) {
		this.salegoodsid = salegoodsid;
	}

	public String getSalegoodsname() {
		return this.salegoodsname;
	}

	public void setSalegoodsname(String salegoodsname) {
		this.salegoodsname = salegoodsname;
	}

	public String getSalegoodsnumber() {
		return this.salegoodsnumber;
	}

	public void setSalegoodsnumber(String salegoodsnumber) {
		this.salegoodsnumber = salegoodsnumber;
	}

	public String getSalegoodspictureurl() {
		return this.salegoodspictureurl;
	}

	public void setSalegoodspictureurl(String salegoodspictureurl) {
		this.salegoodspictureurl = salegoodspictureurl;
	}

	public String getSalegoodsinformation() {
		return this.salegoodsinformation;
	}

	public void setSalegoodsinformation(String salegoodsinformation) {
		this.salegoodsinformation = salegoodsinformation;
	}

	public String getSalegoodsstate() {
		return this.salegoodsstate;
	}

	public void setSalegoodsstate(String salegoodsstate) {
		this.salegoodsstate = salegoodsstate;
	}

	public Date getBegingtime() {
		return this.begingtime;
	}

	public void setBegingtime(Date begingtime) {
		this.begingtime = begingtime;
	}

	public Date getEndingtime() {
		return this.endingtime;
	}

	public void setEndingtime(Date endingtime) {
		this.endingtime = endingtime;
	}

	public String getSalepeople() {
		return this.salepeople;
	}

	public void setSalepeople(String salepeople) {
		this.salepeople = salepeople;
	}

	public double getSalestartingprice() {
		return this.salestartingprice;
	}

	public void setSalestartingprice(double salestartingprice) {
		this.salestartingprice = salestartingprice;
	}

	public int getSalejoinpeople() {
		return this.salejoinpeople;
	}

	public void setSalejoinpeople(int salejoinpeople) {
		this.salejoinpeople = salejoinpeople;
	}

	public String getSalebudget() {
		return this.salebudget;
	}

	public void setSalebudget(String salebudget) {
		this.salebudget = salebudget;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public double getSaleprice() {
		return this.saleprice;
	}

	public void setSaleprice(double saleprice) {
		this.saleprice = saleprice;
	}

}
