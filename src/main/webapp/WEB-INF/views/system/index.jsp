<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="decorator" content="default"/>
    <title>主页</title>
    <!-- ================== BEGIN PAGE LEVEL CSS STYLE ================== -->
    <link href="${ctxStatic}/plugins/jquery-jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet"/>
    <link href="${ctxStatic}/plugins/bootstrap-calendar/css/bootstrap_calendar.css" rel="stylesheet"/>
    <link href="${ctxStatic}/plugins/gritter/css/jquery.gritter.css" rel="stylesheet"/>
    <link href="${ctxStatic}/plugins/morris/morris.css" rel="stylesheet"/>
    <!-- ================== END PAGE LEVEL CSS STYLE ================== -->

    <!-- ================== BEGIN PAGE LEVEL JS ================== -->
    <script src="${ctxStatic}/plugins/morris/raphael.min.js"></script>
    <script src="${ctxStatic}/plugins/morris/morris.js"></script>
    <script src="${ctxStatic}/plugins/jquery-jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="${ctxStatic}/plugins/jquery-jvectormap/jquery-jvectormap-world-merc-en.js"></script>
    <script src="${ctxStatic}/plugins/bootstrap-calendar/js/bootstrap_calendar.min.js"></script>
    <script src="${ctxStatic}/plugins/gritter/js/jquery.gritter.js"></script>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <script>
        $(document).ready(function () {
            App.init();
        });
    </script>
</head>
<body class=" pace-done">

</body>
</html>


