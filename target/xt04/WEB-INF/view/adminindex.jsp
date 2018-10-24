<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>湖中大校园网后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <style type="text/css">
        body{
            margin:0px;
            background-color: #B5D7AF;
        }
        .tx{
            margin: 5%;
            margin-bottom: 1%;
            font-weight: 900;
            font-size: 24px;
            color: #95D784;
        }
        input{
            margin-left: 5%;
            width: 90%;
            height: 40px;
            background:rgba(255, 255, 255, 0.5);
            border-radius: 5px;
            border-color: #CCCCCC;
            font-size: 20px;
            text-align: center;
        }
        form{
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
            width: 300px;
            height: 350px;
            border-radius: 10px;
            background:rgba(255, 255, 255, 0.5);
        }
        button{
            margin-top: 20px;
            margin-left: 20%;
            width: 60%;
            height: 40px;
            border-radius: 10px;
            background-color: #95D784;
            color: white;
            font-size: 20px;
            border-color: transparent ;
        }
        .title{
            margin-top: 30px;
            text-align: center;
            font-size: 30px;
            font-weight: bolder;
            color: #95D784;
        }

    </style>
</head>
<body>
<div class="title">
    <a style="color: white">湖中大校园网后台管理系统</a>
</div>
<form action="/joinmain" method="POST">
    <br />
    <div class="tx">
        <label>账号：</label><br />
    </div>
    <input type="text" name="account" required="required" pattern="^[a-zA-Z0-9]\w{3,19}$" placeholder="请输入账号" oninvalid="setCustomValidity('6~20字母数字或下划线')" oninput="setCustomValidity('')">

    <div class="tx">
        <label>密码：</label><br />
    </div>
    <input type="password" name="password" required="required" pattern="^[a-zA-Z0-9]\w{3,19}$" placeholder="请输入密码" oninvalid="setCustomValidity('6~20字母数字或下划线')" oninput="setCustomValidity('')">

    <button type="submit" value="Submit">登录</button>
    <br/>
</form>
<p>${message}</p>


</body>
</html>