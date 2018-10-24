<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script charset="UTF-8" src="/js/jquery-3.3.1.min.js"></script>
    <script charset="UTF-8" src="/js/jquery-3.3.1.slim.min.js"></script>
    <link rel="stylesheet" href="/css/style.css"/>
</head>

<body>




    <div id="alist"></div>
    <h1>报修列表</h1>
    <hr size="1" width="100%">
    <div style="width:95%;height:auto;">
        <fieldset>
            <legend style="margin-bottom:10px;"><font color=black>今日名单</font></legend>
            <p>总数：${mtopagebean.totalCount}</p>
            <table width="1000" border="0" >
                <thead>
                <tr>
                    <th scope="col">姓名</th>
                    <th scope="col">校园网账号</th>
                    <th scope="col">联系电话</th>
                    <th scope="col">校区</th>
                    <th scope="col">宿舍地址</th>
                    <th scope="col">内容</th>
                    <th scope="col">申请时间</th>
                </tr>
                <c:forEach items="${mtolist}" var="m">
                    <tr>
                        <td align="center">${m.username}</td>
                        <td align="center">${m.account}</td>
                        <td align="center">${m.callnum}</td>
                        <td align="center">${m.campus}</td>
                        <td align="center">${m.address}</td>
                        <td align="center">${m.content}</td>
                        <td align="center">${m.date}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="3">
                        <a >当前 ${mtopagebean.currentPage }/${mtopagebean.totalPage}页 </a>
                        <c:if test="${mtopagebean.currentPage != 1}">
                            <a href="/maintain?mtocurpage=<c:out value="1"/>">首页</a>
                            <a href="/maintain?mtocurpage=<c:out value="${mtopagebean.currentPage - 1}"/>">上一页</a>
                        </c:if>
                        <c:if test="${mtopagebean.currentPage != mtopagebean.totalPage}">
                            <a href="/maintain?mtocurpage=<c:out value="${mtopagebean.currentPage + 1}"/>">下一页</a>
                            <a href="/maintain?mtocurpage=<c:out value="${mtopagebean.totalPage}"/>">末页</a>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="/excel/maintain/today/export">导出</a>
                    </td>
                </tr>
                </thead>
            </table>
        </fieldset>
    </div>

    <div style=" margin-top: 10px;width:95%;height:auto;">
        <fieldset>
            <legend style="margin-bottom:10px;"><font color=black>维修名单</font></legend>
            <p>总数：${mpagebean.totalCount}</p>
            <table width="1000" border="0" >
                <thead>
                <tr>
                    <th scope="col">姓名</th>
                    <th scope="col">校园网账号</th>
                    <th scope="col">联系电话</th>
                    <th scope="col">校区</th>
                    <th scope="col">宿舍地址</th>
                    <th scope="col">内容</th>
                    <th scope="col">申请时间</th>
                </tr>
                <c:forEach items="${mlist}" var="m">
                    <tr>
                        <td align="center">${m.username}</td>
                        <td align="center">${m.account}</td>
                        <td align="center">${m.callnum}</td>
                        <td align="center">${m.campus}</td>
                        <td align="center">${m.address}</td>
                        <td align="center">${m.content}</td>
                        <td align="center">${m.date}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="3">
                        <a >当前 ${mpagebean.currentPage }/${mpagebean.totalPage}页 </a>
                        <c:if test="${mpagebean.currentPage != 1}">
                            <a href="/maintain?mcurpage=<c:out value="1"/>">首页</a>
                            <a href="/maintain?mcurpage=<c:out value="${mpagebean.currentPage - 1}"/>">上一页</a>
                        </c:if>
                        <c:if test="${mpagebean.currentPage != mpagebean.totalPage}">
                            <a href="/maintain?mcurpage=<c:out value="${mpagebean.currentPage + 1}"/>">下一页</a>
                            <a href="/maintain?mcurpage=<c:out value="${mpagebean.totalPage}"/>">末页</a>
                        </c:if>
                    </td>
                </tr>

                <tr>
                    <td>
                        <a href="/excel/maintain/export">导出</a>
                    </td>
                </tr>
                </thead>
            </table>
        </fieldset>
    </div>

<div style="float: left; width:95% ;height:auto;">
    <fieldset>
        <legend style="margin-bottom:10px;">根据时间导出申请列表</legend>
        <form action="/excel/maintain/date/export" method="get">
            <p>  从  <input type="datetime-local" name="start"/>
                到  <input type="datetime-local" name="end"/>
                <button type="submit" value="Submit">导出</button></p>
        </form>
    </fieldset>
</div>
</body>
</html>
