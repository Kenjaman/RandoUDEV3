<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="<c:url value='/css/rando.css'/>" type="text/css" />
<a href="<c:url value='/stop'/>" class="h1 text-success">L'association
	de randonnée K.P</a>
<nav class="navbar navbar-navbar navbar-expand-lg navbar-dark bg-dark">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		<div class="nav navbar-nav">
			<a class="nav-link" href="<c:url value='/itineraires'/>">
				Liste des itinéraires&nbsp;<span class="badge badge-light"><c:out value="${sessionScope.nbItineraires}" /></span>
			</a> 
			<a class="nav-link" href="<c:url value='/etapes'/>">
				Liste des étapes&nbsp;<span class="badge badge-light"><c:out value="${sessionScope.nbEtapes}" /></span>
			</a>
			<c:if test="${!empty sessionScope.key && sessionScope.key=='A'}">
				<c:if test="${empty sessionScope.moi }">
					<!-- 					<a class="nav-link" href="#" role="button" data-toggle="modal" -->
					<!-- 						data-target="#login-modal" title="Connectez-vous"><svg -->
					<!-- 							width="1em" height="1em" viewBox="0 0 16 16" -->
					<!-- 							class="bi bi-person-circle" fill="currentColor" -->
					<!-- 							xmlns="http://www.w3.org/2000/svg"> -->
					<!--   <path -->
					<!-- 								d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z" /> -->
					<!--   <path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" /> -->
					<!--   <path fill-rule="evenodd" -->
					<!-- 								d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z" /> -->
					<!-- </svg></a> -->
					<a class="nav-link" href="<c:url value='/logMe'/>"
						title="Connectez-vous"><svg width="1em" height="1em"
							viewBox="0 0 16 16" class="bi bi-person-circle"
							fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path
								d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z" />
  <path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
  <path fill-rule="evenodd"
								d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z" />
</svg></a>
				</c:if>
			</c:if>
			<c:if test="${!empty sessionScope.moi}">
				<a class="nav-link" href="<c:url value='/stop'/>">Deconnexion</a>
				<a class="nav-link" href="#">
					<span class="badge badge-success">Bienvenue <c:out value="${sessionScope.moi}" /></span>
				</a>
			</c:if>
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
				<!-- 				Begin # Login Form -->
				<%-- 				<form:form id="login-form" servletRelativeAction="/authentification" --%>
				<%-- 					modelAttribute="utilisateurDto"> --%>
				<!-- 					<div class="modal-body"> -->
				<!-- 						<div id="div-login-msg"> -->
				<!-- 							<span>Authentifiez-vous</span> -->
				<!-- 						</div> -->
				<!-- 						<input type="text" id="login_username" name="pseudo" -->
				<!-- 							class="form-control" placeholder="Nom d'utilisateur" value="" /> -->
				<!-- 						<input type="password" id="login_password" class="form-control" -->
				<!-- 							name="mdp" placeholder="********" required="required" value="" /> -->
				<!-- 						<div class="modal-footer"> -->
				<!-- 							<button class="btn btn-success" type="submit">Connectez-vous</button> -->
				<!-- 							<button class="btn btn-secondary"> -->
				<%-- 								<a href="<c:url value='/renseignement'/>">Inscrivez-vous</a> --%>
				<!-- 							</button> -->
				<!-- 						</div> -->
				<!-- 					</div> -->
				<%-- 				</form:form> --%>
				<!-- 				End # Login Form -->
			</div>
		</div>
	</div>
</nav>