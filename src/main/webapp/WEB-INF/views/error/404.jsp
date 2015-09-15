<%@page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<%@include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<title>Fundview Admin | 404 Error Page</title>

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
		<div class="error-code m-b-10">404 <i class="fa fa-warning"></i></div>
		<div class="error-content">
			<div class="error-message">We couldn't find it...</div>
			<div class="error-desc m-b-20">
				The page you're looking for doesn't exist. <br />
				Perhaps, there pages will help find what you're looking for.
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