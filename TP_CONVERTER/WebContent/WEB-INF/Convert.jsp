<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Money Converter</title>
</head>
<body>
	<h2>Converter</h3>
	<form method="post">
		<label>€ to $</label>
		<input type="text" name="EuroInput" />
		<input type="submit" value="=> convert" />
		<input type="text" value="${DollarValue}" />
		<!--
		<c:out value="${value}"/>
		-->
	</form>
	
	<form method="post">
		<label>$ to €</label>
		<input type="text" name="DollarInput" />
		<input type="submit" value="=> convert" />
		<input type="text" value="${EuroValue}" />
	</form>
	
	<p><c:out value="${historic}"/> </p>
</body>
</html>