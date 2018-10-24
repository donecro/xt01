<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <style type="text/css">
        body{
            margin:0px;
            background-image: linear-gradient(to top,#B5D7AF,#FFFFFF);
        }
        .show{
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
            width: 94%;
            height: 75%;
            border-radius: 10px;
            background:rgba(255, 255, 255, 0.5)
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
        .title{
            text-align: center;
            font-size: 30px;
            font-weight: bolder;
            color: #B5D7AF;
        }
    </style>
</head>
<body>
<div class="title">
    <a>校园网介绍</a>
</div>
<div class="show">
    <br />
    <div style="text-align: left;
    		          margin-left:5%;
		              margin-right:5%;">
        <p style="text-align: justify;
    			                    font-weight: 900;
		                          font-size: 22px;
		                          color: #B5D7AF;">
            ${message}
        </p>
    </div>
</div>
</body>
</html>