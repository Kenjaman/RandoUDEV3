$(document).ready(function() {
	$(".btn-ajouter").click(function() {
		let div = $("#etape").clone();
		div.removeAttr('id');
		div.appendTo("#groupeEtape");
	});

	//	$(".delete").click(function(){
	//		let divd = $(this).parent();
	//		alert("remove "+divd);
	//		divd.remove();
	//	});

});

function deleted(elmt) {
	let div2 = elmt.parentNode;
	div2.remove();
}

function toggleMdp(id) {
	var oeilOuvert = document.getElementById('eye-open');
	var oeilFerme = document.getElementById('eye-close');
	var x = document.getElementById(id);
	//x.type = (x.type === "password") ? "text" : "password";
	if (x.type === "password") {
		x.type = "text";
		oeilOuvert.style.display = "none";
		oeilFerme.style.display = "block";
	} else {
		x.type = "password";
		oeilOuvert.style.display = "block";
		oeilFerme.style.display = "none";
	}
}