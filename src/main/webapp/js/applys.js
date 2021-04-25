$(function() {

$("#reason").blur(
		function() {
			$("#reason_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#reason").after("<span id='reason_msg' style='color: red'>调班原因不能为空</span>");
			}
	});

$("#workdate").blur(
		function() {
			$("#workdate_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#workdate").after("<span id='workdate_msg' style='color: red'>原日期不能为空</span>");
			}
	});

$("#orderdate").blur(
		function() {
			$("#orderdate_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#orderdate").after("<span id='orderdate_msg' style='color: red'>计划日期不能为空</span>");
			}
	});

$("#memo").blur(
		function() {
			$("#memo_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
			}
	});







$('#sub').click(function(){
var reason = $("#reason").val();
var workdate = $("#workdate").val();
var orderdate = $("#orderdate").val();
var memo = $("#memo").val();
$("#reason_msg").empty();
$("#workdate_msg").empty();
$("#orderdate_msg").empty();
$("#memo_msg").empty();
if (reason == "" || reason == null) {
	$("#reason").after("<span id='reason_msg' style='color: red'>调班原因不能为空</span>");
	return false;
}
if (workdate == "" || workdate == null) {
	$("#workdate").after("<span id='workdate_msg' style='color: red'>原日期不能为空</span>");
	return false;
}
if (orderdate == "" || orderdate == null) {
	$("#orderdate").after("<span id='orderdate_msg' style='color: red'>计划日期不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#reason_msg").empty();
$("#workdate_msg").empty();
$("#orderdate_msg").empty();
$("#memo_msg").empty();
});

});
