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
	
	<% UserDTO userDTO = (UserDTO)request.getAttribute("user");	%>
		<form>
			<label>Login</label>
			<input type="text" value="<%=userDTO.getLogin()%>" />
			<label>Password</label>
			<input type="password" value="<%=userDTO.getPassword()%>" />
		</form>
</body>
</html>