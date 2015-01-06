<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TP_JSP - Login page</title>
</head>
<body>
		<header>
			<c:if test="${connectedUser == null}">
				<c:out value="Please, connection is required"></c:out>
			</c:if>
			<c:if test="${connectedUser == null} && ${credential == false}">
				<c:out value="Please try again, login or password typing error"></c:out>
			</c:if>
		</header>
		
		<form method="post"> <%--pas d'attribut action car dans ce cas il retourne sur la page courante --%>
			<label>Login</label>
			<input type="text" name="loginInput" />
			<label>Password</label>
			<input type="password" name="passwordInput" />
			<input type="submit" value="login" />
		</form>
</body>
</html>