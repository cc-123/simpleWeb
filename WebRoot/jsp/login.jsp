<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

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

    <title>用户登录</title>

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="../css/login.css" rel="stylesheet">
  </head>

  <body>
	<%session.removeAttribute("user");%>
    <div class="container">

      <form class="form-signin" method="post" action="login">
        <h2 class="form-signin-heading">用户登录</h2>
        <label for="inputName" class="sr-only">用户名</label>
        <input name="user.numb" type="text" id="inputName" class="form-control" placeholder="用户名" />
        <label for="inputPassword" class="sr-only">密码</label>
        <input name="user.paw" type="password" id="inputPassword" class="form-control" placeholder="密码" />
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>
    </div> <!-- /container -->
  </body>
</html>
