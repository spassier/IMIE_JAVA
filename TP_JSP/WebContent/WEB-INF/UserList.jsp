<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ page import="fr.imie.tp.jsp.UserDTO" %>
<%@ page import="java.util.List" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TP JSP - UserList page</title>
</head>
<body>
		<table>
			<tr>
				<th>Login</th>
			</tr>
			<%	List<UserDTO> dtos = (List<UserDTO>) request.getAttribute("users"); %>
			<%	for (UserDTO userDTO : dtos) { %>
			<tr>
				<td><a href="UserFormServlet?id=<%=userDTO.getId()%>"><%=userDTO.getLogin()%></a></td>
			</tr>
			<tr>
				<td><%=userDTO.getPassword() %></td>
			</tr>
			<% } %>
		</table>
</body>
</html>