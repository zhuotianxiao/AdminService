<%--
  Created by IntelliJ IDEA.
  finance: WangJian
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
    <title>金融机构基本信息</title>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <script>
        $(document).ready(function () {
            $("#menu li").removeClass("active");
            $("#106").addClass("active");
            $("#108").addClass("active");
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
                <h4 class="panel-title">金融机构基本信息</h4>
            </div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <tbody>
                    <tr>
                        <td width="10%" align="right">登录名称</td>
                        <td>${finance.account.username }</td>
                        <td width="10%" align="right">登录密码</td>
                        <td>${finance.account.password }</td>
                        <td width="12%" rowspan="5">
                            <div class="superbox" data-offset="54">
                                <div class="superbox-list">
                                    <img src="${finance.businessLicence}"
                                         data-img="${finance.businessLicence}" alt=""
                                         class="superbox-img">
                                </div>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td align="right">机构名称</td>
                        <td><span class="badge badge-info">${finance.name }</span></td>
                        <td align="right">认证状态</td>
                        <td>

                            <c:if test="${finance.financeAuth == 3}">

                                已认证
                            </c:if>
                            <c:if test="${finance.financeAuth != 3}">
                                未认证
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">类型</td>
                        <td><span
                                class="badge badge-info"> ${fns:getTcDictLabel(finance.type+"","finance_type","暂未填写")}</span>
                        </td>
                        <td align="right">组织机构代码</td>
                        <td><span class="badge badge-info">${finance.orgCode }</span></td>
                    </tr>

                    <tr>
                        <td align="right">所在地区</td>
                        <td><span class="badge badge-info">${fns:getDefaultVal(finance.areaNames,"暂未填写")}</span></td>
                        <td align="right">机构邮箱</td>
                        <td>${finance.email}</td>
                    </tr>
                    <tr>
                        <td align="right">固定电话</td>
                        <td><span class="badge badge-info">${finance.tel}</span></td>
                        <td align="right">机构网站</td>
                        <td><span class="badge badge-info">${finance.website }</span></td>
                    </tr>
                    <tr>
                        <td align="right">机构联系人</td>
                        <td><span class="badge badge-info">${finance.linkMan}</span></td>
                        <td align="right">联系人手机号</td>
                        <td colspan="2"><span class="badge badge-info">${finance.phone }</span></td>
                    </tr>

                    <tr>
                        <td align="right">详细地址</td>
                        <td colspan="4">${finance.addr }</td>
                    </tr>
                    <tr>
                        <td align="right">金融产品介绍</td>
                        <td colspan="4">${finance.productDesc}</td>
                    </tr>
                    <tr>
                        <td align="right">机构介绍</td>
                        <td colspan="4">${finance.intro}</td>
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