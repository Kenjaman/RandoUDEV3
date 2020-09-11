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
<!-- <link rel="stylesheet" href="css/rando.css" type="text/css" /> -->
<title>Rando - Ajouter/Modifier une étape</title>
</head>
<body class="bg-dark">
	<div class="container rando rando_design">
		<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
		<div class="container bg-light">
			<c:if test="${!empty etapeDto && etapeDto.id>=1}">
				<c:set var="id" value="${etapeDto.id}" />
				<c:out value="${id}" />
			</c:if>
			<form:form
				servletRelativeAction="${!empty etapeDto.id && etapeDto.id==0 ? '/ajoutEtape' : '/modifEtape'}"
				modelAttribute="etapeDto">
				<div class="modal-body">
					<div class="form-row">
						<div class="col-md-6 mb-3">
							<label for="nom">Nom de l'etape:</label>
							<form:input class="form-control" path="nom" required="required" />
						</div>
					</div>
					<label for="description">Description :</label> <br>
					<form:textarea path="description" class="form-control" />
					<div class="form-row pt-3">
						<c:if test="${!empty etapeDto.id && etapeDto.id==0}">
							<button class="btn btn-success mr-3" type="submit">Ajouter</button>
						</c:if>
						<c:if test="${!empty etapeDto.id && etapeDto.id>=1}">
							<button class="btn btn-success" type="submit"
								style="margin-right: 1%">Modifier</button>
							<input type="hidden" name="id" value="${etapeDto.id}" />
						</c:if>
						<a class="btn btn-danger" href="<c:url value='/etapes'/>">Annuler</a>
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
