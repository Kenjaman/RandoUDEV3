$(document).ready(function() {
	$(".btn-ajouter").click(function(){
		let div = $( "#etape" ).clone();
		div.id="";
		div.appendTo( "#groupeEtape" );
	});
});