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
<title>Rando</title>
</head>
<body class="bg-dark">
	<div class="container">
		<c:if test="${!empty statut}">
			<c:if test="${statut=='false' }">
				<div class="btn btn-danger avertissement">
					<c:out value="Connexion échec" />
				</div>
			</c:if>
			<c:if test="${statut=='true' }">
				<div class="btn btn-success avertissement">
					<c:out value="Connexion reussie" />
				</div>
			</c:if>
		</c:if>
		<H1>Application Web de responsable d'association de randonnée</H1>

		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-link" href="<c:url value='/itineraires'/>">Consulter
						la liste des itinéraires existants</a> <a class="nav-link"
						href="<c:url value='/etapes'/>">Consulter la liste des étapes
						existantes</a> <a class="nav-link"
						href="<c:url value='/ajoutItineraire'/>">Créer un nouvel
						itinéraire</a> <a class="nav-link" href="<c:url value='/ajoutEtape'/>">Réferencer
						une nouvelle étape</a> <a class="nav-link" href="#" role="button"
						data-toggle="modal" data-target="#login-modal">Connexion</a>
				</div>
			</div>
			<c:if test="${!empty messageSucces}">
				<div class="btn btn-success avertissement">
					<c:out value="${messageSucces}" />
				</div>
			</c:if>
			<!-- BEGIN # MODAL LOGIN -->
			<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true"
				style="display: none;">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header" align="center">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							</button>
						</div>

						<!-- Begin # Login Form -->
						<form:form id="login-form"
							servletRelativeAction="/authentification"
							modelAttribute="utilisateurDto">
							<div class="modal-body">
								<div id="div-login-msg">
									<span>Authentifiez-vous</span>
								</div>
								<input type="text" id="login_username" name="pseudo"
									class="form-control" placeholder="Nom d'utilisateur" value="" />
								<input type="password" id="login_password" class="form-control"
									name="mdp" placeholder="********" required="required" value="" />
								<div class="modal-footer">
									<button class="btn btn-success" type="submit">Connectez-vous</button>
									<button class="btn btn-secondary">
										<a href="<c:url value='/renseignement'/>">Inscrivez-vous</a>
									</button>
								</div>
							</div>
						</form:form>
						<!-- End # Login Form -->
					</div>
				</div>
			</div>
		</nav>
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
