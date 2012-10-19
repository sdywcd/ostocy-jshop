$('#submit').click(function(){
	var otherPath= $('#otherPath').val();
	var pathName=$('#pathName').val();
	if(""==otherPath){
		jAlert("内容不能为空","信息提示");
		return ;
	}
	if(""==pathName){
		jAlert("名称不能为空","信息提示");
		return ;
	}
	$.post("encoderQRcode.action",{"otherPath":otherPath,"pathName":pathName},function(data){
		if(data.flag){
			jAlert("生成成功","信息提示");
			window.location.href="QRcode.jsp";
			return ;
		}
	});
});