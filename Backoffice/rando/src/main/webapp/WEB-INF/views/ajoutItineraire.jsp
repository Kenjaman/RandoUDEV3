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
<!-- <link rel="stylesheet" href="css/rando.css" type="text/css" /> -->
<title>Rando - Ajouter/Modifier une itinéraire</title>
</head>
<body class="bg-dark">
	<div class="container rando rando_design">
		<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
		<div class="container bg-light">
			<form:form servletRelativeAction="/ajoutItineraire"
				modelAttribute="itineraireDto">
				<div class="modal-body">
					<div class="form-row">
						<div class="col-md-6 mb-3">
							<form:label path="nom">Nom de l'itinéraire :</form:label>
							<form:input class="form-control" path="nom" required="required" />
						</div>
						<div class="col-md-6 mb-3">
							<form:label path="niveau">Niveau :</form:label>
							<form:select path="niveau" class="form-control">
								<form:options items="${niveau}" />
							</form:select>
						</div>
					</div>
					<div class="form-row justify-content-between">
						<h3 class="col-4">Etapes :</h3>
						<button type="button"
							class="btn btn-primary btn-lg col-4 btn-ajouter" id="btn">+</button>
					</div>
					<div class="form-group" id="groupeEtape">
						<div class="form-row row mb-2" id="etape">
							<form:label path="etapes"></form:label>
							<select name="etapes" class="form-control col">
								<option value="-" selected>Choisir l'etape</option>
								<c:forEach items="${etapes}" var="etape">
									<option value="${etape.id}">${etape.nom}</option>
								</c:forEach>
							</select>
							<button type="button" class="btn btn-danger col-1" id="delete">
								<svg width="1em" height="1em" viewBox="0 0 16 16"
									class="bi bi-trash" fill="currentColor"
									xmlns="http://www.w3.org/2000/svg">
  <path
										d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"></path>
  <path fill-rule="evenodd"
										d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"></path>
</svg>
							</button>
						</div>
					</div>
					<div class="form-row">
						<button class="btn btn-success" type="submit"
							style="margin-right: 1%">Ajouter</button>
						<a class="btn btn-danger" href="<c:url value='/itineraires'/>">Annuler</a>
					</div>
					<form:errors></form:errors>
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

	<script src="<c:url value="/assets/js/main.js"/>"></script>
</body>
</html>