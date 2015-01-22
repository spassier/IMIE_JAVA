<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TP_JPA - Personne</title>
</head>
<body>
	<form method="post">
		<div>User</div>
		<div>
			<!-- for et id utiliser pour ancrer le lablel a son input, en cliquant sur le lable, le input est automatiquement selectionné -->
			<label for="name">Name</label> 
			<input id="name" type="text" name="nameInput" value="${Personne.nom}" />
		</div>
		<div>
			<label for="lastname">Lastname</label>
			<input id="lastname" type="text" name="lastnameInput" value="${Personne.prenom}" />
		</div>
		<div>
			<input type="submit" value="Update" />
		</div>
	</form>
</body>
</html>