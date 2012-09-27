package com.jshop.action.front;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.jshop.action.templates.DataCollectionTAction;
import com.jshop.action.templates.FreeMarkervariable;
import com.jshop.action.tools.AllOrderState;
import com.jshop.action.tools.BaseTools;

import com.jshop.entity.GoodsT;
import com.jshop.entity.OrderT;
import com.jshop.entity.UserT;
import com.jshop.service.GoodsTService;
import com.jshop.service.OrderTService;
import com.jshop.service.WebsiteMsgTService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.emory.mathcs.backport.java.util.Collections;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({
    @InterceptorRef("defaultStack")  
})
@Controller("userCenterIndexAction")
public class UserCenterIndexAction extends ActionSupport {

	private String hidurl;
	private DataCollectionTAction dataCollectionTAction;
	private UserCenterMyorderAction userCenterMyorderAction;
	private OrderTService orderTService;
	private GoodsTService goodsTService;
	private WebsiteMsgTService websiteMsgTService;
	private boolean slogin = false;
	
	public WebsiteMsgTService getWebsiteMsgTService() {
		return websiteMsgTService;
	}

	public void setWebsiteMsgTService(WebsiteMsgTService websiteMsgTService) {
		this.websiteMsgTService = websiteMsgTService;
	}

	public GoodsTService getGoodsTService() {
		return goodsTService;
	}

	public void setGoodsTService(GoodsTService goodsTService) {
		this.goodsTService = goodsTService;
	}

	public OrderTService getOrderTService() {
		return orderTService;
	}

	public void setOrderTService(OrderTService orderTService) {
		this.orderTService = orderTService;
	}

	public UserCenterMyorderAction getUserCenterMyorderAction() {
		return userCenterMyorderAction;
	}

	public void setUserCenterMyorderAction(UserCenterMyorderAction userCenterMyorderAction) {
		this.userCenterMyorderAction = userCenterMyorderAction;
	}

	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}

	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public String getHidurl() {
		return hidurl;
	}

	public void setHidurl(String hidurl) {
		this.hidurl = hidurl;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 初始化用户中心
	 * 
	 * @return
	 */
	@Action(value = "InitUserCenterIndex", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/shop/memberindex.ftl"),
			@Result(name = "input",location = "/html/default/shop/user/login.html")
	})
	public String InitUserCenterIndex() {
		UserT user = (UserT) ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
		if (user != null) {
			int allInfo=this.getWebsiteMsgTService().countfindAllWebsitemsgOfStateByToUsername(user.getUsername(), "0");
			
			//获取最近的订单信息
			this.findAllUserOrderOn(user.getUserid());
			//乱序获取推荐商品
			this.shuffleGoods();
			//获取所有收件人是我未读的信息
			ActionContext.getContext().put("allInfo", allInfo);
			//路径获取
			ActionContext.getContext().put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
			//获取导航数据
			ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation());
			//获取商城基本数据
			ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo());
			//获取页脚分类数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT());
			//获取页脚文章数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, this.getDataCollectionTAction().findFooterArticle());
			return SUCCESS;
		}
		return INPUT;
	}
	
	/**
	 * 获取用户未处理的订单只获取前30条
	 */
	public void findAllUserOrderOn(String userid){
		int currentPage=1;
		int lineSize=30;
		List<OrderT>list=this.getOrderTService().findAllOrderByorderstateForOn(currentPage, lineSize, userid, AllOrderState.ORDERSTATE_EIGHT, AllOrderState.PAYSTATE_TWO, AllOrderState.SHIPPINGSTATE_TWO);
		//获取我的订单
		ActionContext.getContext().put("userorderon", list);
	}
	
	/**
	 * 乱序获取商品
	 */
	public void shuffleGoods(){
		int currentPage=1;
		int lineSize=8;
		String salestate="1";
		String recommended="1";
		List<GoodsT>list=this.getGoodsTService().findshuffleGoods(currentPage, lineSize, salestate, recommended);
		Collections.shuffle(list);
		ActionContext.getContext().put("shufflerecommendgoods", list);
	}

	
	

}
