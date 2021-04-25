<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>${title }</title>

</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="box" style="width: 1200px;">
		<table class="table1200" border="0" align="center" cellpadding="0" cellspacing="15" bgcolor="#FFFFFF">
			<tr valign="top">
				<td width="260" align="center" valign="top" bgcolor="#F5F5F5">
					<!--左侧栏目 -->

					<table height="10" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td></td>
						</tr>
					</table> <!--左侧栏目 --> <!--左侧推荐文章 -->
					<table height="10" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td></td>
						</tr>
					</table>
					<table width="96%" height="250" border="0" cellpadding="0" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#DDDDDD">
						<tr>
							<td valign="top" bgcolor="#FFFFFF"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="dx"
									style="border-radius: 4px;">
									<tr>
										<td width="90" height="35" align="center" class="dh_bj01"><font class="white">热门文章</font></td>
										<td align="right"><img src="themes/nzblue/images/HOT.gif" />&nbsp;</td>
									</tr>
								</table>

								<table width="98%" height="24" border="0" align="center" cellpadding="0" cellspacing="0" class="xux"
									onMouseOver="this.bgColor='#f5f5f5';" onMouseOut="this.bgColor='#FFFFFF';" bgcolor="#ffffff">
									<c:forEach items="${topList}" var="article">
										<tr>
											<td height="33" align="left" valign="middle">&nbsp;<img src="themes/nzblue/images/HOT2.gif" width="7"
												height="7" />&nbsp; <a href="index/read.action?id=${article.articleid }" target="_blank">
													${article.title } </a>
											</td>
										</tr>
									</c:forEach>
								</table></td>
						</tr>
					</table>
					<table height="5" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td></td>
						</tr>
					</table> <!--左侧推荐文章 -->
				</td>
				<td align="center">
					<!--文章显示 -->
					<table width="98%" border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" class="list_title">
						<tr>
							<td width="150" align="center" class="list_title">${banner.bannername }</td>
							<td align="right">您的位置：<a href="index/index.action">首页</a>&nbsp;&gt;&nbsp;&nbsp;<a
								href="index/article.action?id=${banner.bannerid}">${banner.bannername }</a>
							</td>
						</tr>
					</table>
					<table height="20" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td></td>
						</tr>
					</table> <!--图片格式显示 --> <c:forEach items="${articleList}" var="article">
						<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="dx"
							onMouseOver="this.bgColor='#f5f5f5';" onMouseOut="this.bgColor='#FFFFFF';" bgcolor="#ffffff">
							<tr>
								<td width="35" height="40" align="center"><img src="themes/nzblue/images/txt.png" alt="图标" /></td>
								<td align="left"><a href="index/read.action?id=${article.articleid }" target="_blank"> ${article.title }</a></td>
								<td width="110" align="left">浏览：${article.hits }次</td>
								<td width="180" align="left">发稿：${article.addtime }</td>
							</tr>
						</table>
					</c:forEach>
				</td>
			</tr>
		</table>
		<table border="0" align="center">
			<tr>
				<td align="right">
					<p align="center">${html }</p>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

