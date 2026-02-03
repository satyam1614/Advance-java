<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>


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
	List list = (List) request.getAttribute("list");
	%>

	<%@ include file="Header.jsp"%>

	<div align="center">
		<form action="UserListCtl.do" method="post">
			<h1>User List</h1>

			<table width="100%" border="1px">
				<tr>
					<th>select</th>
					<th>id</th>
					<th>firstName</th>
					<th>lastName</th>
					<th>login</th>
					<th>password</th>
					<th>dob</th>
				</tr>

				<%
				Iterator it = list.iterator();

				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
				%>
				<tr align="center">

					<td><input type="checkbox" name="ids"
						value="<%=bean.getId()%>">
					<td><%=bean.getId()%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getLogin()%></td>
					<td><%=bean.getPassword()%></td>
					<td><%=bean.getDob()%></td>
				</tr>
				<%
				}
				%>

			</table>
			<table>
				<td><input type="submit" name="operation" value="Delete"></td>

			</table>
		</form>
	</div>

	<%@ include file="Footer.jsp"%>

</body>
</html>