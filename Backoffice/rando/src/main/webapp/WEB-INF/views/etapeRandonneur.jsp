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
<title>${etape.nom}</title>
</head>
<body class="bg-light">
	<div class="container">
			<div> 	

			<button id="btn-like" class="">like</button>
			<pre>Nombre like : <span id="nbLike">${etape.nbLike}</span></pre>
			<p id="description">${etape.description}</p>
			<input type="hidden" id="etapeId" value="${etape.id }"/>
			</div>
		
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
		
	<script type="text/javascript"> <%-- src="<c:url value='assets/js/randoEtape.js'/>" --%>
	$(document).ready(function(){
		var id_etape = $('#etapeId').val();
		 $("#btn-like").click(function(){
			var action = $("#btn-like").hasClass("liked")?"dislike":"like";
		    var data = {"id":parseInt(id_etape), "nom":$("title").text(),"description":$("#description").text(), "nbLike": parseInt($("#nbLike").text())};		
        	
	 		$.ajax({
				url: '/rando/api/etape/'+action,
			    type: 'PUT',
			    data: JSON.stringify(data),
			    contentType: 'application/json; charset=utf-8',
			    dataType: 'text',
			    success: function(msg) {
			        $("#nbLike").text(msg);
			        $("#btn-like").toggleClass("liked");
					if($("#btn-like").hasClass("liked")){
						$("#btn-like").text("Dislike");
					}else{
						$("#btn-like").text("Like");
					}
					
		    	},
		    	error: 
			});
		});
	});
	</script>
		
</body>
</html>
