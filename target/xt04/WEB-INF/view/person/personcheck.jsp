<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <title>用户身份验证</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <style type="text/css">
        body{
            margin:0px;
            background-image: linear-gradient(to top,#B5D7AF,#FFFFFF);
        }
        .tx{
            /*margin-left:5%;*/
            margin: 5%;
            margin-bottom: 2%;
            font-weight: 900;
            font-size: 20px;
            color: #95D784;
        }
        .tx1{
            margin-left:5%;
            margin-bottom: 2%;
            font-weight: 900;
            font-size: 20px;
            color: #95D784;
        }
        input{
            margin-left: 5%;
            width: 85%;
            height: 33px;
            background-color: whitesmoke;
            border-radius: 5px;
            border-color: #CCCCCC;
            font-size: 16px;
            color: #95D784;
        }select{
             margin-left: 5%;
             width: 90%;
             height: 40px;
             background-color: whitesmoke;
             border-radius: 5px;
             border-color: #CCCCCC;
             font-size: 16px;
             color: #95D784;
         }
        option{
            width: 100%;
            height: 40px;
            background-color: whitesmoke;
            border-radius: 5px;
            border-color: #CCCCCC;
            font-size: 16px;

        }
        form{
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
            width: 94%;
            height: 560px;
            border-radius: 10px;
            background:rgba(255, 255, 255, 0.5);
        }
        button{
            margin-top: 20px;
            margin-left: 20%;
            width: 60%;
            height: 40px;
            border-radius: 10px;
            background-color:  #95D784;
            color: white;
            font-weight: 700;
            font-size: 20px;
            border-color: transparent;
        }
    </style>

</head>
<body>
<form action="/apply/check" method="POST">
    <br />
    <div class="tx1"><label>姓名：</label><br/></div>
    <input type="text" name="username" required="required" pattern="[\u4e00-\u9fa5]{2,4}" placeholder="请输入姓名" oninvalid="setCustomValidity('真实姓名必须是中文，且长度不小于2，不大于4')" oninput="setCustomValidity('')">

    <div class="tx"><label>联系电话：</label><br/></div>
    <input type="tel" name="callnum" required="required" maxlength="11" pattern="^(0|86|17951)?1[0-9]{10}" placeholder="请输入手机号" oninvalid="setCustomValidity('请输入11位手机号码')" oninput="setCustomValidity('')">

    <div class="tx"><label>性别：</label><br/></div>
    <select id="sex" name="sex" required="required" pattern="[\u4e00-\u9fa5]{1}" oninvalid="setCustomValidity('请选择性别')" oninput="setCustomValidity('')">
        <option value="">==请选择==</option>
        <option value="男">男</option>
        <option value="女">女</option>
    </select><br>

    <div class="tx"><label>学号：</label><br/></div>
    <input type="text" name="uid" required="required" minlength="4" maxlength="12" pattern="^([0-9]){4,12}$" placeholder="请输入学号" oninvalid="setCustomValidity('请输入4~12位学号')" oninput="setCustomValidity('')">

    <div class="tx"><label>身份证：</label><br/></div>
    <input type="text" name="identity" required="required" pattern="^[a-zA-Z0-9]{18}" placeholder="请输入身份证号" oninvalid="setCustomValidity('请输入正确的身份证号码')" maxlength="18" oninput="setCustomValidity('')">

    <button type="submit" value="Submit">下一步</button>
</form>
</body>
</html>