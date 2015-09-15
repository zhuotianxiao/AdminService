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
    <title>金融机构认证审核</title>
    <!-- ================== BEGIN PAGE LEVEL STYLE ================== -->
    <link href="${ctxStatic}/plugins/parsley/src/parsley.css"
          rel="stylesheet"/>
    <link
            href="${ctxStatic}/plugins/bootstrap-datepicker/css/datepicker3.css"
            rel="stylesheet"/>
    <link
            href="${ctxStatic}/plugins/bootstrap-select/bootstrap-select.min.css"
            rel="stylesheet"/>
    <!-- ================== END PAGE LEVEL STYLE ================== -->

    <!-- ================== BEGIN PAGE LEVEL JS ================== -->
    <script src="${ctxStatic}/plugins/parsley/dist/parsley.js"></script>
    <script src="${ctxStatic}/plugins/parsley/dist/zh_cn.js"></script>
    <script
            src="${ctxStatic}/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <script
            src="${ctxStatic}/plugins/bootstrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js"
            charset="UTF-8"></script>
    <script
            src="${ctxStatic}/plugins/bootstrap-select/bootstrap-select.min.js"></script>
    <script src="${ctxStatic}/js/apps.min.js"></script>

    <!-- ================== BEGIN PAGE LEVEL CSS STYLE ================== -->
    <link href="${ctxStatic}/plugins/jquery-file-upload/blueimp-gallery/blueimp-gallery.min.css" rel="stylesheet"/>
    <link href="${ctxStatic}/plugins/jquery-file-upload/css/jquery.fileupload.css" rel="stylesheet"/>
    <link href="${ctxStatic}/plugins/jquery-file-upload/css/jquery.fileupload-ui.css" rel="stylesheet"/>
    <!-- ================== END PAGE LEVEL CSS STYLE ================== -->

    <!-- ================== BEGIN PAGE LEVEL JS ================== -->
    <script src="${ctxStatic}/js/ajaxfileupload.js"></script>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <script>
        function init() {

            $("#workDate").datepicker({
                language: "zh-CN",
                todayHighlight: true,
                autoclose: true
            });

            $(".selectpicker").selectpicker("render");
        }
        ;

        $(document).ready(function () {
            $("#menu li").removeClass("active");
            $("#120").addClass("active");
            $("#122").addClass("active");
            App.init();
            init();
        });


        function submitForm(status) {
            $("#status").val(status);
            $.ajax({
                type: "POST",
                url: "${ctx}/auth/finance/auth",
                data: $("#publishForm").serialize(),
                dataType: 'json',
                success: function (data) {
                    if (data.result == 1) {
                        alert("处理成功!");

                        document.location.href = "${ctx}/auth/finance/index";
                        return;
                    } else {
                        alert("处理失败");
                    }
                },
                error: function (msg) {
                    alert("处理失败");
                }
            });
        }

    </script>
</head>
<body>
<!-- begin row -->
<div class="row">
    <div class="col-md-12">

        <div class="tab-content">
            <div class="tab-pane fade active in" id="default-tab-1">
                <!-- begin panel -->
                <div class="panel panel-inverse"
                     data-sortable-id="form-validation-2">
                    <div class="panel-heading">
                        <div class="panel-heading-btn">
                            <a href="javascript:;"
                               class="btn btn-xs btn-icon btn-circle btn-default"
                               data-click="panel-expand"><i class="fa fa-expand"></i></a> <a
                                href="javascript:;"
                                class="btn btn-xs btn-icon btn-circle btn-success"
                                data-click="panel-reload"><i class="fa fa-repeat"></i></a> <a
                                href="javascript:;"
                                class="btn btn-xs btn-icon btn-circle btn-warning"
                                data-click="panel-collapse"><i class="fa fa-minus"></i></a> <a
                                href="javascript:;"
                                class="btn btn-xs btn-icon btn-circle btn-danger"
                                data-click="panel-remove"><i class="fa fa-times"></i></a>
                        </div>
                        <h4 class="panel-title">金融机构认证审核</h4>
                    </div>
                    <div class="panel-body panel-form">
                        <form action="${ctx}/account/finance/auth" method="post"
                              class="form-horizontal form-bordered" id="publishForm"
                              data-parsley-validate="true">
                            <input type="hidden" name="id" value="${finance.id}"/>

                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">用户名:</label>

                                <div class="col-md-2 col-sm-6">
                                    ${finance.account.username}
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">机构名称:</label>

                                <div class="col-md-2">${finance.name}
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">联系人:</label>

                                <div class="col-md-2">${finance.linkMan}</div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">联系人手机号码:</label>

                                <div class="col-md-2 col-sm-6">${finance.phone}
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">机构代码:</label>

                                <div class="col-md-2">${finance.orgCode}
                                </div>
                            </div>
                            <div class=" form-group">
                                <label class="control-label col-md-4 col-sm-4">营业执照:</label>

                                <div class="col-md-2">
                                    <div class="row fileupload-buttonbar">
                                        <div class="col-md-7">

                                            <img src="${finance.businessLicence}" id="img" width="100px"/>
                                        </div>
                                    </div>
                                </div>
                                <!-- The table listing the files available for upload/download -->

                            </div>


                            <div class="form-group">
                                <label class="col-md-4 control-label">审核结果说明</label>

                                <div class="col-md-6">
                                    <textarea rows="5" placeholder="审核结果说明" class="form-control">${finance.choose}</textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4"></label>
                                <input type="hidden" id="status" name="financeAuth"/>
                                <div class="col-md-6 col-sm-6">
                                    <button type="button" class="btn btn-success" onclick="submitForm(3)">审核成功</button>
                                    <button type="button" class="btn btn-success" onclick="submitForm(2)">审核失败</button>
                                </div>
                            </div>
                        </form>
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