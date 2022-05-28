<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/Logup.css" />
<title>Document</title>
</head>
<body>
	<style>
</style>
	<!-- header -->

	<%@ include file="../template/header.jsp"%>

	<div class="registration">

		<h1>Đăng ký</h1>

		<div class="form" >
			<form action="${pageContext.request.contextPath}/logup" method="get">
			<p style="color: red; display: block;"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></p>
				<p style="color: red; display: block;"><%=(request.getAttribute("Message") == null) ? "" : request.getAttribute("Message")%></p>
				
				<p class="text">Tên đăng nhập:</p>
				<input type="text" name="userName" pattern="" placeholder="from 4 to 50 characters">
				<p class="text">Họ và Tên :</p>
				<input type="text" name="name" pattern="" placeholder="from 4 to 50 characters">
				<p class="text">Email:</p>
				<input type="text" name="email" pattern="" placeholder="abc@gmail.com">

				<p class="text">Số điện thoại:</p>
				<input type="text" name="telephone" pattern="" placeholder="098*******">

				<p class="text">Mật khẩu:</p>
				<input type="password" name="password" pattern="" placeholder=""></br>

				<p class="text">Địa chỉ</p>
				<input type="text" name="address" placeholder=""></br>


				<div class="check" >
					<input type="checkbox" checked> Đồng ý với tất cả các điều khoản
					của chúng tôi.
				</div>
				
				<input type="submit" name="" value="Đăng Ký">
				<div class="login">
					Bạn đã có tài khoản <a href="${pageContext.request.contextPath}/login">Đăng nhập ngay?</a>
				</div>

			</form>
		</div>
	</div>
	<!--footer-->
	<%@ include file="../template/footer.jsp"%>
</body>
</html>