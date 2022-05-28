<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/ProductDetail.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/Detail.js" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../template/header.jsp"%>
	<div class="container">
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">

						<div class="preview-pic tab-content">
							<div class="tab-pane active" id="pic-1">
								<img src="../img/${pro.title}.jpg" />
							</div>

						</div>


					</div>
					<div class="details col-md-6">
						<p class="product-id">Mã SP:${current.id}</p>
						<p class="product-id">Tên SP: ${current.title}</p>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span> <span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
							</div>

						</div>
						<p class="product-description">Miêu Tả:${current.descrition }</p>
						<p class="price">
							current price: <span>${current.price}</span>
						</p>

						<div class="section" style="padding-bottom: 20px;">
							<h5 class="title-attr">
								<small>Số Lượng</small>
							</h5>
							<div>
								<div class="btn-minus">
									<span class="glyphicon glyphicon-minus"></span>
								</div>
								<input value="1" />
								<div class="btn-plus">
									<span class="glyphicon glyphicon-plus"></span>
								</div>
							</div>
						</div>



						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	<%@ include file="../template/footer.jsp"%>
</body>
</html>