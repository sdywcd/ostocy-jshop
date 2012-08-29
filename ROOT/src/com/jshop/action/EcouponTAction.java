package com.jshop.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;


import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.Serial;
import com.jshop.entity.EcouponT;
import com.jshop.service.EcouponTService;
@ParentPackage("jshop")
@Controller("ecouponTAction")
public class EcouponTAction {
	private EcouponTService ecouponTService;
	private String eid;
	private String goodsname;
	private double favourableprices;
	private double pricededuction;
	private String goodsid;
	private Date begintime;
	private Date endtime;
	private String ecouponstate;
	private String state;
	private String note;
	private boolean flag;
	private Serial serial;
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	@JSON(serialize=false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	@JSON(serialize=false)
	public EcouponTService getEcouponTService() {
		return ecouponTService;
	}
	public void setEcouponTService(EcouponTService ecouponTService) {
		this.ecouponTService = ecouponTService;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public double getFavourableprices() {
		return favourableprices;
	}
	public void setFavourableprices(double favourableprices) {
		this.favourableprices = favourableprices;
	}
	public double getPricededuction() {
		return pricededuction;
	}
	public void setPricededuction(double pricededuction) {
		this.pricededuction = pricededuction;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public Date getBegintime() {
		return begintime;
	}
	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getEcouponstate() {
		return ecouponstate;
	}
	public void setEcouponstate(String ecouponstate) {
		this.ecouponstate = ecouponstate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public int getRp() {
		return rp;
	}
	public void setRp(int rp) {
		this.rp = rp;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * 添加电子订单优惠券
	 * @return
	 */
	@Action(value="addEcouponT",results={@Result(name="json",type="json")})
	public String addEcouponT(){
		EcouponT et = new EcouponT();
		//当ECOUPONSTATE=3的时候，现金抵扣模式		 
		if(this.getEcouponstate().trim().equals("3")){
		et.setEid(this.getSerial().Serialid(Serial.ECOUPONT));
		et.setEcouponstate(this.getEcouponstate());
		et.setFavourableprices(this.getFavourableprices());
		et.setPricededuction(this.getPricededuction());
		et.setBegintime(this.getBegintime());
		et.setEndtime(this.getEndtime());
		et.setState(this.getState());
		et.setNote(this.getNote());
		et.setGoodsname("");
		et.setGoodsid("");
		if(this.getEcouponTService().addEcoupon(et)>0){
			this.setFlag(true);
			return "json";
		}
		}
		return "json";
	}
	/**
	 *查询所有的电子优惠券
	 * @return
	 */
	@Action(value="findAllEcouponT",results={@Result(name="json",type="json")})
	@SuppressWarnings("unchecked")
	public String findAllEcouponT(){
		int currentPage= page;
		int lineSize= rp;
		List<EcouponT> list = this.getEcouponTService().findAllEcoupon(currentPage, lineSize);
		if(!list.isEmpty()){
		total = this.getEcouponTService().countAllEcoupon();
		rows.clear();
		for(Iterator it=list.iterator();it.hasNext();){
			EcouponT et = (EcouponT) it.next();
			if(et.getEcouponstate().equals("3")){
				et.setEcouponstate("现金抵扣模式");
			}else if(et.getEcouponstate().equals("2")){
				et.setEcouponstate("现金购物模式");
			}else if(et.getEcouponstate().equals("1")){
				et.setEcouponstate("购物抵扣模式");
			}
			if(et.getState().equals("1")){
				et.setState("开启");
			}else if(et.getState().equals("0")){
				et.setState("关闭");
			}
			if(et.getGoodsname().equals("")){
				et.setGoodsname("null");
			}
			if(et.getGoodsid().equals("")){
				et.setGoodsid("null");
			}
			Map cellMap= new HashMap();
			cellMap.put("id",et.getEid());
			cellMap.put("cell", new Object[]{
					et.getGoodsname(),
					et.getGoodsid(),
					et.getEcouponstate(),
					et.getState(),
					et.getBegintime(),
					et.getEndtime(),
					et.getFavourableprices(),
					et.getPricededuction(),
					et.getNote()					
			});
			rows.add(cellMap);
		}
		return "json";
		}		
		return "json";
	}

}
