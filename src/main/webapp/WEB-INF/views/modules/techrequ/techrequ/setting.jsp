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
<title>需求前台展示设置</title>
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
         $("#109").addClass("active");
         $("#115").addClass("active");
         App.init();
         init();
     });
</script>
</head>
<body>
	<!-- begin row -->
	<div class="row">
		<div class="col-md-12">

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
							<h4 class="panel-title">设置成果前台展示</h4>
						</div>
						<div class="panel-body panel-form">
							<form:form modelAttribute="techrequ"
								action="${ctx}/techrequ/techrequ/setting"
								class="form-horizontal form-bordered"
								data-parsley-validate="true">
								<form:hidden path="id" />
								<div class="form-group">
									<label class="control-label col-md-4 col-sm-4">是否推荐:</label>
									<div class="col-md-2 col-sm-6">

										<form:radiobutton path="recommend" value="1" label="推荐"
											class="radio-inline" />
										&nbsp;&nbsp;&nbsp;&nbsp;
										<form:radiobutton path="recommend" value="0" label="不推荐"
											class="radio-inline" />
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-4 col-sm-4">成果推荐值:</label>
									<div class="col-md-2">
										<form:input path="recommendNum" type="text"
											class="form-control" data-parsley-required="true"
											placeholder="成果推荐值" data-parsley-id="2694"
											data-parsley-type="number" />
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-4 col-sm-4">是否热门:</label>
									<div class="col-md-2 col-sm-6">

										<form:radiobutton path="hot" value="1" label="热门"
											class="radio-inline" />
										&nbsp;&nbsp;&nbsp;&nbsp;
										<form:radiobutton path="hot" value="0" label="不热门"
											class="radio-inline" />
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-4 col-sm-4">成果热门值:</label>
									<div class="col-md-2">
										<form:input path="hotNum" type="text" class="form-control"
											data-parsley-required="true" placeholder="成果热门值"
											data-parsley-id="2695" data-parsley-type="number" />
										</ul>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-4 col-sm-4">是否最新:</label>
									<div class="col-md-2 col-sm-6">

										<form:radiobutton path="latest" value="1" label="最新"
											class="radio-inline" />
										&nbsp;&nbsp;&nbsp;&nbsp;
										<form:radiobutton path="latest" value="0" label="不最新"
											class="radio-inline" />
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-4 col-sm-4">成果最新值:</label>
									<div class="col-md-2">
										<form:input path="latestNum" type="text" class="form-control"
											data-parsley-required="true" placeholder="成果最新值"
											data-parsley-id="2696" data-parsley-type="number" />
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
	<!-- end row -->
</body>
</html>