<%--
  Created by IntelliJ IDEA.
  model: WangJian
  Date: 2015/5/19
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="decorator" content="default"/>
    <title>专家咨询详细信息</title>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <script>
        $(document).ready(function () {
            $("#menu li").removeClass("active");
            $("#216").addClass("active");
            $("#218").addClass("active");
            App.init();
        });


        function submitAuditConsultation(flag) {

            $("#flag").val(flag);
            $.ajax({
                type: "POST",
                url: "${ctx}/consultation/list/check-consultation-cancel",
                data: $("#publishForm").serialize(),
                dataType: 'json',
                success: function (data) {
                    if (data.result == 1) {
                        alert("审核完成!");
                        window.location.href = "${ctx}/consultation/list/cancel";
                    } else {

                        alert("审核异常");
                    }
                },
                error: function (msg) {
                    alert("审核异常" + msg);
                }
            });
        }
    </script>
</head>
<body>
<!-- begin row -->
<div class="row">
    <div class="col-md-12">
        <!-- begin panel -->
        <div class="panel panel-inverse" data-sortable-id="ui-general-3">
            <div class="panel-heading">
                <div class="panel-heading-btn">
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i
                            class="fa fa-expand"></i></a>
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-success" data-click="panel-reload"><i
                            class="fa fa-repeat"></i></a>
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning"
                       data-click="panel-collapse"><i class="fa fa-minus"></i></a>
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger"
                       data-click="panel-remove"><i class="fa fa-times"></i></a>
                </div>
                <h4 class="panel-title">专家咨询详细信息</h4>
            </div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <tbody>
                    <tr>
                        <td width="10%" align="right">咨询标题</td>
                        <td><span class="badge badge-info">${model.title }</span></td>
                        <td width="10%" align="right">状态</td>
                        <td>
                            <s:eval expression="T(cn.fundview.modules.util.constants.ConsultationStatus).getNames(${model.status})"
                                    var="status1"/>${status1}
                        </td>
                    </tr>
                    <tr>
                        <td width="10%" align="right">企业名称</td>
                        <td>${model.consulationMan}</td>
                        <td width="10%" align="right">咨询企业手机号</td>
                        <td>${model.phone }</td>
                    </tr>

                    <tr>
                        <td width="10%" align="right">专家姓名</td>
                        <td><span class="badge badge-info">${model.expertName}</span></td>
                        <td width="10%" align="right">专家手机号</td>
                        <td><span class="badge badge-info">${model.expertPhone}</span></td>
                    </tr>

                    <tr>
                        <td align="right">咨询方式</td>
                        <td><span class="badge badge-info">

                            <c:if test="${model.consulationType ==1}">电话咨询</c:if>
                            <c:if test="${model.consulationType ==2}">现场咨询</c:if>

                        </span></td>
                        <td align="right">咨询价格</td>
                        <td>${model.price}
                            <c:if test="${model.consulationType ==1}">元/小时</c:if>
                            <c:if test="${model.consulationType ==2}">元/天</c:if>
                        </td>
                    </tr>
                    <c:if test="!empty model.appointTime">

                        <tr>
                            <td align="right">具体的服务时间</td>
                            <td colspan="3"><span class="badge badge-info">

                                <fmt:formatDate value="${model.appointTime}" type="date"/>
                            </span></td>
                        </tr>
                    </c:if>
                    <c:if test="!empty model.checkCause">

                        <tr>
                            <td align="right">客服审核结果</td>
                            <td colspan="3"><span class="badge badge-info">

                                <fmt:formatDate value="${model.checkCause}" type="date"/>
                            </span></td>
                        </tr>
                    </c:if>
                    <c:if test="${model.cancelStatus != 0}">

                        <tr>
                            <td align="right">咨询取消状态</td>
                            <td colspan="3"><span class="badge badge-info">

                               <s:eval expression="T(cn.fundview.modules.util.constants.ConsultationCancelStatus).getNames(${model.cancelStatus})"
                                       var="status"/>${status}
                            </span></td>
                        </tr>
                        <tr class="form-group">
                            <td align="right" class="col-md-3 control-label">咨询取消原因</td>
                            <td colspan="3">
                                    ${cancelCause}
                            </td>
                        </tr>

                    </c:if>

                    <tr>
                        <td align="right">咨询问题描述</td>
                        <td colspan="3">${model.description}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- end panel -->
        <c:if test="${model.report != null}">
            <!-- begin panel -->
            <div class="panel panel-inverse" data-sortable-id="ui-general-3">
                <div class="panel-heading">
                    <div class="panel-heading-btn">
                        <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default"
                           data-click="panel-expand"><i
                                class="fa fa-expand"></i></a>
                        <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-success"
                           data-click="panel-reload"><i
                                class="fa fa-repeat"></i></a>
                        <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning"
                           data-click="panel-collapse"><i class="fa fa-minus"></i></a>
                        <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger"
                           data-click="panel-remove"><i class="fa fa-times"></i></a>
                    </div>
                    <h4 class="panel-title">专家咨询服务总结报告</h4>
                </div>
                <div class="panel-body">
                    <table class="table table-bordered">
                        <tbody>

                        <tr>
                            <td align="right" width="10%">问题体现</td>
                            <td colspan="3">${model.report.problemManifest}</td>
                        </tr>
                        <tr>
                            <td align="right" width="10%">原因分析</td>
                            <td colspan="3">${model.report.analyse}</td>
                        </tr>

                        <tr>
                            <td align="right" width="10%">改进措施和建议</td>
                            <td colspan="3">${model.report.adverse}</td>
                        </tr>

                        <tr>
                            <td align="right" width="10%">专家服务报告</td>
                            <td colspan="3"><a href="${model.report.docPath}">下载专家服务报告</a></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- end panel -->
        </c:if>
        <c:if test="${model.evaluate}">
            <!-- begin panel -->
            <div class="panel panel-inverse" data-sortable-id="ui-general-3">
                <div class="panel-heading">
                    <div class="panel-heading-btn">
                        <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default"
                           data-click="panel-expand"><i
                                class="fa fa-expand"></i></a>
                        <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-success"
                           data-click="panel-reload"><i
                                class="fa fa-repeat"></i></a>
                        <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning"
                           data-click="panel-collapse"><i class="fa fa-minus"></i></a>
                        <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger"
                           data-click="panel-remove"><i class="fa fa-times"></i></a>
                    </div>
                    <h4 class="panel-title">专家咨询服务评价</h4>
                </div>
                <div class="panel-body">
                    <table class="table table-bordered">
                        <tbody>

                        <tr class="gallery">
                            <td align="right" width="10%">专满意度</td>
                            <td colspan="3">

                                <div class="rating">
                                    <c:forEach begin="1" end="${model.evaluation.satisfaction}">

                                        <span class="star active"></span>
                                    </c:forEach>
                                    <c:forEach begin="${model.evaluation.satisfaction}" end="5">

                                        <span class="star"></span>
                                    </c:forEach>

                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" width="10%">及时性</td>
                            <td colspan="3">

                                <c:if test="${model.evaluation.timeliness==1}">

                                    及时
                                </c:if>
                                <c:if test="${model.evaluation.timeliness==0}">

                                    不及时
                                </c:if>

                            </td>
                        </tr>
                        <tr>
                            <td align="right" width="10%">解决程度</td>
                            <td colspan="3">

                                <c:if test="${model.evaluation.solvingDegree==1}">
                                    已解决
                                </c:if>
                                <c:if test="${model.evaluation.solvingDegree==0}">
                                    未解决
                                </c:if>

                            </td>
                        </tr>
                        <tr>
                            <td align="right">标签</td>
                            <td colspan="3">

                                <s:eval expression="T(cn.fundview.setting.utils.DictUtils).getTcDictLabels('${model.evaluation.evalutionTagIds}','evaluate','暂未填写')"
                                        var="tag"/>
                                    ${tag}
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- end panel -->
        </c:if>
        <div class="panel panel-inverse" data-sortable-id="ui-general-3">
            <form class="form-horizontal" method="post" action="/${ctx}/consultation/list/cancel-check" id="publishForm">
                <input type ="hidden" name="id" value="${model.id}" />
                <input type ="hidden" name="flag" value="" id="flag" />
                <div class="panel-body">
                    <table class="table table-bordered">
                        <tbody>
                        <tr>
                            <td align="right" width="10%">取消审核备注</td>
                            <td colspan="3">
                                <textarea rows="5" placeholder="咨询取消审核备注" name="cancelCheckMark"
                                          class="form-control">${cancelCheckMark}</textarea>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="5">
                                <button class="btn btn-sm btn-success" type="button" onclick="submitAuditConsultation(true);">审核成功</button>
                                <button class="btn btn-sm btn-success" type="button" onclick="submitAuditConsultation();">审核失败</button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- end row -->
</body>
</html>