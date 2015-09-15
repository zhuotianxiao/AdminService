<%--
  Created by IntelliJ IDEA.
  User: WangJian
  Date: 2015/5/19
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="decorator" content="default"/>
    <title>任务列表</title>
    <!-- ================== BEGIN PAGE LEVEL STYLE ================== -->
    <link href="${ctxStatic}/plugins/DataTables/css/data-table.css" rel="stylesheet"/>
    <!-- ================== END PAGE LEVEL STYLE ================== -->

    <!-- ================== BEGIN PAGE LEVEL JS ================== -->
    <script src="${ctxStatic}/plugins/DataTables/js/jquery.dataTables.js"></script>
    <script src="${ctxStatic}/plugins/DataTables/js/dataTables.responsive.js"></script>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->

    <script>
        function init() {
            if ($("#data-table").length !== 0) {
                $("#data-table").DataTable({
                    responsive: true,
                    "oLanguage": {
                        "sProcessing": "处理中...",
                        "sLengthMenu": "显示 _MENU_ 项结果",
                        "sZeroRecords": "没有匹配结果",
                        "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                        "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                        "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                        "sInfoPostFix": "",
                        "sSearch": "搜索:",
                        "sUrl": "",
                        "oPaginate": {
                            "sFirst": "首页",
                            "sPrevious": "上页",
                            "sNext": "下页",
                            "sLast": "末页"
                        }
                    },
                    "aaSorting": [[6, "desc"]]
                })
            }
        }
        ;
        function remindDelete(modelId, key) {
            $("#model-ok").attr("href", "${ctx}/dict/delete?id=" + key);
            $(function () {
                $('#' + modelId).modal({
                    keyboard: true
                })
            });
        }
        ;

        $(document).ready(function () {
            $("#menu li").removeClass("active");
            $("#200").addClass("active");
            $("#201").addClass("active");
            App.init();
            init();
        });
    </script>
</head>
<body>
<div class="row">
    <div class="col-md-12">
        <shiro:hasPermission name="task:list:edit">
            <a href="${ctx}/task/add" class="btn btn-sm btn-success m-b-10"><i class="fa fa-tasks m-r-5"></i>发布新任务</a>
        </shiro:hasPermission>
        <!-- begin panel -->
        <div class="panel panel-primary">
            <div class="panel-heading">
                <div class="panel-heading-btn">
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i
                            class="fa fa-expand"></i></a>
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning"
                       data-click="panel-collapse"><i class="fa fa-minus"></i></a>
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger"
                       data-click="panel-remove"><i class="fa fa-times"></i></a>
                </div>
                <h4 class="panel-title">任务列表</h4>
            </div>

            <div class="panel-body">
                <table id="data-table" class="table table-striped table-bordered nowrap" width="100%">
                    <thead>
                    <tr>
                        <th>任务类型</th>
                        <th>父任务</th>
                        <th>任务状态</th>
                        <th>标题</th>
                        <th>任务级别</th>
                        <th>创建人</th>
                        <th>截至日期</th>
                        <th>描述</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${insideTasks}" var="insideTask" varStatus="idxStatus">
                        <tr class="default">
                            <td>${fns:getDictLabel(insideTask.type, 'task_type', '未填写')}</td>
                            <td>${insideTask.parentTask.title}</td>
                            <td>${fns:getDictLabel(insideTask.taskStatus, 'task_status', '未填写')}</td>
                            <td>${insideTask.title}</td>
                            <td>
                                ${fns:getDictLabel(insideTask.level, 'task_level', '未填写')}
                                <c:choose>
                                    <c:when test="${insideTask.level eq 2}">
                                        <span class="text-danger"><i class="fa fa-star"></i></span>
                                    </c:when>
                                    <c:when test="${insideTask.level eq 1}">
                                        <span class="text-danger"><i class="fa fa-star-half-full"></i></span>
                                    </c:when>
                                </c:choose>
                            </td>
                            <td>${insideTask.createBy.name}</td>
                            <td><fmt:formatDate value="${insideTask.deadline}" type="date"/></td>
                            <td>${fns:abbr(insideTask.description,20)}</td>
                            <td>
                                <a href="${ctx}/task/form?id=${insideTask.id}"><span
                                        class="label label-primary">查看</span></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- end panel -->
    </div>
</div>
<div class="col-md-6">
    <div class="modal modal-message fade" id="modal-message">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title">确认信息</h4>
                </div>
                <div class="modal-body">
                    <p>删除操作不可逆,请确认是否删除？${id}</p>
                </div>
                <div class="modal-footer">
                    <a href="javascript:;" class="btn btn-sm btn-white" data-dismiss="modal">取消</a>
                    <a id="model-ok" href="javascript:;" class="btn btn-sm btn-primary">删除</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

