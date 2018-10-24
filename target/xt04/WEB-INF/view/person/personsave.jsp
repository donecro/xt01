<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>申请信息填写</title>
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
        .tx2{
            margin-left:10%;
            font-weight: 900;
            font-size: 20px;
            color: #95D784;
        }
        option{
            width: 90%;
            height: 33px;
            background-color: whitesmoke;
            border-radius: 5px;
            border-color: #CCCCCC;
            font-size: 20px;
            color: #95D784;
        }
        form{
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
            width: 94%;
            height: 420px;
            border-radius: 10px;
            background:rgba(255, 255, 255, 0.5);
        }
        button{
            margin-top: 20px;
            margin-left: 20%;
            width: 60%;
            height: 40px;
            border-radius: 10px;
            background-color: #95D784;
            color: white;
            border-color: transparent;
            font-weight: 700;
            font-size: 20px;
        }
        .input1{
            width: 50%;
            height: 33px;
            background-color: whitesmoke;
            border-radius: 5px;
            border-color: #CCCCCC;
            font-size: 16px;
            color: #95D784;
        }

        .input2{
            margin-left: 5%;
            width: 90%;
            height: 33px;
            background-color: whitesmoke;
            border-radius: 5px;
            border-color: #CCCCCC;
            font-size: 16px;
            color: #95D784;
        }
        .select1{
            margin-left: 5%;
            width: 90%;
            height: 33px;
            background-color: whitesmoke;
            border-radius: 5px;
            border-color: #CCCCCC;
            font-size: 16px;
            color: #95D784;
        }
        .select2{
            margin-left: 5%;
            width: 25%;
            height: 33px;
            background-color: whitesmoke;
            border-radius: 5px;
            border-color: #CCCCCC;
            font-size: 16px;
            color: #95D784;
        }

    </style>
    <script type="text/javascript">
        function Change(){
            var va = document.f.bst.value;
            console.log(va);
            var j = 0, k = 0,l = 0, q = "", w = "",a = "", e;
            for(var i=0; i<va.length;i++){
                e = va.substring(i,i+1);
                if(e==="#"){
                    k++;
                }else{
                    if(k!=0){
                        if(e===" "){
                            j++;
                        }else{
                            if (j==0) {
                                q += e;
                            }else {
                                if (e==="-") {
                                    l++;
                                }else {
                                    if (l==0){
                                        w += e;
                                    } else {
                                        a += e;
                                    }
                                }

                            }
                        }
                    }
                }
            }
            console.log(q+"<------------->"+w);
            document.f.forlong[0] = new Option("--请选择--");
            document.f.forlong[0].value = "0";
            document.f.forlong[1] = new Option("一个月     ￥" + a);
            document.f.forlong[1].value = "3000";
            document.f.forlong[2] = new Option("一个季度   ￥" + w);
            document.f.forlong[2].value = "3002";
            document.f.forlong[3] = new Option("一个学期   ￥" + q);
            document.f.forlong[3].value = "3001";
            document.f.forlong.focus();
        }
    </script>
</head>
<body>
<form action="/apply/pay" method="POST" name="f">
    <br/>

    <div class="tx1">
        <label class="">地址：</label><br/>
    </div>
    <select class="select2" name="add1" required="required" pattern="[\u4e00-\u9fa5]{1，10}" oninvalid="setCustomValidity('请选择校区')" oninput="setCustomValidity('')">
        <option value="">请选择</option>
        <c:forEach items="${adlist}" var="a" varStatus="vs">
            <option value="${a.build}">${a.build}</option>
        </c:forEach>
    </select>
    <input class="input1" type="text" name="add2" placeholder="例：X栋XXX" required="required" pattern=" [0-9]{1,2}+[\u4e00-\u9fa5]{1，2}+[0-9]{2,4}$" oninvalid="setCustomValidity('格式：X栋XXX')" oninput="setCustomValidity('')"/><br>

    <div class="tx">
        <label>用户组：</label><br/>
    </div>
    <select class="select1" name="usergroup" required="required" pattern="[\u4e00-\u9fa5]{1，20}" oninvalid="setCustomValidity('请选择用户组')" oninput="setCustomValidity('')">
        <option value="">==请选择==</option>
        <c:forEach items="${uglist}" var="u" varStatus="vs">
            <option value="${u.s}">${u.s}</option>
        </c:forEach>
    </select>

    <div class="tx">
        <label>业务类型：</label><br/>
    </div>
    <select class="select1" name="bst" onchange="Change()" required="required" pattern="[\u4e00-\u9fa5]{2，20}" oninvalid="setCustomValidity('请选择办理业务类型')" oninput="setCustomValidity('')">
        <option value="0">==请选择==</option>
        <c:forEach items="${btlist}" var="b" varStatus="vs">
            <option value="${b.bst}###${b.sprice}  ${b.yprice}--${b.mprice}">${b.bst}</option>
        </c:forEach>
    </select>

    <div class="tx">
        <label>办理时长：</label><br/>
    </div>
    <select class="select1" name="forlong" required="required" pattern="^([0-9]){4}" oninvalid="setCustomValidity('请选择办理时长')" oninput="setCustomValidity('')">
        <option value="0">==请选择==</option>
    </select>

    <button type="submit" value="支付">支付</button>
</form>

</body>
</html>