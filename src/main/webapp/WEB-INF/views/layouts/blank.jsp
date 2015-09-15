<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
    <title><sitemesh:title/> | 丰景管理系统</title>


    <!-- ================== BEGIN BASE CSS STYLE ================== -->
    <link href="${ctxStatic}/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${ctxStatic}/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="${ctxStatic}/css/animate.min.css" rel="stylesheet" />
    <link href="${ctxStatic}/css/style.min.css" rel="stylesheet" />
    <link href="${ctxStatic}/css/style-responsive.min.css" rel="stylesheet" />
    <link href="${ctxStatic}/css/theme/default.css" rel="stylesheet" id="theme" />
    <link rel="shortcut icon" href="${ctxStatic}/favicon.ico"/>
    <!-- ================== END BASE CSS STYLE ================== -->

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

    <sitemesh:head/>
</head>
<body>
<sitemesh:body/>
</body>
</html>