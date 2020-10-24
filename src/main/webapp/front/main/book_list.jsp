<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath }/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/prototype-1.6.0.3.js"></script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="${pageContext.request.contextPath }/front/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='#'>当当图书</a> &gt;&gt;
			<font style='color: #cc3300'><strong>${requestScope.oneCategory.category_name }</strong> </font>
			<c:if test="${requestScope.category.dd__category_id!=null }">
				<font style='color: #cc3300'><strong>${requestScope.category.category_name }</strong> </font>
			
			</c:if>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
										&middot;<a href="${pageContext.request.contextPath }/selectProductByCategory?category.category_id=${requestScope.oneCategory.category_id }">全部</a>&nbsp;
										(${requestScope.oneProductCount })
									</div>
								</div>
							</li>
							<div class="clear"></div>
							
							<!--2级分类开始-->
							<c:forEach var="tcategory" items="${requestScope.twoCategory }">
								
								
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
										<a href="${pageContext.request.contextPath }/selectProductByCategory?category.category_id=${tcategory.category_id }&category.dd__category_id=${tcategory.dd__category_id}">${tcategory.category_name }&nbsp;
										<c:forEach var="productCount" items="${requestScope.productCounts }">
										<c:if test="${productCount.category_id==tcategory.category_id }">(${productCount.category_byclass })</c:if>
										 </c:forEach>
										</a>
									</div>
								</div>
							</li>
						    <div class="clear"></div>
						   
						    </c:forEach>
							<!--2级分类结束-->
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
	
						<c:if test="${requestScope.page.pageNumber>1 }" >
							<div class='list_r_title_text3a'>
								<a name=link_page_next href="${pageContext.request.contextPath }/selectProductByCategory?page.pageNumber=${requestScope.page.pageNumber-1 }&category.category_id=${requestScope.category.category_id}&category.dd__category_id=${requestScope.category.dd__category_id}">
									<img src='${pageContext.request.contextPath }/front/images/page_up.gif' /> 
								</a>
							</div>
						</c:if>
						<c:if test="${requestScope.page.pageNumber<=1 }">
							<div class='list_r_title_text3a'>
								<img src='${pageContext.request.contextPath }/front/images/page_up_gray.gif' />
							</div>
						</c:if>
						
						
							<div class='list_r_title_text3b'>
								第${requestScope.page.pageNumber}页/共${requestScope.page.totalPage}页
							</div>
						
						
						<c:if test="${requestScope.page.pageNumber<requestScope.page.totalPage }">
							<div class='list_r_title_text3a'>
								<a name=link_page_next href="${pageContext.request.contextPath }/selectProductByCategory?page.pageNumber=${requestScope.page.pageNumber+1 }&category.category_id=${requestScope.category.category_id}&category.dd__category_id=${requestScope.category.dd__category_id}">
									<img src='${pageContext.request.contextPath }/front/images/page_down.gif' /> 
								</a>
							</div>
						</c:if>
						<c:if test="${requestScope.page.pageNumber>=requestScope.page.totalPage }">
							<div class='list_r_title_text3a'>
								<img src='${pageContext.request.contextPath }/front/images/page_down_gray.gif' />
							</div>
						</c:if>
							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						
						<div class="list_r_line"></div>
						
						<c:forEach var="product" items="${requestScope.products }">
								
						<div class="clear"></div>
							<div class="list_r_list">
								<span class="list_r_list_book">
									<a name="link_prd_img" href='${pageContext.request.contextPath }/queryOneProduct?product_id=${product.product_id}'>
										<img src="${pageContext.request.contextPath }${product.prduct_cover}" /> 
									</a>
								</span>
								<h2>
									<a name="link_prd_name" href='${pageContext.request.contextPath }/queryOneProduct?product_id=${product.product_id}'>${product.prodct_name }</a>
								</h2>
								<h3>
									顾客评分：100
								</h3>
								<h4 class="list_r_list_h4">
									作 者:
									<a href='#' name='作者'>${product.prduct_author }</a>
								</h4>
								<h4>
									出版社：
									<a href='#' name='出版社'>${product.prduct_publisher }</a>
								</h4>
								<h4>
									出版时间：<fmt:formatDate value="${product.prduct_publishtime }" pattern="yyyy-MM-dd"/>
								</h4>
								<h5>
									${product.prduct_nrjs }
								</h5>
								<div class="clear"></div>
								<h6>
									<span class="del">￥${product.prduct_price }</span>
									<span class="red">￥${product.prduct_ddprice }</span>
									节省：￥${product.prduct_price-product.prduct_ddprice }
								</h6>
								<span class="list_r_list_button"> 
								<a href="${pageContext.request.contextPath }/addCart?product_id=${product.product_id}"> 
									<img src='${pageContext.request.contextPath }/front/images/buttom_goumai.gif' /> 
								</a>
								<span id="cartinfo"></span>
							</div>
						<div class="clear"></div>
						
						</c:forEach>
					
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
