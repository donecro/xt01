<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/js/routine.js"></script>
    <style type="text/css">
        body{
            background:white;
            margin:0px;
            font-size: 14px;
        }
        .bu{
            margin-top: 10px;
            margin-left: 30px;
            width: 200px;
            background-color: #9ed99d;
            color: white;
            border-radius: 3px;
            border-color: transparent;
        }
    </style>
</head>
<body>
<h1>系统管理</h1>
<hr size="1" width="100%">

<%--学生验证信息数据--%>
<div style="float: left; width:90% ;height:auto;">
    <fieldset>
        <legend style="margin-bottom:10px;">学生验证信息数据</legend>
        <form action="/excel/upload" method="post" enctype="multipart/form-data">
            选择文件:<input type="file" name="upfile" width="120px">
            <input type="submit" value="上传">
            <br/>
        </form>
        <a href="/excel/identity/export">导出</a>
        <a href="/idenclear" onClick="return confirm('您确认要清空学生信息吗？')">清空学生信息</a>
    </fieldset>
</div>

<%--校园网介绍--%>
<div style="float: left;width:40%;height:auto;">
    <fieldset>
        <legend style="margin-bottom:10px;">校园网介绍</legend>
        <form style="width: 300px;height: 180px;" action="/introset" method="post">
            <div>
                <textarea type="text" name="intro" placeholder=${intro} clos=",30" rows="5" warp="virtual" style="height: 140px;width: 400px;"></textarea>
            </div>
            <div>
                <button type="submit">更改</button>
            </div>
        </form>
    </fieldset>
</div>

<%--申请须知--%>
<div style="float: left;width:40%;height:auto;">
    <fieldset>
        <legend style="margin-bottom:10px;">申请须知</legend>
        <form style="width: 300px;height: 180px;" action="/ainforset" method="post">
            <div>
                <textarea type="text" name="ainfor" placeholder=${ainfor} clos=",30" rows="5" warp="virtual" style="height: 140px;width: 400px;"></textarea>
            </div>
            <div>
                <button type="submit">更改</button>
            </div>
        </form>
    </fieldset>
</div>

<%--报修介绍--%>
<div style="float: left;width:40%;height:auto;">
    <fieldset>
        <legend style="margin-bottom:10px;">报修介绍</legend>
        <form style="width: 300px;height: 180px;" action="/minforset" method="post">
            <div>
                <textarea type="text" name="minfor" placeholder=${minfor} clos=",30" rows="5" warp="virtual" style="height: 140px;width: 400px;"></textarea>
            </div>
            <div>
                <button type="submit">更改</button>
            </div>
        </form>
    </fieldset>
</div>

<hr size="1" width="100%">

<%--用户组管理--%>
<div style="float:left;width:650px;height:auto;">
    <fieldset>
        <legend style="margin-bottom:10px;">用户组管理</legend>
        <table width="300" border="0">
            <tr>
                <th scope="col">序号</th>
                <th scope="col">名称</th>
                <th scope="col">操作</th>
            </tr>
            <c:forEach items="${uglist}" var="u">
                <tr>
                    <td align="center">${u.i}</td>
                    <td align="center">${u.s}</td>
                    <td align="center"><a href="/ugdelete?ugname=<c:out value="${u.s}"/>" onClick="return confirm('您确认要删除吗？')">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td align="center">
                    <a href="javascript:void(0);" onClick="Display(3)">添加</a>
                </td>
            </tr>
        </table>
    </fieldset>
</div>

<%--用户组添加--%>
<div style="display:none; float: left;" id="menu3" name="form">
    <br />
    <fieldset>
        <form action="/ugadd" method="post"  style="width: 350px;">
            <br/>
            <div>
                <label style="font-weight: 600">用户组添加</label><br/>
            </div>
            <div>
                <label>用户组:</label>
                <input style="margin-left: 5px;" type="text" name="ugname" />
            </div>
            <div>
                <input class="bu" type="submit" value="添加"/>
            </div>
        </form>
        <button class="bu" onclick="Display(3)">取消</button>
    </fieldset>
</div>

<%--宿舍地址管理--%>
<div style="float:left;width:650px;height:auto;">
    <fieldset>
        <legend style="margin-bottom:10px;">宿舍地址管理</legend>
        <table width="300" border="0" >
            <tr>
                <th scope="col">序号</th>
                <th scope="col">宿舍区</th>
                <th scope="col">操作</th>
            </tr>
            <c:forEach items="${adlist}" var="ad">
                <tr>
                    <td align="center">${ad.i}</td>
                    <td align="center">${ad.build}</td>
                    <td align="center"><a href="/addelete?build=<c:out value="${ad.build}"/>" onClick="return confirm('您确认要删除吗？')">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td align="center">
                    <a href="javascript:void(0);"  onClick="Display(2)">添加</a>
                </td>
            </tr>
        </table>
    </fieldset>
