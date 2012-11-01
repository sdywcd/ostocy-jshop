var session="true";
var flag=false;
//验证商品传递的参数
function  validatethenpostinfotoaddoutsidegoods(){
	var navid=$('#navid').val();
	var nname=$('#navid').find("option:selected").text();
	var ltypeid=$('#ltypeid').val();
	var lname=$('#ltypeid').find("option:selected").text();
	var stypeid=$('#stypeid').val();
	var sname=$('#stypeid').find("option:selected").text();
	var goodsname=$('#goodsname').val();
	var salestate=$("input[name='salestate']:checked").val();
	var linkUrl=$('#linkUrl').val();
	var sort=$('#sort').val();
	var version=$('#version').val();
	//获取商品图片路径集合
	var pictureurl="";
	$(":checkbox[name='pcpath'][checked=true]").each(function(){
		pictureurl=this.value;
	});
	if("0"==navid&&"0"==ltypeid&&"0"==stypeid){
		jAlert('商品所属分类必须选择', '信息提示');
		return false;
	}
	if(""==goodsname){
		jAlert('商品名称不能为空', '信息提示');
		return false;
	}
	if(""==salestate){
		jAlert('状态不能为空', '信息提示');
		return false;
	}
	if(""==linkUrl){
		jAlert('地址不能为空', '信息提示');
		return false;
	}
	if(""==sort){
		jAlert('排序不能为空', '信息提示');
		return false;
	}
	if(""==version){
		jAlert('版本号不能为空', '信息提示');
		return false;
	}
	flag=true;
}

