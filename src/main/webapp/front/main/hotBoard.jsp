<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<h2 class="t_xsrm">
		新书热卖榜
	</h2>
	<div id="NewProduct_1_o_t" onmouseover="">
	
	<<c:forEach var="product" items="${requestScope.mainPage.hotBoardList }">

		<ul>
			<li>&nbsp;&nbsp;&nbsp;
				<a  target='_blank' href="">
					${product.prodct_name}
				</a>
			</li>
		</ul>
	</c:forEach>
	<h3 class="second">
		<span class="dot_r"> </span><a href="#" target="_blank">更多&gt;&gt;</a>
	</h3>
</div>