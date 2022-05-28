<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/garan.css" />
<link rel="stylesheet"
	href="/js/css/bootstrap.min.css">
<script
	src="/js/3.5.1/jquery.min.js"></script>
<script
	src="/js/popper.min.js"></script>
<script
	src="/js/bootstrap.min.js"></script>
<body>
<body>
	<style>
</style>
	<%@ include file="../template/header.jsp"%>
	<!--Home Page -->
	
	
	<div class="container">


		<c:forEach var="pro" items="${listBean.products}">


			<div class="items">
				<div class="images">
					<img
						src="${pageContext.request.contextPath}/chicken/${pro.title}.jpg"
						class="item-image-size">
				</div>

				<div class="description">

					<c:url var="url" value="ListProduct">
						<c:param name="id" value="${pro.id}" />
						<c:param name="action" value="Details" />
					</c:url>
					<a href="${url}">${pro.title}</a>
					

					<div class="item-select">price: ${pro.price}</div>


					<tr>

						<td>
						<td><c:url var="url" value="ListProduct">
								<c:param name="id" value="${pro.id}" />
								<c:param name="idAcc" value="${user.userName}" />
								<c:param name="action" value="Buy Now" />
							</c:url> <a href="${url}">Buy Now</a></td>

					</tr>
				</div>

			</div>
		</c:forEach>
	</div>
	<!--footer-->
	<%@ include file="../template/footer.jsp"%>
</body>
</html>
