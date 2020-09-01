<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<title>Rando</title>
</head>
<body class="bg-dark">
<div class="container">
	<H1>Application Web de responsable d'association de randonnée</H1>
	
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
   	 			<div class="navbar-nav">	
					<a class="nav-item nav-link active" href="<c:url value='/itineraires'/>">Consulter la liste des itinéraires existants</a>
					<a class="nav-item nav-link" href="<c:url value='/etapes'/>">Consulter la liste des étapes existantes</a>
					<a class="nav-item nav-link" href="<c:url value='/ajoutItineraire'/>">Créer un nouvel itinéraire</a>
					<a class="nav-item nav-link" href="<c:url value='/ajoutEtape'/>">Réferencer une nouvelle étape</a>
				</div>
			</div>
		</nav>
	</div>
	<div class="list-group">
		<a class="btn btn-primary" href="<c:url value='/ajoutItineraire'/>">Ajouter
			un itineraire <svg width="1em" height="1em" viewBox="0 0 16 16"
				class="bi bi-clipboard-plus" fill="currentColor"
				xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
					d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1v-1z"></path>
  <path fill-rule="evenodd"
					d="M9.5 1h-3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3zM8 7a.5.5 0 0 1 .5.5V9H10a.5.5 0 0 1 0 1H8.5v1.5a.5.5 0 0 1-1 0V10H6a.5.5 0 0 1 0-1h1.5V7.5A.5.5 0 0 1 8 7z"></path>
</svg>
		</a>
		<c:forEach items="${itineraires}" var="itineraire">
			<a class="list-group-item list-group-item-action" href="<c:url value='/itineraire/${itineraire.id}'/>"><c:out value="${itineraire.nom}"></c:out></a>
		</c:forEach>
	</div>
</body>
</html>
