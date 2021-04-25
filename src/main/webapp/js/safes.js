$(function() {

$("#safesname").blur(
		function() {
			$("#safesname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#safesname").after("<span id='safesname_msg' style='color: red'>提示问题不能为空</span>");
			}
	});







$('#sub').click(function(){
var safesname = $("#safesname").val();
$("#safesname_msg").empty();
if (safesname == "" || safesname == null) {
	$("#safesname").after("<span id='safesname_msg' style='color: red'>提示问题不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#safesname_msg").empty();
});

});
