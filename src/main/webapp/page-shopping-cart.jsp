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
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,600,800' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="css/leaflet.css" />
	<link rel="stylesheet" href="css/main.css">

      <script src="js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
  </head>
  
  <body>
    <!-- Navigation & Logo-->
        <div class="mainmenu-wrapper">
	        <div class="container">
	        	<div class="menuextras">
		
		        </div>
		        <nav id="mainmenu" class="mainmenu">
					<ul>
						<li class="logo-wrapper"><a href="index.html"><img src="img/mPurpose-logo.png" alt="Multipurpose Twitter Bootstrap Template"></a></li>
						<li>
							<a href="index.html">主页</a>
						</li>
						<li class="active">
							订单确认
						</li>
						<li>
							<a href="page-loc-search.action">订单查询</a>
						</li>
						<li>
							<a href="page-about-us.html">关于我们</a>
						</li>
						
					</ul>
				</nav>
			</div>
		</div>

        <!-- Page Title -->
		<div class="section section-breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h1>订单详情</h1>
					</div>
				</div>
			</div>
		</div>
        
        <div class="section">
	    	<div class="container">
				<div class="row">
					<p><h2>您的选择:</h2></p>
				</div>
				<div class="row">
					<div class="col-md-12">
						<!-- Shopping Cart Items -->
						<table class="shopping-cart">
							<!-- Shopping Cart Item -->
							<tr>
								<!-- Shopping Cart Item Image -->
								<td class="image"><a href="page-product-details.html"><img src="img/product1.png" alt="Item Name"></a></td>
								<!-- Shopping Cart Item Description & Features -->
								<td>
									<div class="cart-item-title"><h3>${request.routeName}</h3></div>
								</td>
								
								<!-- Shopping Cart Item Price -->
								<td class="price"><h4>${request.expense }</h4></td>
								
							</tr>
							
						</table>
						<!-- End Shopping Cart Items -->
					</div>
				</div>
				<div class="row">
					<!-- Promotion Code -->
					<div class="col-md-2  col-md-offset-0 col-sm-6 col-sm-offset-6">
						<div class="cart-promo-code">
							<h5><i class="glyphicon glyphicon-gift"></i><b> 您的姓名:</b></h5>
							<div class="input-group">
								<input class="form-control input-sm" id="customerName" type="text" value="">
								<!-- <span class="input-group-btn">
									<button class="btn btn-sm btn-grey" type="button">Apply</button>
								</span> -->
								<span><input type="hidden" id="tip" value="${request.tip }"></span>
							</div>
						</div>
					</div>
					<div class="col-md-3  col-md-offset-0 col-sm-6 col-sm-offset-6">
						<div class="cart-promo-code">
							<h5><i class="glyphicon glyphicon-gift"></i><b> 您的地址:</b></h5>
							<div class="input-group">
								<input class="form-control input-sm" id="address" type="text" value="">
								<!-- <span class="input-group-btn">
									<button class="btn btn-sm btn-grey" type="button">Apply</button>
								</span> -->
								
							</div>
						</div>
					</div>
					<!-- Shipment Options -->
					<div class="col-md-4 col-md-offset-0 col-sm-6 col-sm-offset-6">
						<div class="cart-shippment-options">
							<h5><i class="glyphicon glyphicon-plane"></i><b> 您的联系电话:</b></h5>
							<div class="input-append">
								<input class="form-control input-sm" id="phone" type="text" value="">
								<!-- <select class="form-control input-sm">
									<option value="1">Standard - FREE</option>
									<option value="2">Next day delivery - $10.00</option>
								</select> -->
							</div>
						</div>
					</div>
					
					<!-- Shopping Cart Totals -->
					<div class="col-md-3 col-md-offset-0 col-sm-6 col-sm-offset-6">
						<table class="cart-totals">
							
							<tr class="cart-grand-total">
								<td><h3>总 计:</h3></td>
								<td><h3>￥${request.expense }</h3></td>
							</tr>
						</table>
						<!-- Action Buttons -->
						<div class="pull-right">
							<!-- <a href="#" class="btn btn-grey"><i class="glyphicon glyphicon-refresh"></i> UPDATE</a> -->
							<button class="btn" onclick="orderSave()"><i class="glyphicon glyphicon-shopping-cart icon-white"></i> <b> 预  定 </b></button>
						</div>
					</div>
				</div>
			</div>
		</div>

	    <!-- Footer -->
	    <div class="footer">
	    	<div class="container">
		    	<div class="row">
		    		<div class="col-footer col-md-5 col-xs-6">
		    			<h3>联系方式</h3>
		    			<p class="contact-us-details">
	        				<b>地址:</b> XX市XX区XXX地址<br/>
	        				<b>电话:</b> +44 123 654321<br/>
	        			</p>
		    		</div>
		    		<div class="col-footer col-md-4 col-xs-6">
		    			<h3>传真/电子邮箱</h3>
		    			<p class="contact-us-details">
	        				<b>传真:</b> +11 123 654321<br/>
	        				<b>电子邮箱:</b> <a href="mailto:getintoutch@yourcompanydomain.com">email@email.com</a>
	        			</p>	
		    		</div>
		    		<div class="col-footer col-md-3 col-xs-6">
		    			<h3>关注我们</h3>
		    			<ul >
		    				<li><a href="#">新浪微博</a></li>
		    			</ul>
		    		</div>
		    	</div>
		    	<div class="row">
		    		<div class="col-md-12">
		    			<div class="footer-copyright">&copy; 2016 Purpose. All rights reserved.</div>
		    		</div>
		    	</div>
		    </div>
	    </div>

        <!-- Javascripts -->
        <script>
        	//$(document).ready(function(){
        		
        	function orderSave(){
        		var tip = $('#tip').val();
        		var customerName = $.trim($('#customerName').val());
        		var phone = $.trim($('#phone').val());
        		var address = $.trim($('#address').val());
        		if(customerName.length < 1 || phone.length < 1 || address.length < 1 ){
        			alert("姓名、地址、联系电话不能为空...");
        		}else{
        			location.href="orderFinishSave.action?tip=" + tip +"&customerName=" + customerName + "&phone=" + phone + "&address=" + address;
        		};	
        		/* $.post(orderFinishSave.action, null,
        				function(data){
        			alert(data);
        		}); */
        		
        	}
        	//});
        </script>
        <script src="js/jquery-1.9.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
        <script src="js/jquery.fitvids.js"></script>
        <script src="js/jquery.sequence-min.js"></script>
        <script src="js/jquery.bxslider.js"></script>
        <script src="js/main-menu.js"></script>
        <script src="js/template.js"></script>
  </body>
</html>
