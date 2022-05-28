<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../template/header.jsp"%>
	<!--Home Page -->


	<div class="container" >


		<c:forEach var="pro" items="${listPro}">
			<p>${pro.title}</p>

			<div class="items">
				<div class="images">
					<img
						src="${pageContext.request.contextPath}/chicken/${pro.title}.jpg"
						class="item-image-size">
				</div>

				<div class="description">

					<c:url var="url" value="SearchServlet">
						<c:param name="id" value="${pro.id}" />
						<c:param name="action" value="Details" />
					</c:url>
					<a href="${url}">${pro.title}</a>


					<div class="item-select">price: ${pro.price}</div>


					<tr>
						<td>
						<td><c:url var="url" value="SearchServlet">
								<c:param name="id" value="${pro.id}" />
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