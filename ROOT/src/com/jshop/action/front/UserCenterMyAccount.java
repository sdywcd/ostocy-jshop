package com.jshop.action.front;

import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.jshop.action.templates.DataCollectionTAction;
import com.jshop.action.templates.FreeMarkervariable;
import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.Validate;
import com.jshop.entity.UserT;
import com.jshop.service.UsertService;

@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
@Controller("userCenterMyAccount")
public class UserCenterMyAccount extends ActionSupport {
	private UsertService usertService;
	private DataCollectionTAction dataCollectionTAction;
	private String userid;
	private String username;
	private String question;
	private String answer;
	private String password;
	private String oldanswer;//原始答案
	private boolean sucflag;

	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}

	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}

	@JSON(serialize = false)
	public UsertService getUsertService() {
		return usertService;
	}

	public void setUsertService(UsertService usertService) {
		this.usertService = usertService;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getOldanswer() {
		return oldanswer;
	}

	public void setOldanswer(String oldanswer) {
		this.oldanswer = oldanswer;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	/**
	 * 设置密码保护
	 * @return
	 */
	@Action(value = "updateUserPasswordProtection", results = { 
			@Result(name = "json",type="json")
	})
	public String updateUserPasswordProtection() {
		UserT user=(UserT) ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
		if(user!=null){
			//先验证原始的密码保护问题是否正确
			if(Validate.StrNotNull(user.getQuestion())){
				//验证输入的原始答案
				if(user.getAnswer().equals(this.getOldanswer().trim())){
					if (Validate.StrNotNull(this.getQuestion()) && Validate.StrNotNull(this.getAnswer())) {
						this.getUsertService().updateUserPasswordProtection(user.getUserid(), this.getQuestion(), this.getAnswer());
						this.setSucflag(true);
						return "json";
					}
					this.setSucflag(false);
					return "json";
				}
			}else{
				if (Validate.StrNotNull(this.getQuestion()) && Validate.StrNotNull(this.getAnswer())) {
					this.getUsertService().updateUserPasswordProtection(user.getUserid(), this.getQuestion(), this.getAnswer());
					this.setSucflag(true);
					return "json";
				}
				this.setSucflag(false);
				return "json";
			}
		}
		this.setSucflag(false);
		return "json";
	}
	
	/**
	 * 初始化用户密码保护页面
	 * @return
	 */
	@Action(value = "InitMyAccountProtection", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/shop/passwordprotection.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html")
	})
	public String InitMyAccountProtection(){
		UserT user=(UserT)ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
		if(user!=null){
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
	

}
