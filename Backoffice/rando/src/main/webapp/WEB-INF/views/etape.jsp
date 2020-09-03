<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<H1 class="text-success">L'association de randonnée K.J.P</H1>
		<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	</div>
	<div class="container bg-light">
		<H2>${etape.nom}</H2>
		<div>
			<h3>Description :</h3>
			<pre>${etape.description}</pre>
		</div>
		<h3>Action :</h3>
		<a class="btn btn-primary" target="_blank"
			href="<c:url value='/etape/${etape.id}/qrcode.pdf'/>">Générer
			affiche du QR Code</a>
		<h3>Photos :</h3>
		<section>
			<div class="container">
				<c:forEach begin="0" end="6" step="1">
				<div class="media">
					<img src="..." class="align-self-start mr-3" alt="...">
					<div class="media-body">
						<h5 class="mt-0">Top-aligned media</h5>
						<p>Cras sit amet nibh libero, in gravida nulla. Nulla vel
							metus scelerisque ante sollicitudin. Cras purus odio, vestibulum
							in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
							nisi vulputate fringilla. Donec lacinia congue felis in faucibus.</p>
						<p>Donec sed odio dui. Nullam quis risus eget urna mollis
							ornare vel eu leo. Cum sociis natoque penatibus et magnis dis
							parturient montes, nascetur ridiculus mus.</p>
					</div>
				</div>
				</c:forEach>
			</div>
		</section>
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
