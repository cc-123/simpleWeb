<%@ page language="java" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="author" content="cc">
    <link rel="icon" href="../Icos/library_favicon.ico">

    <title>主页</title>

    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    
    <link rel="stylesheet" type="text/css" href="../css/tree.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	    <link href="../public/static/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet" />
	    <link href="../public/static/css/animate.min.css" rel="stylesheet" />
	    <link href="../public/static/css/plugins/bootstrapValidator/bootstrapValidator.min.css" rel="stylesheet" />
	    <link href="../public/static/css/style.min.css" rel="stylesheet" />
	    <link href="../css/main.css" rel="stylesheet" />
	    <style>
	    	.back:hover{	    	
	    		cursor: pointer;
	    	}
	    	.fixed-table-toolbar .btn-group>.btn-group:last-child>.btn {
			    border-top-right-radius: 0px;
			    border-bottom-right-radius: 0px;
			}
			label{
				width:100px;
			}
			.popup_de{
				background-color:rgba(0,0,0,0.3);
				width:100%;
				height: 100%;
				position:fixed;
				z-index:999;
				top:0;
				left:0;
				display:none;
			}
			.bbox{
				display: -webkit-box;   /* 老版本语法: Safari, iOS, Android browser, older WebKit browsers. */
			    display: -moz-box;      /* 老版本语法: Firefox (buggy) */
			    display: -ms-flexbox;   /* 混合版本语法: IE 10 */   
				display: -webkit-flex;  /* 新版本语法: Chrome 21+ */
				display: -moz-flex;
			    display: flex;          /* 新版本语法: Opera 12.1, Firefox 22+ */
			}
			.bbox.xycenter{
				-moz-box-pack: center; /*Firefox*/
			    -webkit-box-pack: center; /*Safari,Opera,Chrome*/
			    box-pack: center;
			    -moz-justify-content: center;
			    -webkit-justify-content: center;
			    justify-content: center;
				-moz-box-align: center; /*Firefox*/
			    -webkit-box-align:center; /*Safari,Opera,Chrome*/
			    box-align: center;
				-moz-align-items: center;
			    -webkit-align-items: center;
				align-items:center;
			}
			.popup_de .popup_box{
				width:300px;
				height:150px;
				font-family: '微软雅黑';
				background-color: #fff;
				border-radius:5px;
				color:#333;
			}
			.popup_de .popup_btn{
				display: inline-block;
				width:100px;
				height:30px;
				border-radius: 3px;
				border:1px solid #1ab394;
				font-size:15px;
				text-align: center;
				line-height: 30px;
				margin-right:15px;
				cursor: pointer;
			}
			.popup_de .show_msg{
				display: block;
				width:100%;
				text-align: center;
				font-size:18px;
				margin-top:40px;
				margin-bottom: 20px;
				padding:10px;
			}
			.popup_de .popup_close{
				width:30px;
				height:30px;
				font-size:25px;
				text-align: center;
				display: inline-block;
		        cursor:pointer;
		        float: right;
		        border-top-right-radius: 5px;
				line-height:30px;
			}
			.popup_de .popup_close:hover{
				background-color: #1ab394;
				color:#fff;
			}
			.popup_de .btn_submit{
				background-color: #1ab394;
				color:#fff;
			}
			.popup_de .btn_box{
				text-align: center;
			}
	    </style>
	     <link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0-rc2/css/bootstrap-glyphicons.css" rel="stylesheet" />
  </head>

  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top" style="background: #26516e;">
      <div class="container-fluid">
        <div class="navbar-header" style="font-size:1.5em">
          <!--  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          -->
          <h1 id="title">图书管理系统</h1>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="login.jsp" id="exit" style="font-size: 15px;margin-top: 3px">注销</a></li>
            <li><a href="#" style="font-size: 15px;margin-top: 3px">帮助</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="container-fluid">
    <div class="row" id="control" >
        <div class="col-sm-3 col-md-2 sidebar">
          <div id="treeview" class="nav-sidebar" style="font-size:1.2em;margin-top:-1px;background: #fff;"></div>
        </div>
        <div class=" col-md-9 col-md-offset-2 main" id="bookAction">
        	<div class="tableBody" style="position:absolute;left:20em">
				<div class="panel panel-default">
					<div class="panel-heading">
						查询条件
					</div>
					<div class="panel-body form-group" style="margin-bottom:0px;">
						<div class="form-group col-sm-3">
					      <select class="form-control" style="text-align: right;" id="select_id" onchange="showInput()">
					      	 <option>全部</option>
					         <option>书名</option>
					         <option>条形码</option>
					      </select>
					    </div>
	                    <div class="col-sm-4">
	                        <input type="text" class="form-control" id="searchValue" style="display:none;"/>
	                    </div>
	                    <div class="col-sm-2 pull-right">
	                    	<button class="btn btn-primary" id="search_btn">查询</button>
	                    </div>
	                    
					</div>
				</div>
			  	<table id="mytab" class="table table-hover"></table>
			  	<div id="toolbar" class="btn-group pull-right" style="margin-right: 20px;">
		            <button id="btn_edit" type="button" class="btn btn-default" style="display: none; border-radius: 0">
		                <span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span>修改
		            </button>
		            <button id="btn_delete" type="button" class="btn btn-default" style="display: none;">
		                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
		            </button>
		            <button id="btn_add" type="button" class="btn btn-default">
		                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
		            </button>
		            <button id="btn_export" type="button" class="btn btn-default">
		                <span class="glyphicon glyphicon-save" aria-hidden="true"></span>导出
		            </button>
	        	</div>
        	</div>
        <div class="addBody" style="width:100%; display: none;position: absolute;top:5px">
        	<div class="col-sm-12">
        		<div class="ibox float-e-margins">
        			<div class="ibox-title">
	                    <h5>新增图书</h5>
	                </div>
	                <div class="ibox-content">
		                <form id="addForm" method="post" class="form-horizontal">
		                    <div class="form-group">
		                        <label class="col-sm-2 control-label">书号</label>
		                        <div class="col-sm-8">
		                            <input type="text" class="form-control" name="book.bn" id="add_Name"/>
		                        </div>
		                    </div>
		                    <div class="hr-line-dashed"></div>
		                    <div class="form-group">
		                        <label class="col-sm-2 control-label">书名</label>
		                        <div class="col-sm-8">
		                            <input type="text" class="form-control" name="book.title" id="add_Title"/>
		                        </div>
		                    </div>
		                    <div class="hr-line-dashed"></div>
		                    <div class="form-group">
		                        <label class="col-sm-2 control-label">作者</label>
		                        <div class="col-sm-8">
		                            <input type="text" class="form-control" name="book.author" id="add_Author"/>
		                        </div>
		                    </div>
		                    <div class="hr-line-dashed"></div>
		                    <div class="form-group">
		                        <label class="col-sm-2 control-label">价格</label>
		                        <div class="col-sm-8">
		                            <input type="text" class="form-control" name="book.price" id="add_Price"/>
		                        </div>
		                    </div>
		                    <div class="hr-line-dashed"></div>
		                    <div class="form-group">
		                        <label class="col-sm-2 control-label">房号</label>
		                        <div class="col-sm-8">
		                        	<select id="selectRoomNo" name="book.roomNo" style="height:30px;width:50px;"></select>
		                            <!--  <input type="text" class="form-control" name="book.roomNo" id="add_RoomNO"/>-->
		                        </div>
		                    </div>
		                    <div class="hr-line-dashed"></div>
		                    <div class="form-group">
		                    	<div class="checkbox">
  								    <label class="col-sm-4 control-label" style="font-weight:700;" id="getChkValue"><input id="chkBooks" type="checkbox" style="margin-top: 2px;" />是否添加多本图书</label>
								</div>
		                    </div>
		                    <div class="hr-line-dashed"></div>
		                    <div class="form-group">
		                    	<label class="col-sm-2 control-label">数量</label>
		                    	<div class="col-sm-8">
		                            <input id="num" type=" type="text" class="form-control" name="n" value="1" readonly/>
		                        </div>
		                    </div>
		                    <div class="hr-line-dashed"></div>
		                    <div class="form-group">
		                        <div class="col-sm-2 col-sm-offset-2">
		                            <button type="button" class="btn btn-primary btn-block"  id="add_saveBtn">增加</button>
		                        </div>
		                        <div class="col-sm-2 col-sm-offset-1">
		                            <button type="button" class="btn btn-default btn-block"  id="add_backBtn">返回</button>
		                        </div>
		                    </div>
		                </form>
		             </div>
		          </div>
		       </div>
		    </div>
		 </div>
		<div class="changeBody" style="width: 70%; display: none; position: absolute; top: 55px; left: 24em;">
        	<div class="col-sm-12">
        		<div class="ibox float-e-margins">
        			<div class="ibox-title">
	                    <h5>修改图书信息</h5>
	                </div>
	                <div class="ibox-content">
		                <form id="editForm" method="post" class="form-horizontal">
		                	<div class="form-group">
		                 		<label class="col-sm-2 control-label">条形码</label>
		                        <div class="col-sm-3">
		                            <input type="text" class="form-control" name="book.bc" id="edit_Bc" readonly />
		                        </div>
		                 	</div>
		                 	<div class="hr-line-dashed"></div>
		                 	<div class="form-group" >
		                 		<label class="col-sm-2 control-label">书号</label>
		                        <div class="col-sm-3">
		                            <input type="text" class="form-control" name="book.bn" id="edit_Bn"/>
		                        </div>
		                 	</div>
		                 	<div class="hr-line-dashed"></div>
		                    <div class="form-group">
		                        <label class="col-sm-2 control-label">书名</label>
		                        <div class="col-sm-3">
		                            <input type="text" class="form-control" name="book.title" id="edit_Title"/>
		                        </div>
		                    </div>
		                    <div class="hr-line-dashed"></div>
		                    <div class="form-group">
		                        <label class="col-sm-2 control-label">作者</label>
		                        <div class="col-sm-3">
		                            <input type="text" class="form-control" name="book.author" id="edit_Author"/>
		                        </div>
		                    </div>
		                    <div class="hr-line-dashed"></div>
		                    <div class="form-group">
		                        <label class="col-sm-2 control-label">价格</label>
		                        <div class="col-sm-3">
		                            <input type="text" class="form-control" name="book.price" id="edit_Price"/>
		                        </div>
		                    </div>
		                    <div class="hr-line-dashed"></div>
		                    <div class="form-group">
		                        <label class="col-sm-2 control-label">入库时间</label>
		                        <div class="col-sm-3">
		                            <input type="text" class="form-control" name="book.wst" id="edit_Wst" readonly />
		                        </div>
		                    </div>
		                    <div class="hr-line-dashed"></div>
		                    <div class="form-group">
		                        <label class="col-sm-2 control-label">房号</label>
		                        <div class="col-sm-3">
		                            <input type="text" class="form-control" name="book.roomNo" id="edit_RoomNo"/>
		                        </div>
		                    </div>
		                    <div class="hr-line-dashed"></div>
		                    <div class="form-group">
		                        <label class="col-sm-2 control-label">借阅状态</label>
		                        <div class="col-sm-3">
		                            <input type="text" class="form-control" name="book.state" id="edit_State"/>
		                        </div>
		                    </div>
		                    <div class="hr-line-dashed"></div>
		                    <div class="form-group">
		                        <div class="col-sm-2 col-sm-offset-2">
		                            <button type="button" class="btn btn-primary btn-block"  id="edit_saveBtn">保存修改</button>
		                        </div>
		                        <div class="col-sm-2 col-sm-offset-1">
		                            <button type="button" class="btn btn-default btn-block"  id="edit_backBtn">返回</button>
		                        </div>
		                    </div>
		                </form>
	                </div>
        		</div>
            </div>
		</div>
		<div class="popup_de xycenter">
			<div class="popup_box">
				<span class="popup_close" value="关闭">×</span>
			    <span class="show_msg">确定要删除该书吗？</span>
			    <div class="btn_box">
				    <div class="popup_btn btn_submit" value="确定">确定</div>
					<div class="popup_btn btn_cancel" value="取消">取消</div>
			    </div>
			</div>	
		</div>
	<%  
    String paw="";  
    if(request.getSession().getAttribute("paw")!=null){  
    	paw=request.getSession().getAttribute("paw").toString();  
    }  
	%>
		<div style="display:none" id="changePaw" class=" col-md-9 col-md-offset-6 toTop">
			<form action="changePaw" method="post" class="form"  >
	    		<div>
	    			<label for="oldPaw" style="width:50px;">原密码</label>
    				<input type="password" id="oldPaw" /><span id="message" style="display:none;color: red;margin-left: 20px;">密码错误</span>
    				<input type="text" id="checkPaw" value="<%=paw%>" style="display:none" /> 
	    		</div>	
	    		<div style="margin-top: 10px">
	    			<label for="newPaw" style="width:50px;">新密码</label>
    				<input type="password" id="newPaw" name="newPaw" />
	    		</div>	
	    		<input id="postPaw" type="submit" class="submitButton" value="提交" style="position:relative;left: 180px;top: 10px;" />
	    	</form>
		</div>
    </div>
    </div>
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="../js/bootstrap-treeview.js"></script>
	<script src="../js/test.js"></script>
    <script src="../public/static/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="../public/static/js/plugins/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
    <script src="../public/static/js/plugins/bootstrapValidator/bootstrapValidator.min.js"></script>
    <script src="../js/table.js"></script>   
	<script type="text/javascript">
		$(function() {
	        var defaultData = [
		       {   	  
		    	   text: '图书管理',
		            href: '#bookAction'
	          },
	          {
	            text: '用户管理',
	            href: '#userAction'
	          },
	          {
	        	  text: '书籍存储地管理'
	          },
	          {
	            text: '个人中心',
				nodes: [
	              {
	                text: '修改密码',
	                href: '#changePaw'	                
	              }
	            ]
	          },
	          {
	            text: '友情链接',
	            nodes: [
	                    {
	                    	text: '南航官网',
	                    	href: 'http://www.nchu.edu.cn/'
	                    },
	                    {
	                    	text: '百度搜索',
	                    	href: 'http://www.baidu.com'
	                    }
	                    ]
	          }
	        ];

        

        $('#treeview').treeview({
          color: "#428bca",		//设置列表树所有节点的前景色
          expandIcon: 'glyphicon glyphicon-chevron-right',
          collapseIcon: 'glyphicon glyphicon-chevron-down',
          nodeIcon: 'glyphicon glyphicon-education',
          data: defaultData,	//列表树上显示的数据
          enableLinks: true,	//是否使用当前节点的文本作为超链接。超链接的href值必须在每个节点的data结构中给出。
          levels: 1				//设置继承树默认展开的级别
        });
        



        // Select/unselect/toggle nodes
        $('#input-select-node').on('keyup', function (e) {
          selectableNodes = findSelectableNodes();
          $('.select-node').prop('disabled', !(selectableNodes.length >= 1));
        });

        $('#btn-select-node.select-node').on('click', function (e) {
          $selectableTree.treeview('selectNode', [ selectableNodes, { silent: $('#chk-select-silent').is(':checked') }]);
        });

        $('#btn-unselect-node.select-node').on('click', function (e) {
          $selectableTree.treeview('unselectNode', [ selectableNodes, { silent: $('#chk-select-silent').is(':checked') }]);
        });

        $('#btn-toggle-selected.select-node').on('click', function (e) {
          $selectableTree.treeview('toggleNodeSelected', [ selectableNodes, { silent: $('#chk-select-silent').is(':checked') }]);
        });



     

        // Expand/collapse/toggle nodes
        $('#input-expand-node').on('keyup', function (e) {
          expandibleNodes = findExpandibleNodess();
          $('.expand-node').prop('disabled', !(expandibleNodes.length >= 1));
        });

        $('#btn-expand-node.expand-node').on('click', function (e) {
          var levels = $('#select-expand-node-levels').val();
          $expandibleTree.treeview('expandNode', [ expandibleNodes, { levels: levels, silent: $('#chk-expand-silent').is(':checked') }]);
        });

        $('#btn-collapse-node.expand-node').on('click', function (e) {
          $expandibleTree.treeview('collapseNode', [ expandibleNodes, { silent: $('#chk-expand-silent').is(':checked') }]);
        });

        $('#btn-toggle-expanded.expand-node').on('click', function (e) {
          $expandibleTree.treeview('toggleNodeExpanded', [ expandibleNodes, { silent: $('#chk-expand-silent').is(':checked') }]);
        });

        // Expand/collapse all
        $('#btn-expand-all').on('click', function (e) {
          var levels = $('#select-expand-all-levels').val();
          $expandibleTree.treeview('expandAll', { levels: levels, silent: $('#chk-expand-silent').is(':checked') });
        });

        $('#btn-collapse-all').on('click', function (e) {
          $expandibleTree.treeview('collapseAll', { silent: $('#chk-expand-silent').is(':checked') });
        });



        var $checkableTree = $('#treeview-checkable').treeview({
          data: defaultData,
          showIcon: false,
          showCheckbox: true,
          onNodeChecked: function(event, node) {
            $('#checkable-output').prepend('<p>' + node.text + ' was checked</p>');
          },
          onNodeUnchecked: function (event, node) {
            $('#checkable-output').prepend('<p>' + node.text + ' was unchecked</p>');
          }
        });

        var findCheckableNodess = function() {
          return $checkableTree.treeview('search', [ $('#input-check-node').val(), { ignoreCase: false, exactMatch: false } ]);
        };
        var checkableNodes = findCheckableNodess();

        // Check/uncheck/toggle nodes
        $('#input-check-node').on('keyup', function (e) {
          checkableNodes = findCheckableNodess();
          $('.check-node').prop('disabled', !(checkableNodes.length >= 1));
        });

        $('#btn-check-node.check-node').on('click', function (e) {
          $checkableTree.treeview('checkNode', [ checkableNodes, { silent: $('#chk-check-silent').is(':checked') }]);
        });

        $('#btn-uncheck-node.check-node').on('click', function (e) {
          $checkableTree.treeview('uncheckNode', [ checkableNodes, { silent: $('#chk-check-silent').is(':checked') }]);
        });

        $('#btn-toggle-checked.check-node').on('click', function (e) {
          $checkableTree.treeview('toggleNodeChecked', [ checkableNodes, { silent: $('#chk-check-silent').is(':checked') }]);
        });

        // Check/uncheck all
        $('#btn-check-all').on('click', function (e) {
          $checkableTree.treeview('checkAll', { silent: $('#chk-check-silent').is(':checked') });
        });

        $('#btn-uncheck-all').on('click', function (e) {
          $checkableTree.treeview('uncheckAll', { silent: $('#chk-check-silent').is(':checked') });
        });



        var $disabledTree = $('#treeview-disabled').treeview({
          data: defaultData,
          onNodeDisabled: function(event, node) {
            $('#disabled-output').prepend('<p>' + node.text + ' was disabled</p>');
          },
          onNodeEnabled: function (event, node) {
            $('#disabled-output').prepend('<p>' + node.text + ' was enabled</p>');
          },
          onNodeCollapsed: function(event, node) {
            $('#disabled-output').prepend('<p>' + node.text + ' was collapsed</p>');
          },
          onNodeUnchecked: function (event, node) {
            $('#disabled-output').prepend('<p>' + node.text + ' was unchecked</p>');
          },
          onNodeUnselected: function (event, node) {
            $('#disabled-output').prepend('<p>' + node.text + ' was unselected</p>');
          }
        });

        var findDisabledNodes = function() {
          return $disabledTree.treeview('search', [ $('#input-disable-node').val(), { ignoreCase: false, exactMatch: false } ]);
        };
        var disabledNodes = findDisabledNodes();

        // Expand/collapse/toggle nodes
        $('#input-disable-node').on('keyup', function (e) {
          disabledNodes = findDisabledNodes();
          $('.disable-node').prop('disabled', !(disabledNodes.length >= 1));
        });

        $('#btn-disable-node.disable-node').on('click', function (e) {
          $disabledTree.treeview('disableNode', [ disabledNodes, { silent: $('#chk-disable-silent').is(':checked') }]);
        });

        $('#btn-enable-node.disable-node').on('click', function (e) {
          $disabledTree.treeview('enableNode', [ disabledNodes, { silent: $('#chk-disable-silent').is(':checked') }]);
        });

        $('#btn-toggle-disabled.disable-node').on('click', function (e) {
          $disabledTree.treeview('toggleNodeDisabled', [ disabledNodes, { silent: $('#chk-disable-silent').is(':checked') }]);
        });

        // Expand/collapse all
        $('#btn-disable-all').on('click', function (e) {
          $disabledTree.treeview('disableAll', { silent: $('#chk-disable-silent').is(':checked') });
        });

        $('#btn-enable-all').on('click', function (e) {
          $disabledTree.treeview('enableAll', { silent: $('#chk-disable-silent').is(':checked') });
        });

  		});
	  	</script>    
  </body>
</html>