</div>

<%--宿舍地址添加--%>
<div style="display:none; float: left;" id="menu2" name="form">
    <br />
    <fieldset>
        <form action="/adadd" method="post"  style="width: 350px;">
            <br/>
            <div>
                <label style="font-weight: 600">宿舍地址添加</label><br/>
            </div>
            <div>
                <label>校区:</label>
                <input style="margin-left: 5px;" type="text" name="build" />
            </div>
            <div>
                <input class="bu" type="submit" value="添加"/>
            </div>
        </form>
        <button class="bu" onclick="Display(2)">取消</button>
    </fieldset>
</div>

<%--业务类型管理--%>
<div style="float: left;width:650px;height:auto;">
    <fieldset>
        <legend style="margin-bottom:10px;">业务类型管理</legend>
        <table name="bstlist" width="600" border="0" >
            <tr>
                <th scope="col">序号</th>
                <th scope="col">业务类型</th>
                <th scope="col">价格(元/月)</th>
                <th scope="col">价格(元/季度)</th>
                <th scope="col">价格(元/学期)</th>
                <th scope="col">价格(元/学年)</th>
                <th scope="col">操作</th>
            </tr>
            <c:forEach items="${btlist}" var="b">
                <tr style="height: 30px;">
                    <td align="center">${b.i}</td>
                    <td align="center" name="bst">${b.bst}</td>
                    <div>
                        <td style="text-align: center; width: 100px;" id="tab0s${b.i}">${b.mprice}</td>
                        <td style="text-align: center; width: 100px;" id="tab1s${b.i}">${b.sprice}</td>
                        <td style="text-align: center; width: 100px;" id="tab2s${b.i}">${b.yprice}</td>
                        <td style="text-align: center;" id="tab3s${b.i}">
                            <a href="javascript:Upd(${b.i});">更改</a>
                            <a style="margin-left: 20px;" id="del${b.i}" href="" onclick="DelBt('+${b.bst}+',${b.i})">删除</a>
                        </td>
                    </div>

                    <div>
                        <td style="display:none; text-align: center; width: 100px;" id="tab4s${b.i}">
                            <input style="width: 50px;" type="number" id="newmp${b.i}" placeholder=${b.mprice} />
                        </td>
                        <td style="display:none; text-align: center; width: 100px;" id="tab5s${b.i}">
                            <input style="width: 50px;" type="number" id="newsp${b.i}" placeholder=${b.sprice} />
                        </td>
                        <td style="display:none; text-align: center; width: 100px;" id="tab6s${b.i}">
                            <input style="width: 50px;" type="number" id="newyp${b.i}" placeholder=${b.yprice} />
                        </td>
                        <td style="display:none; text-align: center;" id="tab7s${b.i}">
                            <a href="javascript:Upd(${b.i});">取消</a>
                            <a style="margin-left: 20px;" id="sure${b.i}" href="" onclick="Udload('+${b.bst}+',${b.i})">确定</a>
                        </td>
                    </div>
                </tr>
            </c:forEach>
            <tr>
                <td align="center">
                    <a href="javascript:void(0);" onClick="Display(1)">添加</a>
                </td>
            </tr>
        </table>
    </fieldset>
</div>

<%--业务类型添加--%>
<div style="display:none; float: left;" id="menu1" name="form">
    <br />
    <fieldset>
        <form action="/btadd" method="post" style="width: 350px;">
            <br/>
            <div>
                <label style="font-weight: 600">业务类型添加</label><br/>
            </div>
            <div>
                <label>业务类型:</label>
                <input style="margin-left: 5px;" type="text" name="bst" />
            </div>
            <div>
                <label>价格/（元）：</label><br/>
                <label style="margin-left: 30px;">一个月:</label>
                <input style="margin-left: 15px;" type="number" name="mprice" />
            </div>
            <div style="margin-top: 10px">
                <label style="margin-left: 30px;">一个学期:</label>
                <input style="margin-left: 5px;" type="number" name="sprice" />
            </div>
            <div style="margin-top: 10px">
                <label style="margin-left: 30px;">一个季度:</label>
                <input style="margin-left: 5px;" type="number" name="yprice" />
            </div>
            <div>
                <input class="bu" type="submit" value="添加"/>
            </div>
        </form>
        <button class="bu" onclick="Display(1)">取消</button>
    </fieldset>
</div>

</body>
</html>