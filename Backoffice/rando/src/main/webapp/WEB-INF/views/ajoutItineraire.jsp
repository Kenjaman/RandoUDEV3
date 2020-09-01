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
	<div class="container bg-light">
		
	</div>
</div>
</body>
</html>
