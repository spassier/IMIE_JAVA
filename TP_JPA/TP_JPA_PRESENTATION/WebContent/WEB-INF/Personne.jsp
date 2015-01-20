<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TP_JPA - Personne</title>
</head>
<body>
	<p><c:out value="${Personne.nom}"></c:out></p>
	<p><c:out value="${Personne.prenom}"></c:out></p>
</body>
</html>