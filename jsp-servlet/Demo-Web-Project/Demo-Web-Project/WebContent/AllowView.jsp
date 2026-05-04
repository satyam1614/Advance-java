<%@page import="com.rays.bean.AllowBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	AllowBean bean = (AllowBean) request.getAttribute("bean");
	String successMsg = (String) request.getAttribute("successMsg");
	String errorMsg = (String) request.getAttribute("errorMsg");
	%>

<%@ include file="Header.jsp" %>
	<div align="center">

		<h1>Add Allow</h1>
		<h3 style="color: green"><%=successMsg != null ? successMsg : ""%></h3>
		<h3 style="color: red"><%=errorMsg != null ? errorMsg : ""%></h3>
		<form action="AllowCtl.do" method="post">

			<input type="hidden" name="id"
				value="<%=bean != null ? bean.getId() : ""%>">

			<table>
				<tr>
					<th>Allow Code:</th>
					<td><input type="text" name="accessLogCode"
						value="<%=bean != null ? bean.getAllowCode() : ""%>"
						placeholder="enter allow code"></td>
				</tr>
				<tr>
					<th>User Name:</th>
					<td><input type="text" name="userName"
						value="<%=bean != null ? bean.getUserName() : ""%>"
						placeholder="enter user name"></td>
				</tr>
				<tr>
					<th>Source:</th>
					<td><input type="text" name="source"
						value="<%=bean != null ? bean.getSource() : ""%>"
						placeholder="Enter source"></td>
				</tr>
				<tr>
					<th>Status:</th>
					<td><input type="text" name="status"
						value="<%=bean != null ? bean.getStatus() : ""%>"
						placeholder="enter status"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="opertion" value="save"></td>
				</tr>
			</table>

		</form>

	</div>
	<%@include file="Footer.jsp" %>

</body>
</html>