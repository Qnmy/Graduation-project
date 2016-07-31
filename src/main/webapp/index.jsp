<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   
    <title>物流信息网后台</title> 
<!--     <title>My JSP 'index.jsp' starting page</title>
 -->    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    <link href="css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="js/themes/icon.css" />
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min-1.2.0.js"></script>
    <script type="text/javascript" src='js/outlook.js'></script>

    <script type="text/javascript">
var _menus = {
    basic : [ {
        "menuid" : "10",
        "icon" : "icon-sys",
        "menuname" : "网站设置",
        "menus" : [ {
            "menuid" : "101",
            "menuname" : "管理员信息",
            "icon" : "icon-nav",
            "url" : "web_Adminload.action"
        }, {
            "menuid" : "102",
            "menuname" : "权限信息",
            "icon" : "icon-nav",
            "url" : "web_Privilege_load.action"
        }, {
            "menuid" : "103",
            "menuname" : "权限分配",
            "icon" : "icon-nav",
            "url" : "web_AdminPrivilege_load.action"
        } ]
    }, {
        "menuid" : "20",
        "icon" : "icon-sys",
        "menuname" : "基础信息",
        "menus" : [ {
            "menuid" : "201",
            "menuname" : "客户信息",
            "icon" : "icon-nav",
            "url" : "customer_load.action"
        }, {
            "menuid" : "202",
            "menuname" : "车源信息",
            "icon" : "icon-nav",
            "url" : "car_load.action"
        } , {
            "menuid" : "203",
            "menuname" : "线路信息",
            "icon" : "icon-nav",
            "url" : "route_load.action"
        } , {
            "menuid" : "204",
            "menuname" : "车源-线路关联",
            "icon" : "icon-nav",
            "url" : "carroute_load.action"
        } ]
    } , {
        "menuid" : "30",
        "icon" : "icon-sys",
        "menuname" : "业务明细",
        "menus" : [ {
            "menuid" : "301",
            "menuname" : "发货单详情",
            "icon" : "icon-nav",
            "url" : "sendgoods_load.action"
        }]
    } ],
    point : [{
        "menuid" : "20",
        "icon" : "icon-sys",
        "menuname" : "历史订单",
        "menus" : [ {
            "menuid" : "211",
            "menuname" : "订单记录",
            "icon" : "icon-nav",
            "url" : "order_load.action"
        } ]

    }]
};
        //设置登录窗口
        function openPwd() {
            $('#w').window({
                title: '修改密码',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height: 160,
                resizable:false
            });
        }
        //关闭登录窗口
        function closePwd() {
            $('#w').window('close');
        }

        

        //修改密码
        function serverLogin() {
            var $newpass = $('#txtNewPass');
            var $rePass = $('#txtRePass');

            if ($newpass.val() == '') {
                msgShow('系统提示', '请输入密码！', 'warning');
                return false;
            }
            if ($rePass.val() == '') {
                msgShow('系统提示', '请在一次输入密码！', 'warning');
                return false;
            }

            if ($newpass.val() != $rePass.val()) {
                msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
                return false;
            }

            $.post('editpassword.action?newpass=' + $newpass.val(), function(msg) {
                msgShow('系统提示', '恭喜，密码修改成功！', 'info');
                $newpass.val('');
                $rePass.val('');
                closePwd();
            })
            
        }

        $(function() {

            openPwd();

            $('#editpass').click(function() {
                $('#w').window('open');
            });

            $('#btnEp').click(function() {
                serverLogin();
            })

            $('#btnCancel').click(function(){closePwd();})

            $('#loginOut').click(function() {
                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {

                    if (r) {
                        location.href = 'exitSys.action';
                    }
                });
            })
        });
        
        

    </script>
    <style>
    #css3menu li{ float:left; list-style-type:none;}
#css3menu li a{ color:#fff; padding-right:20px;}
#css3menu li a.active{color:yellow;}
</style>
</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
    <noscript>
        <div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
            <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
        </div>
    </noscript>
    <div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        <span style="float:right; padding-right:20px;" class="head">
        	欢迎 <label>${sessionScope.name }</label>
            <a href="#" id="editpass">修改密码</a>
            <a href="#" id="loginOut">安全退出</a>
        </span>

        <span style="padding-left:10px; font-size: 16px; float:left;">
            <img src="images/blocks.gif" width="20" height="20" align="absmiddle" />
            网站后台
        </span>
        <ul id="css3menu" style="padding:0px; margin:0px;list-type:none; float:left; margin-left:40px;">
            <li >
                <a class="active" name="basic" href="javascript:;" title="常用操作">常用操作</a>
            </li>
            <li>
                <a name="point" href="javascript:;" title="历史订单">历史订单</a>
            </li>
        </ul>
    </div>
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">Copyright &copy; 2016-1-2 All rights reserved.</div>
    </div>
    <div region="west" hide="true" split="true" title="导航菜单" style="width:250px;" id="west">
        <div id='wnav' class="easyui-accordion" fit="true" border="false">
            <!--  导航内容 --> </div>

    </div>
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
            <div title="欢迎使用" style="padding:20px;overflow:hidden;" id="home">

            <h1>物流网后台管理系统欢迎您...</h1>

            </div>
        </div>
    </div>

    <!--修改密码窗口-->
    <div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <table cellpadding=3>
                    <tr>
                        <td>新密码：</td>
                        <td>
                            <input id="txtNewPass" type="Password" class="txt01" />
                        </td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td>
                            <input id="txtRePass" type="Password" class="txt01" />
                        </td>
                    </tr>
                </table>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >确定</a>
                <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
            </div>
        </div>
    </div>

    <div id="mm" class="easyui-menu" style="width:150px;">
        <div id="mm-tabupdate">刷新</div>
        <div class="menu-sep"></div>
        <div id="mm-tabclose">关闭</div>
        <div id="mm-tabcloseall">全部关闭</div>
        <div id="mm-tabcloseother">除此之外全部关闭</div>
        <div class="menu-sep"></div>
        <div id="mm-tabcloseright">当前页右侧全部关闭</div>
        <div id="mm-tabcloseleft">当前页左侧全部关闭</div>
        <div class="menu-sep"></div>
        <div id="mm-exit">退出</div>
    </div>
  </body>
</html>
