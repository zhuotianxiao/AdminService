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
    <title>审核任务</title>
    <!-- ================== BEGIN PAGE LEVEL STYLE ================== -->
    <link href="${ctxStatic}/plugins/parsley/src/parsley.css" rel="stylesheet"/>
    <link href="${ctxStatic}/plugins/bootstrap-datepicker/css/datepicker.css" rel="stylesheet"/>
    <link href="${ctxStatic}/plugins/bootstrap-select/bootstrap-select.min.css" rel="stylesheet"/>
    <!-- ================== END PAGE LEVEL STYLE ================== -->

    <!-- ================== BEGIN PAGE LEVEL JS ================== -->
    <script src="${ctxStatic}/plugins/parsley/dist/parsley.js"></script>
    <script src="${ctxStatic}/plugins/parsley/dist/zh_cn.js"></script>
    <script src="${ctxStatic}/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <script src="${ctxStatic}/plugins/bootstrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js"
            charset="UTF-8"></script>
    <script src="${ctxStatic}/plugins/bootstrap-select/bootstrap-select.min.js"></script>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <script>
        $(document).ready(function () {
            $("#menu li").removeClass("active");
            $("#200").addClass("active");
            $("#206").addClass("active");
            App.init();
        });
    </script>
</head>
<body>
<!-- begin row -->
<div class="row">
    <div class="col-md-12">
        <!-- begin panel -->
        <a href="${ctx}/task/inquiry" class="btn btn-sm btn-success m-b-10"><i class="fa fa-arrow-circle-left m-r-5"></i>返回待审核任务列表</a>
        <div class="panel panel-primary" data-sortable-id="form-validation-2">
            <div class="panel-heading">
                <div class="panel-heading-btn">
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i
                            class="fa fa-expand"></i></a>
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning"
                       data-click="panel-collapse"><i class="fa fa-minus"></i></a>
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger"
                       data-click="panel-remove"><i class="fa fa-times"></i></a>
                </div>
                <h4 class="panel-title">审核任务</h4>
            </div>
            <div class="panel-body panel-form">
                <form:form modelAttribute="insideTask" action="save" class="form-horizontal form-bordered">
                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4">任务标题:</label>
                        <div class="col-md-2 col-sm-6">
                            <form:input path="title" type="text" class="form-control" placeholder="任务标题"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4">截至日期:</label>
                        <div class="col-md-2">
                            <input name="deadline" type="date" data-parsley-required="true" class="form-control" value="<fmt:formatDate value="${insideTask.deadline}" type="date"/>"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4">预计时长(小时):</label>
                        <div class="col-md-2">
                            <form:input path="timer" type="text" class="form-control"  placeholder="小时"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4">指派人员:</label>
                        <div class="col-md-4">
                            <ul>
                                <c:forEach items="${userOrders}" var="userOrder" varStatus="idxStatus">
                                    <li>
                                        ${userOrder.user.name}
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4">任务级别:</label>
                        <div class="col-md-1">
                            <input name="level" type="text" class="form-control" value="${fns:getDictLabel(insideTask.level, 'task_level', '未填写')}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4">任务描述:</label>

                        <div class="col-md-2">
                            <form:textarea path="description" type="text" class="form-control" data-parsley-maxlength="240" placeholder="任务描述"/>
                        </div>
                    </div>
                    <shiro:hasPermission name="task:inquiry:edit">
                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4"></label>
                        <div class="col-md-6 col-sm-6">
                            <a href="${ctx}/task/save-inquiry?key=0&id=${insideTask.id}" class="btn btn-danger">驳回</a>
                            <a href="${ctx}/task/save-inquiry?key=1&id=${insideTask.id}" class="btn btn-success">通过</a>
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