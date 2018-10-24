
/*
 * Don Routine v1.0.0
 * Released under the DON license
 */
    function onBridgeReady() {
        var appId = $("input[name='appId']").val();
        var nonceStr = $("input[name='nonceStr']").val();
        var prepayId = $("input[name='prepayId']").val();
        var paySign = $("input[name='paySign']").val();
        var timeStamp = $("input[name='timeStamp']").val();
        WeixinJSBridge.invoke('getBrandWCPayRequest', {
            "appId": appId,
            "timeStamp": timeStamp,
            "nonceStr": nonceStr,
            "package": prepayId,
            "signType": "MD5",
            "paySign": paySign
        }, function (res) {
            console.log(res)
            if (res.err_msg == "get_brand_wcpay_request:ok") {
                location.href = "http://www.cnmit.net/qweasdzxc/add";
                alert("支付成功");
            } else {//这里支付失败和支付取消统一处理
                alert("支付取消");
                // location.href = "http://www.donecro.cn/qw/defeat";
            }
        });
    }

    $(document).ready(
    function() {
        if (typeof WeixinJSBridge == "undefined") {
            if (document.addEventListener) {
                document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
                console.log(1);
            } else if (document.attachEvent) {
                console.log(3);
                document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
            }
        } else {
            console.log(2);
            onBridgeReady();
        }
    });



    function Display(id) {
        which = eval("menu"+id);
        if (which.style.display == "none")
        {
            eval("menu"+id+".style.display=\"\"; ");
        }else{
            eval("menu"+id+".style.display=\"none\";");
        }
    };

    function showLayer() {
        var obj = document.getElementById("layer");
        var winWidth = document.documentElement.clientWidth;
        var winHeight = document.documentElement.clientHeight;
        var offsetTop = document.documentElement.offsetTop;
        var left = (winWidth - 500) / 2;
        var top = (winHeight - 400) / 2 + offsetTop;
        obj.style.top = top + "px";
        obj.style.width = "360px";
        obj.style.height = "450px";
        obj.style.left = left + "px";
        obj.style.backgroundColor = "white";
        obj.style.border = "2px solid gray";
        obj.style.borderRadius = "10px";
        obj.style.display = "block";
    };

    function hideLayer() {
        var obj = document.getElementById("layer");
        obj.style.display = "none";
    };

    function validate() {
        var pw1 = document.getElementById("pw1").value;
        var pw2 = document.getElementById("pw2").value;
        if (pw1 == pw2) {
            document.getElementById("tishi").innerHTML = "<font color='green'>两次密码吻合</font>";
            document.getElementById("submit").disabled = false;
        } else {
            document.getElementById("tishi").innerHTML = "<font color='red'>两次密码不吻合</font>";
            document.getElementById("submit").disabled = true;
        }
    };

    function Upd(id) {

        which = eval("tab4s"+id);

        if (which.style.display == "none") {
            eval("tab0s"+id+".style.display=\"none\";");
            eval("tab1s"+id+".style.display=\"none\";");
            eval("tab2s"+id+".style.display=\"none\";");
            eval("tab3s"+id+".style.display=\"none\";");
            eval("tab4s"+id+".style.display=\"\"; ");
            eval("tab5s"+id+".style.display=\"\"; ");
            eval("tab6s"+id+".style.display=\"\"; ");
            eval("tab7s"+id+".style.display=\"\"; ");
        }else{
            eval("tab0s"+id+".style.display=\"\"; ");
            eval("tab1s"+id+".style.display=\"\"; ");
            eval("tab2s"+id+".style.display=\"\"; ");
            eval("tab3s"+id+".style.display=\"\"; ");
            eval("tab4s"+id+".style.display=\"none\";");
            eval("tab5s"+id+".style.display=\"none\";");
            eval("tab6s"+id+".style.display=\"none\";");
            eval("tab7s"+id+".style.display=\"none\";");
        }
    };

    function Udload(bst,a) {
        str = ToFalse(bst);
        $.ajax(
            '/btupdate',{
                type: 'get',
                async:true,
                data:{
                    'bst': str,
                    'newmp': $('#newmp' + a).val(),
                    'newqp': $('#newqp' + a).val(),
                    'newsp': $('#newsp' + a).val(),
                    'newyp': $('#newyp' + a).val()
                },
                // dataType: 'json',
                // beforeSend: function(request) {
                //     request.setRequestHeader("Authorization",'token ' + Cookies.get('token'));
                // },
                success: function(data) {

                },
                error: function (data) {

                }
            })

        var pma = 'bst=' + str;
        var pms = '&newmp=' + $('#newmp' + a).val();
        var pmd = '&newsp=' + $('#newsp' + a).val();
        var pmf = '&newyp=' + document.getElementById("newyp"+a).value;
        document.getElementById("sure"+a).href = '/btupdate?' + pma + pms + pmd + pmf;
    };

    function ToFalse(x) {
        var str = '',st;
        var bs = x.substring(1,bst.length-1);
        for (var i = 0; i < bs.length; i++) {
            st = bs.substring(i, i + 1);
            switch (st) {
                case "%":
                    str += "zxcp";
                    break;
                case "+":
                    str += "vbnl";
                    break;
                default:
                    str += st;
                    break;
            }
        }
        return str;
    };

    function getMtList(x) {
        var page, curPage, total, totalPage;
        var str = '',tostr = '';
        curPage = $('#curPage').text();
        totalPage = $('#totalPage').text()

        console.log(curPage + '----' + totalPage);

        if (x === 1) {
            page = 1;
        } else if (x === 'l') {
            page = 1;
        } else if (x === 'n') {
            page = curPage - 1;
        } else if (x === 'm') {
            page = parseInt(curPage) + 1;
        } else {
            page = totalPage;
        }

        $("#getuname").text(Cookies.get('username'));
        $.ajax(
            "/mtdata",
            {
                type: 'get',
                async: true,
                data: {
                    'page': page,
                },
                dataType: 'json',
                beforeSend: function (request) {
                    request.setRequestHeader("Authorization", 'token ' + Cookies.get('token'));
                },
                success: function (data) {
                    console.log(data);
                    if (data.count !== 0) {
                        $(".total").append('总数：' + data.data.count);
                        $(".tototal").append('总数：' + data.data.tocount);
                        str += "<tr><th style='text-align:center;'>姓名</th>" +
                            "<th style='text-align:center;'>校园网账号</th>" +
                            "<th style='text-align:center;'>联系电话</th>" +
                            "<th style='text-align:center;'>校区</th>" +
                            "<th style='text-align:center;'>宿舍地址</th>" +
                            "<th style='text-align:center;'>内容</th>" +
                            "<th style='text-align:center;'>申请时间</th></tr>";
                        tostr += str;
                        for (var i = 0; i < data.data.list.length; i++) {
                            str += "<tr><td style='text-align:center;'>" +
                                data.data.list[i].username +
                                "</td><td style='text-align:center;'>" +
                                data.data.list[i].account +
                                "</td><td style='text-align:center;'>" +
                                data.data.list[i].callnum +
                                "</td><td style='text-align:center;'>" +
                                data.data.list[i].campus +
                                "</td><td style='text-align:center;'>" +
                                data.data.list[i].address +
                                "</td><td style='text-align:center;'>" +
                                data.data.list[i].content +
                                "</td><td style='text-align:center;'>" +
                                data.data.list[i].date +
                                "</td></tr>"
                        };
                        for (var i = 0; i < data.data.tolist.length; i++) {
                            tostr += "<tr><td style='text-align:center;'>" +
                                data.data.tolist[i].username +
                                "</td><td style='text-align:center;'>" +
                                data.data.tolist[i].account +
                                "</td><td style='text-align:center;'>" +
                                data.data.tolist[i].callnum +
                                "</td><td style='text-align:center;'>" +
                                data.data.tolist[i].campus +
                                "</td><td style='text-align:center;'>" +
                                data.data.tolist[i].address +
                                "</td><td style='text-align:center;'>" +
                                data.data.tolist[i].content +
                                "</td><td style='text-align:center;'>" +
                                data.data.tolist[i].date +
                                "</td></tr>"
                        }
                        $(".maintainlist").append(str)
                        $(".tomaintainlist").append(tostr)
                        curPage = page;
                        $('#curPage').text(curPage);
                        console.log(data.list);
                    } else {
                        alert('No Data');
                    }
                },
                error: function (data) {
                    alert('Please Login');
                    console.log(data);
                }
            });
    };

    function getApList(x) {
        var page, curPage, total, totalPage;
        var str = '',tostr = '';
        curPage = $('#curPage').text();
        totalPage = $('#totalPage').text()

        console.log(curPage + '----' + totalPage);

        if (x === 1) {
            page = 1;
        } else if (x === 'l') {
            page = 1;
        } else if (x === 'n') {
            page = curPage - 1;
        } else if (x === 'm') {
            page = parseInt(curPage) + 1;
        } else {
            page = totalPage;
        }
        $("#getuname").text(Cookies.get('username'));
        $.ajax(
            "/apdata",
            {
                type: 'get',
                async: true,
                data: {
                    'page': page,
                },
                dataType: 'json',
                beforeSend: function (request) {
                    request.setRequestHeader("Authorization", 'token ' + Cookies.get('token'));
                },
                success: function (data) {
                    console.log(data);
                    if (data.code === 200) {
                        $(".total").append('总数：' + data.data.count);
                        $(".tototal").append('总数：' + data.data.tocount);
                        str += "<tr><th style='text-align:center;'>姓名</th>" +
                            "<th style='text-align:center;'>性别</th>" +
                            "<th style='text-align:center;'>学号</th>" +
                            "<th style='text-align:center;'>联系电话</th>" +
                            "<th style='text-align:center;'>用户组</th>" +
                            "<th style='text-align:center;'>业务类型</th>" +
                            "<th style='text-align:center;'>办理时长</th>" +
                            "<th style='text-align:center;'>地址</th>" +
                            "<th style='text-align:center;'>申请时间</th>" +
                            "<th style='text-align:center;'>密码</th></tr>";
                        tostr += str;
                        for (var i = 0; i < data.data.list.length; i++) {
                            str += "<tr><td style='text-align:center;'>" +
                                data.data.list[i].username +
                                "</td><td style='text-align:center;'>" +
                                data.data.list[i].sex +
                                "</td><td style='text-align:center;'>" +
                                data.data.list[i].uid +
                                "</td><td style='text-align:center;'>" +
                                data.data.list[i].callnum +
                                "</td><td style='text-align:center;'>" +
                                data.data.list[i].usergroup +
                                "</td><td style='text-align:center;'>" +
                                data.data.list[i].businesstype +
                                "</td><td style='text-align:center;'>" +
                                data.data.list[i].forlong +
                                "</td><td style='text-align:center;'>" +
                                data.data.list[i].address +
                                "</td><td style='text-align:center;'>" +
                                data.data.list[i].applytime +
                                "</td><td style='text-align:center;'>" +
                                data.data.list[i].password +
                                "</td></tr>"
                        };
                        for (var i = 0; i < data.data.tolist.length; i++) {
                            tostr += "<tr><td style='text-align:center;'>" +
                                data.data.tolist[i].username +
                                "</td><td style='text-align:center;'>" +
                                data.data.tolist[i].sex +
                                "</td><td style='text-align:center;'>" +
                                data.data.tolist[i].uid +
                                "</td><td style='text-align:center;'>" +
                                data.data.tolist[i].callnum +
                                "</td><td style='text-align:center;'>" +
                                data.data.tolist[i].usergroup +
                                "</td><td style='text-align:center;'>" +
                                data.data.tolist[i].businesstype +
                                "</td><td style='text-align:center;'>" +
                                data.data.tolist[i].forlong +
                                "</td><td style='text-align:center;'>" +
                                data.data.tolist[i].address +
                                "</td><td style='text-align:center;'>" +
                                data.data.tolist[i].applytime +
                                "</td><td style='text-align:center;'>" +
                                data.data.tolist[i].password +
                                "</td></tr>"
                        }
                        $(".applylist").append(str)
                        $(".toapplylist").append(tostr)
                        curPage = page;
                        $('#curPage').text(curPage);
                        console.log(data.data.list);
                    } else {
                        alert('No Data');
                    }
                },
                error: function (data) {
                    alert('Please Login');
                    console.log(data);
                }
            });
    };

    function getSetting() {
        var ad = '';
        var bt = '';
        var ug = '';
        $.ajax(
            "/stdata",
            {
                type: 'get',
                async:true,
                data:{
                },
                dataType: 'json',
                beforeSend: function(request) {
                    request.setRequestHeader("Authorization",'token ' + Cookies.get('token'));
                },
                success: function(data){
                    console.log(data);
                    $(".intro").val(data.data.intro);
                    $(".ainfor").val(data.data.ainfor);
                    $(".minfor").val(data.data.minfor);
                    ug += "<tr><th style='text-align:center;'>序号</th>" +
                          "<th style='text-align:center;'>名称</th>" +
                          "<th style='text-align:center;'>操作</th></tr>";

                    ad += "<tr><th style='text-align:center;'>序号</th>" +
                          "<th style='text-align:center;'>宿舍区</th>" +
                          "<th style='text-align:center;'>操作</th></tr>";

                    bt += "<tr><th style='text-align:center;'>序号</th>" +
                          "<th style='text-align:center;'>业务类型</th>" +
                          "<th style='text-align:center;'>价格(元/月)</th>" +
                          "<th style='text-align:center;'>价格(元/季度)</th>" +
                          "<th style='text-align:center;'>价格(元/学期)</th>" +
                          "<th style='text-align:center;'>价格(元/学年)</th>" +
                          "<th style='text-align:center;'>操作</th></tr>";


                    /** @namespace data.uglist */
                    for(var i = 0 ; i < data.data.uglist.length ; i++) {
                        ug += "<tr><td style='text-align:center;'>" +
                            data.data.uglist[i].i +
                            "</td><td style='text-align:center;'>" +
                            data.data.uglist[i].s +
                            "</td><td style='text-align:center;'><a href='javascript:ugdel(" +
                            data.data.uglist[i].i +
                            ");'>删除</a></td></tr>"
                    }

                    /** @namespace data.adlist */
                    for(var i = 0 ; i < data.data.adlist.length ; i++) {
                        ad += "<tr><td style='text-align:center;'>" +
                            data.data.adlist[i].i +
                            "</td><td style='text-align:center;'>" +
                            data.data.adlist[i].build +
                            "</td><td style='text-align:center;'><a href='javascript:addel(" +
                            data.data.adlist[i].i +
                            ");'>删除</a></td></tr>"
                    }

                    /** @namespace data.btlist */
                    for(var i = 0 ; i < data.data.btlist.length ; i++) {
                        bt += "<tr><td style='text-align:center;'>" +
                            data.data.btlist[i].i +
                            "</td><td style='text-align:center;'>" +
                            data.data.btlist[i].bst +
                            "</td><td style='text-align:center;'>" +
                            data.data.btlist[i].mprice +
                            "</td><td style='text-align:center;'>" +
                            data.data.btlist[i].qprice +
                            "</td><td style='text-align:center;'>" +
                            data.data.btlist[i].sprice +
                            "</td><td style='text-align:center;'>" +
                            data.data.btlist[i].yprice +
                            "</td><td style='text-align:center;'><a href='javascript:btupdate(" +
                            data.data.btlist[i].i +
                            ");'>更改</a><a style='margin-left: 20px;' href='javascript:btdel(" +
                            data.data.btlist[i].i +
                            ");'>删除</a></td></tr>"
                    }

                    $(".uglist").append(ug);
                    $(".adlist").append(ad);
                    $(".btlist").append(bt);
                },
                error: function(data){
                    alert('Please Login');
                    console.log(data);
                }
            });
    };

    function getAdminMng() {
        var str = '';
        $("#getuname").text(Cookies.get('username'));
        $.ajax(
            "/admngdata",
            {
                type: 'get',
                async: true,
                dataType: 'json',
                beforeSend: function (request) {
                    request.setRequestHeader("Authorization", 'token ' + Cookies.get('token'));
                },
                success: function (data) {
                    console.log(data);
                    if (data.data.count !== 0) {
                        $(".admintotal").append('管理员数量：' + data.data.count);
                        str += "<tr><th style='text-align:center;'>序号</th>" +
                            "<th style='text-align:center;'>账号</th>" +
                            "<th style='text-align:center;'>用户名</th>" +
                            "<th style='text-align:center;'>权限</th>" +
                            "<th style='text-align:center;'>操作</th>" +
                            "<th style='text-align:center;'>删除</th></tr>";
                        for (var i = 0; i < data.data.list.length; i++) {
                            str += "<tr><td style='text-align:center;'>" +
                                data.data.list[i].id +
                                "</td><td style='text-align:center;'>" +
                                data.data.list[i].account +
                                "</td><td style='text-align:center;'>" +
                                data.data.list[i].username +
                                "</td><td style='text-align:center;'>" +
                                turn(data.data.list[i].power) +
                                "</td><td style='text-align:center;'>" +
                                turn('re' + data.data.list[i].power) +
                                "</td><td style='text-align:center;'><a href='javascript:admindel(" +
                                data.data.list[i].id +
                                ");'>删除</a></td></tr>"
                        }
                        $(".adminlist").append(str)
                        console.log(data.data.list);
                    } else {
                        alert('No Data');
                    }
                },
                error: function (data) {
                    alert('Please Login');
                    console.log(data);
                }
            });
    };
    
    function login() {
        console.log($("#account").val());
        console.log($("#password").val());
        $.ajax(
            '/admin/login', {
                type: 'post',
                async: true,
                data: {
                    'account' : $("#account").val(),
                    'password': $("#password").val()
                },
                beforeSend: function (request) {
                    request.setRequestHeader("Authorization", 'token ' + Cookies.get('token'));
                },
                success: function (data) {
                    console.log(data);

                    // if (data.code === 200) {
                    //     Cookies.set('account',data.account);
                    //     Cookies.set('username',data.username);
                    //     Cookies.set('last_name',data.user.last_name);
                    //     Cookies.set('token',data.token);
                    //     window.location.href="/second"
                    // } else if (data.code === 400) {
                    //     alert('USERNAME OR PASSWORD ERROR');
                    // }
                },
                error: function (data) {
                    alert('USERNAME OR PASSWORD ERROR...');
                    console.log(data);

                }
            });
    }

    function btdel(x) {
        var c = confirm('您确认要删除吗？')
        if (c == true) {
            $.ajax(
                '/btdel', {
                    type: 'post',
                    async: true,
                    data: {
                        id: x,
                    },
                    dataType: 'json',
                    beforeSend: function(request) {
                         request.setRequestHeader("Authorization",'token ' + Cookies.get('token'));
                    },
                    success: function () {
                        reframe('删除成功')
                        window.location.reload();
                    },
                    error: function () {
                        reframe('删除失败')
                    }
                })
        } else {
            console.log('Cencer');
        }
    };
    function btadd(x) {
        $.ajax(
            '/btadd', {
                type: 'post',
                async: true,
                data: {
                    id: x,
                },
                dataType: 'json',
                beforeSend: function(request) {
                    request.setRequestHeader("Authorization",'token ' + Cookies.get('token'));
                },
                success: function () {
                    reframe('添加成功')
                    window.location.reload();
                },
                error: function () {
                    reframe('添加失败')
                }
            })
    };

    function ugdel(x) {
        var c = confirm('您确认要删除吗？')
        console.log('---->>' + x)
        if (c == true) {
            $.ajax(
                '/ugdel', {
                    type: 'post',
                    async: true,
                    data: {
                        'id': x
                    },
                    dataType: 'json',
                    beforeSend: function(request) {
                        request.setRequestHeader("Authorization",'token ' + Cookies.get('token'));
                    },
                    success: function () {
                        reframe('删除成功')
                        window.location.reload();
                        reframe('删除成功')
                    },
                    error: function () {
                        reframe('删除失败')
                    }
                })
        } else {
            console.log('Cencer');
        }
    };
    function ugadd(x) {
        $.ajax(
            '/ugadd', {
                type: 'post',
                async: true,
                data: {
                    id: x,
                },
                dataType: 'json',
                beforeSend: function (request) {
                    request.setRequestHeader("Authorization", 'token ' + Cookies.get('token'));
                },
                success: function () {
                    reframe('添加成功')
                    window.location.reload();
                },
                error: function () {
                    reframe('添加失败')
                }
            })
    };

    function addel(x) {
        var c = confirm('您确认要删除吗？')
        if (c == true) {
            $.ajax(
                '/addel', {
                    type: 'delete',
                    async: true,
                    data: {
                        id: x,
                    },
                    dataType: 'json',
                    beforeSend: function(request) {
                        request.setRequestHeader("Authorization",'token ' + Cookies.get('token'));
                    },
                    success: function () {
                        reframe('删除成功')
                        window.location.reload();
                    },
                    error: function () {
                        reframe('删除失败')
                    }
                })
        } else {
            console.log('Cencer');
        }
    };
    function adadd(x) {
        $.ajax(
            '/adadd', {
                type: 'post',
                async: true,
                data: {
                    id: x,
                },
                dataType: 'json',
                beforeSend: function (request) {
                    request.setRequestHeader("Authorization", 'token ' + Cookies.get('token'));
                },
                success: function () {
                    reframe('添加成功')
                    window.location.reload();
                },
                error: function () {
                    reframe('添加失败')
                }
            })
    };

    function admindel(x) {
        var c = confirm('您确认要删除吗？')
        if (c == true) {
            $.ajax(
                '/admin/del', {
                    type: 'delete',
                    async: true,
                    data: {
                        id: x,
                    },
                    dataType: 'json',
                    beforeSend: function(request) {
                        request.setRequestHeader("Authorization",'token ' + Cookies.get('token'));
                    },
                    success: function () {
                        reframe('删除成功')
                        window.location.reload();
                    },
                    error: function () {
                        reframe('删除失败')
                    }
                })
        } else {
            console.log('Cencer');
        }
    };
    
    function reframe(x)  {
        console.log(x);
        layer.msg(x,{
            offset: 't',
            time:3000
        });
    };

    function addframe(x) {
        var hid;
        if (x === 1) {
            hid = '280px';
        } else if (x === 2) {
            hid = '350px';
        } else if (x === 3) {
            hid = '530px';
        }
        layer.open({
            type: 0,
            title: false,
            area: ['360px', hid],
            fixed: false, //不固定
            maxmin: true,
            content: frameval(x)
        });
    };

    function frameval(x) {
        if (x === 1) {
            return "<div class='container-fluid'><div style='margin: 0'><h1>添加用户组</h1><hr size='1' width='100%'><div>" +
                "<p><label style='margin-top: 10px'>请输入新用户组名称:   </label><br/><input class='addinput' type='text' name='newpassword' id='bst'></p>" +
               "</div></div></div>"
        } else if (x === 2) {
            return "<div class='container-fluid'><div style='margin: 0'><h1>添加宿舍地址</h1><hr size='1' width='100%'><div>" +
                "<p><label style='margin-top: 10px'>请输入新宿舍地址名称: </label><br/><input class='addinput' type='text' name='newpassword' id='bst'></p>" +
                "<p><label>宿舍栋数： </label><br/><input class='addinput' type='number' name='newpassword' id='mprice'></p>" +
                "</div></div></div> "
        } else if (x === 3) {
            return "<div class='container-fluid'><div style='margin: 0'><h1>添加业务类型</h1><hr size='1' width='100%'><div>" +
                "<p><label style='margin-top: 10px'>请输入新业务类型名称: </label><br/><input class='addinput' type='text' name='bst' id='bst'></p>" +
                "<p><label>价格(元/月):   </label><br/><input class='addinput' type='number' name='mprice' id='mprice'></p>" +
                "<p><label>价格(元/季度): </label><br/><input class='addinput' type='number' name='qprice' id='qprice'></p>" +
                "<p><label>价格(元/学期): </label><br/><input class='addinput' type='number' name='sprice' id='sprice'></p>" +
                "<p><label>价格(元/学年): </label><br/><input class='addinput' type='number' name='yprice' id='yprice'></p>" +
                "</div></div></div> "
        }
    };
    
    function turn(x) {
        if (40001) {
            return '超级管理员';
        } else if (40002) {
            return '普通管理员';
        } else if ('超级管理员') {
            return 40001;
        } else if ('普通管理员') {
            return 40002;
        } else if ('re40001') {
            return '设为普通管理员';
        } else if ('re40002') {
            return '设为超级管理员';
        }
    }