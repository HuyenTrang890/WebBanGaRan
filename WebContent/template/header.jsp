<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script>
	function stickyMenu() {
		var sticky = document.getElementById('sticky');
		if (window.pageYOffset > 220) {
			sticky.classList.add('sticky');
		} else {
			sticky.classList.remove('sticky');
		}
	}
	window.onscroll = function() {
		stickyMenu();

	}
</script>
<body>
	<div class="parallax">
		<div class="page-title">Tiệm Gà Rán</div>
		<div class="header_menu">
			<c:if test="${sessionScope.userName!=null}">
				<c:url var="url" value="Information">
					<c:param name="userName" value="${userName}" />
				</c:url>
				<a href="${url}" class="dn"><strong>Chào </strong>${userName}</a>|
					<c:url var="url" value="logout">
				</c:url>

				<a href="${url}" class="dn">Đăng xuất</a>
			</c:if>
			<c:if test="${sessionScope.userName==null}">
				<c:url var="url" value="login">
				</c:url>
				<a href="${url}" class="dn"> Đăng nhập</a>|<c:url var="url"
					value="logup">
				</c:url>
				<a href="${url}" class="dn">Đăng ký</a>
			</c:if>
			<select size="1" name="industry">
				<option value="ComputerSoftware">Tiếng Việt</option>
				<option value="Consulting">Tiếng Anh</option>

			</select>
		</div>
	</div>

	<div class="menu" id="sticky">
		<ul class="menu-ul">

			<c:url var="url" value="ListProduct">
			</c:url>
			<a href="${url}" class="a-menu"><li>Trang chủ</li></a>
			<c:url var="url" value="ShoppingCart">
			</c:url>
			<a href="${url}" class="a-menu"><li>Giỏ Hàng</li></a>

			<c:if test="${sessionScope.userName!=null}">
				<c:url var="url" value="Information">
				<c:param name="userName" value="${userName}" />
				</c:url>
				<a href="${url}" class="a-menu"><li>Tài Khoản</li></a>
			</c:if>
			<c:if test="${sessionScope.userName==null}">
				<c:url var="url" value="login">
				</c:url>
				<a href="${url}" class="a-menu"><li>Tài Khoản</li></a>
			</c:if>

		</ul>
		<div class="search-box">
			<form action="SearchServlet" method="get">
				<input type="text" placeholder="Tìm kiếm..." name="search"
					class="search-input" />
				<button type="submit">
					<i class="fa fa-search"></i>

				</button>
			</form>
		</div>
	</div>
</body>
</html>