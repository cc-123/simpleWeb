function itemOnclick(target){  
    //�ҵ���ǰ�ڵ�id  
    var nodeid = $(target).attr('data-nodeid');  
    var tree = $('#treeview');  
    //��ȡ��ǰ�ڵ����  
    var node = tree.treeview('getNode', nodeid);  
    if(node.state.expanded){   
        //����չ��״̬���۵�  
        tree.treeview('collapseNode', node.nodeId);    
    } else {  
        //չ��  
        tree.treeview('expandNode', node.nodeId);  
    }
    
    document.cookie  = 'username=Darren';
    var main = document.getElementById("control");
//    var main = document.getElementsByClassName("container-fluid")[0];
    var divs=main.getElementsByTagName("div"); 
    for(var i in divs) {
    	if(isNaN(i) || node.href == undefined) {
    		break;
    	}
    	
    	div = divs[i];
    	var result = node.href.substring(1);  	
    	if(div.id != "" && div.id != "treeview" && div.id != "toolbar") {
    		console.log(result);
        	console.log(div.id);
    		if (result == div.id ) {
    			div.style.display="block";   
    			if (div.id == "changePaw") {
//    				console.log("qingk");
    				$("#oldPaw").val("");
    				$('#message').css('display','none');
    			}
        	} else {
    			div.style.display="none";
        	}
    	}
    	
    	
    }   
} 
$(function () {
    $('#getChkValue').click(function () {
      var chk = $("#chkBooks");
      var checked = chk.is(':checked');
      if (checked) {
    	  $("#num").removeAttr("readonly");
      } else {
    	  $("#num").attr("readonly","readonly");
      }
    });
    getAllRoomNo(); 
    $("#oldPaw").blur(function(){
//    	console.log($("#checkPaw").val());
    	if ( $("#oldPaw").val() != $("#checkPaw").val()) {
    		$('#message').css('display','inline-block');
    	} else {
    		$('#message').css('display','none');
    	}    		
    });
    $("#postPaw").click(function(){
    	$('.popup_de').addClass('bbox');
 		$('.popup_de .show_msg').text('修改成功！');
 		$('.popup_de .btn_cancel').css('display','none');
 		$('.popup_de .btn_submit').one('click',function(){
			$('.popup_de').removeClass('bbox');
			$('#btn_delete').css('display','none');
			$('#btn_edit').css('display','none');
 		});
    });
//    $("#changePaw").click(function() {
//    	$("#oldPaw").val("");
//    });
});
function getAllRoomNo(){
    $.ajax({
        type:"post",
        dataType:"json",
        url:"getAllRoomNo",
 
        success:function(data){
        	var rows = data.rows;
            var len=rows.length;
            for(var i=0;i<len;i++){
                var option=document.createElement("option");
                $("#selectRoomNo").append(("<option value='"+rows[i].roomNo+"'>"+rows[i].roomNo+"</option>"));
            }
        },
        error:function(data){
            console.log(data);
        }
    });
}
function showInput() {
	var text = $("#select_id").find("option:selected").text();
//	console.log(text);
	if (text == "全部") {
		$('#searchValue').css('display','none');
	} else {
		$('#searchValue').css('display','block');
	}
}


