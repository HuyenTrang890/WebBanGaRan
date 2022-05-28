<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/Login.css" />
<title>Document</title>
</head>
<body>

	<style>
</style>
	<!-- header -->

	<%@ include file="../template/header.jsp"%>


	<div class="loginbox" action="${pageContext.request.contextPath}/LoginAdmin">
		<h1>Đăng Nhập</h1>
		<form >
		 <p style="color:red; display:block">
		                ${errorMsg}
		            </p>
		
			<p>Tên đăng nhập:</p>
			<input type="text" name="userName" placeholder="" value= "${user.userName}">
			<p>Mật khẩu:</p>
			<input type="password" name="password" placeholder="" value= "${user.password}" > <input
				type="submit" name="" value="Đăng Nhập"> <a
				class="float-right" href="#">Quên Mật Khẩu?</a><br>
				<c:url var="url" value="logup">
				</c:url>
				<a class="float-left" href="${url}">Tạo Tài Khoản</a>
		</form>
	</div>
	<!--footer-->
	<%@ include file="../template/footer.jsp"%>

</body>
</html>