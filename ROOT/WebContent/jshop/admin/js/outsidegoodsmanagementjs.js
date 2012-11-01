var session =true;
/**
 * flexigrid list
 */
$(function() {

	$("#outsidegoodsmanagement").flexigrid( {
		url : 'findAllOutsideGoods.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '商品名称	',
			name : 'goodsname',
			width : 120,
			sortable : true,
			align : 'center'
		}, {
			display : '创建者',
			name : 'creatorid',
			width : 120,
			sortable : true,
			align : 'center'
		}, {
			display : '链接地址',
			name : 'linkUrl',
			width : 120,
			sortable : true,
			align : 'center'
		}, {
			display : '上架状态',
			name : 'salestate',
			width : 120,
			sortable : true,
			align : 'center'

		}, {
			display : '图片地址',
			name : 'pictureurl',
			width : 120,
			sortable : true,
			align : 'center'
		} , {
			display : '创建时间',
			name : 'createtime',
			width : 120,
			sortable : true,
			align : 'center'
		} , {
			display : '修改时间',
			name : 'updatetime',
			width : 120,
			sortable : true,
			align : 'center'
		} ],
		buttons : [ {
            name : '添加',
            bclass : 'add',
            onpress : action
        }, {
			name : '编辑',
			bclass : 'edit',
			onpress : action
		}, {
            name : '删除',
            bclass : 'delete',
            onpress : action
        }, {
            name : '生成二维码',
            bclass : 'add',
            onpress : action
        }, {
			separator : true
		} ],

		searchitems : [ {
			display : '请选择搜索条件',
			name : 'sc',
			isdefault : true
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '外链商品列表',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		width : 'auto',
		height : 'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox : true
	});

	function action(com, grid) {
		if (com == '编辑') {
			if ($('.trSelected', grid).length ==1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str =$('.trSelected', grid)[0].id.substr(3);
						$.post("findOutsideGoodsByid.action",{"id":str},function(data){
							if(data.flag){
								window.location.href="addoutsidegoods.jsp?session="+session+"#goods&id="+str;
								return ;
							}else{
								jAlert("获取数据失败","信息提示");
								return;
							}
						});						
					}
				});
				return;
			} else {
				jAlert('请选择一条信息', '信息提示');
                return false;
			}

		}else if(com=="添加"){
            window.location.href="addoutsidegoods.jsp?session="+session+"#goods";
            return;
        }else if(com=="删除"){
            if ($('.trSelected', grid).length > 0) {
                jConfirm('确定删除此项吗?', '信息提示', function(r) {
                    if (r) {
                        var str = "";
                        $('.trSelected', grid).each(function() {
                            str += this.id.substr(3) + ",";
                        });
                        $.post("delOutsidegoods.action", { "id" : str }, function(data) {
                        	if(data.flag){
                        	jAlert("删除成功","信息提示");
                            $('#outsidegoodsmanagement').flexReload();
                            return ;
                        	}else{
                        		jAlert("删除失败","信息提示");
                                $('#outsidegoodsmanagement').flexReload();
                                return ;
                        	}
                        });
                    }
                });
                return;
            } else {
                jAlert('请选择要删除的信息!', '信息提示');
                return false;
            }
        }else if(com=='生成二维码'){

			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定生成此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						$.post("encoderOutsideQRcode.action",{"id":str},function(data){
							if(data.flag){
								jAlert("二维码生成成功","信息提示");
								return;
							}else{
								jAlert("二维码生成失败","信息提示");
								return;
							}
						});
						return;
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		
//			window.location.href = 'QRcode.jsp?session='+session+"#goods";
//			return;
		}
	}
});