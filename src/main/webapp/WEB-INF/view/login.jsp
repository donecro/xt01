<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style type="text/css">
	body{
	  background:#799ae1;
	  margin:0px;
	  font-size: 10px;
	}
   </style>
   </head>
    <body leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
      <form action="/admin" method="POST">
          <label class="">账号：</label>
          <input class="" type="text" name="account" placeholder="请输入账号"/><br>
          <label class="">密码：</label>
          <input class="" type="text" name="password" placeholder="请输入密码"/><br>
          <button type="submit" value="登录"/>
      </form>
    </body>
</html>