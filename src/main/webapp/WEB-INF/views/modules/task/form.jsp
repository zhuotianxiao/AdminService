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
    <title>任务详细</title>
    <!-- ================== BEGIN PAGE LEVEL STYLE ================== -->
    <link href="${ctxStatic}/plugins/DataTables/css/data-table.css" rel="stylesheet" />
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
    <script src="${ctxStatic}/plugins/DataTables/js/jquery.dataTables.js"></script>
    <script src="${ctxStatic}/plugins/DataTables/js/dataTables.responsive.js"></script>
    <script src="${ctxStatic}/plugins/bootstrap-select/bootstrap-select.min.js"></script>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <script>
        function addTaskByParentId(parentId) {
            alert(parentId);

        }
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

            if ($("#data-table").length !== 0) {
                $("#data-table").DataTable({
                    responsive: true,
                    "oLanguage": {
                        "sProcessing":   "处理中...",
                        "sLengthMenu":   "显示 _MENU_ 项结果",
                        "sZeroRecords":  "没有匹配结果",
                        "sInfo":         "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                        "sInfoEmpty":    "显示第 0 至 0 项结果，共 0 项",
                        "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                        "sInfoPostFix":  "",
                        "sSearch":       "搜索:",
                        "sUrl":          "",
                        "oPaginate": {
                            "sFirst":    "首页",
                            "sPrevious": "上页",
                            "sNext":     "下页",
                            "sLast":     "末页"
                        }
                    },
                    "aaSorting": [[ 1, "asc" ]]
                })
            }
        });
    </script>
</head>
<body>
<!-- begin row -->
<div class="row">
    <div class="panel panel-inverse" data-sortable-id="table-basic-1">
        <div class="panel-heading">
            <div class="panel-heading-btn">
                <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i class="fa fa-expand"></i></a>
                <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning" data-click="panel-collapse"><i class="fa fa-minus"></i></a>
            </div>
            <h4 class="panel-title">任务信息</h4>
        </div>
        <div class="panel-body">
            <div class="note note-success">
                <h4>${insideTask.title}</h4>
                <p>
                    ${insideTask.createBy.name}|
                    ${fns:getDictLabel(insideTask.level, 'task_level', '未填写')}|
                    ${fns:getDictLabel(insideTask.type, 'task_type', '未填写')}|
                    <fmt:formatDate value="${insideTask.deadline}" type="date"/><br/>
                    ${insideTask.description }
                </p>
            </div>
            <ul>
                <c:forEach items="${officeOrders}" var="officeOrder" varStatus="idxStatus">
                    <li>${officeOrder.office.name}</li>
                </c:forEach>
            </ul>
            <c:if test="${insideTask.taskStatus eq '0'}">
                <div class="panel-footer text-right">
                    <a href="${ctx}/task/add-sub-task?id=${insideTask.id}" class="btn btn-white btn-sm">创建子任务</a>
                    <a href="${ctx}/task/close-task?id=${insideTask.id}" class="btn btn-danger btn-sm">关闭任务</a>
                </div>
            </c:if>
        </div>
    </div>
</div>
<c:choose>
    <c:when test="${0 < subTaskLists.size()}">
        <div class="row">
            <div class="col-md-12">
                <!-- begin panel -->
                <div class="panel panel-success" data-sortable-id="table-basic-2">
                    <div class="panel-heading">
                        <h4 class="panel-title">子任务信息</h4>
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped table-bordered nowrap" width="100%">
                            <thead>
                            <tr>
                                <th>子任务名称</th>
                                <th>创建人</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${subTaskLists}" var="subTask" varStatus="idxStatus">
                                <tr class="unread">
                                    <td>
                                        <a href="${ctx}/task/form?id=${subTask.id}">${subTask.title}</a></td>
                                    <td>${subTask.createBy.name}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- end panel -->
            </div>
        </div>
    </c:when>
    <c:when test="${0 < userOrders.size()}">
        <div class="row">
            <div class="col-md-12">
                <!-- begin panel -->
                <div class="panel panel-success" data-sortable-id="table-basic-1">
                    <div class="panel-heading">
                        <h4 class="panel-title">指派人员信息</h4>
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped table-bordered nowrap" width="100%" id="data-table" >
                            <thead>
                            <tr>
                                <th>员工姓名</th>
                                <th>部门</th>
                                <th>总工时</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${userOrders}" var="userOrder" varStatus="idxStatus">
                                <tr class="unread">
                                    <td><a href="${ctx}/task/handle?id=${userOrder.id}">${userOrder.user.name}</a></td>
                                    <td>${userOrder.user.office.name}</td>
                                    <td>${userOrder.countTime}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- end panel -->
            </div>
        </div>
    </c:when>
    <c:otherwise>
        没有分配信息
    </c:otherwise>
</c:choose>

<!-- end row -->
</body>
</html>