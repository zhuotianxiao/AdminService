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
    <title>编辑修改</title>
    <!-- ================== BEGIN PAGE LEVEL STYLE ================== -->
    <link href="${ctxStatic}/plugins/parsley/src/parsley.css" rel="stylesheet" />
    <link href="${ctxStatic}/plugins/bootstrap-datepicker/css/datepicker3.css" rel="stylesheet" />
    <link href="${ctxStatic}/plugins/bootstrap-select/bootstrap-select.min.css" rel="stylesheet" />
    <!-- ================== END PAGE LEVEL STYLE ================== -->

    <!-- ================== BEGIN PAGE LEVEL JS ================== -->
    <script src="${ctxStatic}/plugins/parsley/dist/parsley.js"></script>
    <script src="${ctxStatic}/plugins/parsley/dist/zh_cn.js"></script>
    <script src="${ctxStatic}/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <script src="${ctxStatic}/plugins/bootstrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js" charset="UTF-8"></script>
    <script src="${ctxStatic}/plugins/bootstrap-select/bootstrap-select.min.js"></script>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <script>
        function init() {
            $(".selectpicker").selectpicker("render");
        }
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
<!-- begin row -->
<div class="row">
    <div class="col-md-12">
        <ul class="nav nav-tabs">
            <li class=""><a href="${ctx}/news/index">新闻列表</a></li>
            <shiro:hasPermission name="news:list:edit">
                <li class="active"><a href="${ctx}/news/form">新增/编辑</a></li>
            </shiro:hasPermission>
        </ul>

        <div class="tab-content">
            <div class="tab-pane fade active in" id="default-tab-1">
                <!-- begin panel -->
                <div class="panel panel-primary" data-sortable-id="form-validation-2">
                    <div class="panel-heading">
                        <div class="panel-heading-btn">
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i class="fa fa-expand"></i></a>
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-success" data-click="panel-reload"><i class="fa fa-repeat"></i></a>
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning" data-click="panel-collapse"><i class="fa fa-minus"></i></a>
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger" data-click="panel-remove"><i class="fa fa-times"></i></a>
                        </div>
                        <h4 class="panel-title">新增/编辑</h4>
                    </div>
                    <div class="panel-body panel-form">
                        <form:form modelAttribute="news" action="save" class="form-horizontal form-bordered" data-parsley-validate="true">
                            <form:hidden path="id" />
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">新闻标题:</label>
                                <div class="col-md-2 col-sm-6">
                                    <form:input path="title" type="text" class="form-control" data-parsley-required="true" placeholder="新闻标题" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">新闻分类:</label>
                                <div class="col-md-2">
                                    <form:select path="newsSort" data-style="btn-primary" data-live-search="true" cssClass="form-control selectpicker">
                                        <form:option value="0" label="行业快讯"/>
                                        <form:option value="1" label="政策法规"/>
                                        <form:option value="2" label="投融资"/>
                                        <form:option value="3" label="活动专题"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">展示图片:</label>
                                <div class="col-md-6 col-sm-6">
                                    <form:hidden path="imgUrl"/>
                                    <sys:ckfinder input="imgUrl" type="images" readonly="${empty photo ? 'false' : 'true'}" uploadPath="/user" selectMultiple="false" maxWidth="200" maxHeight="200"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">新闻来源:</label>
                                <div class="col-md-6 col-sm-6">
                                    <form:input path="source" type="text" class="form-control" data-parsley-required="true" placeholder="新闻来源" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">内容:</label>
                                <div class="col-md-6 col-sm-6">
                                    <form:input path="content" type="text" class="form-control" placeholder="内容" />
                                </div>
                            </div>

                            <shiro:hasPermission name="news:list:edit">
                                <div class="form-group">
                                    <label class="control-label col-md-4 col-sm-4"></label>
                                    <div class="col-md-6 col-sm-6">
                                        <button type="submit" class="btn btn-success">提交</button>
                                    </div>
                                </div>
                            </shiro:hasPermission>
                        </form:form>
                    </div>
                </div>
                <!-- end panel -->
            </div>
        </div>
    </div>
</div>
<!-- end row -->
</body>
</html>