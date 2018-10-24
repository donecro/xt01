<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
      <style type="text/css">
          body{
              background:white;
              margin:0px;
              font-size: 14px;
          }
      </style>
  	 <title></title>
  </head>

  <body>
  <div id="alist"></div>
  <h1>申请列表</h1>
  <hr size="1" width="100%">
  <div style=" margin-top: 10px;width:95%;height:auto;">
      <fieldset>
          <legend style="margin-bottom:10px;"><font color=black>今日申请名单</font></legend>
          <p>总数：${topagebean.totalCount}</p>
          <table width="1000" border="0" >
              <thead>
              <tr>
                  <th scope="col">姓名</th>
                  <th scope="col">性别</th>
                  <th scope="col">学号</th>
                  <th scope="col">电话号码</th>
                  <th scope="col">用户组</th>
                  <th scope="col">业务类型</th>
                  <th scope="col">办理时长</th>
                  <th scope="col">地址</th>
                  <th scope="col">申请时间</th>
              </tr>
              <c:forEach items="${tolist}" var="apply">
                  <tr>
                      <td align="center">${apply.username}</td>
                      <td align="center">${apply.sex}</td>
                      <td align="center">${apply.uid}</td>
                      <td align="center">${apply.callnum}</td>
                      <td align="center">${apply.usergroup}</td>
                      <td align="center">${apply.businesstype}</td>
                      <td align="center">${apply.forlong}</td>
                      <td align="center">${apply.address}</td>
                      <td align="center">${apply.applytime}</td>
                  </tr>
              </c:forEach>
              <tr>
                  <td colspan="3">
                      <a >当前 ${topagebean.currentPage }/${topagebean.totalPage}页 </a>
                      <c:if test="${topagebean.currentPage != 1}">
                          <a href="/applylist?tocurpage=<c:out value="1"/>">首页</a>
                          <a href="/applylist?tocurpage=<c:out value="${topagebean.currentPage - 1}"/>">上一页</a>
                      </c:if>
                      <c:if test="${topagebean.currentPage != topagebean.totalPage}">
                          <a href="/applylist?tocurpage=<c:out value="${topagebean.currentPage + 1}"/>">下一页</a>
                          <a href="/applylist?tocurpage=<c:out value="${topagebean.totalPage}"/>">末页</a>
                      </c:if>
                  </td>
              </tr>

              <tr>
                  <td>
                      <a href="/excel/today/export">导出</a>
                  </td>
              </tr>
              </thead>
          </table>
      </fieldset>
  </div>

      <div style=" margin-top: 10px;width:95%;height:auto;">
          <fieldset>
              <legend style="margin-bottom:10px;"><font color=black>申请名单</font></legend>
              <p>总数：${pagebean.totalCount}</p>
              <table width="1000" border="0" >
  <thead>
    <tr>
    <th scope="col">姓名</th>
    <th scope="col">性别</th>
    <th scope="col">学号</th>
    <th scope="col">电话号码</th>
    <th scope="col">用户组</th>
    <th scope="col">业务类型</th>
    <th scope="col">办理时长</th>
    <th scope="col">地址</th>
    <th scope="col">申请时间</th>
    </tr>
    <c:forEach items="${list}" var="apply"  varStatus="i">
        <tr>
            <td align="center">${apply.username}</td>
            <td align="center">${apply.sex}</td>
            <td align="center">${apply.uid}</td>
            <td align="center">${apply.callnum}</td>
            <td align="center">${apply.usergroup}</td>
            <td align="center">${apply.businesstype}</td>
            <td align="center">${apply.forlong}</td>
            <td align="center">${apply.address}</td>
            <td align="center">${apply.applytime}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="3">
            <a >当前 ${pagebean.currentPage }/${pagebean.totalPage}页 </a>
            <c:if test="${pagebean.currentPage != 1}">
                <a href="/applylist?curpage=<c:out value="1"/>">首页</a>
                <a href="/applylist?curpage=<c:out value="${pagebean.currentPage - 1}"/>">上一页</a>
            </c:if>
            <c:if test="${pagebean.currentPage != pagebean.totalPage}">
                <a href="/applylist?curpage=<c:out value="${pagebean.currentPage + 1}"/>">下一页</a>
                <a href="/applylist?curpage=<c:out value="${pagebean.totalPage}"/>">末页</a>
            </c:if>
        </td>
    </tr>

    <tr>
        <td>
            <a href="/excel/export">导出</a>
        </td>
    </tr>
  </thead>
              </table>
          </fieldset>
      </div>


  <div style="float: left; width:95% ;height:auto;">
      <fieldset>
          <legend style="margin-bottom:10px;">根据时间导出申请列表</legend>
          <form action="/excel/date/export" method="get">
              <p>  从  <input type="datetime-local" name="start"/>
                  到  <input type="datetime-local" name="end"/>
                  <button type="submit" value="Submit">导出</button></p>
          </form>
      </fieldset>
  </div>


  </body>
</html>