$(function(){
$('#add').click(function(){
	validatethenpostinfotoaddoutsidegoods();
	if(flag){
		var navid=$('#navid').val();
		var nname=$('#navid').find("option:selected").text();
		var ltypeid=$('#ltypeid').val();
		var lname=$('#ltypeid').find("option:selected").text();
		var stypeid=$('#stypeid').val();
		var sname=$('#stypeid').find("option:selected").text();
		if(stypeid==null){
			stypeid=0;
			sname="";
		}
		if(ltypeid==null){
			ltypeid=0;
			lname="";
		}
		if(navid==null){
			navid=0;
			nname="";
		}
		var goodsname=$('#goodsname').val();
		var salestate=$("input[name='salestate']:checked").val();
		var linkUrl=$('#linkUrl').val();
		var sort=$('#sort').val();
		var version=$('#version').val();
		//获取商品图片路径集合
		var pictureurl="";
		$(":checkbox[name='pcpath'][checked=true]").each(function(){
			pictureurl=this.value;
		});
		$.post("addOutsideGoods.action",{"pictureurl":pictureurl,"navid":navid,"nname":nname,"ltypeid":ltypeid,"lname":lname,"stypeid":stypeid,"sname":sname,"goodsname":goodsname,"salestate":salestate,"linkUrl":linkUrl,"sort":sort,"version":version},function(data){
			if(data.flag){
				jAlert("增加成功","信息提示");
				window.location.href='outsidegoodsmanagement.jsp?session='+session+"#goods";
			}
		});
	}
});
});
$(function(){
	var id=$.query.get('id');
	if(id==null){
		return false;
	}
	$.post("findOutsideGoodsByid.action",{"id":id},function(data){
		$('#id').attr("value",data.outside.id);
		$('#navid').attr("value",data.outside.navid);
		if(data.outside.ltypeid!=0){
			$('#ltypeid').append("<option value='"+data.outside.ltypeid+"'>"+data.outside.lname+"</option>");
			
		}
		if(data.outside.stypeid!=0){
			$('#stypeid').append("<option value='"+data.outside.stypeid+"'>"+data.outside.sname+"</option>");
		}
		$('#stypeid').attr("value",data.outside.stypeid);
		$('#goodsname').attr("value",data.outside.goodsname);
		$('#linkUrl').attr("value",data.outside.linkUrl);
		$('#sort').attr("value",data.outside.sort);
		$('#versiont').attr("value",data.outside.versiont);
		if("1"==data.outside.salestate){
			$('#salestate').attr("checked","checked");
		}else{
			$('#salestate').attr("checked","");
		}
//		var pcurl=data.outside.pictureurl;
//		$('#triggers').html("<img src='"+pcurl+"'>");
		//图片显示
		var pcpath="";
		var pcurl=data.outside.pictureurl;
		var htm="";
		var checkpc="";
		var temp=pcurl.split(',');
		var allpcpath="";
		$.each(temp,function(n,value){
			if(""==value){
				return;
			}
			pcpath=value;
			htm="<img id='"+value+"' src='"+pcpath+"'></img>";
			checkpc="<input id='"+value+"' name='pcpath' type='checkbox' value='"+value+"' checked/>";
			allpcpath=htm+checkpc;
			$('#triggers').append(allpcpath);
		});
		$('#update').show();
		$('#add').hide();
		return;
	});
	$('#update').click(function(){

		validatethenpostinfotoaddoutsidegoods();
		if(flag){
			var navid=$('#navid').val();
			var nname=$('#navid').find("option:selected").text();
			var ltypeid=$('#ltypeid').val();
			var lname=$('#ltypeid').find("option:selected").text();
			var stypeid=$('#stypeid').val();
			var sname=$('#stypeid').find("option:selected").text();
			if(stypeid==null){
				stypeid=0;
				sname="";
			}
			if(ltypeid==null){
				ltypeid=0;
				lname="";
			}
			if(navid==null){
				navid=0;
				nname="";
			}
			var goodsname=$('#goodsname').val();
			var salestate=$("input[name='salestate']:checked").val();
			var linkUrl=$('#linkUrl').val();
			var sort=$('#sort').val();
			var versiont=$('#versiont').val();
			var id=$('#id').val();
			//获取商品图片路径集合
			var pictureurl="";
			$(":checkbox[name='pcpath'][checked=true]").each(function(){
				pictureurl=this.value;
			});
			$.post("updateOutsidegoods.action",{"id":id,"pictureurl":pictureurl,"navid":navid,"nname":nname,"ltypeid":ltypeid,"lname":lname,"stypeid":stypeid,"sname":sname,"goodsname":goodsname,"salestate":salestate,"linkUrl":linkUrl,"sort":sort,"versiont":versiont},function(data){
				if(data.flag){
					jAlert("修改成功","信息提示");
					window.location.href='outsidegoodsmanagement.jsp?session='+session+"#goods";
					return ;
				}else{
					jAlert("修改失败","信息提示");
					window.location.href='outsidegoodsmanagement.jsp?session='+session+"#goods";
					return ;
				}
			});
		}

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









//获取商品导航菜单
$(function(){
	$.post("findGoodscategoryNavid.action",function(data){
		$("#navid").append(data.navidlist);
		//向关联商品tab中注入商品导航
		$("#navidbelinked").append(data.navidlist);
		return;
	});
	
});
//获取商品二级菜单
$(function(){
	$("#navid").change(function(){
		var parentId=$("#navid").val();
		if("0"==parentId){
			return;
		}
		$.post("findGoodscategoryLtypeid.action",{"parentId":parentId},function(data){
			$("#ltypeid option").remove();
			if(data.ltypeidlist==""){
				$("#ltypeid").hide();
			}else{
				$("#ltypeid").append(data.ltypeidlist); 
				$("#ltypeid").show();
			}
		});
	});
	//向关联商品tab中注入商品二级菜单
	$("#navidbelinked").change(function(){
		var parentId=$("#navidbelinked").val();
		if("0"==parentId){
			return;
		}
		$.post("findGoodscategoryLtypeid.action",{"parentId":parentId},function(data){
			$("#ltypeidbelinked option").remove();
			if(data.ltypeidlist==""){
				$("#ltypeidbelinked").hide();
			}else{
				$("#ltypeidbelinked").append(data.ltypeidlist); 
				$("#ltypeidbelinked").show();
			}
		});
	});
	
	
});
//获取商品三级菜单
$(function(){
	$("#ltypeid").change(function(){
		var parentId=$("#ltypeid").val();
		if("0"==parentId){
			return;
		}
		$.post("findGoodscategoryStypeid.action",{"parentId":parentId},function(data){
			$("#stypeid option").remove();
			if(data.stypeidlist==""){
				$("#stypeid").hide();
			}else{
				$("#stypeid").append(data.stypeidlist);
				$("#stypeid").show();
			}
			
		});
	});
	//向关联商品tab中注入商品二级菜单
	$("#ltypeidbelinked").change(function(){
		var parentId=$("#ltypeid").val();
		if("0"==parentId){
			return;
		}
		$.post("findGoodscategoryStypeid.action",{"parentId":parentId},function(data){
			$("#stypeidbelinked option").remove();
			if(data.stypeidlist==""){
				$("#stypeidbelinked").hide();
			}else{
				$("#stypeidbelinked").append(data.stypeidlist);
				$("#stypeidbelinked").show();
			}
			
		});
	});
});