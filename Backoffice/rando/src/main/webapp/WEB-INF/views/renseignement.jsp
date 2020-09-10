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
<link rel="stylesheet" href="css/rando.css" type="text/css" />
<title>Rando - Informations</title>
</head>
<body class="bg-dark">
	<div class="container rando rando_design">
		<%-- 		<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include> --%>
		<div class="container bg-light">
			<form:form servletRelativeAction="/inscription"
				modelAttribute="utilisateurDto">
				<div class="modal-body">
					<div id="div-login-msg">
						<span class="h3 text-success">Inscrivez-vous</span> <br>
						<br>
						<form:input path="pseudo" class="form-control" required="required"
							placeholder="Nom d'utilisateur" />
							<br>
						<form:password path="mdp" class="form-control" required="required"
							placeholder="********" />
						<div class="modal-footer">
							<button type="submit" class="btn btn-success">Valider</button>
							<button class="btn btn-danger">
								<a href="<c:url value='/accueil'/>">Annuler</a>
							</button>
						</div>
					</div>
				</div>
			</form:form>
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
</body>
</html>