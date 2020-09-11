<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- CSS Bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
	<!-- <link rel="stylesheet" href="../css/rando.css" type="text/css" /> -->
<title>Rando - Avis étape : ${etape.nom}</title>
</head>
<body class="bg-light">
		<div class="container bg-light">
			<div class="modal-body">
				<div class="row">
					<div class="col-md-6 mb-3">
						<label>Nom de l'étape :</label> <input class="form-control"
							value="${etape.nom}" readonly="readonly" />
					</div>
					<div class="col-md-6 mb-3">
						<label>Nombre like : <span id="nbLike">${etape.nbLike}</span></label>
						<button id="btn-like" class="">like</button>
						<input type="hidden" id="etapeId" value="${etape.id }" />
					</div>
				</div>
				<label for="description">Description :</label> <br>
				<textarea class="form-control" readonly="readonly"><c:out
						value="${etape.description}" /></textarea>
				<%-- <form:form servletRelativeAction="/commentez/${etape.id}" modelAttribute="commentaireDto">
					<br>
					<label for="commentaire">Commentaire :</label>
					<br>
 					<c:forEach var="com" items="${etape.allComs}"> 
 					<form:textarea class="form-control" path="com" placeholder="Vous pouvez commentez cette étape ici"/> 
 					</c:forEach>
					<button class="btn btn-success" type="submit">Valider</button>
				</form:form> --%>
			</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>

	<script type="text/javascript"
		src="<c:url value='/assets/js/randoEtape.js'/>"></script>

</body>
</html>
