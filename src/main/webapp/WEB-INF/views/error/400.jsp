<%
response.setStatus(400);

// 获取异常类
Throwable ex = Exceptions.getThrowable(request);

// 编译错误信息
StringBuilder sb = new StringBuilder("错误信息：\n");
if (ex != null) {
	if (ex instanceof BindException) {
		for (ObjectError e : ((BindException)ex).getGlobalErrors()){
			sb.append("☆" + e.getDefaultMessage() + "(" + e.getObjectName() + ")\n");
		}
		for (FieldError e : ((BindException)ex).getFieldErrors()){
			sb.append("☆" + e.getDefaultMessage() + "(" + e.getField() + ")\n");
		}
		LoggerFactory.getLogger("400.jsp").warn(ex.getMessage(), ex);
	}else if (ex instanceof ConstraintViolationException) {
		for (ConstraintViolation<?> v : ((ConstraintViolationException)ex).getConstraintViolations()) {
			sb.append("☆" + v.getMessage() + "(" + v.getPropertyPath() + ")\n");
		}
	} else {
		//sb.append(Exceptions.getStackTraceAsString(ex));
		sb.append("☆" + ex.getMessage());
	}
} else {
	sb.append("未知错误.\n\n");
}

// 如果是异步请求或是手机端，则直接返回信息
if (Servlets.isAjaxRequest(request)) {
	out.print(sb);
}

// 输出异常信息页面
else {
%>
<%@page import="cn.fundview.common.utils.Exceptions"%>
<%@page import="cn.fundview.common.utils.StringUtils"%>
<%@page import="cn.fundview.common.web.Servlets"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.springframework.validation.BindException"%>
<%@page import="org.springframework.validation.FieldError,org.springframework.validation.ObjectError"%>
<%@page import="javax.validation.ConstraintViolation"%>
<%@page import="javax.validation.ConstraintViolationException"%>
<%@page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<%@include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<title>400 - 服务器无法解析.</title>
	<!-- ================== BEGIN BASE CSS STYLE ================== -->
	<link href="${ctxStatic}/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="${ctxStatic}/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
	<link href="${ctxStatic}/css/animate.min.css" rel="stylesheet" />
	<link href="${ctxStatic}/css/style.min.css" rel="stylesheet" />
	<link href="${ctxStatic}/css/style-responsive.min.css" rel="stylesheet" />
	<link href="${ctxStatic}/css/theme/default.css" rel="stylesheet" id="theme" />
	<!-- ================== END BASE CSS STYLE ================== -->
</head>
<body>



<!-- begin #page-loader -->
<div id="page-loader" class="fade in"><span class="spinner"></span></div>
<!-- end #page-loader -->

<!-- begin #page-container -->
<div id="page-container" class="fade">
	<!-- begin error -->
	<div class="error">
		<div class="error-code m-b-10">400 <i class="fa fa-warning"></i></div>
		<div class="error-content">
			<div class="error-message">参数有误,服务器无法解析.</div>
			<div class="error-desc m-b-20">
				<%=StringUtils.toHtml(sb.toString())%> <br/>
			</div>
			<div>
				<a href="${ctx}" class="btn btn-success">返回主页</a>
				<a href="javascript:history.back()" class="btn btn-warning">返回上一页</a>
			</div>
		</div>
	</div>
	<!-- end error -->

	<!-- begin scroll to top btn -->
	<a href="javascript:;" class="btn btn-icon btn-circle btn-success btn-scroll-to-top fade" data-click="scroll-top"><i class="fa fa-angle-up"></i></a>
	<!-- end scroll to top btn -->
</div>
<!-- end page container -->

<!-- ================== BEGIN BASE JS ================== -->
<script src="${ctxStatic}/plugins/jquery/jquery-1.9.1.min.js"></script>
<script src="${ctxStatic}/plugins/jquery/jquery-migrate-1.1.0.min.js"></script>
<script src="${ctxStatic}/plugins/jquery-ui/ui/minified/jquery-ui.min.js"></script>
<script src="${ctxStatic}/plugins/bootstrap/js/bootstrap.min.js"></script>
<!--[if lt IE 9]>
<script src="${ctxStatic}/crossbrowserjs/html5shiv.js"></script>
<script src="${ctxStatic}/crossbrowserjs/respond.min.js"></script>
<script src="${ctxStatic}/crossbrowserjs/excanvas.min.js"></script>
<![endif]-->
<script src="${ctxStatic}/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${ctxStatic}/plugins/jquery-cookie/jquery.cookie.js"></script>
<!-- ================== END BASE JS ================== -->

<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script src="${ctxStatic}/js/apps.min.js"></script>
<!-- ================== END PAGE LEVEL JS ================== -->

<script>
	$(document).ready(function() {
		App.init();
	});
</script>
</body>
</html>
<%
} out = pageContext.pushBody();
%>