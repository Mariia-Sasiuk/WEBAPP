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

	$("#datepicker").datepicker({dateFormat:"yy-mm-dd",beforeShow: function(){
		$(".ui-datepicker").css('font-size', 12)
	}});
});
