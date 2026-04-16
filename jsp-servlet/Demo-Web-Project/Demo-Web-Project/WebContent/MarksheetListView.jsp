<%@page import="com.rays.bean.MarksheetBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
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
	List<MarksheetBean> list = (List) request.getAttribute("list");
	List<MarksheetBean> nextList = (List) request.getAttribute("nextList");
	int pageNo = (int) request.getAttribute("pageNo");
	Iterator<MarksheetBean> it = list.iterator();
	String succesMsg = (String) request.getAttribute("successMsg");
	String erorrMsg = (String) request.getAttribute("erorrMsg");
	%>

	<%@ include file="Header.jsp"%>


	<h1 align="center" style="color: darkblue">
		<h1>Marksheet List</h1>
	</h1>

	<form action="MarksheetListCtl.do" method="post">

		<div align="center">
			<h2 style="color: green"><%=succesMsg != null ? succesMsg : ""%></h2>
			<h2 style="color: red"><%=erorrMsg != null ? erorrMsg : ""%></h2>
		</div>
		<%
		if (list.size() == 0) {
		%>
		<h1 style="color: red">Record Not found</h1>
		<%
		} else {
		%>
		<input type="hidden" name="pageNo" value="<%=pageNo%>">

		<div align="center">

			<table>
				<tr>
					<th>Roll No</th>
					<td><input type="int" name="RollNo"
						value="<%=request.getParameter("RollNo") != null ? request.getParameter("RollNo") : ""%>"
						placeholder="search by Roll No."></td>
					<td><input type="submit" name="operation" value="search"></td>
				</tr>
			</table>

			<table width="100%" border="1px">
				<tr style="background-color: skyblue">
					<th>Select</th>
					<th>Id</th>
					<th>Name</th>
					<th>Roll No.</th>
					<th>Physics</th>
					<th>Hindi</th>
					<th>Maths</th>
					<th>Edit</th>
				</tr>

				<%
				while (it.hasNext()) {
					MarksheetBean bean = it.next();
				%>

				<tr align="center" style="background-color: #D3D3D3;">
					<td><input type="checkbox" name="ids" value=<%=bean.getId()%>></td>
					<td><%=bean.getId()%></td>
					<td><%=bean.getName()%></td>
					<td><%=bean.getRollNo()%></td>
					<td><%=bean.getPhy()%></td>
					<td><%=bean.getHindi()%></td>
					<td><%=bean.getMaths()%></td>
					<td><a href="MarksheetCtl.do?id=<%=bean.getId()%>">Edit</a></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
		<div>
			<table width="100%">
				<tr>
					<td><input type="submit" name="operation"
						<%=pageNo == 1 ? "disabled" : ""%> value="previous"></td>
					<td><input type="submit" name="operation" value="delete"></td>
					<td align="right"><input type="submit" name="operation"
						<%=nextList.size() == 0 ? "disabled" : ""%> value="next"></td>
				</tr>
			</table>
		</div>
		<%
		}
		%>
	</form>

	<%@ include file="Footer.jsp"%>

</body>
</html>