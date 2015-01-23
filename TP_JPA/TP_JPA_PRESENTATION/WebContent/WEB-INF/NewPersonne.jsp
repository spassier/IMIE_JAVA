<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TP_JPA - New Personne</title>
</head>
<body>
	<form method="post">
		<div>New User</div>
		<div>
			<label>Name</label>
			<input type="text" name="nameInput" value="${Personne.nom}" placeholder="Enter name" />
		</div>
		<div>
			<label>Lastname</label>
			<input type="text" name="lastnameInput" value="${Personne.prenom}" placeholder="Enter lastname" />
		</div>
		<div>
			<label>Promotion</label>
			<select name="promotionInput">
				<option value=""></option>
				<c:forEach items="${Promotions}" var="promotion">
					<option value="${promotion.id}"><c:out value="${promotion.libelle}"></c:out></option>
				</c:forEach>
			</select>
		</div>
		<div>
			<input type="submit" value="Create" />
		</div>
	</form>
</body>
</html>