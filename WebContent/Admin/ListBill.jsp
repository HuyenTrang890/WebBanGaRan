<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bill</title>
</head>
<body>

	<%@ include file="../template/HeaderAdmin.jsp"%>


	<tr>
		<td>
			<table border="1">
				<tr>
					<th>UserName</th>
					<th>Total</th>
				</tr>
				<c:forEach var="bill" items="${listBill.bills}">
					<tr>



						<td>${bill.userName}</td>
						<td>${bill.total}</td>


					</tr>
				</c:forEach>
			</table>
		</td>
	</tr>
	</table>
	</form>

</body>
</html>
