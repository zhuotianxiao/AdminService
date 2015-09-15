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
    <title>企业认证</title>
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
    <script type="text/javascript">

        function submitTempFile() {

            //文件上传地址
            var url = '${ctx}/util/img/upload-temp';
            //alert(url);
            $.ajaxFileUpload
            (
                    {
                        'url': url, //用于文件上传的服务器端请求地址
                        'secureuri': false, //是否需要安全协议，一般设置为false
                        'fileElementId': 'file1', //文件上传域的ID
                        'dataType': 'json', //返回值类型 一般设置为json
                        'success': function (data, status)  //服务器成功响应处理函数
                        {
                            console.log(data.result);
                            $("#img1").attr("src", data.imgurl);
                            if (data.result == '1') {

                                $("#img").attr("src", data.imgPath).show();
                                $("#imgPath").val(data.imgPath);
                            } else {

                                alert('上传失败');
                            }
                        },
                        error: function (data, status, e)//服务器响应失败处理函数
                        {
                            console.log(data);
                            console.log(e);
                            alert(e);
                        }
                    }
            )
            return false;
        }
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
            $("#106").addClass("active");
            $("#117").addClass("active");
            App.init();
            init();
        });
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
                    <h4 class="panel-title">企业认证</h4>
                </div>
                <div class="panel-body panel-form">
                    <form  action="${ctx}/account/company/auth" method="post"
                           class="form-horizontal form-bordered"
                           data-parsley-validate="true">
                        <input type="hidden" name="accountId" value="${company.accountId}"/>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">用户名:</label>

                                <div class="col-md-2 col-sm-6">
                                        ${company.account.username}
                                </div>
                            </div>
                            <div class=" form-group">
                                <label class="control-label col-md-4 col-sm-4">营业执照:</label>
                                <div class="col-md-2">
                                    <div class="row fileupload-buttonbar">
                                        <div class="col-md-7">
                                            <span class="btn btn-success fileinput-button">
                                                <i class="fa fa-plus"></i>
                                                <span>Add files...</span>
                                                <input type="file" id="file1" name="file" onchange="submitTempFile();">
                                            </span>
                                            <input type="hidden" id="imgPath" name="businessLicence" value="${company.businessLicence}" data-parsley-required="true"/>
                                            <img src="${company.businessLicence}" id="img"

                                                 <c:if test="${empty company.businessLicence}">

                                                     style="display:none;"
                                                 </c:if>
                                                 width="100px"/>
                                        </div>
                                    </div>
                                </div>
                                <!-- The table listing the files available for upload/download -->

                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">机构代码:</label>

                                <div class="col-md-2">
                                    <input type="text" name="orgCode" value="${company.orgCode}" class="form-control"
                                                data-parsley-required="true" data-parsley-minlength="2"
                                                placeholder="机构代码"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">企业名称:</label>

                                <div class="col-md-2">
                                    <input name="name" type="text" value="${company.name}" class="form-control"
                                                data-parsley-required="true" data-parsley-minlength="2"
                                                placeholder="企业名称"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">联系人:</label>

                                <div class="col-md-2">
                                    <input name="linkman" value="${company.linkman}" type="text" class="form-control"
                                                data-parsley-required="true" data-parsley-minlength="2"
                                                placeholder="联系人"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4">联系人手机号码:</label>

                                <div class="col-md-2 col-sm-6">
                                    <input name="phone" type="text" value="${company.phone}"  class="form-control"
                                                id="data-phone" data-parsley-id="2694"
                                                data-parsley-type="number" data-parsley-required="true"
                                                placeholder="联系人手机号码"/>
                                    <ul class="parsley-errors-list" id="parsley-id-2694">
                                        <li class="parsley-type">手机号码无效</li>
                                    </ul>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-4 control-label">认证状态</label>

                                <div class="col-md-6">
                                    <label class="radio-inline">
                                        <input type="radio" name="account.isAuth" value="1"  <c:if test="${company.account.isAuth}">checked</c:if> class="radio-inline"/>
                                        已认证
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="account.isAuth" value="0" <c:if test="${!company.account.isAuth}">checked</c:if> class="radio-inline"/>
                                       未认证
                                    </label>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-4 col-sm-4"></label>

                                <div class="col-md-6 col-sm-6">
                                    <button type="submit" class="btn btn-success">提交</button>
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