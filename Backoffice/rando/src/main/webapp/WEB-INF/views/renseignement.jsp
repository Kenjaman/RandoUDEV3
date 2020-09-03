<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<title>Rando - Informations admin</title>
</head>
<body class="bg-dark">
	<div class="container">
		<H1 class="text-success">L'association de randonnée K.J.P</H1>
		<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	</div>
	<div class="container bg-light">
		<form:form servletRelativeAction="/inscription"
			modelAttribute="utilisateurDto">
			<section>
				Nom d'utilisateur :<br>
				<form:input path="pseudo" class="form-control" required="required" />
			</section>
			<br>
			<section>
				Mot de passe :<br>
				<form:password path="mdp" class="form-control" required="required" />
			</section>
			<br>
			<section>
				<button type="submit" class="btn btn-success">Valider</button>
				<button class="btn btn-danger">
					<a href="<c:url value='/accueil'/>">Annuler</a>
				</button>
			</section>
		</form:form>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>
</html>