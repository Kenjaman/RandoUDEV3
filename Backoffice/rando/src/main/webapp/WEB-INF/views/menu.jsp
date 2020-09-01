<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		<div class="navbar-nav">
			<a class="nav-link" href="<c:url value='/itineraires'/>">Consulter
				la liste des itin�raires existants</a> <a class="nav-link"
				href="<c:url value='/etapes'/>">Consulter la liste des �tapes
				existantes</a> <a class="nav-link"
				href="<c:url value='/ajoutItineraire'/>">Cr�er un nouvel
				itin�raire</a> <a class="nav-link" href="<c:url value='/ajoutEtape'/>">R�ferencer
				une nouvelle �tape</a> <a class="nav-link" href="#" role="button"
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
				<form:form id="login-form" servletRelativeAction="/authentification"
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