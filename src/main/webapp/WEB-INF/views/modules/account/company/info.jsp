<%--
  Created by IntelliJ IDEA.
  company: WangJian
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
    <title>企业基本信息</title>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <script>
        $(document).ready(function () {
            $("#menu li").removeClass("active");
            $("#106").addClass("active");
            $("#117").addClass("active");
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
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i class="fa fa-expand"></i></a>
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-success" data-click="panel-reload"><i class="fa fa-repeat"></i></a>
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning" data-click="panel-collapse"><i class="fa fa-minus"></i></a>
                    <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger" data-click="panel-remove"><i class="fa fa-times"></i></a>
                </div>
                <h4 class="panel-title">企业基本信息</h4>
            </div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <tbody>
                    <tr>
                        <td width="10%" align="right">登录名称</td>
                        <td>${company.account.username }</td>
                        <td width="10%" align="right">登录密码</td>
                        <td>${company.account.password }</td>
                        <td colspan="2" rowspan="2" width="10%">

                            <s:eval expression="T(cn.fundview.modules.util.ImgPathConvertor).getFrontCompLogoThumbFile('${company.logo}',104,78)"
                                    var="logo"/>
                            <img src="${logo}" alt="${company.name}" width="104px" height="78px"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">企业名称</td>
                        <td ><span class="badge badge-info">${company.name }</span></td>
                        <td align="right">认证状态</td>
                        <td ><span class="badge badge-info">


                            <c:if test="${company.compAuth == 0}">

                                未认证
                            </c:if>
                            <c:if test="${company.compAuth == 1}">

                                待认证审核
                            </c:if>
                            <c:if test="${company.compAuth == 2}">

                                认证失败
                            </c:if>
                            <c:if test="${company.compAuth == 3}">

                                认证成功
                            </c:if>
                        </span></td>
                    </tr>
                    <tr>
                        <td align="right">所属行业</td>
                        <td colspan="5"><span class="badge badge-info">${company.tradeNames }、${company.tradeChildNames}</span></td>
                    </tr>
                    <tr>
                        <td align="right">所在地区</td>
                        <td><span class="badge badge-info">${fns:getDefaultVal(company.areaNames,"暂未填写")}</span></td>
                        <td align="right">企业邮箱</td>
                        <td colspan="3">${company.email}</td>
                    </tr>

                    <tr>
                        <td align="right">官方网址</td>
                        <td><span class="badge badge-info"><a href="${company.website}" target="_blank">${company.website}</a></span></td>
                        <td align="right">企业固话</td>
                        <td colspan="3">${company.tel}</td>
                    </tr>

                    <tr>
                        <td align="right">注册时间</td>
                        <td><span class="badge badge-info">${company.regTime}</span></td>
                        <td align="right">注册资金</td>
                        <td colspan="3"><span class="badge badge-info">
                            <c:if test="${companu.regCapital == 0}">

                                暂未填写
                            </c:if>
                            <c:if test="${company.regCapital > 0}">

                                ${company.regCapital}万元
                            </c:if>
                        </span></td>
                    </tr>

                    <tr>
                        <td align="right">企业注册类型</td>
                        <td><span class="badge badge-info">${fns:getTcDictLabel(company.regType,"comp_reg_type","暂未填写")}</span></td>
                        <td align="right">重点龙头企业级别</td>
                        <td colspan="3">${fns:getTcDictLabel(company.ltqyType,"comp_level","暂未填写")}</td>
                    </tr>
                    <tr>
                        <td align="right">企业联系人</td>
                        <td><span>${company.linkman}</span></td>
                        <td align="right">联系人手机号</td>
                        <td colspan="3">${company.phone}</td>
                    </tr>

                    <tr>
                        <td align="right">企业标签</td>
                        <td colspan="5"><span>${company.tags}</span></td>
                    </tr>
                    <tr>
                        <td align="right">详细地址</td>
                        <td colspan="5">${company.addr }</td>
                    </tr>
                    <tr>
                        <td align="right">经营范围</td>
                        <td colspan="5">${company.service}</td>
                    </tr>
                    <tr>
                        <td align="right">企业介绍</td>
                        <td colspan="5">${company.info}</td>
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