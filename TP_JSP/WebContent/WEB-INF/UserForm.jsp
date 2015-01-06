<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="fr.imie.tp.jsp.UserDTO"%>
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TP JSP - UserForm page</title>
</head>
<body>
	<% UserDTO userDTO = (UserDTO)request.getAttribute("user");	%>
		<form>
			<label>Login</label>
			<input type="text" value="<%=userDTO.getLogin()%>" />
			<label>Password</label>
			<input type="password" value="<%=userDTO.getPassword()%>" />
		</form>
</body>
</html>