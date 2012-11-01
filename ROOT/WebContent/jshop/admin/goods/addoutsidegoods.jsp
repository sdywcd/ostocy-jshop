<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("detail") != null ? request.getParameter("detail") : "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <style>
	#place select{
		width:120px;
		margin-left:0px;
	}
  </style>
<title>Insert title here</title>
		<style type="text/css">
#triggers img {
	cursor: pointer;
	margin: 0 5px;
	background-color: #fff;
	border: 1px solid #ccc;
	padding: 2px;
	width: 200px;
	height: 150px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
}
.abelinked{  
   display: block;  
   border: 1px solid #aaa;  
   text-decoration: none;  
   background-color: #fafafa;  
   color: #123456;  
   margin: 2px;  
   clear:both;  
  } 
</style>
</head>
<body>
<!-- header 包含头部导航-->
		<%@include file="/jshop/admin/header.jsp"%>
		<!-- end header -->
		<!-- content -->
		<div id="content">
			<!-- end content / left -->
			<%@include file="/jshop/admin/left.jsp"%>
			<!-- end content / left -->
			<!-- content / right -->
			<div id="right">
				<!-- table -->
				<div class="box">
					<!-- box / title -->
					<div class="title">
						<h5>
							增加/编辑外链商品
						</h5>

					</div>

					<div class="form">
						<div class="fields">
								<div class="field field-first">
									<div class="label">
										<label for="select">
											选择商品所属分类:
										</label>
									</div>
									<div class="select">
										<select id="navid" name="navid">
											<option value="0">
												---请选择---
											</option>
										</select>
										<select id="ltypeid" name="ltypeid">
											<option value="0">
												---请选择---
											</option>
										</select>
										<select id="stypeid" name="stypeid">
											<option value="0">
												---请选择---
											</option>
										</select>
									</div>
								</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										商品名称:
									</label>
								</div>
								<div class="input">
									<input type="text" id="goodsname" name="goodsname" class="small" />
									
								</div>
							</div>
							<div class="field ">
								<div class="label label-radio">
									<label for="input-small">
										状态:
									</label>
								</div>
								<div class="radios">
								<div class="radio">									
									<input type=radio id="salestate" name="salestate" class="small" value="1" />	
									<label>开启</label>
									<input type=radio id="salestate" name="salestate" class="small" checked="checked" value="0"/>	
									<label>关闭</label>
								</div>	
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										外链地址:
									</label>
								</div>
								<div class="input">
									<input type="text" id="linkUrl" name="linkUrl" class="small" />
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										排序:
									</label>
								</div>
								<div class="input">
									<input type="text" id="sort" name="sort" class="small" />
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										版本号:
									</label>
								</div>
								<div class="input">
									<input type="text" id="versiont" name="versiont" class="small" />
									
								</div>
							</div>
							
							<div id="box-mainpicture" class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="label">
										<label for="file">
											主图片:
										</label>
									</div>
									<div class="input input-file">
										<button id="delpc" name="delpc">
											删除图片
										</button>
										<div id="file-uploader-demo1">
											<noscript>
												<p>
													Please enable JavaScript to use file uploader.
												</p>
												<!-- or put a simple form for upload here -->
											</noscript>
										</div>
										<!-- trigger elements -->
										<div id="triggers">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">
										<input type="hidden" id="id" name="id" />
										<input type="button" id="add" name="add" value="提交"  />
										<input type="button" id="update" name="update" value="更新" style="display: none;" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
							
						</div>
					</div>	
				</div>
				<!-- end table -->
				
			<!-- end content / right -->
		</div>
		<!-- end content -->
		<!-- footer -->
		<script type="text/javascript" src="<%=basePath%>/jshop/admin/js/regme.js"></script>
		<script type="text/javascript" src="<%=basePath%>/jshop/admin/js/addoutsidegoodsjs.js"></script>
		
		<script type="text/javascript" src="<%=basePath %>/My97DatePicker/WdatePicker.js"></script>
	
		<%@include file="/jshop/admin/footer.jsp"%>
		<!-- end footert -->
		<!--  <script type="text/javascript">
		$(function(){
			$("#place").ProvinceCity();
		});
		</script>-->
	<script type="text/javascript">
 		 function createUploader(){ 
             var uploader = new qq.FileUploader({
                 element: document.getElementById('file-uploader-demo1'),
                 action: '<%=basePath%>/ajaxFileUploads.action;jsessionid=<%=session.getId()%>',
                 debug: true,
                 minSizeLimit:1024,
                 sizeLimit: 1073741824,
                 allowedExtensions: ['jpeg','jpg','gif','png'],
                 onComplete: function(id, fileName, responseJSON){
                	var pcpath1="<%=basePath%>"+responseJSON.success;
  					var pcpath=responseJSON.success;
  					var htm="<img id='"+id+"' src='"+pcpath1+"' rel='#"+fileName+"'/>";
  					var checkpc="<input id='"+id+"' name='pcpath' type='checkbox' value='"+pcpath+"' checked='true'/> "
  					$("#triggers").html("");
  					$("#triggers").append(htm).append(checkpc);
                 },
               
             });           
         }
 		window.onload = createUploader; 
 	</script>

		<script type="text/javascript">
 		KE.show({
			id : 'detail',
		    imageUploadJson : '<%=basePath%>/jshop/admin/js/jsp/upload_json.jsp',
			fileManagerJson : '<%=basePath%>/jshop/admin/js/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function(id) {
				KE.event.ctrl(document, 13, function() {
					KE.util.setData(id);
				});
			}
		});
 		KE.show({
			id : 'commoditylist',
			items : ['fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist','insertunorderedlist']
		});
 		
 		 $().ready(function(){  
 		   $('#addbelinked').click(function() {  
 		    return !$('#select1 option:selected').remove().appendTo('#select2');  
 		   });
 		   $('#removebelinked').click(function() {  
 		    return !$('#select2 option:selected').remove().appendTo('#select1');  
 		   });  
 		 });  
 		
 	</script>
	</body>

</html>
<%!private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}%>