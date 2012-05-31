package com.jshop.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;
import com.jshop.action.templates.CreateHtml;
import com.jshop.action.templates.DataCollectionTAction;
import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.ContentTag;
import com.jshop.action.tools.Serial;
import com.jshop.action.tools.Validate;
import com.jshop.entity.ArticleCategoryT;
import com.jshop.entity.ArticleT;
import com.jshop.entity.JshopbasicInfoT;
import com.jshop.entity.SiteNavigationT;
import com.jshop.service.ArticleCategoryTService;
import com.jshop.service.ArticleTService;
import com.jshop.service.JshopbasicInfoTService;
import com.jshop.service.SiteNavigationTService;
import com.jshop.service.impl.ArticleCategoryTServiceImpl;
import com.jshop.service.impl.ArticleTServiceImpl;
import com.jshop.service.impl.JshopbasicInfoTServiceImpl;
import com.jshop.service.impl.SiteNavigationTServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import freemarker.template.TemplateException;

@ParentPackage("jshop")
@Controller("articleTAction")
public class ArticleTAction extends ActionSupport {
	private ArticleTService articleTService;
	private ArticleCategoryTService articleCategoryTService;
	private DataCollectionTAction dataCollectionTAction;
	private CreateHtml createHtml;
	private Serial serial;
	private String articleid;
	private String articleCategoryTid;
	private String title;
	private String metaKeywords;
	private String metaDes;
	private String contentvalue;
	private String status;
	private String creatorid;
	private String author;
	private String ispublication;
	private String isrecommend;
	private String istop;
	private String readcount;
	private String htmlPath;
	private Integer pageCount;
	private String isnotice;
	private String articleCategoryName;
	private Date createtime;
	private Date updatetime;
	private Integer version;
	private ArticleT bean = new ArticleT();
	private ArticleCategoryT actbean = new ArticleCategoryT();
	private Map<String, Object> map = new HashMap<String, Object>();
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String query;
	private String qtype;
	private boolean slogin;
	private boolean sucflag;
	
	@JSON(serialize = false)
	public ArticleTService getArticleTService() {
		return articleTService;
	}

	public void setArticleTService(ArticleTService articleTService) {
		this.articleTService = articleTService;
	}
	@JSON(serialize = false)
	public ArticleCategoryTService getArticleCategoryTService() {
		return articleCategoryTService;
	}

	public void setArticleCategoryTService(ArticleCategoryTService articleCategoryTService) {
		this.articleCategoryTService = articleCategoryTService;
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

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public String getArticleid() {
		return articleid;
	}

	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}

	public String getArticleCategoryTid() {
		return articleCategoryTid;
	}

