$(function() {

$("#ordercode").blur(
		function() {
			$("#ordercode_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#ordercode").after("<span id='ordercode_msg' style='color: red'>挂号单号不能为空</span>");
			}
	});

$("#usersid").blur(
		function() {
			$("#usersid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
			}
	});

$("#deptid").blur(
		function() {
			$("#deptid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#deptid").after("<span id='deptid_msg' style='color: red'>挂号科室不能为空</span>");
			}
	});

$("#cateid").blur(
		function() {
			$("#cateid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cateid").after("<span id='cateid_msg' style='color: red'>挂号类型不能为空</span>");
			}
	});

$("#orderdate").blur(
		function() {
			$("#orderdate_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#orderdate").after("<span id='orderdate_msg' style='color: red'>预约日期不能为空</span>");
			}
	});

$("#symptoms").blur(
		function() {
			$("#symptoms_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#symptoms").after("<span id='symptoms_msg' style='color: red'>症状描述不能为空</span>");
			}
	});







$('#sub').click(function(){
var ordercode = $("#ordercode").val();
var usersid = $("#usersid").val();
var deptid = $("#deptid").val();
var cateid = $("#cateid").val();
var orderdate = $("#orderdate").val();
var symptoms = $("#symptoms").val();
$("#ordercode_msg").empty();
$("#usersid_msg").empty();
$("#deptid_msg").empty();
$("#cateid_msg").empty();
$("#orderdate_msg").empty();
$("#symptoms_msg").empty();
if (ordercode == "" || ordercode == null) {
	$("#ordercode").after("<span id='ordercode_msg' style='color: red'>挂号单号不能为空</span>");
	return false;
}
if (usersid == "" || usersid == null) {
	$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
	return false;
}
if (deptid == "" || deptid == null) {
	$("#deptid").after("<span id='deptid_msg' style='color: red'>挂号科室不能为空</span>");
	return false;
}
if (cateid == "" || cateid == null) {
	$("#cateid").after("<span id='cateid_msg' style='color: red'>挂号类型不能为空</span>");
	return false;
}
if (orderdate == "" || orderdate == null) {
	$("#orderdate").after("<span id='orderdate_msg' style='color: red'>预约日期不能为空</span>");
	return false;
}
if (symptoms == "" || symptoms == null) {
	$("#symptoms").after("<span id='symptoms_msg' style='color: red'>症状描述不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#ordercode_msg").empty();
$("#usersid_msg").empty();
$("#deptid_msg").empty();
$("#cateid_msg").empty();
$("#orderdate_msg").empty();
$("#symptoms_msg").empty();
});

});
