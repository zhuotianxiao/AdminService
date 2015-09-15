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
    <title>专家管理</title>
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
                });
            }
        };
        function remindDelete(modelId,key,flag){
        	
            $("#"+modelId).find("#model-ok").attr("href","${ctx}/account/expert/valid/"+key+"/"+flag);
            $(function () {
            	$('#'+modelId).modal({
                	keyboard: true
            	});
            });
        };


        $(document).ready(function() {
            $("#menu li").removeClass("active");
            $("#106").addClass("active");
            $("#107").addClass("active");
            App.init();
            init();
        });
    </script>
</head>
<body>
<div class="row">
    <div class="col-md-12">
        <ul class="nav nav-tabs">
            <li class="active"><a href="${ctx}/account/expert/index">专家列表</a></li>
            <li ><a href="${ctx}/account/expert/statistics">专家统计</a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane fade active in" id="default-tab-1">
                <!-- begin panel -->
                <div class="panel panel-inverse">
                    <div class="panel-heading">
                        <div class="panel-heading-btn">
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i class="fa fa-expand"></i></a>
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-success" data-click="panel-reload"><i class="fa fa-repeat"></i></a>
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning" data-click="panel-collapse"><i class="fa fa-minus"></i></a>
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger" data-click="panel-remove"><i class="fa fa-times"></i></a>
                        </div>
                        <h4 class="panel-title">专家列表</h4>
                    </div>

                    <div class="panel-body">
                        <table id="data-table" class="table table-striped table-bordered nowrap" width="100%">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>登录名称</th>
                                <th>姓名</th>
                                <th>地区</th>
                                <th>联系方式</th>
                                <th>认证手机号</th>
                                <th>创建时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${list}" var="expert" varStatus="idxStatus">
                                <tr class="unread">
                                        <%--<tr class="odd gradeX">--%>
                                    <td>${expert.id}</td>
                                    <td>${expert.account.username}</td>
                                    <td>${expert.name}</td>
                                    <td>${expert.areaNames}</td>
                                    <td>${expert.tel}</td>
                                    <td>${expert.phone}</td>
                                    <td><fmt:formatDate value="${expert.createDate}" type="both"/></td>
                                    <td>
                                    	<c:if test="${expert.account.valid}">
                                        <a href="javascript:remindDelete('modal-message1','${expert.id}',false)">
                                        	<span class="label label-danger">禁用</span>
                                        </a>
                                        </c:if>
                                        <c:if test="${!expert.account.valid}">
											<a href="javascript:remindDelete('modal-message2','${expert.id}',true)">
											<span class="label label-success">启用</span>
											</a>
                                        </c:if>
                                        <a href="${ctx}/account/expert/info/${expert.id}"><span class="label label-primary">详细</span></a>
                                        <a href="${ctx}/account/expert/auth/${expert.id}"><span class="label label-primary">修改认证信息</span></a>
                                        <a href="${ctx}/account/expert/setting/${expert.id}"><span class="label label-primary">设置前台显示</span></a>
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
        <div class="modal modal-message fade" id="modal-message1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title">确认信息</h4>
                    </div>
                    <div class="modal-body">
                        <p>禁用后该账户将成为无效账户,请确认是否禁用？${id}</p>
                    </div>
                    <div class="modal-footer">
                        <a href="javascript:;" class="btn btn-sm btn-white" data-dismiss="modal">取消</a>
                        <a id="model-ok" href="javascript:;" class="btn btn-sm btn-primary">禁用</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-6">
        <div class="modal modal-message fade" id="modal-message2">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title">确认信息</h4>
                    </div>
                    <div class="modal-body">
                        <p>启用后该账户将成为有效账户,需要确认其基本信息的真实性,请确认是否启用？${id}</p>
                    </div>
                    <div class="modal-footer">
                        <a href="javascript:;" class="btn btn-sm btn-white" data-dismiss="modal">取消</a>
                        <a id="model-ok" href="javascript:;" class="btn btn-sm btn-primary">启用</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

