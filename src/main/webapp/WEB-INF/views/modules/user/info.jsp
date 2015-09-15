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
    <title>员工基本信息</title>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <script>
        $(document).ready(function () {
            $("#menu li").removeClass("active");
            $("#2").addClass("active");
            $("#3").addClass("active");
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
                <h4 class="panel-title">员工基本信息(管理员填写)</h4>
            </div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <tbody>
                    <tr>
                        <td width="10%" align="right">登录名称</td>
                        <td>${user.loginName}</td>
                        <td width="10%" align="right">真实姓名</td>
                        <td>${user.name}</td>
                    </tr>
                    <tr>
                        <td align="right">归属部门</td>
                        <td><span class="label label-success">${user.office.name}</span></td>
                        <td align="right">性别</td>
                        <td><span class="label label-primary">${fns:getDictLabel(user.sex, 'sex', '未填写')}</span></td>
                    </tr>
                    <tr>
                        <td align="right">人员类别</td>
                        <td><span class="badge badge-info">${fns:getDictLabel(user.type, 'sys_user_type', '未填写')}</span></td>
                        <td align="right">参加工作时间</td>
                        <td><fmt:formatDate value="${user.workDate}" type="date"/></td>
                    </tr>
                    <tr>
                        <td align="right">固定电话</td>
                        <td><span class="badge badge-info">${user.phone}</span></td>
                        <td align="right">角色</td>
                        <td>
                            <c:forEach items="${user.roleList}" var="role" varStatus="idxStatus">
                                <span class="badge badge-info">
                                        ${role.name}
                                </span>
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">备注</td>
                        <td colspan="3">${user.remarks}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- end panel -->
    </div>

    <div class="col-md-12">
        <!-- begin panel -->
        <div class="panel panel-inverse" data-sortable-id="form-validation-2">
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
                <h4 class="panel-title">员工详细信息(员工自行填写)</h4>
            </div>

            <div class="panel-body panel-form">
                <form:form modelAttribute="user" action="info" class="form-horizontal form-bordered">
                    <form:hidden path="id" />

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4">手机号:</label>
                        <div class="col-md-2">
                            <form:input path="mobile" type="text" class="form-control" placeholder="手机号" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4">邮箱:</label>
                        <div class="col-md-2">
                            <form:input path="email" type="text" class="form-control" placeholder="邮箱" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4">上传头像:</label>
                        <div class="col-md-6 col-sm-6">
                            <form:hidden path="photo"/>
                            <sys:ckfinder input="photo" type="images" readonly="${empty photo ? 'false' : 'true'}" uploadPath="/user" selectMultiple="false" maxWidth="200" maxHeight="200"/>
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
        <!-- end panel -->
    </div>
</div>
<!-- end row -->
</body>
</html>