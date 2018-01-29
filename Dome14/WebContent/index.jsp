<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
	body{
		background:#f5f5f5;
	}
.header {
	margin: 0px;
	padding: 0px;
	margin-left: 200px;
	margin-top: 30px;
}
h2{
	font-size:40px;
}
a{
	text-decoration: none;
}
span{
	margin-left:20px;
}
</style>
</head>

<body>
	<div class='header'>

		<h2>APP信息管理平台</h2>
		<span><a
			href="${pageContext.request.contextPath }/backend/login">后台管理系统入口</a>
		</span> <br /> <br /> <span><a
			href="${pageContext.request.contextPath }/dev/login">开发者平台入口</a> </span>

	</div>
</body>
</html>
