$(document).ready(function() {
	$(".btn-ajouter").click(function(){
		let div = $( "#etape" ).clone();
		div.removeAttr('id');
		div.appendTo( "#groupeEtape" );
	});
	
//	$(".delete").click(function(){
//		let divd = $(this).parent();
//		alert("remove "+divd);
//		divd.remove();
//	});

});
function deleted(elmt){
	let div2 = elmt.parentNode;
	div2.remove();
}