<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">
	
	<c:forEach var="product" items="${requestScope.mainPage.hotList }">
	
	
	<!--热销图书A开始-->
	<div class="second_d_wai">
		<div class="img">
			<a href="${pageContext.request.contextPath }/queryOneProduct?product_id=${product.product_id}" target='_blank'>
				<img src="${pageContext.request.contextPath }${product.prduct_cover}" border=0 /> 
			</a>
		</div>
		<div class="shuming">
			<a href="${pageContext.request.contextPath }/queryOneProduct?product_id=${product.product_id}" target="_blank">${product.prodct_name}</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥${product.prduct_price}
		</div>
		<div class="price">
			当当价：￥${product.prduct_ddprice}
		</div>
		<div class="price">
			销量：<font color="red">${product.prduct_salescount}</font>
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->
	</c:forEach>
</div>
<div class="clear"></div>