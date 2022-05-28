<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
		<a class="dn"><strong>Chào </strong>${userName}</a>|<a href="${pageContext.request.contextPath}/logout" class="dn">Đăng xuất</a>
		</c:if>
		<c:if test="${sessionScope.userName==null}">
			<a href="${pageContext.request.contextPath}/login" class="dn"> Đăng nhập</a>|<a href="${pageContext.request.contextPath}/logup" class="dn">Đăng
				ký</a></c:if>
				<select size="1" name="industry">
                  <option value="ComputerSoftware">Tiếng Việt</option>
                  <option value="Consulting">Tiếng Anh</option>
                  
            </select>
		</div>
	</div>

	<div class="menu" id="sticky">
		<ul class="menu-ul">
			<a href="${pageContext.request.contextPath}/HomeAdminServlet"
				class="a-menu"><li>Trang chủ</li></a>
			<a href="${pageContext.request.contextPath}/Bill"
				class="a-menu"><li>Bill</li></a>
			<a href="${pageContext.request.contextPath}/LoginAdminServlet" class="a-menu"><li>Tài
					Khoản</li></a>

		</ul>
		<div class="search-box">
			<form>
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