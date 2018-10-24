<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>申请校园网结果</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <style type="text/css">
        body{
            margin:0px;
            background-image: linear-gradient(to top,#B5D7AF,#FFFFFF);
        }
        button{
            margin-top: 20px;
            margin-left: 20%;
            margin-bottom: 10px;
            width: 60%;
            height: 40px;
            border-radius: 10px;
            border-color: transparent;
            background-color: white;
            color: #B5D7AF;
            font-weight: 700;
            font-size: 20px;
        }
        .show{
            margin-top: 50px;
            margin-left: auto;
            margin-right: auto;
            width: 94%;
            height: 300px;
            border-radius: 10px;
            background:rgba(255, 255, 255, 0.5)
        }
    </style>
    <script type="text/javascript">
        function Retu() {
            window.location.href="/apply/person";
        }
    </script>
</head>
<body>
<div class="show">
    <br />
    <p style="margin-left:5%;
		          margin-right:5%;
        	      text-align: center;
    			  font-weight: 900;
		          font-size: 20px;
		          color: #B5D7AF;
		          height:200px;
		          line-height: 200px;
		          overflow: hidden;">
        申请失败，请返回重新填写
    </p>
</div>
<button type="submit" value="retu" onclick="Retu()">返回</button>
</div>
</body>
</html>