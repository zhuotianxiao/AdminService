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
    <title>菜单管理</title>
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
                    "aaSorting": [[ 0, "asc" ]]
                })
            }
        };
        function remindDelete (modelId,key){
            $("#model-ok").attr("href","${ctx}/menu/delete?id="+key);
            $(function () { $('#'+modelId).modal({
                keyboard: true
            })});
        };

        $(document).ready(function() {
            $("#menu li").removeClass("active");
            $("#2").addClass("active");
            $("#5").addClass("active");
            App.init();
            init();
        });
    </script>
</head>
<body>
<div class="row">
    <div class="col-md-12">
        <ul class="nav nav-tabs">
            <li class="active"><a href="${ctx}/menu/index">菜单列表</a></li>
            <shiro:hasPermission name="sys:menu:edit">
                <li class=""><a href="${ctx}/menu/form">新增/编辑</a></li>
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
                        <h4 class="panel-title">内网菜单列表</h4>
                    </div>

                    <div class="panel-body">
                        <table id="data-table" class="table table-striped table-bordered nowrap" width="100%">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>菜单名称</th>
                                <th>菜单链接</th>
                                <th>菜单图标</th>
                                <th>显示顺序</th>
                                <th>是否显示</th>
                                <th>权限标识</th>
                                <th>父目录名称</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${list}" var="menu" varStatus="idxStatus">
                                <tr class="unread">
                                    <td>${idxStatus.index+1}</td>
                                    <td>${menu.name}</td>
                                    <td>${menu.href}</td>
                                    <td>${menu.icon}</td>
                                    <td>${menu.sort}</td>
                                    <td>${menu.isShow}</td>
                                    <td>${menu.permission}</td>
                                    <td>${menu.parent.name}</td>
                                    <td>
                                        <a href="${ctx}/menu/form?id=${menu.id}"><span class="label label-primary">修改</span></a>
                                        <a href="javascript:remindDelete('modal-message','${menu.id}')"><span class="label label-danger">删除</span></a>
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

