<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>order</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/back/css/btn.css" />
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
  </head>
  <body style="background-color: #f0f9fd;">
  <div align=center style="font-size:25px">订单管理</div><hr/>
  	 <table bordercolor='#898E90' align='center' border='3px' cellpadding='10px' cellspacing="0px">
          <tr bgcolor="lightblue" align="center"> 
              <td>订单id</td>
			  <td>订单编号</td>
			  <td>订单金额</td>
			  <td>订单状态</td>
              <td>收件人</td>
			  <td>收货地址</td>
			  <td>创建日期</td>
              <td>操作</td>
          </tr>
         
         <c:forEach var="order" items="${requestScope.orders }">

		  <tr align='center'> 
			  <td>${order.order_id }</td>
			  <td>${order.order_num }</td>
			  <td>${order.order_totalprice }</td>
			  <td>${order.order_status }</td>
			  <td>${order.order_user }</td>
			  <td>${order.order_address }</td>
			  <td>${order.order_creationtime }</td>
			  <td> 
				<input class="button btn-order" onclick="location.href='${pageContext.request.contextPath }/selectOrderItem?order.order_id=${order.order_id }'" value="订单详细信息 &raquo;" />
			  </td>
		  </tr>
		  </c:forEach>
          
     </table> 
  </body>
</html>
