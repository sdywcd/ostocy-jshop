package com.jshop.action.tools;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.jshop.entity.SerialT;
import com.jshop.service.SerialTService;
import com.jshop.service.impl.SerialTServiceImpl;
@Controller("serial")
public class Serial {

	// 模板主题表主键生成
	public static final String TEMPLATETHEME = "templatetheme";
	// 用户表主键生成
	public static final String USER="user";
	//优惠券表主键生成
	public static final String VOUCHERS="vouchers";
	//模板文件表主键生成
	public static final String TEMPLATE="template";
	//模板文件和系统内容关系表主键生成
	public static final String TEMPLATESET="templateset";
	//系统邮箱表主键生成
	public static final String SYSTEMMAILM="systemmail";
	//文章分类表主键生成
	public static final String ARTICLECATEGORY="articlecategory";
	//文章表主键生成
	public static final String ARTICLE="article";
	//商品品牌表主键生成
	public static final String BRAND="brand";
	//快递单模板表主键生成
	public static final String EXPRESSTEMPLATE="expresstemplete";
	//商品属性表主键生成
	public static final String GOODSATTRIBUTE="goodsattribute";
	//商品分类表主键生成
	public static final String GOODSCATEGORY="goodscategory";
	//商品评论表主键生成
	public static final String GOODSCOMMENT="goodscomment";
	//商品优惠表主键生成
	public static final String GOODSGIF="goodsgif";//
	//商品抢购倒计时表主键生成
	public static final String GOODSLIMIT="goodslimit";
	//商品咨询表主键生成
	public static final String GOODSQUESTION="goodsquestion";
	//货品表主键生成
	public static final String PRODUCT="product";
	//商品表主键生成
	public static final String GOODS="goodsinfo";
	//商品类型品牌（保存该类型下有多少个品牌信息）
	public static final String GOODSTYPEBRAND="goodstypebrand";
	//商品类型表主键生成
	public static final String GOODSTYPE="goodstype";
	//单位表主键生成
	public static final String UNIT="unit";
	//用户等级表主键生成
	public static final String GRADE="grade";
	//图片表主键生成（可能以后去除）
	public static final String IMG="img";
	//发货单模板表主键生成
	public static final String INVOICETEMPLATE="invoicetemplete";
	//商城基本信息表主键生成
	public static final String JSHOPBASICINFO="jshopbasicinfo";
	//关键字表主键生成
	public static final String KEYWORD="keyword";
	//快递单区域运费模式表主键生成
	public static final String LOGISTICSBUSINESSAREA="logbusarea";
	//物流商信息表主键生成
	public static final String LOGISTICSBUSINESS="logistics";
	//自定义页面编辑数据表主键生成
	public static final String PAGEEDITAREA="pageeditarea";
	//页面记录表主键生成
	public static final String PAGE="pageinfo";
	//支付方式信息表主键生成
	public static final String PAYMENT="payment";
	//商品产地信息主键生成
	public static final String PLACEFORIGIN="origin";
	//产品规格值表主键生成
	public static final String PRODUCTSPECIFICATION="productspecifications";
	//导航菜单信息记录表主键生成
	public static final String SITENAVIGATION="sitenavigation";
	//订单发票记录表主键生成
	public static final String ORDERINVOICE="orderinvoice";
	//站内信关系表主键生成
	public static final String WEBSITEMSG="websitemsg";
	//站内信内容表主键生成
	public static final String MSGTEXT="msgtext";
	//送货地址信息记录表主键生成
	public static final String SHIPPINGADDRESS="shippingaddress";
	//购物车合并后的id生成
	public static final String CART="cart";
	//购物车表主键生成
	public static final String CARTINFO="cartinfo";
	//用户收获地址表主键生成
	public static final String DELIVERADDRESS="deliveraddress";
	//订单表主键生成
	public static final String ORDER="order";
	//收藏表主键生成
	public static final String FAVORITE="favoriteinfo";
	//友情链接表
	public static final String FRIENDLINK="friendlink";
	//商品打分记录表
	public static final String GOODSSTARCOMMENT="starcomment";
	//发货单打印记录表
	public static final String INVOICEPRINT="invoiceprint";
	//用户位置表
	public static final String LOCATION="location";
	//模块表
	public static final String MODULE="module";
	//功能表
	public static final String FUNCTION="function";
	//角色表
	public static final String ROLE="role";
	//角色和功能关联表
	public static final String ROLEFUNCTION="rolefunction";
	//用户和角色关系
	public static final String USERROLE="userrole";
	//电子餐桌表
	public static final String ELECTABLE="electable";
	//电子菜单餐车合并后的id生成
	public static final String ELECTRONICMENUCARTT="electronicmenucartt";
	//电子菜单餐车表主键生成
	public static final String ELECTRONICMENUCARTTINFO="electronicmenucarttinfo";
	//团购主键表生成
	public static final String GOODSGROUPT="googsgroupt";
	
	private SerialTService serialTService;
	
	

	public SerialTService getSerialTService() {
		return serialTService;
	}



	public void setSerialTService(SerialTService serialTService) {
		this.serialTService = serialTService;
	}



	public String Serialid(String serial){
		String serialid = null;
		SerialT list =this.getSerialTService().findBybaseid(serial);
		serialid = BaseTools.tagdate() + list.getHead() + list.getLastid();
		return serialid;
	}
	
}
