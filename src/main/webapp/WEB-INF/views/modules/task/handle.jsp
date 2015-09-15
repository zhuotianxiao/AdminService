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
    <title>办理任务</title>
    <!-- ================== BEGIN PAGE LEVEL STYLE ================== -->
    <link href="${ctxStatic}/plugins/DataTables/css/data-table.css" rel="stylesheet"/>
    <link href="${ctxStatic}/plugins/morris/morris.css" rel="stylesheet" />
    <link href="${ctxStatic}/plugins/parsley/src/parsley.css" rel="stylesheet"/>
    <link href="${ctxStatic}/plugins/bootstrap-datepicker/css/datepicker.css" rel="stylesheet"/>
    <link href="${ctxStatic}/plugins/bootstrap-select/bootstrap-select.min.css" rel="stylesheet"/>
    <!-- ================== END PAGE LEVEL STYLE ================== -->

    <!-- ================== BEGIN PAGE LEVEL JS ================== -->
    <script src="${ctxStatic}/plugins/DataTables/js/jquery.dataTables.js"></script>
    <script src="${ctxStatic}/plugins/DataTables/js/dataTables.responsive.js"></script>
    <script src="${ctxStatic}/plugins/morris/raphael.min.js"></script>
    <script src="${ctxStatic}/plugins/morris/morris.js"></script>
    <script src="${ctxStatic}/plugins/parsley/dist/parsley.js"></script>
    <script src="${ctxStatic}/plugins/parsley/dist/zh_cn.js"></script>
    <script src="${ctxStatic}/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <script src="${ctxStatic}/plugins/bootstrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js" charset="UTF-8"></script>
    <script src="${ctxStatic}/plugins/bootstrap-select/bootstrap-select.min.js"></script>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <script>
        var getMonthName = function (e) {
            var t = [];
            t[0] = "一月";
            t[1] = "二月";
            t[2] = "三月";
            t[3] = "四月";
            t[4] = "五月";
            t[5] = "六月";
            t[6] = "七月";
            t[7] = "八月";
            t[8] = "九月";
            t[9] = "十月";
            t[10] = "十一月";
            t[11] = "十二月";
            return t[e]
        };

        $(document).ready(function () {
            $("#menu li").removeClass("active");
            $("#200").addClass("active");
            $("#202").addClass("active");
            App.init();
            $("#workDate").datepicker({
                language: "zh-CN",
                todayHighlight: true,
                autoclose: true
            });

            $(".selectpicker").selectpicker("render");

            $.ajax({
                url:'get-handle-data',
                data:{
                    orderId : $("#orderId").val()
                },
                type:'post',
                cache:false,
                dataType:'json',
                success:function(data) {
                    var e = "#0D888B";
                    var t = "#00ACAC";
                    var n = "#3273B1";
                    var r = "#348FE2";
                    var i = "rgba(0,0,0,0.6)";
                    var s = "rgba(255,255,255,0.4)";
                    Morris.Line({
                        element : "visitors-line-chart",
                        data : data,
                        xkey : "x",
                        ykeys : ["y"],
                        xLabelFormat : function (e) {
                            e = getMonthName(e.getMonth());
                            return e.toString()
                        },
                        labels : ["用时(小时)"],
                        lineColors : [e, n],
                        pointFillColors : [t, r],
                        lineWidth : "2px",
                        pointStrokeColors : [i, i],
                        resize : true,
                        gridTextFamily : "Open Sans",
                        gridTextColor : s,
                        gridTextWeight : "normal",
                        gridTextSize : "11px",
                        gridLineColor : "rgba(0,0,0,0.5)",
                        hideHover : "auto"
                    });
                    var countTime = 0;
                    $.each(data, function(i, item) {
                        countTime += parseFloat(item.y);;
                    });
                    $("#countTime").append(countTime);

                },
                error : function() {
                    alert("异常！");
                }
            });

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
                    "aaSorting": [[0, "desc"]]
                })
            }

        });
    </script>
