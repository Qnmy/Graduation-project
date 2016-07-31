<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'route.jsp' starting page</title>
    
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
    		$('#dg').datagrid({url:'route_get.action'});
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
    <h2>线路信息</h2>
    <p>本公司提供的货运线路详情</p>
      <!--  url="web_AdminGet.action" -->
    <table id="dg" title="线路信息" class="easyui-datagrid" style="width:80%;height:60%"
         	
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
                <th field="id" width="50">ID</th>
                <th field="linebegin" width="50">起始位置</th>
                <th field="include1" width="50">途径位置A</th>
                <th field="include2" width="50">途径位置B</th>
                <th field="include3" width="50">途径位置C</th>
                <th field="lineend" width="50">终点位置</th>
            </tr>
        </thead>
    </table>
   <!--  <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
    </div> -->
    
    <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle">线路信息</div>
        <form id="fm" method="post" novalidate>
            <div class="fitem">
                <label>起始位置:</label>
                <input name="linebegin" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
                <label>途径位置A:</label>
                <input name="include1" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
                <label>途径位置B:</label>
                <input name="include2" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
                <label>途径位置C:</label>
                <input name="include3" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
                <label>终点位置:</label>
                <input name="lineend" class="easyui-textbox" required="true">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>
    <script type="text/javascript">
    	/* $(document).ready(function(){
    		var obj = {"total":"4","rows":[{"id":"14426","firstname":"erw","lastname":"wer","phone":"111","email":"54654@eqweq.com"},{"id":"14428","firstname":"one111","lastname":"two","phone":"299475476","email":"tot@fdgdsf.com"},{"id":"14430","firstname":"1","lastname":"1","phone":"1","email":"q@qq.com"},{"id":"14432","firstname":"qw","lastname":"qw","phone":"122","email":"221@sina.cn"}]};
    		$('#dg').datagrid('loadData', obj);
    	});  */
        var url;
        function newUser(){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','添加线路');
            $('#fm').form('clear');
            url = 'route_save.action';
        }
        function editUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('center').dialog('setTitle','修改信息');
                $('#fm').form('load',row);
                url = 'route_update.action?id='+row.id;
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
        function destroyUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('确认','确定要删除选中条目?',function(r){
                    if (r){
                        $.get('route_delete.action',{id:row.id},function(result){
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
