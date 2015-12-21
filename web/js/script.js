$(document).ready(function () {
	$('#addEmp').change(function(){
	if ($('#addEmp').is(":checked"))
		$("#vismoreEmp").css("visibility","visible");
	else
		$("#vismoreEmp").css("visibility","hidden");
	 
 });

	$('#addDept').change(function(){
		if ($('#addDept').is(":checked"))
			$("#vismoreDept").css("visibility","visible");
		else
			$("#vismoreDept").css("visibility","hidden");

	});
});
