
$(function(){
	//获取url地址用来让用户登录时跳转
	var windowsurl=window.location;
	$('#hidurl').attr("value",windowsurl);
	
	$('#hidarea').html(windowsurl);

	//控制开发票是否显示和关闭
	$("#newmsg").toggle(
			function(){
				$('#msgarea').show();
				$('#msgarea1').show();
			},
			function(){
				$('#msgarea').hide();
				$('#msgarea1').hide();
			}
	)
	//发信息
	$("#btn_reportSpam").click(function(){
		$('#inbox').hide();
		$('#write').show();
		$('#text1').hide();
	});
	//收件箱
	$("#setAllReaded").click(function(){
		
		$('#inbox').show();
		$('#write').hide();
		$('#text1').hide();
		window.location.href="findAllWebsiteMsgByToUsername.action";
	});
	//详细信息
	$("#title").click(function(){	
		
		var msgtextid = $('#mailid').val();
		$.post("findMsgtextById.action",{"msgtextid":msgtextid},function(data){
			$('#webtitle').attr("value",data.webbean.title);
			$('#msgfromusrname').attr("value",data.webbean.msgfromusrname);
			$('#createtime').attr("value",data.webbean.createtime);
			$('#msgtousername').attr("value",data.webbean.msgtousername);
			$('#msgtext').attr("value",data.msgbean.text);
		});
		$('#text1').show();
		$('#inbox').hide();
		$('#write').hide();
				
	});
	
	$('#add').click(function(){
		var title=$('#title').val();
		var msgToUsername=$('#addressee').val();
		var text=$('#detail').val();
		if(title==""||msgToUsername==""||text==""){
			alert("信息未写完整");
				return;
		}
		$.post("addWebsiteMsgT.action",{"title":title,"msgToUsername":msgToUsername,"text":text},function(data){
			if(data.slogin){
				if(data.sflag){
					$('#msginfo').text('发送信件成功');
					alert("提交成功");
					window.location.href="InitUserCenterIndex.action";
				}
			}else{
				//跳转到登录页面
				window.location.href="/usercenter/login.jsp?redirecturl="+hidurl;
			}
		});
	});
	//删除站内信
	$('#quick_del').click(function(){

		var msgid="";
		$('input[name="mailid"]:checked').each(function(){
			msgid +=$(this).val()+",";
		});
		$.post("DelWebsiteMsgT.action",{"msgid":msgid});
		window.location.href="findAllWebsiteMsgByToUsername.action";
	});
	//更新为未读
	$('#markasunread').click(function(){

		var msgid="";
		$('input[name="mailid"]:checked').each(function(){
			msgid +=$(this).val()+",";
		});
		$.post("updateStateToZero.action",{"msgid":msgid});
		window.location.href="findAllWebsiteMsgByToUsername.action";
	});
	//更新为已读
	$('#markasread').click(function(){

		var msgid="";
		$('input[name="mailid"]:checked').each(function(){
			msgid +=$(this).val()+",";
		});
		$.post("updateStateToOne.action",{"msgid":msgid});
		window.location.href="findAllWebsiteMsgByToUsername.action";
	});
	
	
});
function onc(){
	
}


