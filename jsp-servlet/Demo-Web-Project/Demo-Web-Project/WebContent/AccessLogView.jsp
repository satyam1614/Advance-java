<%@page import="com.rays.bean.AccessLogBean"%>
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
	AccessLogBean bean = (AccessLogBean) request.getAttribute("bean");
	String successMsg = (String) request.getAttribute("successMsg");
	String errorMsg = (String) request.getAttribute("errorMsg");
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">

		<h1>Add Access Log</h1>
		<h3 style="color: green"><%=successMsg != null ? successMsg : ""%></h3>
		<h3 style="color: red"><%=errorMsg != null ? errorMsg : ""%></h3>
		<form action="AccessLogCtl.do" method="post">

			<input type="hidden" name="id"
				value="<%=bean != null ? bean.getId() : ""%>">

			<table>
				<tr>
					<th>Access Log Code:</th>
					<td><input type="text" name="accessLogCode"
						value="<%=bean != null ? bean.getAccessLogCode() : ""%>"
						placeholder="enter access log code"></td>
				</tr>
				<tr>
					<th>User Name:</th>
					<td><input type="text" name="userName"
						value="<%=bean != null ? bean.getUserName() : ""%>"
						placeholder="enter user name"></td>
				</tr>
				<tr>
					<th>Access Time:</th>
					<td><input type="text" name="accessTime"
						value="<%=bean != null ? bean.getAccessTime() : ""%>"
						placeholder="Enter Access Time"></td>
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
	<%@ include file="Footer.jsp"%>

</body>
</html>