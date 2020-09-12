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
						<span class="h3 text-success">Authentifiez-vous</span> <br> <br>
						<form:errors path="*"></form:errors>
						<!-- ne fonctionne pas -->
						<input type="text" id="login_username" name="pseudo"
							class="form-control" placeholder="Nom d'utilisateur" value="" />
						<br>
						<div class="form-group" id="groupeEtape">
							<div class="form-row row mb-2" id="etape">
								<input type="password" id="login_password"
									class="form-control col" name="mdp" placeholder="********"
									required="required" value=""/>
								<button type="button" class="btn btn-primary col-1"
									onclick="toggleMdp('login_password')">
									<div id="eye-open">
										<svg width="1em" height="1em" viewBox="0 0 16 16"
											class="bi bi-eye-fill" fill="currentColor"
											xmlns="http://www.w3.org/2000/svg">
  <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z" />
  <path fill-rule="evenodd"
												d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z" />
</svg>
									</div>
									<div id="eye-close">
										<svg width="1em" height="1em" viewBox="0 0 16 16"
											class="bi bi-eye-slash-fill" fill="currentColor"
											xmlns="http://www.w3.org/2000/svg">
  <path
												d="M10.79 12.912l-1.614-1.615a3.5 3.5 0 0 1-4.474-4.474l-2.06-2.06C.938 6.278 0 8 0 8s3 5.5 8 5.5a7.029 7.029 0 0 0 2.79-.588zM5.21 3.088A7.028 7.028 0 0 1 8 2.5c5 0 8 5.5 8 5.5s-.939 1.721-2.641 3.238l-2.062-2.062a3.5 3.5 0 0 0-4.474-4.474L5.21 3.089z" />
  <path
												d="M5.525 7.646a2.5 2.5 0 0 0 2.829 2.829l-2.83-2.829zm4.95.708l-2.829-2.83a2.5 2.5 0 0 1 2.829 2.829z" />
  <path fill-rule="evenodd"
												d="M13.646 14.354l-12-12 .708-.708 12 12-.708.708z" />
</svg>
									</div>
								</button>
							</div>
						</div>
						<div class="modal-footer">
							<button class="btn btn-success" type="submit">Connectez-vous</button>
							<a class="btn btn-secondary"
								href="<c:url value='/renseignement'/>">Inscrivez-vous</a> <a
								class="btn btn-danger" href="<c:url value='/'/>">Annuler</a>
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