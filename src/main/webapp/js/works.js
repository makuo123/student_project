$(function() {

	$("#wno")
			.blur(
					function() {
						$("#wno_msg").empty();
						var name = $(this).val();
						if (name == "" || name == null) {
							$("#wno")
									.after(
											"<span id='wno_msg' style='color: red'>排班号不能为空</span>");
						}
					});

	$("#deptid")
			.blur(
					function() {
						$("#deptid_msg").empty();
						var name = $(this).val();
						if (name == "" || name == null) {
							$("#deptid")
									.after(
											"<span id='deptid_msg' style='color: red'>科室不能为空</span>");
						}
					});

	$("#doctorid")
			.blur(
					function() {
						$("#doctorid_msg").empty();
						var name = $(this).val();
						if (name == "" || name == null) {
							$("#doctorid")
									.after(
											"<span id='doctorid_msg' style='color: red'>医生不能为空</span>");
						}
					});

	$("#workdate")
			.blur(
					function() {
						$("#workdate_msg").empty();
						var name = $(this).val();
						if (name == "" || name == null) {
							$("#workdate")
									.after(
											"<span id='workdate_msg' style='color: red'>日期不能为空</span>");
						}
					});

	$("#memo")
			.blur(
					function() {
						$("#memo_msg").empty();
						var name = $(this).val();
						if (name == "" || name == null) {
							$("#memo")
									.after(
											"<span id='memo_msg' style='color: red'>备注不能为空</span>");
						}
					});

	$('#sub')
			.click(
					function() {
						var wno = $("#wno").val();
						var deptid = $("#deptid").val();
						var doctorid = $("#doctorid").val();
						var workdate = $("#workdate").val();
						var memo = $("#memo").val();
						$("#wno_msg").empty();
						$("#deptid_msg").empty();
						$("#doctorid_msg").empty();
						$("#workdate_msg").empty();
						$("#memo_msg").empty();
						if (wno == "" || wno == null) {
							$("#wno")
									.after(
											"<span id='wno_msg' style='color: red'>排班号不能为空</span>");
							return false;
						}
						if (deptid == "" || deptid == null) {
							$("#deptid")
									.after(
											"<span id='deptid_msg' style='color: red'>科室不能为空</span>");
							return false;
						}
						if (doctorid == "" || doctorid == null) {
							$("#doctorid")
									.after(
											"<span id='doctorid_msg' style='color: red'>医生不能为空</span>");
							return false;
						}
						if (workdate == "" || workdate == null) {
							$("#workdate")
									.after(
											"<span id='workdate_msg' style='color: red'>日期不能为空</span>");
							return false;
						}
						if (memo == "" || memo == null) {
							$("#memo")
									.after(
											"<span id='memo_msg' style='color: red'>备注不能为空</span>");
							return false;
						}
					});
	$('#res').click(function() {
		$("#wno_msg").empty();
		$("#deptid_msg").empty();
		$("#doctorid_msg").empty();
		$("#workdate_msg").empty();
		$("#memo_msg").empty();
	});

});
