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
    <link href="${ctxStatic}/plugins/jquery-ui/themes/base/minified/jquery-ui.min.css" rel="stylesheet" />
    <link href="${ctxStatic}/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${ctxStatic}/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="${ctxStatic}/css/animate.min.css" rel="stylesheet" />
    <link href="${ctxStatic}/css/style.min.css" rel="stylesheet" />
    <link href="${ctxStatic}/css/style-responsive.min.css" rel="stylesheet" />
    <link href="${ctxStatic}/css/theme/default.css" rel="stylesheet" id="theme" />
    <link href="${ctxStatic}/plugins/gritter/css/jquery.gritter.css" rel="stylesheet" />
    <link rel="shortcut icon" href="${ctxStatic}/favicon.ico"/>
    <!-- ================== END BASE CSS STYLE ================== -->

    <!-- ================== BEGIN BASE JS ================== -->
    <script src="${ctxStatic}/plugins/pace/pace.min.js"></script>
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
    <script src="${ctxStatic}/plugins/gritter/js/jquery.gritter.js"></script>
    <!-- ================== END BASE JS ================== -->
    <script>
        $(document).ready(function() {
            var message = $("#retuen-message").val();
            if(message!=""){
                $.gritter.add({
                    title : "提示信息",
                    text : message,
                    sticky : false,
                    time : "5000"
                });
            }
        });
    </script>
    <sitemesh:head/>
</head>
<body>
<!-- begin #page-loader -->
<div id="page-loader" class="fade in"><span class="spinner"></span></div>
<!-- end #page-loader -->

