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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="decorator" content="default"/>
    <title>咨询服务列表</title>
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
            $("#218").addClass("active");
            App.init();
            init();
        });
    </script>
</head>
<body>
<div class="row">
    <div class="col-md-12">
        <ul class="nav nav-tabs">
            <li ><a href="${ctx}/consultation/list/unsure">待专家确认咨询服务列表</a></li>
            <li class="active"><a href="${ctx}/consultation/list/cancel">取消待处理列表</a></li>
            <li ><a href="${ctx}/consultation/list/unpayed">待确认转账汇款</a></li>


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
                        <h4 class="panel-title">咨询服务列表</h4>
                    </div>

                    <div class="panel-body">
                        <table id="data-table" class="table table-striped table-bordered nowrap" width="100%">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>企业名称</th>
                                <th>企业联系电话</th>
                                <th>专家名称</th>
                                <th>专家电话</th>
                                <th>咨询方式</th>
                                <th>咨询价格</th>
                                <th>咨询状态</th>
                                <th>咨询时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${list}" var="consultation" varStatus="idxStatus">
                                <tr class="unread">
                                        <%--<tr class="odd gradeX">--%>
                                    <td>${consultation.id}</td>
                                    <td>${consultation.consulationMan}</td>
                                    <td>${consultation.phone}</td>
                                    <td>${consultation.expertName}</td>
                                    <td>${consultation.expertPhone}</td>

                                    <td><c:if test="${consultation.consulationType==1}">电话咨询</c:if><c:if
                                            test="${consultation.consulationType==2}">现场咨询</c:if></td>
                                    <td>${consultation.price}
                                        <c:if test="${consultation.consulationType==1}">元/小时</c:if>
                                        <c:if test="${consultation.consulationType==2}">元/天</c:if></td>
                                    <td>
                                        <s:eval expression="T(cn.fundview.modules.util.constants.ConsultationStatus).getNames(${consultation.status})" var="status"/>
                                        ${status}
                                    </td>

                                    <td><fmt:formatDate value="${consultation.createDate}" type="both"/></td>
                                    <td>

                                        <a href="${ctx}/consultation/list/to-cancel/${consultation.id}"><span
                                                class="label label-primary">处理</span></a>
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

