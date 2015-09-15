<%--
  Created by IntelliJ IDEA.
  User: WangJian
  Date: 2015/5/19
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="decorator" content="default"/>
    <title>待专家确认咨询服务列表</title>
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
                    "aaSorting": [[0, "asc"]]
                });
            }
        }
        ;
        ;


        $(document).ready(function () {
            $("#menu li").removeClass("active");
            $("#216").addClass("active");
            $("#217").addClass("active");
            App.init();
            init();
        });

        function submitMoney(id) {
            $.ajax({
                type: "POST",
                url: "${ctx}/consultation/list/confirm-pay/" + id,
                dataType: "json",
                success: function (data) {
                    if (data.result == 1) {
                        alert("操作成功！", function () {
                            window.location.href = '${ctx}/consultation/list/unpayed';
                        });

                    } else {
                        alert("操作失败！");
                    }
                },
                error: function (msg) {
                    alert("操作失败");
                }
            });
        }
    </script>
</head>
<body>
<div class="row">
    <div class="col-md-12">
        <ul class="nav nav-tabs">
            <li><a href="${ctx}/consultation/list/unsure">待专家确认咨询服务列表</a></li>
            <li><a href="${ctx}/consultation/list/cancel">取消待处理列表</a></li>
            <li class="active"><a href="${ctx}/consultation/list/unpayed">待确认转账汇款</a></li>


        </ul>
        <div class="tab-content">
            <div class="tab-pane fade active in" id="default-tab-1">
                <!-- begin panel -->
                <div class="panel panel-inverse">
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
                        <h4 class="panel-title">待确认转账汇款</h4>
                    </div>

                    <div class="panel-body">
                        <form class="form-horizontal" action="${ctx}/consultation/list/search.action" method="post">
                            <div class="form-group">
                                <label class="col-md-3 control-label">请输入汇款识别码</label>

                                <div class="col-md-3">
                                    <input class="form-control" type="text" name="code" value="${code }">
                                </div>
                                <button class="btn btn-success" type=submit>查询</button>
                            </div>
                        </form>
                    </div>


                </div>
                <!-- end panel -->
                <!-- begin panel -->
                <div class="panel panel-inverse">
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
                        <h4 class="panel-title">订单列表列表</h4>
                    </div>

                    <div class="panel-body">
                        <table id="data-table" class="table table-striped table-bordered nowrap" width="100%">
                            <thead>
                            <tr>
                                <th>订单号</th>
                                <th>订单描述</th>
                                <th>订单金额</th>
                                <th>订单时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${list}" var="item" varStatus="idxStatus">
                                <tr class="unread">
                                        <%--<tr class="odd gradeX">--%>
                                    <td>
                                        <a class="a1"
                                           href="${ctx}/consultation/list/info/${item.payMain.orderId}" target="_blank">${item.payMain.orderId}</a>
                                    </td>
                                    <td>${item.payMain.orderDesc}</td>
                                    <td>${item.payMain.orderMoney}</td>
                                    <td><fmt:formatDate value="${item.payMain.payDate}" type="both"/>${item.payMain.payDate}</td>
                                    <td>
                                    <C:if test="${item.payMain.payStatus == 1}">
                                        已付款
                                    </C:if>
                                    <c:if test="${item.payMain.payStatus != 1}">
                                        <a href="javascript:void(0);" onclick="submitMoney('${item.id}');">确认收款</a>
                                    </c:if>
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
    </div>

</div>
</body>
</html>

