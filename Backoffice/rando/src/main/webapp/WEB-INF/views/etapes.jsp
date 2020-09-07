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
<title>Rando - Liste des étapes</title>
</head>
<body class="bg-dark">
	<div class="container rando rando_design">
		<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
		<c:if test="${!empty messageEchecAjoutEtape}">
			<div class="btn btn-danger avertissement">
				<c:out value="${messageEchecAjoutEtape}" />
			</div>
		</c:if>
		<div class="list-group container">
			<c:if test="${!empty sessionScope.moi}">
				<a class="btn btn-primary" href="<c:url value='/ajoutEtape'/>">Ajouter
					une etape <svg width="1em" height="1em" viewBox="0 0 16 16"
						class="bi bi-clipboard-plus" fill="currentColor"
						xmlns="http://www.w3.org/2000/svg"> <path
							fill-rule="evenodd"
							d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1v-1z"></path> <path
							fill-rule="evenodd"
							d="M9.5 1h-3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3zM8 7a.5.5 0 0 1 .5.5V9H10a.5.5 0 0 1 0 1H8.5v1.5a.5.5 0 0 1-1 0V10H6a.5.5 0 0 1 0-1h1.5V7.5A.5.5 0 0 1 8 7z"></path>
</svg>
				</a>
			</c:if>
			<c:if test="${!empty MsgEchecSuppression}">
				<div class="alert alert-danger">
					<c:out value="${MsgEchecSuppression}" />
				</div>
			</c:if>
			<c:forEach items="${etapes}" var="etape">
				<div class="row">
					<div class="${!empty sessionScope.moi ? 'col-8' : 'col-12'}">
						<a class="list-group-item list-group-item-action"
							href="<c:url value='/etape/${etape.id}'/>"><c:out
								value="${etape.nom}"></c:out></a>
					</div>
					<c:if test="${!empty sessionScope.moi}">
						<div class="col-2">
							<form:form servletRelativeAction="/etape/suppression/${etape.id}"
								modelAttribute="etape">
								<button type="submit" class="btn btn-danger"
									onclick="return(confirm('Voulez-vous vraiment supprimer ' +
                               'définitivement <c:out value="${etape.nom}"/> ?'));">
									<svg width="1em" height="1em" viewBox="0 0 16 16"
										class="bi bi-trash-fill" fill="currentColor"
										xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
											d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5a.5.5 0 0 0-1 0v7a.5.5 0 0 0 1 0v-7z" />
</svg>
								</button>
							</form:form>
						</div>
						<div class="col-2">
							<button class="btn btn-success">
								<a href="<c:url value='/modifEtape/${etape.id}'/>"><svg
										width="1em" height="1em" viewBox="0 0 16 16"
										class="bi bi-pen-fill" fill="currentColor"
										xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
											d="M13.498.795l.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001z" />
</svg></a>
							</button>
						</div>
					</c:if>
				</div>
			</c:forEach>
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
