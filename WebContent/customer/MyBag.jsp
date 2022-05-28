<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/MyBag.css" />
<title>Document</title>
</head>
<body>

	<%@ include file="../template/header.jsp"%>
	<div class="bagBox">
		<c:forEach items="${scart.products}" var="item">
			<div id="sticky">
				<h1>Giỏ Hàng</h1>
			</div>
			<div class="container">
				<table id="cart" class="table table-hover table-condensed">
					<thead>
						<tr>
							<th style="width: 10%">ID:${item.product.id}</th>
							<th style="width: 35%">Name:${item.product.title}</th>
							<th style="width: 15%">Price:${item.product.price}</th>
							<th style="width: 10%">SL:${item.quantity}</th>
							<th style="width: 17%" class="text-center"><p class="amuont">Price:
									${scart.total}</p></th>
							<th style="width: 13%"><p class="amuont">amount:
									${scart.numberOfItems}</p></th>
						</tr>
					</thead>
					<tbody>
						</c:forEach>
						<td><c:if test="${sessionScope.userName!=null}">
								<c:url var="urlCheck" value="ShoppingCart">
									<c:param name="userName" value="${userName}" />
									<c:param name="idAcc" value="${userName}" />
									<c:param name="action" value="Checkout" />
								</c:url>
								<a href="${urlCheck}">CheckOut</a></td>
						</c:if>
						<c:if test="${sessionScope.userName==null}">
							<c:url var="url" value="login">
							</c:url>
							<a href="${url}" class="a-menu"><li>Đăng nhập</li></a>
						</c:if>
						</div>
</body>
</html>

