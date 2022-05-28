<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Employee</title>

</head>
<body>
<%@ include file="../template/header.jsp"%>
	<h1>Edit Product</h1>
	<form action="${pageContext.request.contextPath}/EditProductAdminServlet" method="post">

		<table>
			<td>ID:</td>
			<td>${current.id}</td>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="price" value="${current.price}"></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="title" value="${current.title}"></td>
			</tr>
			<tr>
				<td>Descrition:</td>
				<td><input type="text" name="descrition"
					value="${current.descrition}"></td>
			</tr>
			<tr>
				<td>Amount:</td>
				<td><input type="text" name="amount" value="${current.amount}"></td>
			</tr>

		</table>
		<%-- <c:url var="url" value="ListProduct">
								<c:param name="id" value="${pro.id}" />
								<c:param name="action" value="Edit" />
							</c:url> <a href="${url}">Buy Now</a></td>--%>
			<input type="submit" value="Edit">
		</form>
</body>
</html>