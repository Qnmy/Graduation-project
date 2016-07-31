// JavaScript Document
//支持Enter键登录
		document.onkeydown = function(e){
			if($(".bac").length==0)
			{
				if(!e) e = window.event;
				if((e.keyCode || e.which) == 13){
					var obtnLogin=document.getElementById("submit_btn")
					obtnLogin.focus();
				}
			}
		}

    	$(function(){
			//提交表单
			$('#submit_btn').click(function(){
				/*show_loading();
				var myReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; //邮件正则
*/				if($('#email').val() == ''){
					show_err_msg('账号还没填呢！');	
					$('#email').focus();
				}/*else if(!myReg.test($('#email').val())){
					show_err_msg('您的邮箱格式错咯！');
					$('#email').focus();
				}*/else if($('#password').val() == ''){
					show_err_msg('密码还没填呢！');
					$('#password').focus();
				}else{
					//ajax提交表单，#login_form为表单的ID。 如：$('#login_form').ajaxSubmit(function(data) { ... });
					$.ajax({
						cache: false,
						type: "POST",
						url:"login.action",	//把表单数据发送到ajax.jsp
						data:$('#login_form').serialize(),	//要发送的是ajaxFrm表单中的数据
						async: false,
						error: function(request) {
								alert("发送请求失败！");
						},
						success: function(result) {
							var result = eval('('+result+')');
							if (result.errorMsg){
								//'loginsuc.action?name='+$('#email').val()
								show_msg('登录成功咯！  正在为您跳转...',"index.jsp");
		                    } else {
		                    	show_err_msg("登录信息有误");
		                    }
						}
						});
					
					
						
				}
			});
		});