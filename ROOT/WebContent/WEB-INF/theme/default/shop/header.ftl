<div id="header">
  <div id="logininfo" style="height: 30px;">
    <div class="topbar">
      <div class="inner">
        <!--<div class="topbar_left">
						
							<a style="color: red;" target="_blank" href="http://www.datanggroup.cn/"></a> 
						</div>-->
        <div class="shortcut" id="id_temp">
          <div class="welcome"> 您好，欢迎来到欧斯塔克商城！ </div>
          <ul>
            <#if Session??&&Session["user"]?exists>
            <#list sitenavigationlist?sort_by("sort") as snl>
            <#if snl.position="1">
            <li> <#if snl.sign??&&snl.sign=="login">
              你好[${Session.user.username}]
              <#else> <a href="${basepath}<@snl.htmlPath?interpret />"
									<#if snl.isTargetBlank="1"> target="_blank"</#if> >${snl.name} </a> </#if> </li>
            </#if>
            </#list>
            <#else>
            <#list sitenavigationlist?sort_by("sort") as snl>
            <#if snl.position="1">
            <li> <a href="${basepath}<@snl.htmlPath?interpret />"
										<#if snl.isTargetBlank="1"> target="_blank"</#if> >${snl.name} </a> </li>
            </#if>
            </#list>
            </#if>
          </ul>
          <div class="hotline"> <img src="${basepath}ui/default/images/hotline_top.gif"> </div>
        </div>
      </div>
    </div>
  </div>
  <div class="logo">
    <div class="inner">
      <!-- 平时使用的logo -->
      <div class="logowrap"> <a href="${basepath}index.html"><img src="${basepath}ui/default/images/index_logo.gif"> </a> </div>
      <div class="slogan"> <img src="${basepath}ui/default/images/slogan.gif"> </div>
      <div class="top_right_ad"> <img src="${basepath}ui/default/images/home_promises.gif" style="cursor: pointer;"> </div>
      <!--广告尺寸宽度小于378ps高度小于75px-->
    </div>
  </div>
  <#include "/WEB-INF/theme/default/shop/headersearch.ftl"> </div>
