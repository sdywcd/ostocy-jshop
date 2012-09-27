var session=true;
var flag=false;
function validatesalegoods(){
	var salegoodsname=$('#salegoodsname').val();
	var salegoodsnumber=$('#salegoodsnumber').val();
	var salegoodsstate= $("input[name='salegoodsstate']:checked").val();
	var begingtime=$('#begingtime').val();	
	var endingtime=$('#endingtime').val();
	var salepeople=$('#salepeople').val();
	var salejoinpeople=$('#salejoinpeople').val();
	var salestartingprice=$('#salestartingprice').val();
	var salegoodsinformation=$('#salegoodsinformation').val();
	var salegoodspictureurl="";
	$(":checkbox[name='pcpath'][checked=true]").each(function(){
		salegoodspictureurl+=this.value+",";
});
	if(""==salegoodsname){
		jAlert('拍卖商品名称不能为空','信息提示');
		return false;
	}
	if(""==salegoodsnumber){
		jAlert('拍卖商品编号不能为空','信息提示');
		return false;
	}
	if(""==begingtime){
		jAlert('开始时间不能为空','信息提示');
		return false;
	}
	if(""==endingtime){
		jAlert('结束时间不能为空','信息提示');
		return false;
	}
	
	if(""==salepeople){
		jAlert('拍卖者或管理员不能为空','信息提示');
		return false;
	}
	if(""==salejoinpeople){
		jAlert('参加拍卖设置最大人数不能为空','信息提示');
		return false;
	}
	if(""==salestartingprice){
		jAlert('起拍价不能为空','信息提示');
		return false;
	}
	return flag = true;
}


$(function(){
	$('#add').click(function(){
		validatesalegoods();
		$('#add').show();
		$('#update').hide();
		if(flag){
			var salegoodsname=$('#salegoodsname').val();
			var salegoodsnumber=$('#salegoodsnumber').val();		
			var salegoodsstate= $("input[name='salegoodsstate']:checked").val();
			var begingtime=$('#begingtime').val();	
			var endingtime=$('#endingtime').val();
			var salepeople=$('#salepeople').val();
			var salejoinpeople=$('#salejoinpeople').val();
			var salestartingprice=$('#salestartingprice').val();
			var salegoodsinformation=$('#salegoodsinformation').val();
			var salegoodspictureurl="";
			$(":checkbox[name='pcpath'][checked=true]").each(function(){
				salegoodspictureurl+=this.value+",";
		});
			/*var regFlag=$(this.regme([{
				regid : "salegoodsname",
				type : "value",
				textvalue : salegoodsname,
				refillname : '限购数量',
				regular : 'EnChNum',
				onSuccess : true,
 			}]));if(!regFlag){
				return false;
			}*/
		
	/*	//正则验证
		var regFlag = $(this).regme([{
			regid : "salegoodsname",
			type : "text",
			textvalue : salegoodsname,
			regular : "EnChNum_",
			refillname:"拍卖商品名称",
			onSuccess : true,			
			codelimit : 100			
		},
		{
			regid : "salegoodsnumber",
			type : "text",
			textvalue : salegoodsnumber,
			regular : "EnChNum_",
			refillname:"拍卖商品名编号",
			onSuccess : true,			
			codelimit : 100			
		},{
			regid : "salestartingprice",
			type : "value",
			textvalue : sendpoint,
			regular : 'floatordouble',
			refillname : '起拍价',
			onSuccess : true,
		},{
			regid : "cashlimit",
			type : "value",
			textvalue : cashlimit,
			regular : 'nosigninteger',
			refillname : '保证金额度 ',
			onSuccess : true,
		},{
			regid : "groupprice",
			type : "compare",
			textvalue : groupprice,
			uplimit : memberprice,
			refillname : '团购价',
			onSuccess : true,
			upregion : false,
		},{
			regid : "salequantity",
			type : "value",
			textvalue : salequantity,
			refillname : '可售数量',
			regular : 'nosigninteger',
			onSuccess : true,
		},{
			regid : "limitbuy",
			type : "value",
			textvalue : limitbuy,
			refillname : '限购数量',
			regular : 'nosigninteger',
			onSuccess : true,
		}
		]);
		if(!regFlag){
			return false;	}*/
			
		$.post("addSalegoodsT.action",{"salegoodsname":salegoodsname,"salegoodsnumber":salegoodsnumber,"salegoodspictureurl":salegoodspictureurl,"salegoodsinformation":salegoodsinformation,"salegoodsstate":salegoodsstate,"begingtime":begingtime,"endingtime":endingtime,"salepeople":salepeople,"salestartingprice":salestartingprice,"salejoinpeople":salejoinpeople},function(data){
			if(data.salegoods){
				jAlert('添加成功','信息提示');
				window.location.href='salemanagement.jsp?session'+session+"#goods";
			}else{
				jAlert('添加失败','信息提示');
				return false;
			}
		});
		}else{ return false;}
	});
	
});


