<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ page import="fr.imie.tp.jsp.UserDTO" %>
<%@ page import="java.util.List" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
	<title>TP JSP - UserList page</title>
</head>
<body>
	<%--TP7 : inclusion d'un composant header contenant le login du user --%>
	<jsp:include page="Header.jsp"></jsp:include>
	
	<table>
			<tr>
				<th>Login</th>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.nom}"></c:out></td>
					<td><a class="btn btn-primary" href="UserFormServlet?id=${user.id}">Edit</a></td>
					<%-- TP8 : ajouter un bouton "delete" et realiser la suppression d'un user --%>
					<td>
						<form method="post">
							<input type="hidden" name="deleteInput" value="${user.id}" />
							<input class="btn btn-danger" type="submit" value="Delete" />
						</form>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td>
					<%-- Pas de parametre --%>
					<a class="btn btn-primary" href="UserFormServlet">Create</a>
				</td>
			</tr>
	</table>
</body>
</html>