	public void setArticleCategoryTid(String articleCategoryTid) {
		this.articleCategoryTid = articleCategoryTid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	public String getMetaDes() {
		return metaDes;
	}

	public void setMetaDes(String metaDes) {
		this.metaDes = metaDes;
	}

	public String getContentvalue() {
		return contentvalue;
	}

	public void setContentvalue(String contentvalue) {
		this.contentvalue = contentvalue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIspublication() {
		return ispublication;
	}

	public void setIspublication(String ispublication) {
		this.ispublication = ispublication;
	}

	public String getIsrecommend() {
		return isrecommend;
	}

	public void setIsrecommend(String isrecommend) {
		this.isrecommend = isrecommend;
	}

	public String getIstop() {
		return istop;
	}

	public void setIstop(String istop) {
		this.istop = istop;
	}

	public String getReadcount() {
		return readcount;
	}

	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}

	public String getHtmlPath() {
		return htmlPath;
	}

	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public ArticleT getBean() {
		return bean;
	}

	public void setBean(ArticleT bean) {
		this.bean = bean;
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

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public String getArticleCategoryName() {
		return articleCategoryName;
	}

	public void setArticleCategoryName(String articleCategoryName) {
		this.articleCategoryName = articleCategoryName;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public ArticleCategoryT getActbean() {
		return actbean;
	}

	public void setActbean(ArticleCategoryT actbean) {
		this.actbean = actbean;
	}


	public String getIsnotice() {
		return isnotice;
	}

	public void setIsnotice(String isnotice) {
		this.isnotice = isnotice;
	}

	
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}



	/**
	 * 增加文章
	 * 
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 */
	@Action(value = "addArticleT", results = { @Result(name = "json", type = "json") })
	public String addArticleT() throws IOException, TemplateException {
		ArticleT at = new ArticleT();
		at.setArticleid(this.getSerial().Serialid(Serial.ARTICLE));
		at.setArticleCategoryTid(this.getArticleCategoryTid());
		at.setArticleCategoryName(this.getArticleCategoryName());
		at.setTitle(this.getTitle());
		at.setMetaKeywords(this.getMetaKeywords());
		at.setMetaDes(this.getMetaDes());
		at.setContentvalue(this.getContentvalue());
		at.setAuthor(this.getAuthor());
		if (this.getIspublication().equals("1")) {
			at.setIspublication("1");
			at.setStatus("1");
		} else {
			at.setIspublication("0");
			at.setStatus("0");
		}
		at.setIsrecommend(this.getIsrecommend());
		at.setIstop(this.getIstop());
		at.setReadcount(0);
		at.setPageCount(this.getPageCount());
		at.setCreatetime(BaseTools.systemtime());
		at.setCreatorid(BaseTools.adminCreateId());
		at.setUpdatetime(BaseTools.systemtime());
		at.setVersion(0);
		at.setHtmlPath("#");
		actbean = this.getArticleCategoryTService().findArticleCategoryByarticleCategoryTid(this.getArticleCategoryTid());
		if (actbean != null) {
			if (actbean.getPosition() != null && actbean.getPosition().equals("1")) {
				at.setPosition("1");
			} else {
				at.setPosition("0");
			}
		}
		at.setIsnotice(this.getIsnotice());
		this.getArticleTService().addArticleT(at);
		this.setBean(at);
		this.setSucflag(true);
		return "json";
	}

	/**
	 * 更新文章静态路径
	 * 
	 * @param articleid
	 * @param htmlPath
	 */
	public void updateHtmlPath(String articleid, String htmlPath) {
		this.getArticleTService().updateHtmlPath(articleid, htmlPath);
	}

	/**
	 * 根据articleid获取文章
	 * 
	 * @return
	 */
	@Action(value = "findArticleByarticleid", results = { @Result(name = "json", type = "json") })
	public String findArticleByarticleid() {
		if(Validate.StrNotNull(this.getArticleid())){
			bean = this.getArticleTService().findArticleByarticleid(this.getArticleid());
			if (bean != null) {
				this.setSucflag(true);
				return "json";
			}
			this.setSucflag(false);
			return "json";
		}
		this.setSucflag(false);
		return "json";

	}

	/**
	 * 更新文章
	 * 
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 */
	@Action(value = "updateArticleT", results = { @Result(name = "json", type = "json") })
	public String updateArticleT() throws IOException, TemplateException {
		ArticleT at = new ArticleT();
		at=this.getArticleTService().findArticleByarticleid(this.getArticleid());
		at.setArticleCategoryTid(this.getArticleCategoryTid());
		at.setArticleCategoryName(this.getArticleCategoryName());
		at.setTitle(this.getTitle());
		at.setMetaKeywords(this.getMetaKeywords());
		at.setMetaDes(this.getMetaDes());
		at.setContentvalue(this.getContentvalue());
		if (this.getIspublication().equals("1")) {
			at.setIspublication("1");
			at.setStatus("1");
		} else {
			at.setIspublication("0");
			at.setStatus("0");
		}
		at.setAuthor(this.getAuthor());
		at.setIsrecommend(this.getIsrecommend());
		at.setIstop(this.getIstop());
		at.setPageCount(this.getPageCount());
		at.setCreatetime(BaseTools.systemtime());
		at.setCreatorid(BaseTools.adminCreateId());
		at.setReadcount(Integer.parseInt(this.getReadcount()));
		actbean = this.getArticleCategoryTService().findArticleCategoryByarticleCategoryTid(this.getArticleCategoryTid());
		if (actbean != null) {
			if (actbean.getPosition() != null && actbean.getPosition().equals("1")) {
				at.setPosition("1");
			} else {
				at.setPosition("0");
			}
		}
		at.setIsnotice(this.getIsnotice());
		if (this.getArticleTService().updateArticleT(at) > 0) {
			this.setBean(at);
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 批量删除文章
	 * 
	 * @return
	 */
	@Action(value = "delArticleT", results = { @Result(name = "json", type = "json") })
	public String delArticleT() {
		String[] strs = this.getArticleid().split(",");
		this.getArticleTService().delArticleT(strs);
		this.setSucflag(true);
		return "json";
	}

	/**
	 * 查询所有文章
	 * 
	 * @return
	 */
	@Action(value = "findAllArticleT", results = { @Result(name = "json", type = "json") })
	public String findAllArticleT() {
		if ("sc".equals(this.getQtype())) {
			this.findDefaultAllArticle();
		} else {
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {
				return "json";
			}
		}
		return "json";
	}

	public void findDefaultAllArticle() {
		int currentPage = page;
		int lineSize = rp;
		total = this.getArticleTService().countfindAllArticle(BaseTools.adminCreateId());
		List<ArticleT> list = this.getArticleTService().findAllArticleT(currentPage, lineSize, BaseTools.adminCreateId());
		if (list != null) {
			this.ProcessArticleTList(list);
		}
	}

	public void ProcessArticleTList(List<ArticleT> list) {
		for (Iterator it = list.iterator(); it.hasNext();) {
			ArticleT at = (ArticleT) it.next();
			if (at.getIspublication().equals("1")) {
				at.setIspublication("<span class='truestatue'><img src='../images/base_right_icon.gif'/></span>");
			} else {
				at.setIspublication("<span class='falsestatue'><img src='../images/base_wrong_icon.gif'/></span>");
			}
			if (at.getIsrecommend().equals("1")) {
				at.setIsrecommend("<span class='truestatue'><img src='../images/base_right_icon.gif'/></span>");
			} else {
				at.setIsrecommend("<span class='falsestatue'><img src='../images/base_wrong_icon.gif'/></span>");
			}
			if (at.getIstop().equals("1")) {
				at.setIstop("<span class='truestatue'><img src='../images/base_right_icon.gif'/></span>");
			} else {
				at.setIstop("<span class='falsestatue'><img src='../images/base_wrong_icon.gif'/></span>");
			}
			if (at.getIsnotice().equals("1")) {
				at.setIsnotice("<span class='truestatue'><img src='../images/base_right_icon.gif'/></span>");
			} else {
				at.setIsnotice("<span class='falsestatue'><img src='../images/base_wrong_icon.gif'/></span>");
			}
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", at.getArticleid());
			cellMap.put("cell", new Object[] { at.getTitle(), at.getArticleCategoryName(),at.getIsnotice(), at.getIspublication(), at.getIsrecommend(), at.getIstop(), at.getCreatetime(), "<a target='_blank' id='editarticle' href='jshop/admin/pagecontent/addarticle.jsp?articleid=" + at.getArticleid() + "' name='editarticle'>[编辑]</a>" + "<a target='_blank' id='browerarticle' href='" + at.getHtmlPath() + "' name='browerarticle'>[预览]</a>" });
			rows.add(cellMap);
		}
	}
}
