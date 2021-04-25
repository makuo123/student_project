<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
	String role = (String) session.getAttribute("role");
	if ("管理员".equals(role)) {
%>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">

		<dl id="menu-admin">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>管理员信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="admin/createAdmin.action" data-title="新增管理员" href="javascript:void(0)">新增管理员信息</a></li>
					<li><a data-href="admin/getAllAdmin.action" data-title="管理员列表" href="javascript:void(0)">管理员信息列表</a></li>
					<li><a data-href="admin/queryAdminByCond.action" data-title="管理员查询" href="javascript:void(0)">管理员信息查询</a></li>
					<li><a data-href="admin/prePwd.action" data-title="修改密码" href="javascript:void(0)">修改密码</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>医生用户信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="doctor/createDoctor.action" data-title="新增医生用户" href="javascript:void(0)">新增医生用户信息</a></li>
					<li><a data-href="doctor/getAllDoctor.action" data-title="医生用户列表" href="javascript:void(0)">医生用户信息列表</a></li>
					<li><a data-href="doctor/queryDoctorByCond.action" data-title="医生用户查询" href="javascript:void(0)">医生用户信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu-member">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>网站用户信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="users/getAllUsers.action" data-title="网站用户列表" href="javascript:void(0)">网站用户信息列表</a></li>
					<li><a data-href="users/queryUsersByCond.action" data-title="网站用户查询" href="javascript:void(0)">网站用户信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>科室信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="dept/createDept.action" data-title="新增科室" href="javascript:void(0)">新增科室信息</a></li>
					<li><a data-href="dept/getAllDept.action" data-title="科室列表" href="javascript:void(0)">科室信息列表</a></li>
					<li><a data-href="dept/queryDeptByCond.action" data-title="科室查询" href="javascript:void(0)">科室信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>提示问题信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="safes/createSafes.action" data-title="新增提示问题" href="javascript:void(0)">新增提示问题信息</a></li>
					<li><a data-href="safes/getAllSafes.action" data-title="提示问题列表" href="javascript:void(0)">提示问题信息列表</a></li>
					<li><a data-href="safes/querySafesByCond.action" data-title="提示问题查询" href="javascript:void(0)">提示问题信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>挂号类型信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="cate/createCate.action" data-title="新增挂号类型" href="javascript:void(0)">新增挂号类型信息</a></li>
					<li><a data-href="cate/getAllCate.action" data-title="挂号类型列表" href="javascript:void(0)">挂号类型信息列表</a></li>
					<li><a data-href="cate/queryCateByCond.action" data-title="挂号类型查询" href="javascript:void(0)">挂号类型信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>预约挂号信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="orders/getAllOrders.action" data-title="预约挂号列表" href="javascript:void(0)">预约挂号信息列表</a></li>
					<li><a data-href="orders/queryOrdersByCond.action" data-title="预约挂号查询" href="javascript:void(0)">预约挂号信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>医嘱信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="advice/getAllAdvice.action" data-title="医嘱列表" href="javascript:void(0)">医嘱信息列表</a></li>
					<li><a data-href="advice/queryAdviceByCond.action" data-title="医嘱查询" href="javascript:void(0)">医嘱信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>医生排班信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="works/createWorks.action" data-title="新增医生排班" href="javascript:void(0)">新增医生排班信息</a></li>
					<li><a data-href="works/getAllWorks.action" data-title="医生排班列表" href="javascript:void(0)">医生排班信息列表</a></li>
					<li><a data-href="works/queryWorksByCond.action" data-title="医生排班查询" href="javascript:void(0)">医生排班信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>调班申请信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="applys/getAllApplys.action" data-title="调班申请列表" href="javascript:void(0)">调班申请信息列表</a></li>
					<li><a data-href="applys/queryApplysByCond.action" data-title="调班申请查询" href="javascript:void(0)">调班申请信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>意见反馈信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="complains/getAllComplains.action" data-title="意见反馈列表" href="javascript:void(0)">意见反馈信息列表</a></li>
					<li><a data-href="complains/queryComplainsByCond.action" data-title="意见反馈查询" href="javascript:void(0)">意见反馈信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>网站栏目信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="banner/createBanner.action" data-title="新增网站栏目" href="javascript:void(0)">新增网站栏目信息</a></li>
					<li><a data-href="banner/getAllBanner.action" data-title="网站栏目列表" href="javascript:void(0)">网站栏目信息列表</a></li>
					<li><a data-href="banner/queryBannerByCond.action" data-title="网站栏目查询" href="javascript:void(0)">网站栏目信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>网站内容信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="article/createArticle.action" data-title="新增网站内容" href="javascript:void(0)">新增网站内容信息</a></li>
					<li><a data-href="article/getAllArticle.action" data-title="网站内容列表" href="javascript:void(0)">网站内容信息列表</a></li>
					<li><a data-href="article/queryArticleByCond.action" data-title="网站内容查询" href="javascript:void(0)">网站内容信息查询</a></li>
				</ul>
			</dd>
		</dl>
		
		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>数据统计<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="admin/chartmoney.jsp" data-title="挂号收入统计" href="javascript:void(0)">挂号收入统计</a></li>
					<li><a data-href="admin/chartnum.jsp" data-title="挂号数量统计" href="javascript:void(0)">挂号数量统计</a></li>
					<li><a data-href="admin/daytotal.jsp" data-title="日报表" href="javascript:void(0)">日报表</a></li>
					<li><a data-href="orders/monthtotal.action" data-title="当月报表" href="javascript:void(0)">当月报表</a></li>
				</ul>
			</dd>
		</dl>

	</div>
</aside>
<%
	} else {
%>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>医生用户信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="doctor/prePwd.action" data-title="修改密码" href="javascript:void(0)">修改密码</a></li>
					<li><a data-href="doctor/personal.action" data-title="个人信息" href="javascript:void(0)">个人信息</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>预约挂号信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="orders/getTodayOrders.action" data-title="预约挂号列表" href="javascript:void(0)">今日预约挂号</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>医嘱信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="advice/getMyAdvice.action" data-title="医嘱列表" href="javascript:void(0)">我的医嘱</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>医生排班信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="works/getMyWorks.action" data-title="医生排班列表" href="javascript:void(0)">医生排班信息列表</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>调班申请信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="applys/getMyApplys.action" data-title="调班申请列表" href="javascript:void(0)">我的调班申请</a></li>
				</ul>
			</dd>
		</dl>



	</div>
</aside>
<%
	}
%>

