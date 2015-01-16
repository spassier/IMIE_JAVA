<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Money Converter</title>
</head>
<body>
	<h3>Converter</h3>
	<form method="post">
		<label>Value</label>
		<input type="text" name="valueInput" />
		<label>Value Converted</label>
		<c:out value="${value}"/>
		<input type="submit" value="Convert" />
	</form>
</body>
</html>