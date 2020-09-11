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
<title>Rando - Détails étape</title>
</head>
<body class="bg-dark">
	<div class="container">
		<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
		<div class="container bg-light">
			<c:if test="${!empty sessionScope.moi}">
				<section>
					<bouton class="btn btn-success mt-3"> <a
						href="<c:url value='/modifEtape/${etape.id}'/>">Modifier</a> </bouton>
				</section>
				<H2>${etape.nom}</H2>
				<div>
					<h3>Description :</h3>
					<pre>${etape.description}</pre>
				</div>
				<h3>Action :</h3>
				<a class="btn btn-primary" target="_blank"
					href="<c:url value='/etape/${etape.id}/qrcode.pdf'/>">QR Code
					de l'étape</a>
				<h3>Photos :</h3>
				<section>
					<div class="container">
						<c:forEach begin="0" end="6" step="1">
							<div class="media">
								<img src="..." class="align-self-start mr-3" alt="...">
								<div class="media-body">
									<h5 class="mt-0">Top-aligned media</h5>
									<p>Cras sit amet nibh libero, in gravida nulla. Nulla vel
										metus scelerisque ante sollicitudin. Cras purus odio,
										vestibulum in vulputate at, tempus viverra turpis. Fusce
										condimentum nunc ac nisi vulputate fringilla. Donec lacinia
										congue felis in faucibus.</p>
									<p>Donec sed odio dui. Nullam quis risus eget urna mollis
										ornare vel eu leo. Cum sociis natoque penatibus et magnis dis
										parturient montes, nascetur ridiculus mus.</p>
								</div>
							</div>
						</c:forEach>
					</div>
				</section>
			</c:if>
			<c:if test="${empty sessionScope.moi}">

				<div class="row">
					<div class="col-6" style="border: 2px solid black">
						<h1>
							<c:out value="${etape.nom}" />
						</h1>
					</div>
					<div class="col-4" style="border: 2px solid black">
						<form:form servletRelativeAction="/ajoutLike/${etape.id}"
							modelAttribute="etape">
							<div class="checkbox">
								<label> <input type="checkbox" data-toggle="toggle">
									Option one is enabled
								</label>
							</div>
						</form:form>
					</div>
					<div class="col-2" style="border: 2px solid black">
						<p>
							Nombre de like :
							<c:out value="${etape.nbLike}" />
						</p>
					</div>
				</div>
				<div class="row" style="border: 2px solid black">
					<form:form servletRelativeAction="/ajoutCommentaire/${etape.id}"
						modelAttribute="etape">
						<form:textarea path="description" />
						<button class="btn btn-success" type="submit">Commentez</button>
					</form:form>
				</div>
			</c:if>
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
