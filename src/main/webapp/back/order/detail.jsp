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
  <body style="background-color: #f0f9fd;text-align: center">
  <div align=center style="font-size:25px">订单详细信息</div><hr/>
  	 <table bordercolor='#898E90' align='center' border='3px' cellpadding='5px' cellspacing="0px">
          <tr bgcolor="lightblue" align="center"> 
             <td>订单号：${requestScope.order.order_num }</td>
             <td colspan="2">订单金额：¥${requestScope.order.order_totalprice }</td>
             <td colspan="2">订单状态：${requestScope.order.order_status }</td>
          </tr>
          
          <c:forEach var="orderItem" items="${requestScope.orderItems }">

			<tr align='center'> 
				 <td>${orderItem.product.prodct_name }</td>
				 <td style="width: 100px;"><img style="width:32px;height: 20px" src="${pageContext.request.contextPath }${orderItem.product.prduct_cover}"></td>
				 <td style="width: 180px;">单价：¥${orderItem.product.prduct_price }</td>
				 <td style="width: 200px;">当当价：¥${orderItem.product.prduct_ddprice }</td>
				 <td style="width: 100px;">${orderItem.shopcar_counts }本</td>
			</tr>
			</c:forEach>

     </table> 
	<input class="button btn-p" value="返回上级" onclick="history.go(-1);" style="margin-top: 10px"/>
  </body>
</html>
