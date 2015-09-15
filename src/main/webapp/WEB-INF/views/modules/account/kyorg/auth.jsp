<%--
  Created by IntelliJ IDEA.
  User: WangJian
  Date: 2015/5/19
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="decorator" content="default" />
<title>科研机构认证</title>
<!-- ================== BEGIN PAGE LEVEL STYLE ================== -->
<link href="${ctxStatic}/plugins/parsley/src/parsley.css"
	rel="stylesheet" />
<link
	href="${ctxStatic}/plugins/bootstrap-datepicker/css/datepicker3.css"
	rel="stylesheet" />
<link
	href="${ctxStatic}/plugins/bootstrap-select/bootstrap-select.min.css"
	rel="stylesheet" />
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
<!-- ================== END PAGE LEVEL JS ================== -->
<script>
	function init() {

		$("#workDate").datepicker({
			language : "zh-CN",
			todayHighlight : true,
			autoclose : true
		});

		$(".selectpicker").selectpicker("render");
	};

	$(document).ready(function() {
		$("#menu li").removeClass("active");
        $("#106").addClass("active");
        $("#118").addClass("active");
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
							<h4 class="panel-title">科研机构认证</h4>
						</div>
						<div class="panel-body panel-form">
							<form:form modelAttribute="kyOrg" action="${ctx}/account/kyorg/auth"
								class="form-horizontal form-bordered"
								data-parsley-validate="true">
								<form:hidden path="id" />
								<div class="form-group">
									<label class="control-label col-md-4 col-sm-4">用户名:</label>
									<div class="col-md-2 col-sm-6">
										${kyOrg.account.username}</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-4 col-sm-4">机构联系人姓名:</label>
									<div class="col-md-2">
										<form:input path="linkman" type="text" class="form-control"
											data-parsley-required="true" data-parsley-minlength="2"
											placeholder="机构联系人姓名" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-4 col-sm-4">联系人手机号码:</label>
									<div class="col-md-2 col-sm-6">
										<form:input path="linkmanPhone" type="text" class="form-control"
											id="data-phone" data-parsley-id="2694"
											data-parsley-type="number" data-parsley-required="true"
											placeholder="联系人手机号码" />
										<ul class="parsley-errors-list" id="parsley-id-2694">
											<li class="parsley-type">手机号码无效</li>
										</ul>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">认证状态</label>
									<div class="col-md-6">
										<form:radiobutton path="account.isAuth" value="1" label="已认证"  class="radio-inline" />
										&nbsp;&nbsp;&nbsp;&nbsp;
										<form:radiobutton path="account.isAuth" value="0" label="未认证"   class="radio-inline"/>
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
		</div>
	</div>
	<!-- end row -->
</body>
</html>