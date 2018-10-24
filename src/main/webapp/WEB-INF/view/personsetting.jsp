<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <script charset="UTF-8" src="/js/jquery-3.3.1.min.js"></script>
    <script charset="UTF-8" src="/js/jquery-3.3.1.slim.min.js"></script>
    <style type="text/css">
        body{
            background:white;
            margin:0px;
            font-size: 14px;
        }
        .button1{
            margin-left: 240px;
            width: 100px;
            height: 35px;
            background-color: #B5D7AF;
            color: white;
            border-radius: 10px;
            border-color: transparent;
            font-size: 20px;
            font-weight: 700;
        }
    </style>
    <script>
        function validate() {
            var pw1 = document.getElementById("pw1").value;
            var pw2 = document.getElementById("pw2").value;
            if(pw1 == pw2) {
                document.getElementById("tishi").innerHTML="<font color='green'>两次密码吻合</font>";
                document.getElementById("submit").disabled = false;
            }else {
                document.getElementById("tishi").innerHTML="<font color='red'>两次密码不吻合</font>";
                document.getElementById("submit").disabled = true;
            }
        }
    </script>
    </head>
<body>
<h1>个人设置</h1>
<hr size="1" width="100%">
<div style="width:370px; height:450px;font-size: 20px;margin:0px auto;">
    <p></p>
    <p>
        <a style="margin-left: 30px;font-weight: 700">你的账号为：${account}</a><br/>
        <a style="margin-left: 30px;font-weight: 700">你当前用户名为：${username}</a><br/>
    </p>
    <form style="border:2px solid #99968A;border-radius: 10px;width: 370px;height: 150px;" action="/setadminname" method="post">
        <p>
            <label style="margin-left: 30px">请输入你的新用户名: </label><br/>
            <input style="margin-left: 30px;width: 300px;height: 30px; font-size: 20px; text-align: center;" type="text" name="newusername"  required="required" pattern="^[a-zA-Z0-9]\w{3,30}$" oninvalid="setCustomValidity('3~30字母数字或下划线')" oninput="setCustomValidity('')"/><br />
        </p>
        <p>
            <button class="button1" type="submit" value="Submit">更改</button>
        </p>
    </form>
    <form style="margin-top:10px;border:2px solid #99968A;border-radius: 10px;width: 370px;height: 250px;" action="/setadminpwd" method="post">
        <p>
            <label style="margin-left: 30px">请输入你的新密码: </label><br/>
            <input style="margin-left: 30px;width: 300px;height: 30px; font-size: 20px; text-align: center;" type="password" name="newpassword" id="pw1" required="required" pattern="^[a-zA-Z0-9]\w{6,20}$" oninvalid="setCustomValidity('6~20字母数字或下划线')" oninput="setCustomValidity('')">
        <p>
        <p>
            <label style="margin-left: 30px">请再次输入你的新密码: </label><br/>
            <input style="margin-left: 30px;width: 300px;height: 30px; font-size: 20px; text-align: center;" type="password" name="newpassword" id="pw2" onkeyup="validate()" required="required" pattern="^[a-zA-Z0-9]\w{6,20}$" oninvalid="setCustomValidity('6~20字母数字或下划线')" oninput="setCustomValidity('')">
            <span  style="margin-left: 30px" id="tishi"></span>
        </p>
        <p>
            <button class="button1" type="submit" value="Submit">更改</button>
        </p>
    </form>


</div>
</body>
</html>