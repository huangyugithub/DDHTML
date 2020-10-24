<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath }/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<!-- 引入相关js文件 -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery.validate.js"></script>
		<script type="text/javascript">
			function countDown(){
		    	//获取初始时间
		      	var time = document.getElementById("OrderTime");
		      	//获取到id为time标签中的数字时间
		      	if(time.innerHTML == 0){
		       		//等于0时清除计时，并跳转该指定页面
		       		window.location.href="${pageContext.request.contextPath }/homePage";
		      	}else{
		       		time.innerHTML = time.innerHTML-1;
		      	}
			}
		    //1000毫秒调用一次
		    window.setInterval("countDown()",1000);
	   		
   		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单步骤: 1.确认订单 > 2.填写送货地址 >
			<span class="red_bold">3.订单成功</span>
		</div>


		<div class="login_success">
			<div class="login_bj">
				<div class="succ">
					<img src="${pageContext.request.contextPath }/front/images/order_success.jpg" />
				</div>
				<h5>
					订单已经生成
				</h5>
				<h6>
					您刚刚生成的订单号是：<font color="red"><strong>${requestScope.order.order_num }</strong></font>，
					金额总计<font color="red"><strong>${requestScope.order.order_totalprice }</strong></font>
				</h6>

				<ul>
					<li class="nobj">
						您现在可以：还有<font color="red"><strong id="OrderTime">5</strong></font>秒,回到首页！！！
					</li>
					<li>
						<a href="${pageContext.request.contextPath }/homePage">继续浏览并选购商品</a>
					</li>
				</ul>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

