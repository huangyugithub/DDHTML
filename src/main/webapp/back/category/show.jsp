<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/back/css/btn.css" />
	</head>
	<body style="background-color: #f0f9fd;text-align: center;">
	
		<div style="font-size:25px">类别管理</div><hr/>
		<div style="margin-bottom: 10px;">
			<div class="button btn-p" onclick="location.href='${pageContext.request.contextPath }/back/category/add-first.jsp'">添加一级类别&raquo;</div>
			<div class="button btn-p" onclick="location.href='${pageContext.request.contextPath }/back/category/add-second.jsp'">添加二级类别&raquo;</div>
		</div>
		
		<div style="color:red;float:center"><h1 style="font-size:30px">${requestScope.deleteFail }</h1></div>
		
		<table bordercolor='#898E90' align='center' border='3px' cellpadding='10px' cellspacing="0px" >
			<tr bgcolor='lightblue'>
				<td>Id</td>
				<td>类别名</td>
				<td>所属类别</td>
				<td>级别</td>
				<td>操作</td>
			</tr>
			<c:forEach  var="category" items="${sessionScope.Categorys}">
					<tr>
						<td>${category.category_id }</td><td>${category.category_name }</td><td>${category.dd__category_id }</td><td>${category.category_class }</td>
						<td><a href="${pageContext.request.contextPath }/deleteCategory?category_id=${category.category_id }&category_class=${category.category_class }"><input type="button" value="删除"/></a></td>
					</tr>
			</c:forEach>
			
			
			
		</table><br/>
		
	</body>  
</html>



