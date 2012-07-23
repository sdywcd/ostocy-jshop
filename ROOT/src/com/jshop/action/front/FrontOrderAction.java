package com.jshop.action.front;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.templates.DataCollectionTAction;
import com.jshop.action.templates.FreeMarkervariable;
import com.jshop.action.tools.Arith;
import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.Serial;
import com.jshop.action.tools.Validate;
import com.jshop.alipay.config.AlipayConfig;
import com.jshop.entity.CartT;
import com.jshop.entity.DeliverAddressT;
import com.jshop.entity.LogisticsBusinessT;
import com.jshop.entity.LogisticsbusinessareaT;
import com.jshop.entity.OrderT;
import com.jshop.entity.PaymentM;
import com.jshop.entity.ShippingAddressT;
import com.jshop.entity.UserT;
import com.jshop.entity.VouchersT;
import com.jshop.service.CartTService;
import com.jshop.service.DeliverAddressTService;
import com.jshop.service.LogisticsBusinessTService;
import com.jshop.service.LogisticsbusinessareaTService;
import com.jshop.service.OrderTService;
import com.jshop.service.PaymentMService;
import com.jshop.service.ShippingAddressTService;
import com.jshop.service.VouchersTService;
import com.jshop.service.impl.CartTServiceImpl;
import com.jshop.service.impl.DeliverAddressTServiceImpl;
import com.jshop.service.impl.LogisticsBusinessTServiceImpl;
import com.jshop.service.impl.LogisticsbusinessareaTServiceImpl;
import com.jshop.service.impl.OrderTServiceImpl;
import com.jshop.service.impl.PaymentMServiceImpl;
import com.jshop.service.impl.ShippingAddressTServiceImpl;
import com.jshop.service.impl.VouchersTServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
@Controller("frontOrderAction")
public class FrontOrderAction extends ActionSupport {
	private DeliverAddressTService deliverAddressTService;
	private Serial serial;
	private CartTService cartTService;
	private LogisticsBusinessTService logisticsBusinessTService;
	private PaymentMService paymentMService;
	private LogisticsbusinessareaTService logisticsbusinessareaTService;
	private VouchersTService vouchersTService;
	private ShippingAddressTService shippingAddressTService;
	private OrderTService orderTService;
	private DataCollectionTAction dataCollectionTAction;

