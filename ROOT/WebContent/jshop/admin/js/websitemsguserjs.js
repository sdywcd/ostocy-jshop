$(function() {
	$("#websitemembermanagement").flexigrid( {
		url : 'findAllUsert.action',
		dataType : 'json',
		cache : false,
		colModel : [ { 
			display:'用户名',
			name:'username',
			width:150,
			sortable:true,
			align:'center'
		},{ 
			display:'真名',
			name:'realname',
			width:120,
			sortable:true,
			align:'center'
		},{ 
			display:'邮箱',
			name:'email',
			width:150,
			sortable:true,
			align:'center'
		},{ 
			display:'性别',
			name:'sex',
			width:80,
			sortable:true,
			align:'center'
		},{ 
			display:'累计积分',
			name:'points',
			width:150,
			sortable:true,
			align:'center'
		}],
		buttons : [ 
		 {
			name : '确定',
			bclass : 'edit',
			onpress : action
		},{
			separator : true
		} ],

		searchitems : [{
			display:'请选择搜索条件',
			name:'sc',
			isdefault : true
		}, {
			display : '用户名',
			name : 'username'
		} ],
		sortname : "gradetime",
		sortorder : "desc",
		usepager : true,
		title : '会员列表',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		width :'auto',
		height : 'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox:true
	});
	function action(com, grid){
		if(com=="确定"){
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定选择此用户吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						$.post("findUserById.action",{"userid":str},function(data){
							$('#msgtousername').attr("value",data.beanlist.username);
							return;
						});		
					}
				});
			}
			}
		}
	
});