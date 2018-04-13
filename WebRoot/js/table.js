$(function(){
	//根据窗口调整表格高度
    $(window).resize(function() {
        $('#mytab').bootstrapTable('resetView', {
            height: tableHeight()
        })
    })
    //生成用户数据
    var $table = $('#mytab').bootstrapTable({
    	method: 'post',
    	dataType: "json",
    	contentType: "application/x-www-form-urlencoded;charset=utf-8",
    	url:"searchAll",
    	height:tableHeight(),//高度调整
    	toolbar: '#toolbar',
    	cache: false, 	//是否缓存
    	striped: true, //是否显示行间隔色
    	pageNumber: 1, //初始化加载第一页，默认第一页
    	pagination:true,//是否分页
    	queryParamsType:'limit',
    	queryParams:queryParams,
    	sidePagination:'server',
    	pageSize:10,//单页记录数
    	pageList:[5,10,20,30],//分页步进值ֵ
    	showRefresh:true,//刷新按钮
    	showColumns:true,
    	clickToSelect: true,//是否启用点击选中行
    	toolbarAlign:'right',
    	buttonsAlign:'right',//按钮对齐方式
    	toolbar:'#toolbar',//指定工作栏
    	sortName: 'bc',        // 设置默认排序为 bc
        sortOrder: "asc",      //排序方式
    	columns:[
        	{
        		title:'全选',
        		field:'select',
        		checkbox:true,
        		width:25,
        		align:'center',
        		valign:'middle'
        	},
        	{
        		title:'条形码',
        		field:'bc',
        		visible:false
        	},
        	{
        		title:'书号',
        		field:'bn',
        		sortable:true
        	},
        	{
        		title:'书名',
        		field:'title',
        		sortable:true
        	},
        	{
        		title:'作者',
        		field:'author'
        	},
        	{
        		title:'价格',
        		field:'price',
        		sortable: true
        	},
        	{
        		title:'入库时间',
        		field:'wst'
        	},
        	{
        		title:'房号',
        		field:'roomNo'
        	},
        	{
        		title:'借阅状态',
        		field:'state'
        	}
    	],
    	locale:'zh-CN',//中文支持
    	onLoadSuccess: function (data) { //加载成功时执行
    		//增加表单字段验证
    		 $('#addForm').bootstrapValidator({
 		       	feedbackIcons: {
 		               valid: 'glyphicon glyphicon-ok',
 		               invalid: 'glyphicon glyphicon-remove',
 		               validating: 'glyphicon glyphicon-refresh'
 		           },
 		           fields: {
 		        	   "book.bn": {
 		        		  validators: {
		                       notEmpty: {
		                           message: '书号不能为空'
		                       },
		                       stringLength:{
	 		               			min:5,
	 		               			max:10,
	 		               			message:'书号为5-10位'
	 		               		}
 		        		  }
 		        	   },
 		        	   "book.title": {
 		                   validators: {
 		                       notEmpty: {
 		                           message: '书名不能为空'
 		                       }
 		                   }
 		        	   },
 		        	   "book.author": {
 		        		  validators: {
		                       notEmpty: {
		                           message: '作者不能为空'
		                       }
 		        		  }
 		        	   },
 		        	   "book.price": {
 		        		  validators: {
		                       notEmpty: {
		                           message: '价格不能为空'
		                       }
 		        		  }
 		        	   },
 		        	   "book.roomNo": {
 		        		  validators: {
		                       notEmpty: {
		                           message: '房间号不能为空'
		                       },
		                       stringLength:{
		                    	    min:3,
	 		               			max:3,
	 		               			message:'房间号只能为3位'
		                       }
 		        		  }
 		        	   }
// 		               Tel: {
// 		                   validators: {
// 		                       notEmpty: {
// 		                           message: '�ֻ�Ų���Ϊ��'
// 		                       },
// 		                       stringLength: {
// 		                           min: 11,
// 		                           max: 11,
// 		                           message: '�ֻ�ű���Ϊ11λ'
// 		                       },
// 		                       regexp: {
// 		                           regexp: /^1(3|4|5|7|8)\d{9}$/,
// 		                           message: '����д��ȷ���ֻ��'
// 		                       }
// 		                   }
// 		               }
 		           }
 		     });
    		 $('#editForm').bootstrapValidator({
 		       	feedbackIcons: {
 		               valid: 'glyphicon glyphicon-ok',
 		               invalid: 'glyphicon glyphicon-remove',
 		               validating: 'glyphicon glyphicon-refresh'
 		           },
 		           fields: {
 		        	   "book.bn":{
 		        		   validators:{
 		        			   notEmpty: {
 		                           message: '书号不能为空'
 		                       } 
 		        		   }
 		        	   },
 		               "book.title": {
 		                   validators: {
 		                       notEmpty: {
 		                           message: '书名不能为空'
 		                       }
 		                   }
 		               },
 		              "book.author": {
 		        		  validators: {
		                       notEmpty: {
		                           message: '作者不能为空'
		                       }
 		        		  }
 		        	   },
 		        	   "book.price": {
 		        		  validators: {
		                       notEmpty: {
		                           message: '价格不能为空'
		                       }
 		        		  }
 		        	   },
 		        	   "book.state": {
 		        		   validators: {
 		        			  notEmpty: {
		                           message: '借阅状态不能为空'
		                       }  
 		        		   }
 		        	   }
 		           }
 		       });
//            console.log(data);
        }
    })
    /*
     * 用户管理首页事件
     */
    //请求后台数据获取角色列表
//    var roleArr=[];
//    $.get('show',function(data){
////	  if(data.suc && data.res){
//    	if(data){
//		  for(var i=0;i<data.res.length;i++){
//			  var obj=new Object();
//			  obj.ID=data.res[i].ID;
//			  obj.Name=data.res[i].Name;
//			  roleArr[i]=obj;
//		  }
		//生成增加与修改页面的角色复选框
//		  var _roleHtml='';
//		  for(var i=0;i<roleArr.length;i++){
//			  _roleHtml+='<label><input type="checkbox" name="RoleID[]"   value="'+roleArr[i].ID+'"/> '+roleArr[i].Name+' </label>';
//		  }
//		  $('.role').html(_roleHtml);
//		  $('.role input').eq(0).attr('checked','true');
		//请求成功后生成增加用户页面表单内容
//		  $('#addForm').bootstrapValidator({
//		       	feedbackIcons: {
//		               valid: 'glyphicon glyphicon-ok',
//		               invalid: 'glyphicon glyphicon-remove',
//		               validating: 'glyphicon glyphicon-refresh'
//		           },
//		           fields: {
//		        	   name: {
//		                   validators: {
//		                       notEmpty: {
//		                           message: '姓名不能为空'
//		                       },
//		               		stringLength:{
//		               			min:2,
//		               			max:10,
//		               			message:'姓名为2-10位'
//		               		}
//		                   }
//		               },
//		               psw:{
//		               	validators:{
//		               		notEmpty:{
//		               			message:'密码不能为空'
//		               		},
//		                       stringLength:{
//		                       	min:6,
//		                       	max:128,
//		                       	message:'密码为6-128位'
//		                       }
//		               	}
//		               }
////		               },
////		               Tel: {
////		                   validators: {
////		                       notEmpty: {
////		                           message: '�ֻ�Ų���Ϊ��'
////		                       },
////		                       stringLength: {
////		                           min: 11,
////		                           max: 11,
////		                           message: '�ֻ�ű���Ϊ11λ'
////		                       },
////		                       regexp: {
////		                           regexp: /^1(3|4|5|7|8)\d{9}$/,
////		                           message: '����д��ȷ���ֻ��'
////		                       }
////		                   }
////		               }
//		           }
//		     });	
//		    $('#editForm').bootstrapValidator({
//		       	feedbackIcons: {
//		               valid: 'glyphicon glyphicon-ok',
//		               invalid: 'glyphicon glyphicon-remove',
//		               validating: 'glyphicon glyphicon-refresh'
//		           },
//		           fields: {
//		        	   ID:{
//		        		   validators:{
//		        			   notEmpty: {
//		                           message: 'ID不能为空'
//		                       } 
//		        		   }
//		        	   },
//		               LoginName: {
//		                   validators: {
//		                       notEmpty: {
//		                           message: '登录名不能为空'
//		                       }
//		                   }
//		               }
////		               },
////		               Name: {
////		                   validators: {
////		                       notEmpty: {
////		                           message: '������Ϊ��'
////		                       },
////		               		stringLength:{
////		               			min:2,
////		               			max:10,
////		               			message:'����Ϊ2-10λ'
////		               		}
////		                   }
////		               }
////		               Tel: {
////		                   validators: {
////		                       notEmpty: {
////		                           message: '�ֻ�Ų���Ϊ��'
////		                       },
////		                       stringLength: {
////		                           min: 11,
////		                           max: 11,
////		                           message: '�ֻ�ű���Ϊ11λ'
////		                       },
////		                       regexp: {
////		                           regexp: /^1(3|4|5|7|8)\d{9}$/,
////		                           message: '����д��ȷ���ֻ��'
////		                       }
////		                   }
////		               }
//		           }
//		       });
//	  }else{
//		  console.log('后台角色列表获取失败');
//	  }
//   });
    //请求服务数据时所传参数
    function queryParams(params){
    	return{
    		pageSize: params.limit,
    		pageIndex:params.pageNumber,
    		searchItem:$("#select_id").find("option:selected").text(),
    		searchValue:$('#searchValue').val(),	//传递搜索条件参数
    		sortName:params.sort,				//排序字段
            sortOrder:params.order				// 排序方式
    	}
    }
  //查询按钮事件
    $('#search_btn').click(function(){
    	$('#mytab').bootstrapTable('refresh', {url: 'searchByOption'});
    })
    
    //增加按钮事件
    $('#btn_add').click(function(){
		$('.tableBody').addClass('animated slideOutLeft');
		setTimeout(function(){
			$('.tableBody').removeClass('animated slideOutLeft').css('display','none');
		},500)
		$('.addBody').css('display','block');
		$('.addBody').addClass('animated slideInRight');
    })
    //导出按钮事件
    $('#btn_export').click(function(){
//    	console.log("导出");
//    	console.log($('#mytab').bootstrapTable('getData'));
    	$.ajax({
            type:"get",
            dataType:"json",
            traditional:true,
//            data: {test: JSON.stringify($table.bootstrapTable('getData')),total: $('#mytab').bootstrapTable('getData').length},
            data: {searchItem:$("#select_id").find("option:selected").text(),searchValue:$('#searchValue').val()},
            url:"exportDatas",
     
            success:function(data){
            	alert("导出成功");
            },
            error:function(data){
                console.log(data);
            }
        });    	
    })
    //删除按钮与修改按钮的出现与消失
    $('.bootstrap-table').change(function(){
    	var dataArr=$('#mytab .selected');
    	if(dataArr.length==1){
    		$('#btn_edit').css('display','block').removeClass('fadeOutRight').addClass('animated fadeInRight');
    	}else{
    		$('#btn_edit').addClass('fadeOutRight');
    		setTimeout(function(){
    			$('#btn_edit').css('display','none');
    		},400);	
    	}
    	if(dataArr.length>=1){
    		$('#btn_delete').css('display','block').removeClass('fadeOutRight').addClass('animated fadeInRight');
    	}else{
    		$('#btn_delete').addClass('fadeOutRight');
    		setTimeout(function(){
    			$('#btn_delete').css('display','none');
    		},400);	
    	}
    });
    //修改按钮事件
    $('#btn_edit').click(function(){
    	var dataArr=$('#mytab').bootstrapTable('getSelections');
    	$('.tableBody').addClass('animated slideOutLeft');
		setTimeout(function(){
			$('.tableBody').removeClass('animated slideOutLeft').css('display','none');
		},500)
		$('.changeBody').css('display','block');
		$('.changeBody').addClass('animated slideInRight');
		$('#edit_Bc').val(dataArr[0].bc);
		$('#edit_Bn').val(dataArr[0].bn);
		$('#edit_Title').val(dataArr[0].title);
		$('#edit_Author').val(dataArr[0].author);
		$('#edit_Wst').val(dataArr[0].wst);
		$('#edit_State').val(dataArr[0].state);
		$('#edit_Price').val(dataArr[0].price);
		$('#edit_RoomNo').val(dataArr[0].roomNo);
		console.log(dataArr[0].Attribute);
		if(dataArr[0].Attribute==1){
			$("#editForm input[name=Attribute]:eq(0)").prop("checked",true);
			$("#editForm input[name=Attribute]:eq(1)").prop("checked",false);
		}
		else if(dataArr[0].Attribute==2){
			$("#editForm input[name=Attribute]:eq(1)").prop("checked",true);
			$("#editForm input[name=Attribute]:eq(0)").prop("checked",false);
		}
		//先清空角色复选框
//	    $('#editForm .edit input').prop('checked',false);
//	  //获取用户角色
//		$.post('show',
//				{ID:dataArr[0].ID},
//				function(data){
//				   var roleIDArr=data.res.user.RoleID;
//				 //将对应用户的角色列表显示到对应的修改页
//                   for(var i=0;i<roleIDArr.length;i++){
//                	   for(var j=0;j<$('#editForm .edit input').length;j++){
//                		   if(roleIDArr[i]==$('#editForm .edit input:eq('+j+')').val()){
//                			   $('#editForm .edit input:eq('+j+')').prop('checked',true);
//                		   }
//                	   }
//                   }
//		        }
//		);
    })
    /*
     * 用户管理增加用户页面所有事件
    */
    //增加页面表单验证
    $('#add_saveBtn').click(function() {
    	//点击保存时触发表单验证֤
       $('#addForm').bootstrapValidator('validate');
       //如果表单验证正确，则请求后台添加用户
       if($("#addForm").data('bootstrapValidator').isValid()){
    	   var _info = $('#addForm').serialize();
    	  $.get(
				"addBooks",
				$('#addForm').serialize(),
				function(data){
					//后台返回添加成功
//					console.log("test");
//					console.log(data);
//					if(data.suc==true){
					$('.popup_de').addClass('bbox');
			 		$('.popup_de .show_msg').text('添加成功！');
			 		$('.popup_de .btn_cancel').css('display','none');
			 		$('.popup_de .btn_submit').one('click',function(){
						$('.popup_de').removeClass('bbox');
						$('.addBody').addClass('animated slideOutLeft');
				    	setTimeout(function(){
							$('.addBody').removeClass('animated slideOutLeft').css('display','none');
						},500);
				    	$('.tableBody').css('display','block').addClass('animated slideInRight');
				    	$('#mytab').bootstrapTable('refresh', {url: 'searchAll'});
				    	$('#addForm').data('bootstrapValidator').resetForm(true);
				    	//隐藏修改与删除按钮
						$('#btn_delete').css('display','none');
						$('#btn_edit').css('display','none');
			 		});
//					}
					//����
//					else{
//					}
				}
			) 
       }
    });
    //增加页面返回按钮事件
    $('#add_backBtn').click(function() {
    	$('.addBody').addClass('animated slideOutLeft');
    	setTimeout(function(){
			$('.addBody').removeClass('animated slideOutLeft').css('display','none');
		},500)
    	$('.tableBody').css('display','block').addClass('animated slideInRight');  
    	$('#addForm').data('bootstrapValidator').resetForm(true);
    });
    	//修改表单
    $('#edit_backBtn').click(function(){
    	$('.changeBody').addClass('animated slideOutLeft');
    	setTimeout(function(){
			$('.changeBody').removeClass('animated slideOutLeft').css('display','none');
		},500)
    	$('.tableBody').css('display','block').addClass('animated slideInRight'); 
    	$('#editForm').data('bootstrapValidator').resetForm(true);
    })
    //保存修改
    $('#edit_saveBtn').click(function(){
    	$('#editForm').bootstrapValidator('validate');
    	if($("#editForm").data('bootstrapValidator').isValid()){
    		 $.post("alterBook",
				$('#editForm').serialize(),
				function(data){
//					if(data.suc==true){
						//�����޸���ɾ��ť
    			 		$('.popup_de').addClass('bbox');
    			 		$('.popup_de .show_msg').text('修改成功！');
    			 		$('.popup_de .btn_cancel').css('display','none');
    			 		$('.popup_de .btn_submit').one('click',function(){
    						$('.popup_de').removeClass('bbox');
    						$('#btn_delete').css('display','none');
    						$('#btn_edit').css('display','none');
    						//���˵���Ա������ҳ
    						$('.changeBody').addClass('animated slideOutLeft');
    				    	setTimeout(function(){
    							$('.changeBody').removeClass('animated slideOutLeft').css('display','none');
    						},500)
    				    	$('.tableBody').css('display','block').addClass('animated slideInRight'); 
    				    	//ˢ����Ա������ҳ
    				    	$('#mytab').bootstrapTable('refresh', {url: 'searchAll'});
    				    	//�޸�ҳ��?����
    				    	$('#editForm').data('bootstrapValidator').resetForm(true);
    					});
    					
						
//					}else{
//					}
			    }
    		 ) 
    	}
    });
//    //ɾ���¼���ť
    $('#btn_delete').click(function(){
    	var dataArr=$('#mytab').bootstrapTable('getSelections');
    	$('.popup_de .show_msg').text('确定要删除这些书吗?');
    	$('.popup_de').addClass('bbox');
    	$('.popup_de .btn_submit').one('click',function(){
    		var Bc=[];
        	for(var i=0;i<dataArr.length;i++){
        		Bc[i]=dataArr[i].bc;
        	}
        	$.get("deleteBook",
        			jQuery.param({"bcs":Bc}, true),//默认为false,则发送的数组会变成发送的post信息中的数组信息为&arr[]=aaa&arr[]=bbb
         			function(data){
//        		if(data.suc==true){
        			$('.popup_de .show_msg').text('删除成功！');
					$('.popup_de .btn_cancel').css('display','none');
					$('.popup_de').addClass('bbox');
					$('.popup_de .btn_submit').one('click',function(){
						$('.popup_de').removeClass('bbox');
					})
        			$('#mytab').bootstrapTable('refresh', {url: 'searchAll'});
//        		}else{
//        		}
        	});
    	})
    })
    //弹出框取消按钮事件
   $('.popup_de .btn_cancel').click(function(){
	   $('.popup_de').removeClass('bbox');
   })
    //弹出框关闭按钮事件
     $('.popup_de .popup_close').click(function(){
	   $('.popup_de').removeClass('bbox');
   })
})
function tableHeight() {
    return $(window).height() - 140;
}