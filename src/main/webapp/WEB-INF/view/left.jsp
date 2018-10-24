<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style type="text/css">
        body{
            background-color: #B5D7AF;
            margin:0px;
        }
        table{
            border:0;
            margin-top: 30%;
        }
        a{
            font-size:15px;
            color:#000000;
            text-decoration:none;
        }
        a:hover{
            color:#428eff;
            text-decoration:underline;
        }
        .sec_menu{
            border-right:white 1px solid;
            background:#d6dff7;
            overflow:hidden;
            border-left:white 1px solid;
            border-bottom:white 1px solid;
        }
        .menu_title {
        }
        .menu_title span {
            font-weight: bold; LEFT: 7px; COLOR: #215dc6; POSITION: relative; TOP: 2px
        }
        .menu_title2 {
        }
        .menu_title2 span {
            font-weight: bold; LEFT: 8px; COLOR: #428eff; POSITION: relative; TOP: 2px
        }
    </style>
</head>
<body>
<table cellSpacing=0 cellPadding=0 width=120 align=center>
    <tbody>
    <tr>
        <td height=30 align="center"><a href="/applylist" target="mainFrame">申请情况</a></td>
    </tr>
    <tr>
        <td height=30 align="center"><a href="/maintain" target="mainFrame">报修情况</a></td>
    </tr>
    <tr>
        <td height=30 align="center"><a href="/setting" target="mainFrame">系统设置</a></td>
    </tr>
    <tr>
        <td height=30 align="center"><a href="/personsetting" target="mainFrame">个人设置</a></td>
    </tr>
    <c:if test="${power==40001}">
        <tr>
            <td height=30 align="center"><a href="/adminmanager" target="mainFrame">管理员列表</a></td>
        </tr>
    </c:if>
    <tr>
        <td height=30 align="center"><a href="/logout" target="_parent" onClick="return confirm('您确认要退出吗？')">退出登陆</a></td>
    </tr>
    </tbody>
</table>
</body>
</html>