$(document).ready(function() {
	$('#show').click(function() {
		$("#menu").slideDown("slow");
		$("#show").hide("slow");
		$("#hide").show("slow");
	});
	$('#hide').click(function() {
		$("#menu").slideUp("slow");
		$("#show").show("slow");
		$("#hide").hide("slow");
	});	

	//para tabs
	$('#tabs').tabs();

		// Datepicker
				$('#datepicker').datepicker({
					inline: true
				});
});