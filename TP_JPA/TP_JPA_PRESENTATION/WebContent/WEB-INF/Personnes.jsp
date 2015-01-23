<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TP_JPA - Personnes List</title>
</head>
<body>
	<table>
		<tr>
			<th>Name</th>
			<th>Lastname</th>
			<th>Promotion</th>
			<th>Promotion selection</th>
		</tr>
		<c:forEach items="${Personnes}" var="personne">
			<tr>
				<td><a href="OneUser?id=${personne.id}"><c:out value="${personne.nom}"></c:out></a></td>
				<td><a href="OneUser?id=${personne.id}"><c:out value="${personne.prenom}"></c:out></a></td>
				<td><a href="PromotionForm?id=${personne.promotion.id}"><c:out value="${personne.promotion.libelle}"></c:out></a></td>
				<td>
					<form method="post">
						<input type="hidden" name="deleteInput" value="${personne.id}" />
						<input type="submit" value="Delete" />
					</form>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<a href="NewUser">Create User</a>
		</tr>
		<tr>
			<a href="NewPromotion">Create Promotion</a>
		</tr>
	</table>
</body>
</html>