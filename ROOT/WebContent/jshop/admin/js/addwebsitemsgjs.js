var f=false;
var session=true;
function validate(){
	var  title= $('#title').val();
	var msgtousername=$('#msgtousername').val();
	var msgstate=$('#msgstate').val();
	var text = $('#text').val();
	if(title==""){
		jAlert("标题不能为空","信息提示");
		return false;
	}
	if(msgtousername==""){
		jAlert("收件人不能为空","信息提示");
		return  false;
	}
	if(text==""){
		jAlert("内容不能为空","信息提示");
		return false;
	}
	return f=true;
}
$(function(){
	$('#add').click(function(){
		validate();
		if(f){
			var  title= $('#title').val();
			var msgtousername=$('#msgtousername').val();
			var msgstate=$("input[name='msgstate']:checked").val();
			var text = $('#text').val();
			$.post("addWebsiteMsg.action",{"title":title,"msgtousername":msgtousername,"msgstate":msgstate,"text":text},function(data){
				if(data.flag){
					jAlert("添加成功","信息提示");
					window.location.href = "websitemsgmenagement.jsp?session="+session+"#pagecontent";
					return ;
				}
			});
		}
		
	});
	var eid =$.query.get('eid');
	if(eid==null) return false;
	$.post("findEcoupontById.action",{"eid":eid},function(data){
		 if("3"==data.bean.ecouponstate){
			 var text="尊敬的用户，您好！恭喜您！获得了现金抵扣券。现在您只要在"+data.bean.begintime+"到"+data.bean.endtime+"之间消费满"+data.bean.favourableprices+"就可以抵扣"+data.bean.pricededuction+"";
		 }
		 if("2"==data.bean.ecouponstate){
			 var text="尊敬的用户，您好！恭喜您！获得了现金购物券。现在您只要在"+data.bean.begintime+"到"+data.bean.endtime+"之间只要以"+data.bean.favourableprices+"就可以购得"+data.bean.goodsname+"物品";
		 }
		 if("1"==data.bean.ecouponstate){
			 var text="尊敬的用户，您好！恭喜您！获得了购物抵扣券。现在您只要在"+data.bean.begintime+"到"+data.bean.endtime+"之间购"+data.bean.goodsname+"物品就可以抵扣"+data.bean.favourableprices+"";
		 }
		
		KE.html("text",text);
		});
	
});