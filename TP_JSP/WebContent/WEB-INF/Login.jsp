<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
	<title>TP_JSP - Login page</title>
</head>
<body>
		<form method="post"> <%--pas d'attribut action car dans ce cas il retourne sur la page courante --%>
			<legend>Please login</legend>
			<div class="form-group">
				<label>Login</label>
				<input class="form-control" type="text" name="loginInput" placeholder="Enter login"/>
			</div>
			<div class="form-group">
				<label>Password</label>
				<input class="form-control" type="password" name="passwordInput" placeholder="Enter password" />
				<input class="btn btn-success"type="submit" value="Login" />
			</div>
			
			<%-- Affiche un message d'erreur si login ou password ne correspond a aucun user --%>
			<c:if test="!empty ${errorMessage}">
				<span><c:out value="${errorMessage}"></c:out></span>
			</c:if>
		</form>
</body>
</html>