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
    <link href="${ctxStatic}/plugins/parsley/src/parsley.css" rel="stylesheet" />
    <link href="${ctxStatic}/plugins/bootstrap-datepicker/css/datepicker3.css" rel="stylesheet" />
    <link href="${ctxStatic}/plugins/bootstrap-select/bootstrap-select.min.css" rel="stylesheet" />
    <!-- ================== END PAGE LEVEL STYLE ================== -->

    <!-- ================== BEGIN PAGE LEVEL JS ================== -->
    <script src="${ctxStatic}/plugins/parsley/dist/parsley.js"></script>
    <script src="${ctxStatic}/plugins/parsley/dist/zh_cn.js"></script>
    <script src="${ctxStatic}/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <script src="${ctxStatic}/plugins/bootstrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js" charset="UTF-8"></script>
    <script src="${ctxStatic}/plugins/bootstrap-select/bootstrap-select.min.js"></script>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <script>
        function init() {

            $("#workDate").datepicker({
                language: "zh-CN",
                todayHighlight : true,
                autoclose : true
            });

            $(".selectpicker").selectpicker("render");
        };

        $(document).ready(function() {
            $("#menu li").removeClass("active");
            $("#2").addClass("active");
            $("#3").addClass("active");
            App.init();
            init();
        });
    </script>
</head>
<body>
<!-- begin row -->
<div class="row">
    <div class="col-md-12">
        <ul class="nav nav-tabs">
            <li class=""><a href="${ctx}/user/index">员工列表</a></li>
            <shiro:hasPermission name="sys:user:edit">
                <li class="active"><a href="${ctx}/user/form">新增/编辑</a></li>
            </shiro:hasPermission>
            <shiro:lacksPermission name="sys:user:edit">
                <li class="active"><a href="${ctx}/user/form">查看</a></li>
            </shiro:lacksPermission>
        </ul>

        <div class="tab-content">
            <div class="tab-pane fade active in" id="default-tab-1">
                <!-- begin panel -->
                <div class="panel panel-inverse" data-sortable-id="form-validation-2">
                    <div class="panel-heading">
                        <div class="panel-heading-btn">
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i class="fa fa-expand"></i></a>
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-success" data-click="panel-reload"><i class="fa fa-repeat"></i></a>
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning" data-click="panel-collapse"><i class="fa fa-minus"></i></a>
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger" data-click="panel-remove"><i class="fa fa-times"></i></a>
                        </div>
                        <h4 class="panel-title">新增/编辑员工</h4>
                    </div>
                    <div class="panel-body panel-form">
                        <form:form modelAttribute="user" action="save" class="form-horizontal form-bordered" data-parsley-validate="true">
                            <form:hidden path="id" />
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">登录名称:</label>
                                <div class="col-md-2 col-sm-6">
                                    <form:input path="loginName" type="text" class="form-control" data-parsley-required="true" data-parsley-minlength="4" placeholder="填写登录内网用户名" />
                                    <input id="oldLoginName" name="oldLoginName" type="hidden" value="${user.loginName}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">真实姓名:</label>
                                <div class="col-md-2">
                                    <form:input path="name" type="text" class="form-control"  data-parsley-required="true" data-parsley-minlength="2" placeholder="员工姓名" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">性别:</label>
                                <div class="col-md-1 col-sm-6">
                                    <form:select path="sex" data-style="btn-primary" class="form-control selectpicker" placeholder="请选择性别...">
                                        <form:options items="${fns:getDictList('sex')}" itemLabel="label" itemValue="value"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">入职时间:</label>
                                <div class="col-md-2 col-sm-6">
                                    <input id="workDate" name="workDate" type="text" class="form-control" placeholder="入职时间" value="<fmt:formatDate value="${user.workDate}" type="date"/>"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">人员类型:</label>
                                <div class="col-md-6 col-sm-6">
                                    <div class="radio">
                                        <label>
                                            <form:radiobutton path="type" value="1" data-parsley-required="true" />实习员工
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <form:radiobutton path="type" value="2" />试用员工
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <form:radiobutton path="type" value="3" />正式员工
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">归属部门:</label>
                                <div class="col-md-2">
                                    <form:select path="office.id" data-style="btn-primary" data-live-search="true" cssClass="form-control selectpicker">
                                        <form:options items="${list}" itemLabel="name" itemValue="id"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">配置角色:</label>
                                <div class="col-md-4">
                                    <form:select path="roleList" data-style="btn-primary" multiple="true" data-live-search="true" data-parsley-required="true" cssClass="form-control selectpicker" title="请选择角色...">
                                        <form:options items="${allRoles}" itemLabel="name" itemValue="id"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">固定电话:</label>
                                <div class="col-md-2">
                                    <form:input path="phone" type="text" class="form-control" placeholder="固定电话" />
                                </div>
                            </div>
                            <shiro:hasPermission name="sys:user:edit">
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