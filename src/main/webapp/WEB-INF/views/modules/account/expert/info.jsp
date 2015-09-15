<%--
  Created by IntelliJ IDEA.
  expert: WangJian
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
    <title>专家基本信息</title>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <script>
        $(document).ready(function () {
            $("#menu li").removeClass("active");
            $("#106").addClass("active");
            $("#107").addClass("active");
            App.init();
        });
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
                <h4 class="panel-title">专家基本信息</h4>
            </div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <tbody>
                    <tr>
                        <td width="10%" align="right">登录名称</td>
                        <td>${expert.account.username }</td>
                        <td width="10%" align="right">登录密码</td>
                        <td>${expert.account.password }</td>
                        <td colspan="2" rowspan="2" width="10%">

                            <s:eval expression="T(cn.fundview.modules.util.ImgPathConvertor).getFrontExpertLogoThumbFile('${expert.logo}',104,78)"
                                    var="logo"/>
                            <img src="${logo}" alt="${expert.name}" width="104px" height="78px"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="10%">专家姓名</td>
                        <td ><span class="badge badge-info">${expert.name }</span></td>
                        <td align="right" width="10%">专家认证</td>
                        <td ><span class="badge badge-info">

                            <c:if test="${expert.account.isAuth}">

                                <c:if test="${expert.expertType == 1 and expert.applyGuestExpertStatus == 3}">

                                    特约专家
                                </c:if>
                                <c:if test="${expert.expertType != 1 or expert.applyGuestExpertStatus != 3}">

                                    已认证
                                </c:if>
                            </c:if>
                            <c:if test="${!expert.account.isAuth}">

                                未认证
                            </c:if>
                        </span></td>
                    </tr>
                    <tr>
                        <td align="right">所属行业</td>
                        <td colspan="5"><span
                                class="badge badge-info">${expert.tradeNames }、${expert.tradeChildNames}</span></td>
                    </tr>
                    <tr>
                        <td align="right">所在地区</td>
                        <td><span class="badge badge-info">${fns:getDefaultVal(expert.areaNames,"暂未填写")}</span></td>
                        <td align="right">专家邮箱</td>
                        <td colspan="3">${expert.email}</td>
                    </tr>
                    <tr>
                        <td align="right">固定电话</td>
                        <td><span class="badge badge-info">${expert.tel}</span></td>
                        <td align="right">认证手机号</td>
                        <td colspan="3"><span class="badge badge-info">${expert.phone }</span></td>
                    </tr>
                    <tr>
                        <td align="right">学历</td>
                        <td><span
                                class="badge badge-info">${fns:getTcDictLabel(expert.education+"","education","暂未填写")}</span>
                        </td>
                        <td align="right">专业职称</td>
                        <td colspan="3"><span class="badge badge-info">${expert.professionalTitle }</span></td>
                    </tr>
                    <tr>
                        <td align="right">出生日期</td>
                        <td><span class="badge badge-info">${expert.birthday}</span></td>
                        <td align="right">性别</td>
                        <td colspan="3"><span
                                class="badge badge-info">${fns:getTcDictLabel(expert.sex+"","user_sex","暂未填写")}</span>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">工作单位</td>
                        <td><span>${expert.theUnit}</span></td>
                        <td align="right">工作部门</td>
                        <td colspan="3"><span>${expert.department }</span></td>
                    </tr>
                    <tr>
                        <td align="right">专家标签</td>
                        <td><span>${expert.tags}</span></td>
                        <td align="right">是否愿意接受企业付费咨询</td>
                        <td colspan="3"><span class="badge badge-info">
                        	<c:if test="${expert.applyGuestExpertStatus == 1}">是</c:if>
                        	<c:if test="${expert.applyGuestExpertStatus != 1}">否</c:if>
                        	</span>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">详细地址</td>
                        <td colspan="5">${expert.addr }</td>
                    </tr>
                    <tr>
                        <td align="right">研究领域</td>
                        <td colspan="5">${expert.specialty}</td>
                    </tr>
                    <tr>
                        <td align="right">专家介绍</td>
                        <td colspan="5">${expert.intro}</td>
                    </tr>
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