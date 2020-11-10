<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- CSS BootStrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<!-- CSS Custom -->
<link rel="stylesheet" href="<c:url value='/css/rando.css'/>"
	type="text/css" />
<link rel="stylesheet" href="<c:url value='./css/rando.css'/>"
	type="text/css" />
<!-- Deux car bug de chargement lorsque l'adresse est "localhost:8080/rando"
 -->
<title>Rando</title>
</head>
<body class="bg-dark">
	<div class="container rando rando_design">
		<h1 class="text-success">Association de Randonnée K.P</h1>
		<div id="myCarousel" class="carousel slide carousel-fade pt-5"
			data-ride="carousel" data-interval="3000">
			<div class="carousel-indicators pb-5">
				<section>
					<a class="btn btn-primary mr-3" href="itineraires?itineraireKey=R">RONDONNEUR</a>
				</section>
				<br>
				<section>
					<a class="btn btn-primary" href="<c:url value='/logMe'/>"> <!-- 				<a href="itineraires?itineraireKey=A">ADMINISTRATEUR</a> -->
						ADMINISTRATEUR
					</a>
				</section>
			</div>
			<div class="carousel-inner">

				<div class="carousel-item active">
					<img class="first-slide animated zoomInUp"
						src="<c:url value='/images/paysage-randonnée.jpg'/>" alt="">
				</div>
				<div class="carousel-item">
					<img class="second-slide animated zoomInDown"
						src="<c:url value='/images/queyras-ceillac-lac-miroir.jpg'/>"
						alt="">
				</div>
				<div class="carousel-item">
					<img class="third-slide animated zoomIn"
						src="<c:url value='/images/randonnees-vers-lacs-de-montagnes2.jpg'/>" alt="">
				</div>
			</div>
			<a class="carousel-control-prev" href="#myCarousel" role="button"
				data-slide="prev"> <span class="carousel-control-prev-icon"
				aria-hidden="true"></span> <span class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#myCarousel" role="button"
				data-slide="next"> <span class="carousel-control-next-icon"
				aria-hidden="true"></span> <span class="sr-only">Next</span>
			</a>
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
