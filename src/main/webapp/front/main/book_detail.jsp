<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<title>图书详情</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/front/css/book_detail.css"/>
		<link href="${pageContext.request.contextPath }/front/css/public_footer.css" rel="stylesheet" type="text/css" />

	</head>
	<body>
		<br/>
		<div>
			<h1>
				丛书名：
			</h1>
			<hr/>
		</div>
		<table width="80%" border="0" align="center" cellspacing="0" cellpadding="5">
			<tr>
				<td rowspan="9" width="20%" valign="top"><img src="${pageContext.request.contextPath }${requestScope.product.prduct_cover }" width="240px" height="340px" /></td>
				<td colspan="2">作者：${requestScope.product.prduct_author }</td>
			</tr>
			<tr>
				<td colspan="2">出版社：${requestScope.product.prduct_publisher }</td>
			</tr>
			<tr>
				<td>出版时间：<fmt:formatDate value="${requestScope.product.prduct_publishtime }" pattern="yyyy-MM-dd"/> </td>
				<td>字数：${requestScope.product.prduct_words }</td>
			</tr>
			<tr>
				<td>销量：${requestScope.product.prduct_salescount }</td>
				<td>页数：${requestScope.product.prduct_pages }</td>
			</tr>
			<tr>
				<td>印刷时间：<fmt:formatDate value="${requestScope.product.prduct_printtime }" pattern="yyyy-MM-dd"/> </td>
				<td>开本：${requestScope.product.prduct_format }</td>
			</tr>
			<tr>
				<td>印次：默认第一次</td>
				<td>纸张：${requestScope.product.prduct_paper }</td>
			</tr>
			<tr>
				<td>ISBN：${requestScope.product.prduct_ISBN }</td>
				<td>包装：${requestScope.product.prduct_packaging }</td>
			</tr>
			<tr>
				<td colspan="2">定价：￥${requestScope.product.prduct_price }&nbsp;&nbsp;&nbsp;&nbsp;
				<font color="red">当当价：￥${requestScope.product.prduct_ddprice }</font>&nbsp;&nbsp;&nbsp;&nbsp;
				节省：￥${requestScope.product.prduct_price-requestScope.product.prduct_ddprice }</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="${pageContext.request.contextPath }/addCart?product_id=${requestScope.product.product_id}">
						<img src='${pageContext.request.contextPath }/front/images/buttom_goumai.gif' />
					</a>
				</td>
			</tr>
		</table>
		<hr style="border:1px dotted #666"/>
		<h2>编辑推荐</h2>
		<p>&nbsp;&nbsp;${requestScope.product.prduct_bjtj }</p>
		<hr style="border:1px dotted #666"/>
		<h2>内容简介</h2>
		<p>&nbsp;&nbsp;${requestScope.product.prduct_nrjs }</p>
		<hr style="border:1px dotted #666"/>
		<h2>作者简介</h2>
		<p>&nbsp;&nbsp;${requestScope.product.prduct_zzjs }</p>
		<hr style="border:1px dotted #666"/>
		<h2>目录</h2>
		<p>&nbsp;&nbsp;${requestScope.product.prduct_jbml }</p>
		<hr style="border:1px dotted #666"/>
		<h2>媒体评论</h2>
		<p>&nbsp;&nbsp;${requestScope.product.prduct_comments }</p>
		<hr style="border:1px dotted #666"/>
		<h2>书摘插图</h2>
		<p>&nbsp;&nbsp;无</p>
		<!--页尾开始 -->
		<div class="public_footer">
			<div class="public_footer_bottom">
				<div class="public_footer_icp" style="line-height: 48px;">
					Copyright (C) 当当网 2004-2008, All Rights Reserved
					<a href="#" target="_blank"><img src="${pageContext.request.contextPath }/front/images/bottom/validate.gif" border="0" align="middle" /> </a>
					<a href="#" target="_blank" style="color: #666;">京ICP证041189号</a>
				</div>
			</div>
		</div>
		<!--页尾结束 -->
	</body>
</html>
