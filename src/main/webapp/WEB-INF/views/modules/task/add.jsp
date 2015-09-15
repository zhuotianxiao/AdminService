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
    <title>新建任务</title>
    <!-- ================== BEGIN PAGE LEVEL STYLE ================== -->
    <link href="${ctxStatic}/plugins/parsley/src/parsley.css" rel="stylesheet"/>
    <link href="${ctxStatic}/plugins/bootstrap-datepicker/css/datepicker.css" rel="stylesheet"/>
    <link href="${ctxStatic}/plugins/bootstrap-select/bootstrap-select.min.css" rel="stylesheet"/>
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
        $(document).ready(function () {
            $("#menu li").removeClass("active");
            $("#200").addClass("active");
            $("#201").addClass("active");
            App.init();

            $("#deadline").datepicker({
                language: "zh-CN",
                todayHighlight: true,
                autoclose: true
            });

            $(".selectpicker").selectpicker("render");
        });
    </script>
</head>
<body>
<!-- begin row -->
<div class="row">
    <div class="col-md-12">
        <a href="${ctx}/task/index" class="btn btn-sm btn-success m-b-10"><i class="fa fa-arrow-circle-left m-r-5"></i>返回任务列表</a>
        <!-- begin panel -->
        <div class="panel panel-primary" data-sortable-id="form-validation-1">
            <div class="panel-heading">
                <div class="panel-heading-btn">
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i class="fa fa-expand"></i></a>
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning" data-click="panel-collapse"><i class="fa fa-minus"></i></a>
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger" data-click="panel-remove"><i class="fa fa-times"></i></a>
                </div>
                <h4 class="panel-title">新建任务</h4>
            </div>
            <div class="panel-body panel-form">
                <form:form modelAttribute="insideTask" action="save" class="form-horizontal form-bordered" data-parsley-validate="true">
                    <form:hidden path="id"/>
                    <form:hidden path="deferTimeRemarks"/>
                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4">任务标题:</label>

                        <div class="col-md-4 col-sm-6">
                            <form:input path="title" type="text" class="form-control" data-parsley-required="true" data-parsley-minlength="2"
                                        data-parsley-maxlength="36" placeholder="任务标题"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4">截至日期:</label>

                        <div class="col-md-2">
                            <input id="deadline" name="deadline" type="date" data-parsley-required="true" class="form-control" value="${fns:formatDateDefault(insideTask.deadline)}" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4">预计时长(小时):</label>

                        <div class="col-md-2">
                            <form:input path="timer" type="number" class="form-control" data-parsley-required="true"
                                        data-parsley-type="number" placeholder="小时"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4">指派部门:</label>

                        <div class="col-md-4">
                            <form:select path="officeIds" data-style="btn-primary" multiple="true"
                                         data-live-search="true" cssClass="form-control selectpicker"
                                         title="选择部门...">
                                <form:options items="${fns:getOfficeList()}" itemLabel="name" itemValue="id"/>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4">指派人员:</label>

                        <div class="col-md-4">
                            <form:select path="userIds" data-style="btn-info" multiple="true" data-live-search="true"
                                         cssClass="form-control selectpicker" title="选择人员...">
                                <form:options items="${userList}" itemLabel="name" itemValue="id"/>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4">任务级别:</label>

                        <div class="col-md-2">
                            <form:select path="level" data-style="btn-success" cssClass="form-control selectpicker">
                                <form:options items="${fns:getDictList('task_level')}" itemValue="value"
                                              itemLabel="label"/>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4">任务描述:</label>

                        <div class="col-md-4">
                            <form:textarea path="description" type="text" class="form-control"
                                           data-parsley-maxlength="240" placeholder="任务描述"/>
                        </div>
                    </div>
                    <shiro:hasPermission name="task:list:edit">
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
<!-- end row -->
</body>
</html>