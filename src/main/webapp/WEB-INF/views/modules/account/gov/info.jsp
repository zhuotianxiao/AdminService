<%--
  Created by IntelliJ IDEA.
  gov: WangJian
  Date: 2015/5/19
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="decorator" content="default"/>
    <title>政府机构基本信息</title>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <script>
        $(document).ready(function () {
            $("#menu li").removeClass("active");
            $("#106").addClass("active");
            $("#119").addClass("active");
            App.init();
        });
    </script>
</head>
<body>
<!-- begin row -->
<div class="row">
    <div class="col-md-12">
        <!-- begin panel -->
        <div class="panel panel-inverse" data-sortable-id="ui-general-3">
            <div class="panel-heading">
                <div class="panel-heading-btn">
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i
                            class="fa fa-expand"></i></a>
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-success" data-click="panel-reload"><i
                            class="fa fa-repeat"></i></a>
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning"
                       data-click="panel-collapse"><i class="fa fa-minus"></i></a>
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger"
                       data-click="panel-remove"><i class="fa fa-times"></i></a>
                </div>
                <h4 class="panel-title">政府机构基本信息</h4>
            </div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <tbody>
                    <tr>
                        <td width="10%" align="right">登录名称</td>
                        <td>${gov.account.username }</td>
                        <td width="10%" align="right">登录密码</td>
                        <td>${gov.account.password }</td>
                    </tr>
                    <tr>
                        <td align="right">机构名称</td>
                        <td ><span class="badge badge-info">${gov.name }</span></td>
                        <td align="right">机构负责人</td>
                        <td ><span class="badge badge-info">${gov.manager }</span></td>
                    </tr>

                    <tr>
                        <td align="right">所在地区</td>
                        <td><span class="badge badge-info">${fns:getDefaultVal(gov.areaNames,"暂未填写")}</span></td>
                        <td align="right">机构邮箱</td>
                        <td>${gov.email}</td>
                    </tr>
                    <tr>
                        <td align="right">固定电话</td>
                        <td><span class="badge badge-info">${gov.tel}</span></td>
                        <td align="right">机构网站</td>
                        <td><span class="badge badge-info">${gov.website }</span></td>
                    </tr>
                    <tr>
                        <td align="right">机构联系人</td>
                        <td><span class="badge badge-info">${gov.linkman}</span></td>
                        <td align="right">联系人手机号</td>
                        <td ><span class="badge badge-info">${gov.linkmanPhone }</span></td>
                    </tr>

                    <tr>
                        <td align="right">详细地址</td>
                        <td colspan="3">${gov.addr }</td>
                    </tr>
                    <tr>
                        <td align="right">机构介绍</td>
                        <td colspan="3">${gov.intro}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- end panel -->
    </div>
</div>
<!-- end row -->
</body>
</html>