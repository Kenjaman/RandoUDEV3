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
<!-- <link rel="stylesheet" href="../css/rando.css" type="text/css" />
 --><title>Rando - Détails itinéraire</title>
</head>
<body class="bg-dark">	
	<div class="container">
		<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
		<div class="container bg-light">
		<span class="text-success"><c:out value="${param.messageReussite}" /></span>
			<table class="table table-striped">
				<thead>
					<tr>
						<c:if test="${!empty sessionScope.moi}">
							<th></th>
						</c:if>
						<th>Nom de l'itinéraire</th>
						<th>Niveau requis</th>
						<th>Etapes</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:if test="${!empty sessionScope.moi}">
							<form:form
								servletRelativeAction="/modifItineraireDetail/${itineraire.id}"
								modelAttribute="itineraire">
								<td>
									<a class="btn btn-danger" href="<c:url value='/itineraires'/>">Tout annuler</a>
									<button type="submit" class="btn btn-primary">Modifier</button></td>
								<td><form:input path="nom" class="form-control" /></td>
								<td><form:select path="niveau" class="form-control">
										<form:options items="${niveau}" />
									</form:select></td>
							</form:form>
						</c:if>
						<c:if test="${empty sessionScope.moi}">
							<td><c:out value='${itineraire.nom}' /></td>
							<td><c:out value='${itineraire.niveau}' /></td>
						</c:if>
						<td><ul class="list-group">
								<c:forEach items="${itineraire.etapeitineraires}"
									var="etapeItineraire">
									<li class="list-group-item"><c:if
											test="${empty sessionScope.moi}">
											<a href="<c:url value='/etape/view/${etapeItineraire.etape.id}'/>"><c:out
													value="${etapeItineraire.etape.nom}" /></a>
										</c:if> <c:if test="${!empty sessionScope.moi}">
											<a
												href="<c:url value='/etape/detail/${etapeItineraire.etape.id}'/>"><c:out
													value="${etapeItineraire.etape.nom}" /></a>
										</c:if></li>
									<c:set var="etapeId" value="${etapeItineraire.etape.id}" />
<!-- 									<c:if test="${!empty sessionScope.moi}">
										<form:form
											servletRelativeAction="/actionSurEtapeItineraire/${etapeId}"
											modelAttribute="etapeItineraireDto">
											<li class="list-group-item"><form:select path="etape"
													class="form-control">
													<form:option value="-">Remplacer par une autre étape</form:option>
													<c:forEach items="${etapes}" var="etape">
														<form:option value="${etape.nom}"></form:option>
													</c:forEach>
												</form:select></li>
											<%-- 											<c:if test="${!empty sessionScope.moi}"> --%>

										<div class="form-row">
												<button class="btn btn-success mr-3 mt-3 mb-3" type="submit" name="action"
													value="modification">
													<svg width="10em" height="1em" viewBox="0 0 16 16"
														class="bi bi-pen-fill" fill="currentColor"
														xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
															d="M13.498.795l.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001z" />
</svg>
												</button>
												<button type="submit" class="btn btn-danger mt-3 mb-3" name="action"
													value="suppression">
													<svg width="10em" height="1em" viewBox="0 0 16 16"
														class="bi bi-trash-fill" fill="currentColor"
														xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
															d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5a.5.5 0 0 0-1 0v7a.5.5 0 0 0 1 0v-7z" />
</svg>
												</button> -->
											</div>
											<%-- 											</c:if> --%>
										</form:form>
									</c:if>
								</c:forEach>
							</ul></td>
					</tr>
				</tbody>
			</table>

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
