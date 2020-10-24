<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="${pageContext.request.contextPath}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<!-- 引入相关js文件 -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery.validate.js"></script>
		<script type="text/javascript">
			function changeAddress(){
				var id = $("#address>option:selected").val();
				location.href = "${pageContext.request.contextPath}/selectAddressById?address_id="+id;
			}
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
		</div>
		<div class="fill_message">
			<p>
				选择地址：
				<select id="address" onchange="changeAddress();">
					<c:if test="${requestScope.address.address_name==null }"><option value="">新建地址</option></c:if>
					<c:if test="${requestScope.address.address_name!=null }"><option>${requestScope.address.address_name}</option></c:if>
					<c:forEach var="address" items="${sessionScope.addresses }">
						
						<c:if test="${requestScope.address.address_name!=address.address_name}">
							<option value="${address.address_id }">
								${address.address_name }
							</option>
						</c:if>
					</c:forEach>
					<c:if test="${requestScope.address.address_name!=null }"><option value="">新建地址</option></c:if>
				</select>
			</p>
			<form name="ctl00" method="get" action="${pageContext.request.contextPath }/updateAddress" id="f">
				<input type="hidden" name="address.address_id" value="${requestScope.address.address_id }" id="addressId" />
				<input type="hidden" name="address.dd__user_id" value="${sessionScope.user.user_id}"  />

				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<input type="text" class="text_input" name="username" value="${sessionScope.user.user_name }" id="receiveName" />
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<input type="text" name="address.address_name" class="text_input" value="${requestScope.address.address_name }" id="fullAddress" />
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码
						</td>
						<td>
							<input type="text" class="text_input" name="address.address_zip" value="${requestScope.address.address_zip }" id="postalCode" />
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
							<input type="text" class="text_input"  name="address.address_phone" value="${requestScope.address.address_phone }" id="phone" />
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							手机
						</td>
						<td>
							<input type="text" class="text_input" name="address.address_telephone" value="${requestScope.address.address_telephone }" id="mobile" />
							<div class="text_left" id="mobileValidMsg">
								<p>
									请填写有效的收件人的手机
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">
					<a href="${pageContext.request.contextPath }/front/order/order_info.jsp">
						<input id="btnClientRegister" class="button_1" name="submit" type="submit" value="取消" />
					</a>			
				<input id="btnClientRegister" class="button_1" name="submit" type="submit" value="下一步" />
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

