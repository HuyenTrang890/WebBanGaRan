<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Product</title>
</head>
<body>
	<h1>Create new Product</h1>
	<form action="NewProductAdminServlet" method="get">
		<table>
			<tr>
				<td>* ID:</td>
				<td><input type="text" name="id" value="" required="required"></td>
			</tr>
			<tr>
				<td>* Price:</td>
				<td><input type="text" name="price" value=""
					required="required"></td>
			</tr>
			<tr>
				<td>* Name:</td>
				<td><input type="text" name="title" value=""
					required="required"></td>
			</tr>

			<tr>
				<td>* Descrition:</td>
				<td><input type="text" name="descrition" value=""
					required="required" size="55"></td>
			</tr>

			<tr>
				<td>Amount:</td>
				<td><input type="text" name="amount" value=""></td>
			</tr>

		</table>
		<input type="submit" name="submit" value="Add">


	</form>

	<form action="ListProduct">
		<input type="submit" name="submit" value="Return">
	</form>
</body>
</html>