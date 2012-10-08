var session = "true";
$(function() {
	$('#salemanagement').flexigrid({
		url : 'findAllSalegoodsT.action',
		dataType : 'json', 
		cache : false,
		colModel : [{
			display : '拍卖商品名称',
			name : 'salegoodsname',
			width : '100',
			sortable : true,
			align : 'center'
		},{
			display:'商品编号',
				name:'salegoodsnumber',
				width:'90',
				sortable:true,
				align:'center'
		},{
			display:'拍卖商品状态',
			width:'80',
			name:'salegoodsstate',
			sortable:true,
			align:'center'
		},{
			display:'开始时间', 
				name:'begingtime',
				width:'100',
				sortable:true,
				align:'center'
		},
		{
			display:'结束时间',
				name:'endingtime',
				width:'100',
				sortable:true,
				align:'center'
		},{
			display:'拍卖者',
			name:'salepeople',
			width:'80',
			sortable:true,
			align:'center'
		},{
			display:'起拍价',
			name:'salestartingprice',
			width:'80',
			sortable:true,
			align:'center'
		},{
			display:'参拍人数',
			name:'salejoinpeople',
			width:'50',
			sortable:true,
			align:'center'
		},{
			display:'拍卖成交价',
			name:'saleprice',
			width:'50',
			sortable:true,
			align:'center'
			
		},{
			display:'图片路径',
			name:'salegoodspictureurl',
			width:'100',
			sortable:true,
			align:'center'
			
		}],searchitems : [ {
			display : '请选择搜索条件',
			name : 'sc',
			isdefault : true
		}, {
			display : '商品编号',
			name : ''
		} ],
			
		buttons:[{
			
			name : '添加',
			bclass : 'add',
			onpress : action
		}, {
			name:'编辑',
			bclass:'edit',
			onpress:action
		},{
			name : '删除',
			bclass : 'delete',
			onpress : action
		},{
			separator : true		 
		}],
		sortname:"begingtime",
		sortname:"endingtime",
		sortorder:"desc",
		userpager:true,
		title:'拍卖管理',
		userRp:true,
		rp:20,
		rpOptions:[5,20,40,100],
		showTableToggleBtn:true,
		showToggleBtn:true,
		width:'auto',
		height:'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',                                                                                                                                                                                                                                                                                                                                                              
		checkbox:true,
	});function action(com,grid){
		if(com=='添加'){
			window.location.href='addsalegoods.jsp?session='+session+"#goods";
			return;
		}else if(com=='编辑'){
			if($('.trSelected',grid).length==1){
				jConfirm('确定编辑此项吗？','信息提示',function(r){
					if(r){
					var str	=$('.trSelected',grid)[0].id.substr(3);
					window.location.href="editsalegoods.jsp?session="+session+"#goods&salegoodsid="+str;
					return;
					}
				});
			}else if($('.trSelected').length>1){
				jAlert('请不要选择多个','信息提示');
			}else {
				jAlert('请选择一条信息','信息提示');
				return false;
			}
		}else if(com=='删除'){
			if($('.trSelected',grid).length>0){
				jConfirm('确定删除吗？','信息提示',function(r){
					if(r){
						var str="";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("deletesalegoodsT.action",{"salegoodsid":str},function(data){
							if(data.flag){
								jAlert('删除成功','信息提示');
								$('#salemanagement').flexReload();
							}
						});
					}
				});
				return ;				
			}else{
				jAlert('请选择要删除的信息!', '信息提示');
				return false;
			}
		}
	}
});
