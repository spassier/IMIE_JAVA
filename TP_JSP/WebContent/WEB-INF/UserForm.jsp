<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="fr.imie.tp.jsp.UserDTO"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TP JSP - UserForm page</title>
</head>
<body>
	<%--TP7 : inclusion d'un composant header contenant le login du user  --%>
	<jsp:include page="Header.jsp"></jsp:include>
	
		<form method="post">
			<%-- Un input hidden pour recuperer l'id necessaire au create --%>
			<input type="hidden" value="${user.id}" name="id">
			<label>Login</label>
			<input type="text" name="loginInput"value="${user.nom}" />
			<label>Password</label>
			<input type="text" name="passwordInput" value="${user.password}" />
			<%--TP9/10 : inclure un bouton pour updater et creer  --%>
			<%-- Un seul bouton d'afficher dynamiquement selon qu'il existe un user ou pas --%>
			<c:choose>
				<c:when test="${empty user}">
					<input class="btn btn-primary" type="submit" value="Create" />
				</c:when>
				<c:otherwise>
					<input class="btn btn-danger" type="submit" value="Update" />
				</c:otherwise>
			</c:choose>
		</form>
</body>
</html>