	/**
	 * 收获地址区域变量
	 */
	private String addressid;
	private String userid;
	private String username;
	private String province;
	private String city;
	private String district;
	private String street;
	private String postcode;
	private String telno;
	private String mobile;
	private String email;
	private String state;
	private String shippingusername;
	private String serialidorderid;
	private OrderT order = new OrderT();
	private String paymentid;
	private String logisticsid;
	private String logisticswebaddress;
	private String totalfreight;
	private String vouchername;
	private String customernotes;
	private String orderTag;
	private Double total;//会员总价
	private Double totalweight;
	private String defaultlogisticsid;
	private Double freight;
	private Double vouchercontent = 0.0;
	private Double totalpoints;
	private String usedvoucherid;
	private String cartgoodsname;
	private String cartgoodsid;
	private int cartneedquantity;
	private String cartid;
	private String hidurl;
	private String redirecturl;
	private boolean sflag = false;
	private boolean svoucher = false;
	private boolean spayment = false;
	private boolean sshoppingaddress = false;
	private boolean saddorder = false;
	private boolean supdatecart = false;
	private boolean slogin;
	@JSON(serialize = false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}

	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}

	@JSON(serialize = false)
	public DeliverAddressTService getDeliverAddressTService() {
		return deliverAddressTService;
	}

	public void setDeliverAddressTService(DeliverAddressTService deliverAddressTService) {
		this.deliverAddressTService = deliverAddressTService;
	}
	@JSON(serialize = false)
	public CartTService getCartTService() {
		return cartTService;
	}

	public void setCartTService(CartTService cartTService) {
		this.cartTService = cartTService;
	}
	@JSON(serialize = false)
	public LogisticsBusinessTService getLogisticsBusinessTService() {
		return logisticsBusinessTService;
	}

	public void setLogisticsBusinessTService(LogisticsBusinessTService logisticsBusinessTService) {
		this.logisticsBusinessTService = logisticsBusinessTService;
	}
	@JSON(serialize = false)
	public PaymentMService getPaymentMService() {
		return paymentMService;
	}

	public void setPaymentMService(PaymentMService paymentMService) {
		this.paymentMService = paymentMService;
	}
	@JSON(serialize = false)
	public LogisticsbusinessareaTService getLogisticsbusinessareaTService() {
		return logisticsbusinessareaTService;
	}

	public void setLogisticsbusinessareaTService(LogisticsbusinessareaTService logisticsbusinessareaTService) {
		this.logisticsbusinessareaTService = logisticsbusinessareaTService;
	}
	@JSON(serialize = false)
	public VouchersTService getVouchersTService() {
		return vouchersTService;
	}

	public void setVouchersTService(VouchersTService vouchersTService) {
		this.vouchersTService = vouchersTService;
	}
	@JSON(serialize = false)
	public ShippingAddressTService getShippingAddressTService() {
		return shippingAddressTService;
	}

	public void setShippingAddressTService(ShippingAddressTService shippingAddressTService) {
		this.shippingAddressTService = shippingAddressTService;
	}
	@JSON(serialize = false)
	public OrderTService getOrderTService() {
		return orderTService;
	}

	public void setOrderTService(OrderTService orderTService) {
		this.orderTService = orderTService;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}


	public OrderT getOrder() {
		return order;
	}

	public void setOrder(OrderT order) {
		this.order = order;
	}

	public String getAddressid() {
		return addressid;
	}

	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}

	public String getTotalfreight() {
		return totalfreight;
	}

	public void setTotalfreight(String totalfreight) {
		this.totalfreight = totalfreight;
	}

	public Double getTotalpoints() {
		return totalpoints;
	}

	public void setTotalpoints(Double totalpoints) {
		this.totalpoints = totalpoints;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHidurl() {
		return hidurl;
	}

	public void setHidurl(String hidurl) {
		this.hidurl = hidurl;
	}

	public boolean isSflag() {
		return sflag;
	}

	public void setSflag(boolean sflag) {
		this.sflag = sflag;
	}

	public String getShippingusername() {
		return shippingusername;
	}

	public void setShippingusername(String shippingusername) {
		this.shippingusername = shippingusername;
	}

	public String getCartgoodsname() {
		return cartgoodsname;
	}

	public void setCartgoodsname(String cartgoodsname) {
		this.cartgoodsname = cartgoodsname;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getDefaultlogisticsid() {
		return defaultlogisticsid;
	}

	public void setDefaultlogisticsid(String defaultlogisticsid) {
		this.defaultlogisticsid = defaultlogisticsid;
	}

	public Double getTotalweight() {
		return totalweight;
	}

	public void setTotalweight(Double totalweight) {
		this.totalweight = totalweight;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public String getVouchername() {
		return vouchername;
	}

	public void setVouchername(String vouchername) {
		this.vouchername = vouchername;
	}

	public boolean isSvoucher() {
		return svoucher;
	}

	public void setSvoucher(boolean svoucher) {
		this.svoucher = svoucher;
	}

	public String getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}

	public Double getVouchercontent() {
		return vouchercontent;
	}

	public void setVouchercontent(Double vouchercontent) {
		this.vouchercontent = vouchercontent;
	}

	public int getCartneedquantity() {
		return cartneedquantity;
	}

	public void setCartneedquantity(int cartneedquantity) {
		this.cartneedquantity = cartneedquantity;
	}

	public boolean isSupdatecart() {
		return supdatecart;
	}

	public void setSupdatecart(boolean supdatecart) {
		this.supdatecart = supdatecart;
	}

	public String getCartgoodsid() {
		return cartgoodsid;
	}

	public void setCartgoodsid(String cartgoodsid) {
		this.cartgoodsid = cartgoodsid;
	}

	public boolean isSaddorder() {
		return saddorder;
	}

	public void setSaddorder(boolean saddorder) {
		this.saddorder = saddorder;
	}

	public String getOrderTag() {
		return orderTag;
	}

	public void setOrderTag(String orderTag) {
		this.orderTag = orderTag;
	}

	public String getCustomernotes() {
		return customernotes;
	}

	public void setCustomernotes(String customernotes) {
		this.customernotes = customernotes;
	}

	public boolean isSshoppingaddress() {
		return sshoppingaddress;
	}

	public void setSshoppingaddress(boolean sshoppingaddress) {
		this.sshoppingaddress = sshoppingaddress;
	}

	public String getLogisticsid() {
		return logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}

	public boolean isSpayment() {
		return spayment;
	}

	public void setSpayment(boolean spayment) {
		this.spayment = spayment;
	}

	public String getUsedvoucherid() {
		return usedvoucherid;
	}

	public void setUsedvoucherid(String usedvoucherid) {
		this.usedvoucherid = usedvoucherid;
	}

	public String getSerialidorderid() {
		return serialidorderid;
	}

	public void setSerialidorderid(String serialidorderid) {
		this.serialidorderid = serialidorderid;
	}

	public String getLogisticswebaddress() {
		return logisticswebaddress;
	}

	public void setLogisticswebaddress(String logisticswebaddress) {
		this.logisticswebaddress = logisticswebaddress;
	}

	public String getCartid() {
		return cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
	}

	public String getRedirecturl() {
		return redirecturl;
	}

	public void setRedirecturl(String redirecturl) {
		this.redirecturl = redirecturl;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	//初始化订单操作，包括收货地址是否已经有了。有就读取出来没有就增加新的，涉及保存新收获地址，
	//读取出新购物车内容，读取出默认的物流商，读取出默认的支付方式，保存订单需要同时保存发货地址
	//发票初始化，支付宝对接
	/**
	 * 获取用户收获地址
	 */
	public void GetUserDeliverAddress(UserT user) {
		List<DeliverAddressT> list = this.getDeliverAddressTService().findDeliverAddressByuserid(user.getUserid());
		ActionContext.getContext().put("deliveraddress", list);
	
	}

	/**
	 * 获取物流商配送方式
	 */
	public void GetDefaultLogistictsBusiness() {
		List<LogisticsBusinessT> list = this.getLogisticsBusinessTService().findAllLogisticsBusinessWithoutPage();
		if (!list.isEmpty()) {
			for (Iterator it = list.iterator(); it.hasNext();) {
				LogisticsBusinessT lbt = (LogisticsBusinessT) it.next();
				if (lbt.getVisible().equals("1")) {
					this.setDefaultlogisticsid(lbt.getLogisticsid());
					break;
				}
			}
			ActionContext.getContext().put("logistics", list);
		}
	}

	/**
	 * 获取支付方式
	 */
	public void GetDefaultPayment() {
		List<PaymentM> list = this.getPaymentMService().findAllPaymentWithoutPage();
		ActionContext.getContext().put("payments", list);
	}

	/**
	 * 获取购物车中的商品作为订单商品处理
	 * 
	 * @param user
	 */
	public void GetMyCart(UserT user) {
		List<CartT> list = this.getCartTService().findAllCartByUserId(user.getUserid());
		if (list != null) {
			this.setTotal(0.0);
			this.setTotalweight(0.0);
			this.setTotalpoints(0.0);
			this.setCartgoodsname("");
			this.setCartgoodsid("");
			this.setCartneedquantity(0);
			for (Iterator<CartT> it = list.iterator(); it.hasNext();) {
				CartT ct = (CartT) it.next();
				total = Arith.add(total, Arith.mul(ct.getFavorable(), Double.parseDouble(String.valueOf(ct.getNeedquantity()))));
				totalweight = Arith.add(totalweight, Arith.mul(Double.parseDouble(ct.getWeight()), Double.parseDouble(String.valueOf(ct.getNeedquantity()))));
				totalpoints = Arith.add(totalpoints, Arith.mul(ct.getPoints(), Double.parseDouble(String.valueOf(ct.getNeedquantity()))));
				cartgoodsname += ct.getGoodsname();
				cartgoodsid += ct.getGoodsid() + ",";
				cartneedquantity += ct.getNeedquantity();
				cartid = ct.getCartid();//获取购物车中的cartid表示同一个cartid即在同一个订单中
			}
			ActionContext.getContext().put("cart", list);
			ActionContext.getContext().put("totalprice", total);
			ActionContext.getContext().put("totalpoints", totalpoints);
			ActionContext.getContext().put("cartid", cartid);
			ActionContext.getContext().put("cartgoodsid", cartgoodsid);
			ActionContext.getContext().put("cartgoodsname", cartgoodsname);
			ActionContext.getContext().put("cartneedquantity", cartneedquantity);
		}
	}

	/**
	 * 计算运费
	 */
	private void GetLogisticsPrice() {
		Double temptotal = this.getTotal();
		List<LogisticsbusinessareaT> list = this.getLogisticsbusinessareaTService().findAllLogisticsbusinessareaTBylogisticsid(this.getDefaultlogisticsid());
		if (list != null) {
			Double tempfreight = 0.0;
			int tempy = 0;
			for (Iterator it = list.iterator(); it.hasNext();) {
				LogisticsbusinessareaT lbt = (LogisticsbusinessareaT) it.next();
				if (this.getTotal() > lbt.getNeedcostmin() && this.getTotal() < lbt.getNeedcostmax() && this.getTotalweight() < lbt.getOvervalue()) {
					tempfreight = lbt.getNormalcost();
					tempy = (int) (this.getTotalweight() / 1000);
				} else if (this.getTotal() > lbt.getNeedcostmin() && this.getTotal() < lbt.getNeedcostmax() && this.getTotalweight() < lbt.getOvervalue()) {
					tempfreight = 0.0;
					tempy = (int) (this.getTotalweight() / 1000);
				} else {
					tempfreight = 0.0;
					tempy = (int) (this.getTotalweight() / 1000);
				}
			}
			Double freight = tempfreight + tempy;
			this.setFreight(freight);
			ActionContext.getContext().put("freight", freight);

		}

	}

	/**
	 * 初始化订单所需信息
	 * 
	 * @return
	 */
	@Action(value = "InitOrder", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/shop/confirmorder.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html?redirecturl=${redirecturl}")
	})
	public String InitOrder() {
		UserT user = (UserT) ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
		if (user != null) {
			//获取用户收获地址
			GetUserDeliverAddress(user);
			//获取物流商
			GetDefaultLogistictsBusiness();
			//获取支付方式
			GetDefaultPayment();
			//获取购物车中的商品作为订单商品处理
			GetMyCart(user);
			//计算运费
			GetLogisticsPrice();
			//获取总金额+运费
			Double totalfreight = this.getTotal() + this.getFreight();
			ActionContext.getContext().put("totalfreight", totalfreight);
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
	 * 根据编码兑现抵用券
	 * 
	 * @return
	 * @throws ParseException
	 */
	@Action(value = "GetVouchersByname", results = { 
			@Result(name = "json",type="json")
	})
	public String GetVouchersByname() throws ParseException {
		UserT user = (UserT) ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
		if (user != null) {
			if (Validate.StrNotNull(this.getVouchername())) {
				VouchersT v = this.getVouchersTService().findVouchersForHonor(this.getVouchername());
				if (v != null) {
					this.setVouchercontent(Double.parseDouble(v.getVoucherscontent()));
					this.setUsedvoucherid(v.getVouchersid());
					this.setSvoucher(false);
					return "json";
				}
				return "json";
			} else {
				this.setSvoucher(true);
				return "json";
			}

		} else {
			return "json";
		}

	}

	/**
	 *获取支付信息
	 * 
	 * @return
	 */
	public void GetPaymentinfo() {
		PaymentM list = this.getPaymentMService().findPaymentbyId(this.getPaymentid().trim());
		if (list != null) {
			AlipayConfig.partner = list.getPartnerid();
			AlipayConfig.key = list.getSafecode();
			AlipayConfig.seller_email = list.getAccount();
			//把支付方式id和名称增加到order中
			order.setPaymentid(list.getPaymentid());
			order.setPaymentname(list.getPaymentname());
			this.setSpayment(true);
		} else {
			this.setSpayment(false);
		}
	}

	/**
	 * 设置订单数据
	 * 
	 * @return
	 */
	@SuppressWarnings("static-access")
	public void initOrderInfo(UserT user) {

		order.setOrderid(this.getSerialidorderid());
		order.setUserid(user.getUserid());
		order.setUsername(user.getUsername());
		//未来需要在这里处理是平邮还是快递或者是ems，这样物流商需要选择是平邮还是快递还是ems
		if (this.getPaymentid().trim().equals("-1")) {
			order.setDelivermode("货到付款");
			//未来获取特定的支付标记来标记货到付款
		}
		order.setDelivermode("EXPRESS");
		order.setDeliverynumber(null);//发货单号在发货后填写
		order.setOrderstate("0");//待确认
		order.setPaystate("0");//未付款
		order.setShippingstate("0");//未发货
		order.setLogisticsid(this.getLogisticsid().trim());
		order.setLogisticswebaddress(this.getLogisticswebaddress());
		order.setGoodid(this.getCartgoodsid());
		order.setGoodsname(this.getCartgoodsname());
		order.setNeedquantity(this.getCartneedquantity());
		order.setFreight(this.getFreight());//运费，在request中也有
		//		if(!this.isSvoucher()){

		order.setAmount(Arith.sub(Arith.add(this.getTotal(), this.getFreight()), this.getVouchercontent()));
		//		}else{
		//			order.setAmount(this.getTotal()+this.getFreight());//金额，含运费
		//		}
		order.setPoints(this.getTotalpoints());
		order.setPurchasetime(BaseTools.systemtime());
		order.setDeliverytime(null);
		order.setDeliverynumber(null);
		//发票处理晚
		order.setInvoice("0");
		order.setCustomernotes(this.getCustomernotes());
		order.setPaytime(null);
		order.setOrderTag(this.getOrderTag());
		order.setToBuyer(null);//给用户的留言
		//		if(!this.isSvoucher()){
		order.setShouldpay(Arith.sub(Arith.add(this.getTotal(), this.getFreight()), this.getVouchercontent()));
		//		}else{
		//			order.setShouldpay(this.getTotal()+this.getFreight());//金额，含运费
		//		}
		order.setUsepoints(0.0);//用户没有使用积分
		order.setVouchersid(this.getUsedvoucherid());
		order.setCreatetime(BaseTools.systemtime());
		order.setHasprintexpress("0");//未打印快递单
		order.setHasprintinvoice("0");//未打印发货单
		order.setHasprintfpinvoice("0");//未开具发票
		order.setExpressnumber(null);//快递单号
		if (this.getOrderTService().addOrder(order) > 0) {
			AlipayConfig.out_trade_no = order.getOrderid();
			AlipayConfig.subject = order.getGoodsname();
			AlipayConfig.body = order.getGoodsname();
			AlipayConfig.price = String.valueOf(order.getShouldpay());
			AlipayConfig.logistics_fee = String.valueOf(order.getFreight());

			this.setSaddorder(true);
		} else {
			this.setSaddorder(false);
		}
	}

	/**
	 * 增加发货地址
	 */
	public void AddShippingAddress() {
		DeliverAddressT list = this.getDeliverAddressTService().findDeliverAddressById(this.getAddressid());
		if (list != null) {
			ShippingAddressT s = new ShippingAddressT();
			s.setShippingaddressid(this.getSerial().Serialid(Serial.SHIPPINGADDRESS));
			s.setUserid(list.getUserid());
			s.setUsername(list.getUsername());
			s.setCountry(list.getCountry());
			s.setProvince(list.getProvince());
			s.setCity(list.getCity());
			s.setDistrict(list.getDistrict());
			s.setStreet(list.getStreet());
			s.setPostcode(list.getPostcode());
			s.setTelno(list.getTelno());
			s.setMobile(list.getMobile());
			s.setEmail(list.getEmail());
			s.setCreatetime(BaseTools.systemtime());
			s.setState("1");
			s.setDeliveraddressid(list.getAddressid());
			s.setIssend("0");//未发送到这个地址过
			s.setOrderid(this.getSerialidorderid());//设置订单号
			if (this.getShippingAddressTService().addShoppingAddress(s) > 0) {
				this.setSshoppingaddress(false);
				order.setShippingaddressid(s.getShippingaddressid());//设置发货地址到订单中
				order.setDeliveraddressid(list.getAddressid());//设置收货地址到订单中
				order.setShippingusername(list.getUsername());//设置收货人
				//设置收货人信息给支付宝借口
				AlipayConfig.receive_name = list.getUsername();
				AlipayConfig.receive_address = list.getProvince() + list.getCity() + list.getDistrict() + list.getStreet();
				AlipayConfig.reveive_zip = list.getPostcode();
				AlipayConfig.reveive_phone = list.getTelno();
				AlipayConfig.reveive_mobile = list.getMobile();
			} else {
				this.setSshoppingaddress(true);
			}
		}
	}

	/**
	 * 事先获取订单编号
	 */
	public void GetSerialidorder() {
		
		this.setSerialidorderid(this.getSerial().Serialid(Serial.ORDER));
	}

	/**
	 * 获取支付宝需要的订单信息
	 * 
	 * @return
	 */
	@Action(value = "InitAlipayneedInfo", results = { 
			@Result(name = "json",type="json")
	})
	public String InitAlipayneedInfo() {
		UserT user = (UserT) ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
		if (user != null) {
			this.setSlogin(true);
			//预先生成订单编号
			GetSerialidorder();
			//获取支付信息
			GetPaymentinfo();
			//增加收获信息到发货地址表中
			AddShippingAddress();
			//增加订单到数据库
			initOrderInfo(user);
			if (this.isSaddorder()) {
				//更新购物车商品到3，表示已经在订单中。并把对应订单号更新
				//String []tempgoodsid=order.getGoodid().split(",");
				//检查如果购物已经有对应的订单号则不更新
				//3表示加入订单的购物车
				List<CartT>list=this.getCartTService().findCartByCartid(this.getCartid(), "3");
				if(!list.isEmpty()){
					return "json";
				}
				this.getCartTService().updateCartStateandOrderidByGoodsidList(this.getCartid().trim(), this.getSerialidorderid(), user.getUserid(), "3");
			}
			return "json";

		}
		this.setSlogin(false);
		return "json";
	}
}
