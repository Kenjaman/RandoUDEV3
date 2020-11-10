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
		    	error: function(msg,xhr,erreur){
		    		console.log(msg);
		    		console.log(xhr);
		    		console.log(erreur);
		    	}
			});
		});
	});