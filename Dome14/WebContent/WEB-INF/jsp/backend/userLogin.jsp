<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'userLogin.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link
	href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="${pageContext.request.contextPath }/statics/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link
	href="${pageContext.request.contextPath }/statics/css/nprogress.css"
	rel="stylesheet">
<!-- Animate.css -->


<!-- Custom Theme Style -->
<link
	href="${pageContext.request.contextPath }/statics/css/custom.min.css"
	rel="stylesheet">
</head>

<body class="login">
	<div>
		<div class="login_wrapper">
			<div class="animate form login_form">
				<section class="login_content">
				<form
					action="${pageContext.request.contextPath }/backend/backendLoginAction"
					method="post">
					<h1>APP后台管理平台</h1>
					<div class="">${error}</div>
					<div>
						<input type="text" class="form-control" name="codeName"
							placeholder="请输入用户名" required="" />
					</div>
					<div>
						<input type="password" class="form-control" name="userPassword"
							placeholder="请输入密码" required="" />
					</div>
					<div>
						<input type="submit" class="btn btn-success" value="登陆"> <input
							id="fanhui" type="button" class="btn btn-default" value="入口"
							onclick="javascript:window.location.href='${pageContext.request.contextPath }/index.jsp'">
						<input type="reset" class="btn btn-default" value="重填">
					</div>

					<div class="clearfix"></div>

					<div class="separator">

						<div>
							<p>©2016 All Rights Reserved.</p>
						</div>
					</div>
				</form>
				</section>
			</div>
		</div>
	</div>
</body>
</html>
