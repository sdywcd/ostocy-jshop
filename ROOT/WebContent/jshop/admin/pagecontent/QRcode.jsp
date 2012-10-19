<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>二维码生成</title>


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
							生成二维码
						</h5>

					</div>

					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										名称:
									</label>
								</div>
								<div class="input">
									<input type="text"  id="pathName" name="pathName"  class="samll" />
									
								</div>
							</div>
								<div class="field field-first">
								<div class="label">
									<label for="input-small">
										生成内容:
									</label>
								</div>
								<div class="input">
									<input type="text"  id="otherPath" name="otherPath"  class="medium input_validation-failed" />
									
								</div>							
								
							</div>
							
							<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">										
										<input type="button" id="submit" name="submit" value="生成" />										
									</div>
								</div>
							</div>
						</div>
					</div>
						</div>
					</div>				

					
				</div>
				<!-- end table -->



			</div>
			<!-- end content / right -->
		</div>
		<!-- end content -->
		<!-- footer -->
		<%@include file="/jshop/admin/footer.jsp"%>
		<!-- end footert -->
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/creatQRcodejs.js"></script>




	</body>
</html>
