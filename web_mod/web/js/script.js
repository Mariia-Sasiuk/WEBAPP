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

	$("#datepicker").datepicker({dateFormat:"yy-mm-dd"
	});
});
//function MyFunction(){
//	name=/[A-z]{1,5}/;
//	job=/[A-z]{1,10}[0-9]{0,2}/;
//	mgr=/[1-9]{1}[0-9]{3}/;
//
//	if (name.exec(document.getElementById('name').value)&&
//		job.exec(document.getElementById('job').value)&&
//		mgr.exec(document.getElementById('mgr').value)) {
//		return true;
//	}
//	else {alert("qwerrttttt");return false;};
//
//};
