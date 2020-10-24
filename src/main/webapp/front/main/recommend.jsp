<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h2>
	编辑推荐
</h2>

<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<c:forEach var="product" items="${requestScope.mainPage.recommendList }">
	
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href="${pageContext.request.contextPath }/queryOneProduct?product_id=${product.product_id}" target='_blank'>
					<img src="${pageContext.request.contextPath }${product.prduct_cover }" width=70 border=0 /> 
				</a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='#' target='_blank' title='输赢'>${product.prodct_name }</a>
				</h3>
				<h4>
					作者：${product.prduct_author } 著
					<br />
					出版社：${product.prduct_publisher }&nbsp;&nbsp;&nbsp;&nbsp;
					出版时间：<fmt:formatDate value="${product.prduct_publishtime }" pattern="yyyy-MM-dd"/>
				</h4>
				<h5>
					简介： ${product.prduct_nrjs }
				</h5>
				<h6>
					定价：￥ ${product.prduct_price }&nbsp;&nbsp;
					当当价：￥${product.prduct_ddprice }
					销量：<font color="red">${product.prduct_salescount }</font>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
		
		</c:forEach>
		
		
		
	</div>
</div>
