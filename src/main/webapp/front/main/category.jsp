<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
		<!--1级分类开始-->
		<c:forEach var="category" items="${requestScope.mainPage.categoryList }">
			<c:if test="${category.category_class==1 }">
			
				<div class="bg_old" onmouseover="this.className = 'bg_white';"onmouseout="this.className = 'bg_old';">
				
					<h3>
						[<a href="${pageContext.request.contextPath }/selectProductByCategory?category.category_id=${category.category_id }">${category.category_name }</a>]
					</h3>
					<ul class="ul_left_list">
							
						<c:forEach var="twoCategory" items="${requestScope.mainPage.categoryList}">
							<c:if test="${twoCategory.dd__category_id==category.category_id }">
								<!--2级分类开始-->
								<li>
									<a href="${pageContext.request.contextPath }/selectProductByCategory?category.category_id=${twoCategory.category_id }&category.dd__category_id=${twoCategory.dd__category_id}">${twoCategory.category_name }</a>
								</li>
							</c:if>
						</c:forEach>
					</ul>
				
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
			</c:if>
			</c:forEach>
		<!--1级分类结束-->
		


			


		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
