<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/back/css/btn.css" />
	
<style type="text/css">
td{
	padding-top: 8px;
}
#file_upload1 {
	display: none;
}
#file_upload1_label {
	display: inline-block;
	border: 1px solid #aaa;
	width: 120px;
	height: 145px;
	margin-left: 20px;
	text-align: center;
	line-height: 145px;
	cursor: pointer;
}
</style>


</head>

<body style="background-color: #f0f9fd;text-align: center">
	<div style="font-size:25px">修改图书信息</div>
	<hr />
	<div align="center">
	<form action="${pageContext.request.contextPath }/updateProduct" method="post" enctype="multipart/form-data">
		<input type="hidden" name="product.product_id" value="${requestScope.product.product_id }"/>
			<table>
				<tr>
					
					<td>名称：</td>
					<td><input type="text" name="product.prodct_name" class="el-input__inner" value="${requestScope.product.prodct_name }"></td>
					<td rowspan="14" style="width: 300px">
					<td>页数：</td>
					<td><input type="number" name="product.prduct_pages" class="el-input__inner" value="${requestScope.product.prduct_pages }" ></td>
				</tr>
				<tr>
					<td>所属分类：</td>
					<td>
						<select name="product.category_id" class="el-select__inner inner2">
							<option value="${requestScope.product.category_id }" >${requestScope.category.category_name}</option>
							<c:forEach var="twocate" items="${requestScope.twoCategory }">
								<c:if test="${twocate.category_id!=requestScope.product.category_id }">
									<option value="${twocate.category_id }">${twocate.category_name }</option>
								</c:if>
							</c:forEach>
							
							
						</select>
					</td>
					<td>字数：</td>
					<td><input type="number" name="product.prduct_words" class="el-input__inner" value="${requestScope.product.prduct_words }" ></td>
				</tr>
				
				<tr>
					<td>原价：</td>
					<td><input type="number" name="product.prduct_price" class="el-input__inner" value="${requestScope.product.prduct_price }"></td>
					<td>封面：</td>
					<td rowspan="3">
						<label id="file_upload1_label" for="file_upload1">
							<img id="uploadimg" src="${pageContext.request.contextPath }${requestScope.product.prduct_cover}" alt="" width="120" height="145" />
						</label> 
						<input type="file" name="uploadProduct" class="" id="file_upload1" value="${requestScope.uploadProduct }"	onchange="upload_review()"> 
					</td>
				</tr>
				
				<tr>
					<td>当当价：</td>
					<td><input type=number name="product.prduct_ddprice" class="el-input__inner" value="${requestScope.product.prduct_ddprice }"></td>
					<td></td>
				</tr>
				<tr>
					<td>库存：</td>
					<td><input type="number" name="product.product_counts" class="el-input__inner" value="${requestScope.product.product_counts }"></td>
					<td></td>
				</tr>
				<tr>
					<td>作者：</td>
					<td><input type="text" name="product.prduct_author" class="el-input__inner" value="${requestScope.product.prduct_author }"></td>
					<td>编辑推荐：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="product.prduct_bjtj">${requestScope.product.prduct_bjtj }</textarea></td>
				</tr>
				<tr>
					<td>出版社：</td>
					<td><input type="text" name="product.prduct_publisher" class="el-input__inner" value="${requestScope.product.prduct_publisher }"></td>
					<td></td>
				</tr>
				<tr>
					<td>出版时间：</td>
					<td><input type="date" name="product.prduct_publishtime" class="el-input__inner" value="<fmt:formatDate value="${requestScope.product.prduct_publishtime }" pattern="yyyy-MM-dd"/>"></td>
					<td>内容简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="product.prduct_nrjs" >${requestScope.product.prduct_nrjs }</textarea></td>
				</tr>
				<tr>
					<td>版次：</td>
					<td><input type="text" name="" class="el-input__inner" value="默认" readonly="readonly"></td>
					<td></td>
				</tr>
				<tr>
					<td>印刷时间：</td>
					<td><input type="date" name="product.prduct_printtime" class="el-input__inner" value="<fmt:formatDate value="${requestScope.product.prduct_printtime }" pattern="yyyy-MM-dd"/>"></td>
					<td>作者简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="product.prduct_zzjs">${requestScope.product.prduct_zzjs }</textarea></td>
				</tr>
				<tr>
					<td>销量：</td>
					<td><input type="text" name="product.prduct_salescount" class="el-input__inner" value="${requestScope.product.prduct_salescount }"></td>
					<td></td>
				</tr>
				<tr>
					<td>ISBN：</td>
					<td><input type="text" name="product.prduct_ISBN" class="el-input__inner" value="${requestScope.product.prduct_ISBN }"></td>
					<td>基本目录：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="product.prduct_jbml" >${requestScope.product.prduct_jbml }</textarea></td>
				</tr>
				<tr>
					<td>开本：</td>
					<td><input type="text" name="product.prduct_format" class="el-input__inner" value="${requestScope.product.prduct_format }"></td>
					<td></td>
				</tr>
				<tr>
					<td>纸张：</td>
					<td><input type="text" name="product.prduct_paper" class="el-input__inner" value="${requestScope.product.prduct_paper }"></td>
					<td>媒体评论：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="product.prduct_comments">${requestScope.product.prduct_comments }</textarea></td>
				</tr>
				<tr>
					<td>包装：</td>
					<td><input type="text" name="product.prduct_packaging" class="el-input__inner" value="${requestScope.product.prduct_packaging }"></td>
					<td></td>
				</tr>
			</table>
			<input type="submit" class="button btn-p" value="提交" />&emsp; 
			<input type="button" class="button btn-p" value="返回上级" onclick="history.go(-1);" />
		</form>
	</div>
	<script>
		function upload_review() {
			var img = document.getElementById("uploadimg");
			var input = document.getElementById("file_upload1");
			var tip = document.getElementById("uploadtip");			

			var file = input.files.item(0);
			var freader = new FileReader();
			freader.readAsDataURL(file);
			freader.onload = function(e) {
				img.src = e.target.result;
				tip.style.display = "none";
			};
		}
	</script>
</body>
</html>

