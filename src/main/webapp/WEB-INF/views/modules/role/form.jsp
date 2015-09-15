<%--
  Created by IntelliJ IDEA.
  User: WangJian
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
    <title>编辑修改</title>
    <!-- ================== BEGIN PAGE LEVEL STYLE ================== -->
    <link href="${ctxStatic}/plugins/parsley/src/parsley.css" rel="stylesheet"/>
    <link href="${ctxStatic}/plugins/multi-select/css/multi-select.css" rel="stylesheet"/>
    <link href="${ctxStatic}/plugins/ionRangeSlider/css/ion.rangeSlider.css" rel="stylesheet"/>
    <link href="${ctxStatic}/plugins/ionRangeSlider/css/ion.rangeSlider.skinNice.css" rel="stylesheet"/>
    <link href="${ctxStatic}/plugins/bootstrap-select/bootstrap-select.min.css" rel="stylesheet"/>
    <!-- ================== END PAGE LEVEL STYLE ================== -->

    <!-- ================== BEGIN PAGE LEVEL JS ================== -->
    <script src="${ctxStatic}/plugins/multi-select/js/jquery.multi-select.js"></script>
    <script src="${ctxStatic}/plugins/multi-select/js/jquery.quicksearch.js"></script>
    <script src="${ctxStatic}/plugins/ionRangeSlider/js/ion-rangeSlider/ion.rangeSlider.min.js"></script>
    <script src="${ctxStatic}/plugins/parsley/dist/parsley.js"></script>
    <script src="${ctxStatic}/plugins/parsley/dist/zh_cn.js"></script>
    <script src="${ctxStatic}/plugins/bootstrap-select/bootstrap-select.min.js"></script>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <script>

        $(document).ready(function () {
            $("#menu li").removeClass("active");
            $("#2").addClass("active");
            $("#14").addClass("active");
            App.init();

            //初始化下拉菜单
            $(".selectpicker").selectpicker("render");

            //初始化滑动条设置
            $("#dataScope").ionRangeSlider({
                values: ["所有数据", "所在公司及以下数据", "所在公司数据", "所在部门及以下数据", "所在部门数据", "仅本人数据"],
                type: "single",
                hasGrid: true
            });

            $("#menuList").val(${role.getMenuIdList()});
            $("#menuList").multiSelect({
                selectableHeader: "<div class='custom-header'>未选择</div>",
                selectionHeader: "<div class='custom-header'>已选择</div>"
            });

        });
    </script>
</head>
<body>
<!-- begin row -->
<div class="row">
    <div class="col-md-12">
        <ul class="nav nav-tabs">
            <li class=""><a href="${ctx}/role/index">角色列表</a></li>
            <shiro:hasPermission name="sys:role:edit">
                <li class="active"><a href="${ctx}/role/form">新增/编辑</a></li>
            </shiro:hasPermission>
            <shiro:lacksPermission name="sys:role:edit">
                <li class="active"><a href="${ctx}/role/form">查看</a></li>
            </shiro:lacksPermission>
        </ul>

        <div class="tab-content">
            <div class="tab-pane fade active in" id="default-tab-1">
                <!-- begin panel -->
                <div class="panel panel-inverse" data-sortable-id="form-validation-2">
                    <div class="panel-heading">
                        <div class="panel-heading-btn">
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default"
                               data-click="panel-expand"><i class="fa fa-expand"></i></a>
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-success"
                               data-click="panel-reload"><i class="fa fa-repeat"></i></a>
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning"
                               data-click="panel-collapse"><i class="fa fa-minus"></i></a>
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger"
                               data-click="panel-remove"><i class="fa fa-times"></i></a>
                        </div>
                        <h4 class="panel-title">新增/编辑</h4>
                    </div>
                    <div class="panel-body panel-form">
                        <form:form modelAttribute="role" action="save" class="form-horizontal form-bordered"
                                   data-parsley-validate="true">
                            <form:hidden path="id"/>
                            <form:hidden path="roleType"/>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">角色名称:</label>

                                <div class="col-md-2 col-sm-6">
                                    <form:input path="name" type="text" class="form-control"
                                                data-parsley-required="true" placeholder="角色名称"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">角色英文名:</label>

                                <div class="col-md-2 col-sm-6">
                                    <form:input path="enname" type="text" class="form-control"
                                                data-parsley-required="true" placeholder="角色英文名"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">数据范围:</label>

                                <div class="col-md-6 col-sm-6">
                                    <form:input path="dataScope" type="text" class="form-control" placeholder="数据范围"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">菜单权限选择:</label>

                                <div class="col-md-6 col-sm-6">
                                    <form:select path="menuList" multiple="multiple">
                                        <c:forEach items="${fns:getMenuList()}" var="menu" varStatus="idxStatus">
                                            <c:if test="${menu.delFlag eq '0'}">
                                                <option value="${menu.id}">${menu.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                            <shiro:hasPermission name="sys:role:edit">
                                <div class="form-group">
                                    <label class="control-label col-md-4 col-sm-4"></label>

                                    <div class="col-md-6 col-sm-6">
                                        <button type="submit" class="btn btn-success">提交</button>
                                    </div>
                                </div>
                            </shiro:hasPermission>
                        </form:form>
                    </div>
                </div>
                <!-- end panel -->
            </div>
        </div>
    </div>
</div>
<!-- end row -->
</body>
</html>