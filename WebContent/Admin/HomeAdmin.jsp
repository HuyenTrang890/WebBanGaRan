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
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<body>
<body>
	<style>
</style>
	<%@ include file="../template/HeaderAdmin.jsp"%>
	<!--Home Page -->
	<tr>
		<td bgcolor="#00CC99"><b>Product Count:
				${listBean.productCount}</b></td>
	</tr>
	<tr>
		<c:url var="url" value="HomeAdminServlet">
			<c:param name="action" value="Add" />

		</c:url>
		<td><input type="button" value="Add New Product"
			onclick="location.href='${url}'">
	</tr>
	<div class="container">


		<c:forEach var="pro" items="${listBean.products}">


			<div class="items">
				<div class="images">
					<img
						src="${pageContext.request.contextPath}/chicken/${pro.title}.jpg"
						class="item-image-size">
				</div>

				<div class="description">

					<c:url var="url" value="HomeAdminServlet">
						<c:param name="id" value="${pro.id}" />
						<c:param name="action" value="Details" />
					</c:url>
					<a href="${url}">${pro.id}</a>
					<td>${pro.title}</td>

					<div class="item-select">price: ${pro.price}</div>


					<tr>

						<td>
						<c:url var="urlEdit" value="HomeAdminServlet">

								<c:param name="id" value="${pro.id}" />
								<c:param name="title" value="${pro.title}" />
								<c:param name="action" value="Edit" />
							</c:url> <a href="${urlEdit}">Edit</a></td>
						<td><c:url var="urlDel" value="HomeAdminServlet">

								<c:param name="id" value="${pro.id}" />

								<c:param name="action" value="Delete" />
							</c:url> <a href="${urlDel}">Delete</a></td>

					</tr>
				</div>

			</div>
		</c:forEach>
	</div>
	<!--footer-->
	<%@ include file="../template/footer.jsp"%>
</body>
</html>
