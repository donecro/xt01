<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <script charset="UTF-8" src="/js/jquery-3.3.1.min.js"></script>
    <script charset="UTF-8" src="/js/jquery-3.3.1.slim.min.js"></script>
    <link rel="stylesheet" href="/css/style.css"/>
    <script type="text/javascript">
        function showLayer() {
            var obj  = document.getElementById("layer");
            var winWidth = document.documentElement.clientWidth;
            var winHeight = document.documentElement.clientHeight;
            var offsetTop = document.documentElement.offsetTop;
            var left = (winWidth - 500)/2;
            var top  = (winHeight - 400)/2 + offsetTop;
            obj.style.top = top + "px";
            obj.style.width = "360px";
            obj.style.height = "450px";
            obj.style.left = left + "px";
            obj.style.backgroundColor = "white";
            obj.style.border = "2px solid gray";
            obj.style.borderRadius = "10px";
            obj.style.display = "block";
        }
        function hideLayer() {
            var obj = document.getElementById("layer");
            obj.style.display = "none";
        }
    </script>
</head>
<body>
  <h1>管理员管理</h1>
    <hr size="1" width="100%">
  <div style="width:90%;height:auto;">
      <fieldset>
          <legend style="margin-bottom:10px;">管理员添加</legend>
          <div>
              <a href="javascript:;" onclick="showLayer()">添加管理员入口</a>
          </div>
      </fieldset>
  </div>
  <form style="font-size: 20px; display: none;position:absolute;" id="layer" action="/addadmin" method="post">
      <p style="margin-left: 30px;font-size: 22px;font-weight: 700">管理员添加</p>
      <p>
          <label style="margin-left: 30px">账  号: </label><br/>
          <input style="margin-left: 30px;width: 300px;height: 30px; font-size: 20px; " type="text" name="newaccount" />
      </p>
      <p>
          <label style="margin-left: 30px">用户名: </label><br/>
          <input style="margin-left: 30px;width: 300px;height: 30px; font-size: 20px; " type="text" name="newusername" />
      </p>
      <p>
          <label style="margin-left: 30px">密  码: </label><br/>
          <input style="margin-left: 30px;width: 300px;height: 30px; font-size: 20px; " type="password" name="newpassword" />
      <p>

      <p>
          <label style="margin-left: 30px">权  限: </label><br/>
          <input style="margin-left: 30px; margin-right: 20px;" type="radio" value="40002" name="newpower">普通管理员</input>
          <input type="radio" value="40001" name="newpower">超级管理员</input>

      </p>

          <input style="margin-left: 60px; margin-right: 60px; width: 90px;height: 30px;" type="button" onclick="hideLayer()" value="取消">
          <input style="margin-left: auto; margin-right: auto; width: 90px;height: 30px;" type="submit" value=" 添 加 " />
      </p>

  </form>

  <div style="width:90%;height:auto;">
      <fieldset>
          <legend style="margin-bottom:10px;">管理员列表</legend>
      <table  width="500" border="0">
          <tr>
              <th scope="col">序号</th>
              <th scope="col">账号</th>
              <th scope="col">用户名</th>
              <th scope="col">权限</th>
              <th scope="col">操作</th>
              <th scope="col">删除</th>
          </tr>
        <c:forEach items="${adminlist}" var="a">
          <tr>
              <td align="center">${a.id}</td>
              <td align="center">${a.account}</td>
              <td align="center">${a.username}</td>
              <td align="center">${a.powerinfo}</td>
              <td align="center">
                  <c:if test="${a.power==40001}">
                      <a href="/adminpower?iaccount=<c:out value="${a.account}&ipower=40002"/>" onClick="return confirm('您确认要将其设为普通管理员？')">设为普通管理员</a>
                  </c:if>
                  <c:if test="${a.power==40002}">
                      <a href="/adminpower?iaccount=<c:out value="${a.account}&ipower=40001"/>" onClick="return confirm('您确认要将其设为超级管理员？')">设为超级管理员</a>
                  </c:if>
              </td>
              <td align="center">
                  <a href="/adddelete?account=<c:out value="${a.account}"/>" onClick="return confirm('您确认要删除吗？')">删除</a>
              </td>
          </tr>
        </c:forEach>
      </table>
      </fieldset>
  </div>
</body>
</html>