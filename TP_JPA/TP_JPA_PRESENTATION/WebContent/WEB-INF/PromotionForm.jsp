<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TP_JPA - Promotion Form TP4</title>
</head>
<body>
	<div></div>
	<table>
	<tr>
		<th>Name</th>
		<th>Lastname</th>
	</tr>
		<c:forEach items="${Personnes}" var="personne">
			<tr>
				<td><c:out value="${personne.nom}"></c:out></td>
				<td><c:out value="${personne.prenom}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>