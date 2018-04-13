<%@ page language="java" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="cc">
    <link rel="icon" href="../Icos/library_favicon.ico">

    <title>主页</title>
  </head>

  <body>
	<canvas id="canvas" width="70" height="34"></canvas>  
       <a href="javascript:;" id="change" style="line-height: 34px;text-indent: 10px;">换一张</a>  
       <input type="text" class="form-control" id="yzms" name="yzms" readonly = "readonly" style="display:block" >  
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript">
	$.ajax({  
	    url:"random",  
	    success:function(k){  
	         $("#yzms").attr("value",k.yzms);  
	         drawPic();  
	    }  
	})  
	  
	  $("#change").on("click",function(){  
	        var _this=$(this)  
	        $.ajax({  
	            url:"random",  
	            success:function(k){ 
	            	console.log(k);
	                console.log(k.yzms);  
	                 $("#yzms").attr("value",k.yzms);  
	                 drawPic();  
	            }  
	        })  
	    })   
	  /**生成一个随机数**/  
	  function randomNum(min,max){  
	    return Math.floor( Math.random()*(max-min)+min);  
	  }  
	  /**生成一个随机色**/  
	  function randomColor(min,max){  
	    var r = randomNum(min,max);  
	    var g = randomNum(min,max);  
	    var b = randomNum(min,max);  
	    return "rgb("+r+","+g+","+b+")";  
	  }  
	      
	          
	  /**绘制验证码图片**/  
	  function drawPic(){  
	    var canvas=document.getElementById("canvas");  
	    var width=canvas.width;  
	    var height=canvas.height;  
	    var ctx = canvas.getContext('2d');  
	    ctx.textBaseline = 'bottom';  
	  
	    /**绘制背景色**/  
	    ctx.fillStyle = randomColor(180,240); //颜色若太深可能导致看不清  
	    ctx.fillRect(0,0,width,height);  
	    /**绘制文字**/  
	  
	      var txt = $("#yzms").attr("value");  
	      ctx.fillStyle = randomColor(50,160);  //随机生成字体颜色  
	      ctx.font = randomNum(15,20)+'px SimHei'; //随机生成字体大小  
	      var x = 20;  
	      var y = randomNum(20,20);  
	      var deg = randomNum(-20, 30);  
	      //修改坐标原点和旋转角度  
	      ctx.translate(x,y);  
	      ctx.rotate(deg*Math.PI/180);  
	      ctx.fillText(txt, 0,0);  
	      //恢复坐标原点和旋转角度  
	      ctx.rotate(-deg*Math.PI/180);  
	      ctx.translate(-x,-y);  
	 /*    } */  
	    /* /**绘制干扰线**/  
	     for(var i=0; i<8; i++){  
	      ctx.strokeStyle = randomColor(40,180);  
	      ctx.beginPath();  
	      ctx.moveTo( randomNum(0,width), randomNum(0,height) );  
	      ctx.lineTo( randomNum(0,width), randomNum(0,height) );  
	      ctx.stroke();  
	    }   
	    /**绘制干扰点**/  
	    /*for(var i=0; i<100; i++){  
	      ctx.fillStyle = randomColor(0,255);  
	      ctx.beginPath();  
	      ctx.arc(randomNum(0,width),randomNum(0,height), 1, 0, 2*Math.PI);  
	      ctx.fill();  
	    }  
	    */
	  }  
	</script>    
  </body>
</html>
