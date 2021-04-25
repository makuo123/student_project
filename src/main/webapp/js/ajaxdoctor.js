$(function() {
	$('#deptid').change(function(){
		var deptid = $("#deptid").val();
		var loc = $("#basepath").val();
		var url = loc+"ajax/getDoctor.action?id=" + deptid;
		$.ajax({
			type : "get",
			url : url,
			dataType : "json",
			success : function(json) {
				var doctorid = json.doctorid.replace("[", "").replace("]", "").split(",");
				var doctorname = json.doctorname.replace("[", "").replace("]", "").split(",");
				var myOptions = '<option value="">---请选择医生---</option>';
				for (var i = 0; i < doctorid.length; i++) {
					myOptions += '<option value="' + doctorid[i] + '">' + doctorname[i] + '</option>';
				}
				$("#doctorid").empty();
				$("#doctorid").html(myOptions);
			},
			error : function() {
				alert("ajax请求发生错误3");
			}
		});
	});
});