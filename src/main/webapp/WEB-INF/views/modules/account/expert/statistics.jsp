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
    <link href="${ctxStatic}/plugins/DataTables/css/data-table.css" rel="stylesheet"/>
    <!-- ================== END PAGE LEVEL STYLE ================== -->

    <!-- ================== BEGIN PAGE LEVEL JS ================== -->
    <script src="${ctxStatic}/plugins/DataTables/js/jquery.dataTables.js"></script>
    <script src="${ctxStatic}/plugins/DataTables/js/dataTables.responsive.js"></script>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <!-- ================== BEGIN PAGE LEVEL JS ================== -->
    <script src="${ctxStatic}/plugins/DataTables/js/jquery.dataTables.js"></script>
    <script src="${ctxStatic}/plugins/DataTables/js/dataTables.responsive.js"></script>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <script src="${ctxStatic}/plugins/flot/jquery.flot.min.js"></script>
    <script src="${ctxStatic}/plugins/flot/jquery.flot.time.min.js"></script>
    <script src="${ctxStatic}/plugins/flot/jquery.flot.resize.min.js"></script>
    <script src="${ctxStatic}/plugins/flot/jquery.flot.pie.min.js"></script>
    <script src="${ctxStatic}/plugins/flot/jquery.flot.stack.min.js"></script>
    <script src="${ctxStatic}/plugins/flot/jquery.flot.crosshair.min.js"></script>
    <script src="${ctxStatic}/plugins/flot/jquery.flot.categories.js"></script>
    <script src="${ctxStatic}/js/chart-flot.demo.js"></script>
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
        function remindDelete(modelId, key, flag) {

            $("#" + modelId).find("#model-ok").attr("href", "${ctx}/account/expert/valid/" + key + "/" + flag);
            $(function () {
                $('#' + modelId).modal({
                    keyboard: true
                });
            });
        }
        ;


        $(document).ready(function () {
            $("#menu li").removeClass("active");
            $("#106").addClass("active");
            $("#107").addClass("active");
            App.init();
            init();
            handleBarChart();
        });

        var handleBarChart = function () {
            "use strict";
            if ($("#bar-chart").length !== 0) {


                //var e = [["January", 10], ["February", 8], ["March", 4], ["April", 13], ["May", 17], ["June", 9]];
                var e = new Array();

                <c:forEach items="${list}" var="map">
                var arrayItem = new Array();
                arrayItem.push("${map.value}");
                arrayItem.push(${map.key});
                e.push(arrayItem);
                </c:forEach>

                $.plot("#bar-chart", [{
                    data: e,
                    color: purple
                }], {
                    series: {
                        bars: {
                            show: true,
                            barWidth: .4,
                            align: "center",
                            fill: true,
                            fillColor: purple,
                            zero: true
                        }
                    },
                    xaxis: {
                        mode: "categories",
                        tickColor: "#ddd",
                        tickLength: 0
                    },
                    grid: {
                        borderWidth: 0
                    }
                })
            }
        };
    </script>
</head>
<body>
<div class="row">
    <div class="col-md-12">
        <ul class="nav nav-tabs">
            <li><a href="${ctx}/account/expert/index">专家列表</a></li>
            <li class="active"><a href="${ctx}/account/expert/statistics/">专家统计</a></li>
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
                        <h4 class="panel-title">专家用户个地区统计图</h4>
                    </div>

                    <div class="panel-body">
                        <div id="page-container " class="fade page-sidebar-fixed page-header-fixed in tab-content">
                            <div id="content" class="">
                                <div class="row">
                                    <div class="ui-sortable">
                                        <div data-sortable-id="flot-chart-3" class="panel panel-inverse">
                                            <div class="panel-body">
                                                <div class="height-sm" id="bar-chart">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>
</body>
</html>