$(function(){	
	var salegoodsid=$.query.get('salegoodsid');
	if(salegoodsid==null){
		return false;		
	}
	$.post("findAllSalegoodsById.action",{"salegoodsid":salegoodsid},function(data){
		$('#salegoodsname').attr("value",data.salelist.salegoodsname);
		$('#salegoodsnumber').attr("value",data.salelist.salegoodsnumber);
		if("1"==data.salelist.salegoodsstate){
			$('#salegoodsstate').attr("checked","checked");
		}else{
			$('#salegoodsstate').attr("checked","");
		}
	//	$('#salegoodsstate').attr("value",data.salelist.salegoodsstate);
		$('#begingtime').attr("value",data.salelist.begingtime);
		$('#endingtime').attr("value",data.salelist.endingtime);
		$('#salejoinpeople').attr("value",data.salelist.salejoinpeople);
		$('#salestartingprice').attr("value",data.salelist.salestartingprice);
		$('#salepeople').attr("value",data.salelist.salepeople);
		KE.html("salegoodsinformation",data.salelist.salegoodsinformation);
	  //$('#salegoodspictureurl').attr("value",data.salelist.salelistsalelist);
		
		//图片显示		
		var pcurl=data.salelist.salegoodspictureurl;
		
		$('#triggers').html("<img src='"+pcurl+"'/>");
		$('#update').show();
	
		return;			
	});
	$('#update').click(function(){
		validatesalegoods();
		/*$('#update').show();
		$('#add').hide();*/
			if(flag){
				var salegoodsid=$.query.get('salegoodsid');
				var salegoodsname=$('#salegoodsname').val();
				var salegoodsnumber=$('#salegoodsnumber').val();		
				var salegoodsstate= $("input[name='salegoodsstate']:checked").val();
				var begingtime=$('#begingtime').val();	
				var endingtime=$('#endingtime').val();
				var salepeople=$('#salepeople').val();
				var salejoinpeople=$('#salejoinpeople').val();
				var salestartingprice=$('#salestartingprice').val();
				var salegoodsinformation=$('#salegoodsinformation').val();
				/*KE.html("salegoodsinformation",data.salelist.salegoodsinformation);*/
				var salegoodspictureurl="";
				$(":checkbox[name='pcpath'][checked=true]").each(function(){
					salegoodspictureurl=this.value;
			});
			/*var regFlag = $(this).regme([{
				regid : "goodsname",
				type : "text",
				textvalue : goodsname,
				regular : "EnChNum_",
				refillname:"商品名称",
				onSuccess : true,			
				codelimit : 100			
			},{
				regid : "sendpoint",
				type : "value",
				textvalue : sendpoint,
				regular : 'floatordouble',
				refillname : '商品积分',
				onSuccess : true,
			},{
				regid : "cashlimit",
				type : "value",
				textvalue : cashlimit,
				regular : 'nosigninteger',
				refillname : '保证金额度 ',
				onSuccess : true,
			},{
				regid : "groupprice",
				type : "compare",
				textvalue : groupprice,
				uplimit : memberprice,
				refillname : '团购价',
				onSuccess : true,
				upregion : false,
			},{
				regid : "salequantity",
				type : "value",
				textvalue : salequantity,
				refillname : '可售数量',
				regular : 'nosigninteger',
				onSuccess : true,
			},{
				regid : "limitbuy",
				type : "value",
				textvalue : limitbuy,
				refillname : '限购数量',
				regular : 'nosigninteger',
				onSuccess : true,
			}
			]);
			if(!regFlag){
				return false;
			}*/
				$.post("updatesalegoodsT.action",{"salegoodsid":salegoodsid,"salegoodsname":salegoodsname,"salegoodsnumber":salegoodsnumber,"salegoodspictureurl":salegoodspictureurl,"salegoodsinformation":salegoodsinformation,"salegoodsstate":salegoodsstate,"begingtime":begingtime,"endingtime":endingtime,"salepeople":salepeople,"salestartingprice":salestartingprice,"salejoinpeople":salejoinpeople},function(data){
					if(data.salegoods){
						jAlert('修改成功','信息提示');
						window.location.href='salemanagement.jsp?session'+session+"#goods";
					}else{
						jAlert('修改失败','信息提示');
						return false;
					}
				});
				}else{ return false;}
			});
			
		});
//获取图片删除按钮并删除图片
$(function(){
	$("#delpc").click(function(){
		var str="";
		var sum=0;
		$(":checkbox[name='pcpath'][checked=true]").each(function(){
			sum++;
			str=this.value;
		});
		if(sum==0){
			jAlert('只有在选择图片后才能删除', '信息提示');
			return false;
		}
		if(sum>1){
			jAlert('不能选择多个图片', '信息提示');
			return false;
		}
		$('#triggers img').each(function(){
			if(this.id==str){
				this.style.display="none";
				$(":checkbox[name='pcpath'][checked=true]").each(function(){
					if(this.value==str){
						this.style.display="none";
						this.name="dispcpath";
					}
				});
			}
		});  

	});
});