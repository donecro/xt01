<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>网络故障报修</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <style type="text/css">
        body{
            margin:0px;
            background-image: linear-gradient(to top,#B5D7AF,#FFFFFF);
        }
        select{
            margin-left: 5%;
            width: 90%;
            height: 40px;
            background-color: whitesmoke;
            border-radius: 5px;
            border-color: #CCCCCC;
            font-size: 18px;
        }
        option{
            width: 100%;
            height: 40px;
            background-color: whitesmoke;
            border-radius: 5px;
            border-color: #CCCCCC;
            font-size: 20px;
        }
        form{
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
            width: 94%;
            height: 700px;
            border-radius: 10px;
            background:rgba(255, 255, 255, 0.5)
        }
        button{
            margin-top: 20px;
            margin-left: 20%;
            width: 60%;
            height: 40px;
            border-radius: 10px;
            background-color: #95D784;
            color: white;
            font-weight: 700;
            font-size: 20px;
            border-color: transparent;
        }
        textarea{
            margin-left: 5%;
            width: 90%;
            height: 120px;
            background-color: whitesmoke;
            border-radius: 5px;
            border-color: #CCCCCC;
            font-size: 16px;
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
            margin-bottom: 5%;
            margin-bottom: 2%;
            font-weight: 900;
            font-size: 20px;
            color: #95D784;
        }
        .input1{
            margin-left: 5%;
            width: 90%;
            height: 33px;
            background-color: whitesmoke;
            border-radius: 5px;
            border-color: #CCCCCC;
            font-size: 16px;
        }
        .input2{
            margin-left: 5%;
            width: 20px;
            height: 18px;
            font-size: 20px;
        }
    </style>
    <script type="text/javascript">
        function chy(obj){
            document.getElementById("patent").style.display="";
            document.getElementById("form1").style.height="820px";
        }
        function chn(obj){
            document.getElementById("patent").style.display="none";
            document.getElementById("form1").style.height="700px";
        }
        function ok()
        {
            if(document.getElementById("patent").style.display==""){
            document.getElementById("input4").value=document.getElementById("input3").value;
            }else {
                return;
            }
        }
    </script>
</head>
<body>
<form action="/maintain/finish" method="post" id="form1" >
    <br />
    <div class="tx1">
        <label>姓名：</label><br />
    </div>
    <input class="input1" type="text" name="username" required="required" pattern="[\u4e00-\u9fa5]{2,4}" placeholder="请输入姓名" oninvalid="setCustomValidity('真实姓名必须是中文，且长度不小于2，不大于4')" oninput="setCustomValidity('')">

    <div class="tx">
        <label>校园网账号：</label><br />
    </div>
    <input class="input1" type="text" name="account" required="required" pattern="^[a-zA-Z0-9]{1,30}" placeholder="请输入校园网账号" oninvalid="setCustomValidity('请输入校园网账号')" oninput="setCustomValidity('')">

    <div class="tx">
        <label>联系电话：</label><br />
    </div>
    <input class="input1" type="tel" name="callnum" required="required" maxlength="11" pattern="^(0|86|17951)?1[0-9]{10}" placeholder="请输入手机号" oninvalid="setCustomValidity('请输入11位手机号码')" oninput="setCustomValidity('')">

    <div class="tx">
        <label>所属校区：</label><br />
    </div>
    <select name="campus" required="required" pattern="[\u4e00-\u9fa5]{1，10}" oninvalid="setCustomValidity('请选择校区')" oninput="setCustomValidity('')">
        <option value="">请选择</option>
        <c:forEach items="${adl}" var="a" varStatus="vs">
            <option value="${a.build}">${a.build}</option>
        </c:forEach>
    </select>

    <div class="tx">
        <label>宿舍地址：</label><br />
    </div>
    <input class="input1" type="text" name="address" placeholder="例：X栋XXX" required="required" pattern=" [0-9]{1,2}+[\u4e00-\u9fa5]{1，2}+[0-9]{2,4}$" oninvalid="setCustomValidity('格式：X栋XXX')" oninput="setCustomValidity('')"/><br>

    <div class="tx">
        <label>故障现象：</label><br />
    </div>
    <div>
        <input class="input2" type="radio" name="content" value="弹不出认证界面" onchange="chn(this)">弹不出认证界面</input><br />
        <input class="input2" type="radio" name="content" value="连不上WIFI或频繁掉线" onchange="chn(this)">连不上WIFI或频繁掉线</input><br />
        <input class="input2" type="radio" name="content" value="用户名不存在或密码错误" onchange="chn(this)">用户名不存在或密码错误</input><br />
        <input class="input2" type="radio" name="content" value="认证后不能上网" onchange="chn(this)">认证后不能上网</input><br />
        <input class="input2" type="radio" id="input4" name="content" value="" onchange="chy(this)">其他</input>
    </div>

    <div id="patent" style="display:none">
        <textarea type="text" id="input3" name="content" placeholder="" clos=",30" rows="5" warp="virtual" required="required" pattern="[\u4e00-\u9fa5]{1，200}" oninvalid="setCustomValidity('请填写1~200字故障现象')" oninput="setCustomValidity('')"></textarea>
    </div>
    <button type="submit" value="查询" ONCLICK="ok()">提交</button>
</form>
</body>
</html>
