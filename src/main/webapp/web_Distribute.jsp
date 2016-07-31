<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'web_Distribute.jsp' starting page</title>
    
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
    		$('#dg').datagrid({url:'web_AdminPrivilege_get.action'});
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
    <h2>管理员权限信息</h2>
    <p>可以对已有管理员添加、修改、以及删除相应权限操作</p>
    <!--  url="web_AdminGet.action" -->
    <table id="dg" title="权限分配" class="easyui-datagrid" style="width:80%;height:60%"
         	
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
                <th field="id" width="50">ID</th>
                <th field="adminName" width="50">用户名</th>
                <th field="privilegeName" width="50">权限名</th>
            </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
    </div>
    
    <div id="dlg" class="easyui-dialog" style="width:380px;height:250px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle">权限添加</div>
        <form id="fm" method="post" novalidate>
            <div class="fitem">
                <label>用户名：</label>
                <input id = "adminName" name="adminName" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
	            <label for="language">权限名:</label>
				<input class="easyui-combobox" name="privilegeName"
						data-options="
								url:'privilegeOption.txt',
								valueField:'id',
								textField:'text',
								panelHeight:'auto'
						" required="true">
            </div>
        </form>
    </div>
    
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
    <div id="dlg2" class="easyui-dialog" style="width:350px;height:200px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle">权限添加</div>
        <form id="fm2" method="post" novalidate>
           
            <div class="fitem">
	            <label for="language">权限名:</label>
				<input class="easyui-combobox" name="privilegeName"
						data-options="
								url:'privilegeOption.txt',
								valueField:'id',
								textField:'text',
								panelHeight:'auto'
						" required="true">
            </div>
        </form>
    </div>
    
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser2()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg2').dialog('close')" style="width:90px">取消</a>
    </div>
    <script type="text/javascript">
    	/* $(document).ready(function(){
    		var obj = {"total":"4","rows":[{"id":"14426","firstname":"erw","lastname":"wer","phone":"111","email":"54654@eqweq.com"},{"id":"14428","firstname":"one111","lastname":"two","phone":"299475476","email":"tot@fdgdsf.com"},{"id":"14430","firstname":"1","lastname":"1","phone":"1","email":"q@qq.com"},{"id":"14432","firstname":"qw","lastname":"qw","phone":"122","email":"221@sina.cn"}]};
    		$('#dg').datagrid('loadData', obj);
    	});  */
        var url;
        function newUser(){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','权限添加');
           
            url = 'web_AdminPrivilege_save.action';
        }
        function editUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
            	//$('#adminName').attr('readonly','readonly');
                $('#dlg2').dialog('open').dialog('center').dialog('setTitle','权限修改');
                $('#fm2').form('load',row);
                url = 'web_AdminPrivilege_update.action?id='+row.id;
            }
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
        function saveUser2(){
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
        function destroyUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('确认','确定要删除选中条目?',function(r){
                    if (r){
                        $.get('web_AdminPrivilege_delete.action',{id:row.id},function(result){
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
