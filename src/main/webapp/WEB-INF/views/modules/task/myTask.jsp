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
  <title>我的任务</title>
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
          "aaSorting": [[4, "desc"]]
        })
      }
    }

    $(document).ready(function () {
      $("#menu li").removeClass("active");
      $("#200").addClass("active");
      $("#202").addClass("active");
      App.init();
      init();
    });
  </script>
</head>
<body>
<div class="row">
  <div class="col-md-12">
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
        <h4 class="panel-title">任务单列表</h4>
      </div>

      <div class="panel-body">
        <table id="data-table" class="table table-striped table-bordered nowrap" width="100%">
          <thead>
          <tr>
            <th>任务类型</th>
            <th>标题</th>
            <th>任务级别</th>
            <th>创建人</th>
            <th>截至日期</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${taskUserOrders}" var="taskUserOrder" varStatus="idxStatus">
            <tr class="default">
              <td>${fns:getDictLabel(taskUserOrder.insideTask.type, 'task_type', '未填写')}</td>
              <td>${taskUserOrder.insideTask.title}</td>
              <td>
                  ${fns:getDictLabel(taskUserOrder.insideTask.level, 'task_level', '未填写')}
                <c:choose>
                  <c:when test="${taskUserOrder.insideTask.level eq 2}">
                    <span class="text-danger"><i class="fa fa-star"></i></span>
                  </c:when>
                  <c:when test="${taskUserOrder.insideTask.level eq 1}">
                    <span class="text-danger"><i class="fa fa-star-half-full"></i></span>
                  </c:when>
                </c:choose>
              </td>
              <td>${taskUserOrder.insideTask.createBy.name}</td>
              <td><fmt:formatDate value="${taskUserOrder.insideTask.deadline}" type="date"/></td>
              <td>
                <a href="${ctx}/task/handle?id=${taskUserOrder.id}"><span
                        class="label label-primary">任务办理</span></a>
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
</body>
</html>