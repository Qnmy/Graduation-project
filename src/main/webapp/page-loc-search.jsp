<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>物流配送网欢迎您</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/icomoon-social.css">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,600,800'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="css/leaflet.css" />
<link rel="stylesheet" href="css/main.css">

<script src="js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>

<body>
	<!-- Navigation & Logo-->
	<div class="mainmenu-wrapper">
		<div class="container">
			<div class="menuextras"></div>
			<nav id="mainmenu" class="mainmenu">
			<ul>
				<li class="logo-wrapper"><a href="index.html"><img
						src="img/mPurpose-logo.png"
						alt="Multipurpose Twitter Bootstrap Template"></a></li>
				<li><a href="index.html">主页</a></li>
				<li><a href="page-404.html">订单确认</a></li>
				<li class="active">订单查询</li>
				<li><a href="page-about-us.html">关于我们</a></li>

			</ul>
			</nav>
		</div>
	</div>

	<!-- Page Title -->
	<div class="section section-breadcrumbs">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>订单查询</h1>
				</div>
			</div>
		</div>
	</div>

	<div class="section">
		<div class="container">
			<div class="col-sm-4 blog-sidebar">
				<h4>请输入您的订单编号：</h4>
				<form>
					<div class="input-group">
						<input class="form-control input-md" id="appendedInputButtons"
							type="text"> <span class="input-group-btn">
							<button class="btn btn-md" type="button" id="searchBtn">Search</button>
						</span>
					</div>
				</form>
			</div>
			<div class="col-sm-12">
				<div class="error-page-wrapper" id="current">
					<p>&nbsp;</p>
					<p>
						&nbsp;
					</p>
				</div>
			</div>
			<div>
				<p>&nbsp;</p>
			</div>
			<div>
				<p>&nbsp;</p>
			</div>
			<div>
				<p>&nbsp;</p>
			</div>

		</div>
	</div>

	<div class="footer">
		<div class="container">
			<div class="row">
				<div class="col-footer col-md-5 col-xs-6">
					<h3>联系方式</h3>
					<p class="contact-us-details">
						<b>地址:</b> XX市XX区XXX地址<br /> <b>电话:</b> +44 123 654321<br />
					</p>
				</div>
				<div class="col-footer col-md-4 col-xs-6">
					<h3>传真/电子邮箱</h3>
					<p class="contact-us-details">
						<b>传真:</b> +11 123 654321<br /> <b>电子邮箱:</b> <a
							href="mailto:getintoutch@yourcompanydomain.com">email@email.com</a>
					</p>
				</div>
				<div class="col-footer col-md-3 col-xs-6">
					<h3>关注我们</h3>
					<ul>
						<li><a href="#">新浪微博</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="footer-copyright">&copy; 2016 Purpose. All rights
						reserved.</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Javascripts -->
	<script src="js/jquery-1.9.1.min.js"></script>
	<script>
        	$(document).ready(function(){
        		$('#searchBtn').click(function(){
        			var orderNumber = $('#appendedInputButtons').val();
        			if($.trim(orderNumber) == ''){
        				alert('您输入的订单编号为空...');
        				return;
        			}
        			$.ajax({   
        			    url:'page-order-search.action',   
        			    type:'post',   
        			    data:'orderNumber='+orderNumber,   
        			    async : true, //默认为true 异步   
        			    dataType:'json', 
        			    error:function(){   
        			       alert('查询出错...');   
        			    },   
        			    success:function(data){ 
        			       //-------------------
        			       //alert(data);
        			       $("#current").html('');
        			       $("#current").append("<p>您的货物当前位置：</p><p>" + data.current + "</p>");
        			       //$("#"+divs).html(data);   
        			    }
        			});
        		});
        	
        	});
        </script>

	<script src="js/bootstrap.min.js"></script>

	<script src="js/jquery.fitvids.js"></script>
	<script src="js/jquery.sequence-min.js"></script>
	<script src="js/jquery.bxslider.js"></script>
	<script src="js/main-menu.js"></script>
	<script src="js/template.js"></script>
</body>
</html>