<!-- begin #page-container -->
<div id="page-container" class="fade page-sidebar-fixed page-header-fixed">
    <!-- begin #header -->
    <div id="header" class="header navbar navbar-default navbar-fixed-top">
        <!-- begin container-fluid -->
        <div class="container-fluid">
            <!-- begin mobile sidebar expand / collapse button -->
            <div class="navbar-header">
                <a href="${ctx}" class="navbar-brand"><span class="navbar-logo"></span> Fundview Admin</a>
                <button type="button" class="navbar-toggle" data-click="sidebar-toggled">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <!-- end mobile sidebar expand / collapse button -->

            <!-- begin header navigation right -->
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <form class="navbar-form full-width">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="关键字" />
                            <button type="submit" class="btn btn-search"><i class="fa fa-search"></i></button>
                        </div>
                    </form>
                </li>
                <li class="dropdown">
                    <a href="javascript:;" data-toggle="dropdown" class="dropdown-toggle f-s-14">
                        <i class="fa fa-bell-o"></i>
                        <span class="label">5</span>
                    </a>
                    <ul class="dropdown-menu media-list pull-right animated fadeInDown">
                        <li class="dropdown-header">Notifications (5)</li>
                        <li class="media">
                            <a href="javascript:;">
                                <div class="media-left"><i class="fa fa-bug media-object bg-red"></i></div>
                                <div class="media-body">
                                    <h6 class="media-heading">Server Error Reports</h6>
                                    <div class="text-muted f-s-11">3 minutes ago</div>
                                </div>
                            </a>
                        </li>
                        <li class="media">
                            <a href="javascript:;">
                                <div class="media-left"><img src="${ctxStatic}/img/user-1.jpg" class="media-object" alt="" /></div>
                                <div class="media-body">
                                    <h6 class="media-heading">John Smith</h6>
                                    <p>Quisque pulvinar tellus sit amet sem scelerisque tincidunt.</p>
                                    <div class="text-muted f-s-11">25 minutes ago</div>
                                </div>
                            </a>
                        </li>
                        <li class="media">
                            <a href="javascript:;">
                                <div class="media-left"><img src="${ctxStatic}/img/user-2.jpg" class="media-object" alt="" /></div>
                                <div class="media-body">
                                    <h6 class="media-heading">Olivia</h6>
                                    <p>Quisque pulvinar tellus sit amet sem scelerisque tincidunt.</p>
                                    <div class="text-muted f-s-11">35 minutes ago</div>
                                </div>
                            </a>
                        </li>
                        <li class="media">
                            <a href="javascript:;">
                                <div class="media-left"><i class="fa fa-plus media-object bg-green"></i></div>
                                <div class="media-body">
                                    <h6 class="media-heading"> New User Registered</h6>
                                    <div class="text-muted f-s-11">1 hour ago</div>
                                </div>
                            </a>
                        </li>
                        <li class="media">
                            <a href="javascript:;">
                                <div class="media-left"><i class="fa fa-envelope media-object bg-blue"></i></div>
                                <div class="media-body">
                                    <h6 class="media-heading"> New Email From John</h6>
                                    <div class="text-muted f-s-11">2 hour ago</div>
                                </div>
                            </a>
                        </li>
                        <li class="dropdown-footer text-center">
                            <a href="javascript:;">View more</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown navbar-user">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="${fns:getUser().photo}" alt="" />
                        <span class="hidden-xs">${fns:getUser().name}</span> <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu animated fadeInLeft">
                        <li class="arrow"></li>
                        <li><a href="${ctx}/user/info">基本信息</a></li>
                        <li><a href="${ctx}/user/modifyPwd">修改密码</a></li>
                        <li class="divider"></li>
                        <li><a href="${ctx}/logout">退出系统</a></li>
                    </ul>
                </li>
            </ul>
            <!-- end header navigation right -->
        </div>
        <!-- end container-fluid -->
    </div>
    <!-- end #header -->

    <!-- begin #sidebar -->
    <div id="sidebar" class="sidebar">
        <!-- begin sidebar scrollbar -->
        <div data-scrollbar="true" data-height="100%">
            <!-- begin sidebar user -->
            <ul class="nav">
                <li class="nav-profile">
                    <div class="image">
                        <a href="javascript:;"><img src="${fns:getUser().photo}" alt="" /></a>
                    </div>
                    <div class="info">
                        ${fns:getUser().name}
                        <small>${fns:getUser().remarks}</small>
                    </div>
                </li>
            </ul>
            <!-- end sidebar user -->
            <!-- begin sidebar nav -->
            <ul class="nav" id="menu">
                <li class="nav-header">功能菜单</li>
                <li class="has-sub active">
                    <a href="javascript:;">
                        <i class="fa fa-home"></i>
                        <span>主页</span>
                    </a>
                </li>
                <c:set var="menuList" value="${fns:getMenuList()}"/>
                <c:forEach items="${menuList}" var="menu" varStatus="idxStatus">
                    <c:if test="${menu.parent.id eq '1' && menu.isShow eq '1' && menu.delFlag eq '0'}">
                        <li class="has-sub" id="${menu.id}">
                            <a href="javascript:;">
                                <b class="caret pull-right"></b>
                                <i class="fa ${menu.icon}"></i>
                                <span>${menu.name}</span>
                            </a>
                            <ul class="sub-menu">
                                <c:forEach items="${menuList}" var="subMenu" varStatus="idxStatus2">
                                    <c:if test="${subMenu.parent.id eq menu.id && subMenu.isShow eq '1'}">
                                        <li id="${subMenu.id}"><a href="${ctx}${subMenu.href}">${subMenu.name}</a></li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </li>
                    </c:if>
                </c:forEach>
                <!-- begin sidebar minify button -->
                <li><a href="javascript:;" class="sidebar-minify-btn" data-click="sidebar-minify"><i class="fa fa-angle-double-left"></i></a></li>
                <!-- end sidebar minify button -->
            </ul>
            <!-- end sidebar nav -->
        </div>
        <!-- end sidebar scrollbar -->
    </div>
    <div class="sidebar-bg"></div>
    <!-- end #sidebar -->

    <input id="retuen-message" type="hidden" value="${message }" />

    <!-- begin #content -->
    <div id="content" class="content">
        <sitemesh:body/>
    </div>
    <!-- end #content -->

    <div id="footer" class="footer"> © 2015 Fundview Admin  - by wangjian </div>

    <!-- begin theme-panel -->
    <div class="theme-panel">
        <a href="javascript:;" data-click="theme-panel-expand" class="theme-collapse-btn"><i class="fa fa-cog"></i></a>
        <div class="theme-panel-content">
            <h5 class="m-t-0">主题颜色</h5>
            <ul class="theme-list clearfix">
                <li class="active"><a href="javascript:;" class="bg-green" data-theme="default" data-click="theme-selector" data-toggle="tooltip" data-trigger="hover" data-container="body" data-title="Default">&nbsp;</a></li>
                <li><a href="javascript:;" class="bg-red" data-theme="red" data-click="theme-selector" data-toggle="tooltip" data-trigger="hover" data-container="body" data-title="Red">&nbsp;</a></li>
                <li><a href="javascript:;" class="bg-blue" data-theme="blue" data-click="theme-selector" data-toggle="tooltip" data-trigger="hover" data-container="body" data-title="Blue">&nbsp;</a></li>
                <li><a href="javascript:;" class="bg-purple" data-theme="purple" data-click="theme-selector" data-toggle="tooltip" data-trigger="hover" data-container="body" data-title="Purple">&nbsp;</a></li>
                <li><a href="javascript:;" class="bg-orange" data-theme="orange" data-click="theme-selector" data-toggle="tooltip" data-trigger="hover" data-container="body" data-title="Orange">&nbsp;</a></li>
                <li><a href="javascript:;" class="bg-black" data-theme="black" data-click="theme-selector" data-toggle="tooltip" data-trigger="hover" data-container="body" data-title="Black">&nbsp;</a></li>
            </ul>
            <div class="divider"></div>
            <div class="row m-t-10">
                <div class="col-md-5 control-label double-line">头部样式</div>
                <div class="col-md-7">
                    <select name="header-styling" class="form-control input-sm">
                        <option value="1">默认</option>
                        <option value="2">黑色</option>
                    </select>
                </div>
            </div>
        </div>
    </div>
    <!-- end theme-panel -->

    <!-- begin scroll to top btn -->
    <a href="javascript:;" class="btn btn-icon btn-circle btn-success btn-scroll-to-top fade" data-click="scroll-top"><i class="fa fa-angle-up"></i></a>
    <!-- end scroll to top btn -->
</div>
<!-- end page container -->
</body>
</html>