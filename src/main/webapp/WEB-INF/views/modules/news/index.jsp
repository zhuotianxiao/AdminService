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
    <title>新闻管理</title>
    <!-- ================== BEGIN PAGE LEVEL STYLE ================== -->
    <link href="${ctxStatic}/plugins/DataTables/css/data-table.css" rel="stylesheet" />
    <!-- ================== END PAGE LEVEL STYLE ================== -->

    <!-- ================== BEGIN PAGE LEVEL JS ================== -->
    <script src="${ctxStatic}/plugins/DataTables/js/jquery.dataTables.js"></script>
    <script src="${ctxStatic}/plugins/DataTables/js/dataTables.responsive.js"></script>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->

    <script>
        function init () {
            if ($("#data-table").length !== 0) {
                $("#data-table").dataTable({
                    "processing": true,
                    "serverSide": true,
                    "ajax": {
                        "url": "${ctx}/news/list",
                        "dataType": "json"
                    },
                    "columns": [
                        { "data": "id" },
                        { "data": "id" },
                        { "data": "id" },
                        { "data": "id" },
                        { "data": "id" }
                    ]
                });
            }
        };
        function remindDelete (modelId,key){
            $("#model-ok").attr("href","${ctx}/news/delete?id="+key);
            $(function () { $('#'+modelId).modal({
                keyboard: true
            })});
        };

        $(document).ready(function() {
            $("#menu li").removeClass("active");
            $("#209").addClass("active");
            $("#210").addClass("active");
            App.init();
            init();
        });
    </script>
</head>
<body>
<div class="row">
    <div class="col-md-12">
        <ul class="nav nav-tabs">
            <li class="active"><a href="${ctx}/news/index">新闻列表</a></li>
            <shiro:hasPermission name="news:list:edit">
                <li class=""><a href="${ctx}/news/form">新增/编辑</a></li>
            </shiro:hasPermission>
        </ul>
        <div class="tab-content">
            <div class="tab-pane fade active in" id="default-tab-1">
                <!-- begin panel -->
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <div class="panel-heading-btn">
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i class="fa fa-expand"></i></a>
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-success" data-click="panel-reload"><i class="fa fa-repeat"></i></a>
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning" data-click="panel-collapse"><i class="fa fa-minus"></i></a>
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger" data-click="panel-remove"><i class="fa fa-times"></i></a>
                        </div>
                        <h4 class="panel-title">新闻列表</h4>
                    </div>

                    <div class="panel-body">
                        <table id="data-table" class="table table-striped table-bordered nowrap" width="100%">
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>标题</th>
                                <th>发布时间</th>
                                <th>发布人</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- end panel -->
            </div>
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
</div>
</body>
</html>

