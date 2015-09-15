<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="decorator" content="blank"/>
    <title>登录</title>
    <!-- ================== BEGIN PAGE LEVEL JS ================== -->
    <script src="${ctxStatic}/js/login-v2.demo.min.js"></script>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <script>
        $(document).ready(function() {
            App.init();
            LoginV2.init();
        });
    </script>
</head>
<body>
<!-- begin #page-loader -->
<div id="page-loader" class="fade in"><span class="spinner"></span></div>
<!-- end #page-loader -->

<div class="login-cover">
    <div class="login-cover-image"><img src="${ctxStatic}/img/login-bg/bg-1.jpg" data-id="login-cover-image" alt="" /></div>
    <div class="login-cover-bg"></div>
</div>
<!-- begin #page-container -->
<div id="page-container" class="fade">
    <!-- begin login -->
    <div class="login login-v2" data-pageload-addclass="animated flipInX">
        <!-- begin brand -->
        <div class="login-header">
            <div class="brand">
                <span class="logo"></span> Fundview Admin
                <small>丰景惠农企业内部管理系统</small>
            </div>
            <div class="icon">
                <i class="fa fa-sign-in"></i>
            </div>
        </div>
        <!-- end brand -->
        <div class="login-content">
            <form action="${ctx}/login" method="POST" class="margin-bottom-0">
                <div class="alert alert-warning fade in m-b-15 ${empty message ? 'hide' : ''}">
                    <strong>登录失败!</strong>
                    ${message}
                    <span class="close" data-dismiss="alert">&times;</span>
                </div>
                <div class="form-group m-b-20">
                    <input type="text" name="username" class="form-control input-lg" placeholder="用户名/工号" />
                </div>
                <div class="form-group m-b-20">
                    <input type="password" name="password" class="form-control input-lg" placeholder="密码" />
                </div>
                <div class="checkbox m-b-20">
                    <label>
                        <input type="checkbox" name="rememberMe"/> 记住我(公共计算机慎用)
                    </label>
                </div>
                <div class="login-buttons">
                    <button type="submit" class="btn btn-success btn-block btn-lg">登录管理系统</button>
                </div>
            </form>
        </div>
    </div>
    <!-- end login -->

    <ul class="login-bg-list">
        <li class="active"><a href="#" data-click="change-bg"><img src="${ctxStatic}/img/login-bg/bg-1.jpg" alt="" /></a></li>
        <li><a href="#" data-click="change-bg"><img src="${ctxStatic}/img/login-bg/bg-2.jpg" alt="" /></a></li>
        <li><a href="#" data-click="change-bg"><img src="${ctxStatic}/img/login-bg/bg-3.jpg" alt="" /></a></li>
        <li><a href="#" data-click="change-bg"><img src="${ctxStatic}/img/login-bg/bg-4.jpg" alt="" /></a></li>
        <li><a href="#" data-click="change-bg"><img src="${ctxStatic}/img/login-bg/bg-5.jpg" alt="" /></a></li>
        <li><a href="#" data-click="change-bg"><img src="${ctxStatic}/img/login-bg/bg-6.jpg" alt="" /></a></li>
    </ul>
</div>
<!-- end page container -->
</body>
</html>
