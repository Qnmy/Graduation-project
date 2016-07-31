<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sendgoods.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
    <link rel="stylesheet" type="text/css" href="themes/color.css">
    <link rel="stylesheet" type="text/css" href="js/demo/demo.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    
    <script type="text/javascript">
    	$(document).ready(function(){
    		$('#dg').datagrid({url:'sendgoods_get.action'});
    	});	
    </script>
    
    <style type="text/css">
        body{
            margin-left: 100px;
        }
        #fm{
            margin:0;
            padding:10px 30px;
        }
        .ftitle{
            font-size:14px;
            font-weight:bold;
            padding:5px 0;
            margin-bottom:10px;
            border-bottom:1px solid #ccc;
        }
        .fitem{
            margin-bottom:5px;
        }
        .fitem label{
            display:inline-block;
            width:80px;
        }
        .fitem input{
            width:160px;
        }
    </style>
</head>
<body>
    <h2>发货单详情</h2>
    <p>对未完成的发货单进行相关操作<br/>
    	线路编号：<br/>
    		1. 北京-天津<br/>
    		2. 北京-上海<br/>
    		3. 北京-广州<br/>
    		4. 北京-哈尔滨</p>
     <!--  url="web_AdminGet.action" -->
    <table id="dg" title="发货单详情" class="easyui-datagrid" style="width:80%;height:60%"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
                <th field="id" width="50">ID</th>
                <th field="customerName" width="50">顾客姓名</th>
                <th field="linebegin" width="50">出发地</th>
                <th field="lineend" width="50">目的地</th>
                <th field="starttime" width="50">起始时间</th>
                <th field="totalday" width="50">所需时间/天</th>
                <th field="expense" width="50">费用</th>
			    <th field="msg" width="50">当前位置</th>
            </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">录入当前位置</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">完成</a>
         <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser_no()">删除</a>
    </div>
    
    <div id="dlg" class="easyui-dialog" style="width:380px;height:220px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle">发货单详情</div>
        <form id="fm" method="post" novalidate>
            
            <div class="fitem">
                <label>客户姓名:</label>
                <input name="customerNameMsg" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
                <label>线路编号:</label>
                <input name="routeid" class="easyui-textbox" required="true">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>
    
    <div id="dlg2" class="easyui-dialog" style="width:380px;height:220px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle">发货单位置</div>
        <form id="fm2" method="post" novalidate>
            <div class="fitem">
                <label>当前位置:</label>
                <input name="id" type="hidden">
                <input name="msg" class="easyui-textbox" required="true">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveLoc()" style="width:90px">Save2</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg2').dialog('close')" style="width:90px">Cancel</a>
    </div>
    <script type="text/javascript">
    	/* $(document).ready(function(){
    		var obj = {"total":"4","rows":[{"id":"14426","firstname":"erw","lastname":"wer","phone":"111","email":"54654@eqweq.com"},{"id":"14428","firstname":"one111","lastname":"two","phone":"299475476","email":"tot@fdgdsf.com"},{"id":"14430","firstname":"1","lastname":"1","phone":"1","email":"q@qq.com"},{"id":"14432","firstname":"qw","lastname":"qw","phone":"122","email":"221@sina.cn"}]};
    		$('#dg').datagrid('loadData', obj);
    	});  */
        var url;
        function newUser(){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','添加发货单');
            $('#fm').form('clear');
            url = 'sendgoods_save.action';
        }
        function editUser(){
            var row = $('#dg').datagrid('getSelected');
            // ----------------------------------------------------
            if (row){
                $('#dlg2').dialog('open').dialog('center').dialog('setTitle','修改信息');
                $('#fm2').form('load',row);
                //url = 'sendgoods_update.action?id='+row.id;
                url = 'sendgoods_update.action?';
            } 
        }
        
        function saveLoc(){
        	$('#fm2').form('submit',{
                url: url,
                onSubmit: function(){
             		
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result.errorMsg){
                        $.messager.show({
                            title: 'Error',
                            msg: result.errorMsg
                        });
                    } else {
                        $('#dlg2').dialog('close');        // close the dialog
                        $('#dg').datagrid('reload');    // reload the user data
                    }
                }
            });	
        }
        
        function saveUser(){
            $('#fm').form('submit',{
                url: url,
                onSubmit: function(){
             		
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result.errorMsg){
                        $.messager.show({
                            title: 'Error',
                            msg: result.errorMsg
                        });
                    } else {
                        $('#dlg').dialog('close');        // close the dialog
                        $('#dg').datagrid('reload');    // reload the user data
                    }
                }
            });
        }
        function destroyUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('确认','该订单已完成?',function(r){
                    if (r){
                        $.get('sendgoods_delete.action',{id:row.id},function(result){
                        	var result = eval('('+result+')');
                            if (result.success){
                                $('#dg').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: result.errorMsg
                                });
                            }
                        });
                    }
                });
            }
        }
        
        function destroyUser_no(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('确认','确定要删除选中条目?',function(r){
                    if (r){
                        $.get('sendgoods_delete_noFinish.action',{id:row.id},function(result){
                        	var result = eval('('+result+')');
                            if (result.success){
                                $('#dg').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: result.errorMsg
                                });
                            }
                        });
                    }
                });
            }
        }
    </script>
  </body>
</html>
