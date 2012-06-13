package com.jshop.action.templates;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.InitTAction;
import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.ContentTag;
import com.jshop.action.tools.FreeMarkervariable;
import com.jshop.entity.TemplatesetT;
import com.jshop.service.TemplatesetTService;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.TemplateException;
@ParentPackage("json-default")
@Namespace("")
@Controller("initAllHtml")
public class InitAllHtml extends ActionSupport {
	private CreateHtml createHtml;
	private DataCollectionTAction dataCollectionTAction;
	private InitTAction initTAction;
	private TemplatesetTService templatesetTService;
	private Map<String, Object> map;
	private String status;
	private String buildlog;
	public InitAllHtml() {
		map = new HashMap<String, Object>();
	}
	@JSON(serialize = false)
	public TemplatesetTService getTemplatesetTService() {
		return templatesetTService;
	}

	public void setTemplatesetTService(TemplatesetTService templatesetTService) {
		this.templatesetTService = templatesetTService;
	}

	@JSON(serialize = false)
	public InitTAction getInitTAction() {
		return initTAction;
	}
	public void setInitTAction(InitTAction initTAction) {
		this.initTAction = initTAction;
	}
	@JSON(serialize = false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}
	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
	}
	
	@JSON(serialize = false)
	public CreateHtml getCreateHtml() {
		return createHtml;
	}

	public void setCreateHtml(CreateHtml createHtml) {
		this.createHtml = createHtml;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public String getBuildlog() {
		return buildlog;
	}

	public void setBuildlog(String buildlog) {
		this.buildlog = buildlog;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 生成所有静态数据
	 * 
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("finally")
	@Action(value = "buildAllHtml", results = { 
			@Result(name = "json",type="json")
	})
	public String buildAllHtml() throws IOException, TemplateException, IllegalAccessException {
		StringBuilder buildhtmllog=new StringBuilder();
		//开始收集公共数据
		try{
			//生成记录开始
			buildhtmllog.append("<p>1,获取默认主题信息</p>");
			//获取默认主题
			this.getInitTAction().InitDefaultThemeT();
			buildhtmllog.append(this.getInitTAction().getLogmsg());
			//创建ftl模板数据
			buildhtmllog.append("<p>2,创建FTL模板数据</p>");
			this.getCreateHtml().recreateTemplate();
			buildhtmllog.append(this.getCreateHtml().getLogmsg());
			//获取根目录
			buildhtmllog.append("<p>3,获取网站根目录</p>");
			map.put(FreeMarkervariable.BASEPATH,this.getDataCollectionTAction().getBasePath());
			buildhtmllog.append("<p>根目录获取成功</p>");
			//获取session
//			buildhtmllog.append("<p>4,获取Session数据</p>");
//			map.put(FreeMarkervariable.SESSION, this.getDataCollectionTAction().getSession());
//			buildhtmllog.append("<p>Session数据获取成功</p>");
			//获取导航数据
			buildhtmllog.append("<p>5,获取导航数据<p>");
			map.put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation());
			buildhtmllog.append(this.getDataCollectionTAction().getLogmsg());
			//获取商城基本数据
			buildhtmllog.append("<p>6,获取商城基础数据</p>");
			map.put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo());
			buildhtmllog.append(this.getDataCollectionTAction().getLogmsg());
			
			
			//获取商品分类左侧主导航
			buildhtmllog.append("<p>7,获取商品分类导航数据</p>");
			map.put(FreeMarkervariable.GOODSCATEGORYTREE, this.getDataCollectionTAction().findGoodsCategoryT());
			map.put(FreeMarkervariable.GOODSCATEGORYTREEFIRSTCOUNT, this.getDataCollectionTAction().getGoodsCategoryTreeFirstCount());
			buildhtmllog.append(this.getDataCollectionTAction().getLogmsg());
			//获取页脚分类数据
			buildhtmllog.append("<p>8,获取商城页脚分类数据</p>");
			map.put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT());
			buildhtmllog.append(this.getDataCollectionTAction().getLogmsg());
			//获取页脚文章数据
			buildhtmllog.append("<p>9,获取商城页脚文章数据</p>");
			map.put(FreeMarkervariable.FOOTERATRICLE,this.getDataCollectionTAction().findFooterArticle());
			buildhtmllog.append(this.getDataCollectionTAction().getLogmsg());
			//获取首页自定义区域
			buildhtmllog.append("<p>10,获取首页自定义区域数据</p>");
			this.getDataCollectionTAction().findEditarea(ContentTag.TEMPLATENAMEFORINDEX, "1", map);
			buildhtmllog.append(this.getDataCollectionTAction().getLogmsg());
			//获取系统所有文章数据
			map.put(FreeMarkervariable.ARTICLE, this.getDataCollectionTAction().findAllArticleT());
			
			//根据模板生成静态页
			List<TemplatesetT>list=this.getTemplatesetTService().findTemplatesetTBystatus("1");
			if(!list.isEmpty()){
				for(Iterator it=list.iterator();it.hasNext();){
					TemplatesetT tt=(TemplatesetT)it.next();
					if(tt.getSign().equals(BaseTools.getApplicationthemesig()+"_"+ContentTag.TEMPLATENAMEFORGOODSDETAIL)){
						this.getCreateHtml().buildGoodsdetailsPage(map);
						buildhtmllog.append(this.getCreateHtml().getLogmsg().toString());
					}else if(tt.getSign().equals(BaseTools.getApplicationthemesig()+"_"+ContentTag.TEMPLATENAMEFORARTICLE)){
						this.getCreateHtml().buildArticlesPage(map);
						buildhtmllog.append(this.getCreateHtml().getLogmsg().toString());
					}else if(tt.getSign().equals(BaseTools.getApplicationthemesig()+"_"+ContentTag.TEMPLATENAMEFORGOODSCATEGORYLIST)){
						this.getCreateHtml().buildGoodsCategoryPage(map);
						buildhtmllog.append(this.getCreateHtml().getLogmsg().toString());
					}else if(tt.getSign().equals(BaseTools.getApplicationthemesig() + "_" + ContentTag.TEMPLATENAMEFORGOODSGROUPT)){
						this.getCreateHtml().buildGoodsGroupT(map);
						buildhtmllog.append(this.getCreateHtml().getLogmsg().toString());
					}else{
						this.getCreateHtml().createNormalhtml(tt.getSign(), "", map);
						buildhtmllog.append(this.getCreateHtml().getLogmsg().toString());
					}
				}
				
			}
			
			
			
		}catch(Exception e){
			buildhtmllog.append("<p style='color:red;'>"+e.getMessage()+"出现异常请根据反馈信息修复</p>");
			this.setBuildlog(buildhtmllog.toString());
		}
		this.setBuildlog(buildhtmllog.toString());
		this.setStatus("success");
		return "json";
		
		
	}
	
	

	
}
