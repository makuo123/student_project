<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用后台管理系统</title>
<link rel="stylesheet" type="text/css" href="h-ui/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/style.css" />
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="js/doctor.js" charset="utf-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>医生用户管理 <span class="c-gray en">&gt;</span>
		新增医生用户 <a class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px"
			href="doctor/createDoctor.action" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<article class="page-container">
		<form class="form form-horizontal" id="form-article-add" action="doctor/addDoctor.action" name="myform" method="post">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">用户名</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="username" class="input-text" id="username" placeholder="请输入用户名" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">密码</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" name="password" class="input-text" id="password" placeholder="请输入密码" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">医生姓名</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="doctorname" class="input-text" id="doctorname" placeholder="请输入医生姓名" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">性别</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="radio" name="sex" value="男" title="男" checked>男 &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"
						name="sex" value="女" title="女">女
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">出生日期</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="birthday" class="input-text" id="birthday" onclick="WdatePicker()" readonly="readonly"
						placeholder="请输入出生日期" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">照片</label>
				<div class="formControls col-xs-8 col-sm-9">
					<script type="text/javascript" src="js/selimage.js"></script>
					<input class="input-text" type="text" name="image" id="image" onclick="selimage();" placeholder="请选择图片"
						readonly="readonly" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">所在科室</label>
				<div class="formControls col-xs-8 col-sm-9">
					<span class="select-box"><select name="deptid" class="select" id="deptid"><option value="">---请选择所在科室--</option>
							<c:forEach items="${deptList}" var="dept">
								<option value="${dept.deptid}">${dept.deptname }</option>
							</c:forEach></select></span>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">毕业院校</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="graduate" class="input-text" id="graduate" placeholder="请输入毕业院校" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">学历</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="xueli" class="input-text" id="xueli" placeholder="请输入学历" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">职务</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="duty" class="input-text" id="duty" placeholder="请输入职务" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">医生介绍</label>
				<div class="formControls col-xs-8 col-sm-9">
					<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
					<textarea class="textarea" name="contents" id="contents" placeholder="请输入医生介绍"> </textarea>
					<script type="text/javascript">
						CKEDITOR.replace('contents', {
							language : 'zh-cn'
						});
					</script>
				</div>
			</div>

			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
					<input type="hidden" id="basepath" value="<%=basePath%>" />
					<button id="sub" class="btn btn-secondary radius" type="submit">
						<i class="Hui-iconfont">&#xe632;</i>提交保存
					</button>
					<button id="res" class="btn btn-default radius" type="reset">
						<i class="Hui-iconfont">&#xe68f;</i>取消重置
					</button>
				</div>
			</div>
		</form>
	</article>
</body>
</html>

