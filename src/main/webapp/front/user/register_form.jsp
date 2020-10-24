<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath }/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
		<!-- 引入相关js文件 -->
		
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery.validate.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#f").validate({
					rules:{
						'user.user_name':{required:true,minlength:4,maxlength:20},
						'user.user_password':{required:true,minlength:6,maxlength:20},
						'password2':{required:true,minlength:6,maxlength:20,equalTo:"#txtPassword"},
						'user.user_eamil':{required:true,email:true}
					},
					messages:{
						'user.user_name':{required:"&nbsp;&nbsp;<span style='color:red' >必须填写，不能为空</span>",minlength:"&nbsp;&nbsp;<span style='color:red' >最少写4位</span>",maxlength:"&nbsp;&nbsp;<span style='color:red' >最多20位</span>"},
						'user.user_password':{required:"&nbsp;&nbsp;<span style='color:red' >必须填写，不能为空</span>",minlength:"&nbsp;&nbsp;<span style='color:red' >最少写6位</span>",maxlength:"&nbsp;&nbsp;<span style='color:red' >最多20位</span>"},
						'password2':{required:"必须填写，不能为空",minlength:"&nbsp;&nbsp;<span style='color:red' >最少写6位</span>",maxlength:"&nbsp;&nbsp;<span style='color:red' >最多20位</span>",equalTo:"&nbsp;&nbsp;<span style='color:red' >两次密码不一致！</span>"},
						'user.user_eamil':{required:"&nbsp;&nbsp;<span style='color:red' >必须填写，不能为空</span>",email:"&nbsp;&nbsp;<span style='color:red' >必须按照正确格式写</span>"}
					}
				});
			});
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="post" action="${pageContext.request.contextPath }/registerUser" id="f" >
				<h2>
					以下均为必填项&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					${requestScope.hint }
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="user.user_eamil"  type="text" id="txtEmail" class="text_input"/>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
								<span id="emailInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="user.user_name"  type="text" id="txtNickName" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="nameInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="user.user_password" type="password" id="txtPassword" class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="passwordInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password2" type="password" id="txtRepeatPass" class="text_input"/>
							
							<div class="text_left" id="repeatPassValidMsg">
								<span id="password1Info"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="${pageContext.request.contextPath }/code" />
							<input name="code" type="text" id="txtVerifyCode" class="yzm_input"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									<a id="change" onClick="document.getElementById('imgVcode').src='${pageContext.request.contextPath}/code?dt='+(new Date()).getTime()">看不清楚？换个图片</a>
									<br/>
									<span id="codeInfo"></span>
								</p>
							</div>
						</td>
					</tr>
				</table>
				<div class="login_in">
					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