</head>
<body>
<!-- begin row -->
<div class="row">
    <div class="col-md-12">
        <div class="note note-warning">
            <input type="hidden" id="orderId" value="${taskUserOrder.id}"/>
            <h4>${taskUserOrder.insideTask.title}</h4>
            <h5>截至日期：${fns:formatDateDefault(taskUserOrder.insideTask.deadline)}</h5>
        </div>
        <div class="note note-info">
            <h5>任务类型：${fns:getDictLabel(taskUserOrder.insideTask.type, 'task_type', '未填写')}</h5>
            <h5>任务级别：${fns:getDictLabel(taskUserOrder.insideTask.level, 'task_level', '未填写')}</h5>
        </div>
        <div class="note note-success">
            <h5>发布人：${taskUserOrder.insideTask.createBy.name}</h5>
            <p>
                ${taskUserOrder.insideTask.description }
            </p>
        </div>
        <div class="widget-chart with-sidebar bg-black">
            <div class="widget-chart-content">
                <h4 class="chart-title">
                    办理该任务已用时间
                </h4>
                <div id="visitors-line-chart" class="morris-inverse" style="height: 260px;"></div>
            </div>
            <div class="widget-chart-sidebar bg-black-darker">
                <div id="countTime" class="chart-number">
                    <small>总用时</small>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="row">
    <div class="col-md-12">
        <c:if test="${taskUserOrder.insideTask.taskStatus eq '0'}">
        <c:if test="${taskUserOrder.consumer eq fns:getUser().id}">
            <div class="panel panel-primary" data-sortable-id="validation-handle-save">
                <div class="panel-heading">
                    <div class="panel-heading-btn">
                        <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i class="fa fa-expand"></i></a>
                        <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning" data-click="panel-collapse"><i class="fa fa-minus"></i></a>
                        <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger" data-click="panel-remove"><i class="fa fa-times"></i></a>
                    </div>
                    <h4 class="panel-title">办理任务</h4>
                </div>
                <div class="panel-body panel-form">
                    <form:form modelAttribute="insideTaskDetail" action="save-handle" class="form-horizontal form-bordered" data-parsley-validate="true">
                        <input type="hidden" name="orderId" value="${taskUserOrder.id}"/>
                        <input type="hidden" name="userId" value="${fns:getUser().id}"/>
                        <div class="form-group">
                            <label class="control-label col-md-4 col-sm-4">任务标题:</label>
                            <div class="col-md-4 col-sm-6">
                                <input type="text" class="form-control" value="${taskUserOrder.insideTask.title}" readonly="readonly"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4 col-sm-4">任务执行日期:</label>

                            <div class="col-md-2">
                                <input name="workDate" id="workDate" type="date" data-parsley-required="true" class="form-control" value="${fns:getDate('yyyy-MM-dd')}" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4 col-sm-4">任务执行时长:</label>

                            <div class="col-md-2">
                                <input name="workTime" type="number" class="form-control" data-parsley-required="true" data-parsley-type="number" placeholder="小时"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4 col-sm-4">任务描述:</label>

                            <div class="col-md-4">
                            <textarea name="description" type="text" class="form-control"
                                      data-parsley-maxlength="240" placeholder="任务描述"></textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4 col-sm-4"></label>

                            <div class="col-md-6 col-sm-6">
                                <button type="submit" class="btn btn-success">提交</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </c:if>
        </c:if>

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
                <h4 class="panel-title">工作记录</h4>
            </div>

            <div class="panel-body">
                <table id="data-table" class="table table-striped table-bordered nowrap" width="100%">
                    <thead>
                    <tr>
                        <th>工作日期</th>
                        <th>工作时长(h)</th>
                        <th>工作描述</th>
                        <th>操作日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${taskDetails}" var="taskDetail" varStatus="idxStatus">
                        <tr class="default">
                            <td><fmt:formatDate value="${taskDetail.workDate}" type="date"/></td>
                            <td>${taskDetail.workTime}</td>
                            <td>${taskDetail.description}</td>
                            <td><fmt:formatDate value="${taskDetail.createDate}" type="date"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- end panel -->
    </div>
</div>


<!-- end row -->
</body>
</html>