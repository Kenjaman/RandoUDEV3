$(document).ready(function() {
	$(".btn-ajouter").click(function(){
		let div = $( "#etape" ).clone();
		div.removeAttr('id');
		div.appendTo( "#groupeEtape" );
	});
});