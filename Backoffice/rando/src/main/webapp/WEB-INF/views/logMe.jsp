<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<link rel="stylesheet" href="css/rando.css" type="text/css" />
<title>Rando - Connexion</title>
</head>
<body class="bg-dark">
	<div class="container rando rando_design">
<%-- 		<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include> --%>
		<div class="container bg-light">
			<!-- Begin # Login Form -->
			<span class="text-danger">${errorLogin}</span>
			<form:form id="login-form" servletRelativeAction="/authentification"
				modelAttribute="utilisateurDto">
				<div class="modal-body">
					<div id="div-login-msg">
						<span>Authentifiez-vous</span>
					<form:errors path="*"></form:errors> <!-- ne fonctionne pas -->
					<input type="text" id="login_username" name="pseudo"
						class="form-control" placeholder="Nom d'utilisateur" value="" />
					<input type="password" id="login_password" class="form-control"
						name="mdp" placeholder="********" required="required" value="" />
					<div class="modal-footer">
						<button class="btn btn-success" type="submit">Connectez-vous</button>
							<a class="btn btn-secondary" href="<c:url value='/renseignement'/>">Inscrivez-vous</a>
							<a class="btn btn-danger" href="<c:url value='/'/>">Annuler</a>
					</div>
				</div>
				</div>
			</form:form>
			<!-- End # Login Form -->
		</div>
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

	<script src="<c:url value="/assets/js/main.js"/>"></script>
</body>
</html>