<%@page import="com.rays.bean.MarksheetBean"%>
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
	String succesMsg = (String) request.getAttribute("succesMsg");
	String errorMsg = (String) request.getAttribute("errorMsg");
	MarksheetBean bean = (MarksheetBean) request.getAttribute("bean");
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">

		<h1><%=bean != null ? "Update Marksheet Detail" : "Add Marksheet Detail"%></h1>

		<h3 style="color: green"><%=succesMsg != null ? succesMsg : ""%></h3>
		<h3 style="color: red"><%=errorMsg != null ? errorMsg : ""%></h3>
		<form action="MarksheetCtl.do" method="post">

			<input type="hidden" name="id"
				value="<%=bean != null ? bean.getId() : ""%>">

			<table align="center">
				<tr>
					<th>Roll No</th>
					<td><input type="text" name="rollNo"
						value="<%=bean != null ? bean.getRollNo() : ""%>"></td>
				</tr>

				<tr>
					<th>Name</th>
					<td><input type="text" name="name"
						value="<%=bean != null ? bean.getName() : ""%>"></td>
				</tr>

				<tr>
					<th>Physics</th>
					<td><input type="text" name="phy"
						value="<%=bean != null ? bean.getPhy() : ""%>"></td>
				</tr>

				<tr>
					<th>Maths</th>
					<td><input type="text" name="maths"
						value="<%=bean != null ? bean.getMaths() : ""%>"></td>
				</tr>

				<tr>
					<th>Hindi</th>
					<td><input type="text" name="hindi"
						value="<%=bean != null ? bean.getHindi() : ""%>"></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="operation" value="save"> <input type="submit"
						name="operation" value="update"></td>
				</tr>
			</table>

		</form>