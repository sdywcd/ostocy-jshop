package com.jshop.action;

import java.util.Date;

import com.jshop.action.tools.Serial;
import com.jshop.service.SaleGoodsTService;

public class SaleGoodsTAction {
	private SaleGoodsTService salegoodstservice;
	public Serial serial;
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
	private int total=0;
	private int page=1;
	private int rp;
	
	
}
