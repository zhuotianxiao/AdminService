<%--
  Created by IntelliJ IDEA.
  expert: WangJian
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
    <title>成果基本信息</title>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <script>
	    $(document).ready(function() {
	        $("#menu li").removeClass("active");
	        $("#110").addClass("active");
	        $("#113").addClass("active");
	        App.init();
	        init();
	    });
    </script>
</head>
<body>
<!-- begin row -->
			<!-- begin page-header -->
			<h1 class="page-header">${achvNew.name } <small></small></h1>
			<!-- end page-header -->
			
			<!-- begin row -->
			<div class="row" >
			    <!-- begin col-6 -->
			    <div class="col-md-6" style="height:80%;width:1250px;">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#default-tab-1" data-toggle="tab">技术成果的针对性,适用性与成熟度</a></li>
						<li class=""><a href="#default-tab-2" data-toggle="tab">技术成果的价值体现</a></li>
						<li class=""><a href="#default-tab-3" data-toggle="tab">技术成果的转让方式及价格</a></li>
						<li class=""><a href="#default-tab-4" data-toggle="tab">技术成果持有人信息</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane fade active in" id="default-tab-1">
						<table class="table table-bordered">
		                    <tbody>
		                    <tr>
		                        <td align="right"  style="width: 15%">成果（课题）名称</td>
		                        <td ><span class="badge badge-info">${achvNew.name }</span></td>
		                    	<td align="right"  style="width: 15%">成果（课题）研究状态</td>
		                        <td>
		                     	   ${fns:getTcDictLabel(achvNew.status,'achv_search_status','暂未填写') }
								</td>
		                    </tr>
		                    <tr>
		                    	<c:if test="${achvNew.zlStatus == 1}">
		                        <td align="right">是否申请专利</td>
		                        <td>
		                        	未申请专利
								</td>
								</c:if>
		                    	<c:if test="${achvNew.zlStatus == 2}">
			                        <td align="right">专利受理号</td>
			                        <td>
										${achvNew.acceptNo }
										<c:if test="${achvNew.acceptUrl == null || achvNew.acceptUrl.trim() == '' }">
											<span style="color:#f60;">暂未上传专利受理函件</span>
										</c:if>
										<c:if test="${achvNew.acceptUrl != null || achvNew.acceptUrl.trim() != '' }">
											<a href="${achvNew.acceptUrl}"
												target="_blank">查看专利受理函件</a>
										</c:if>
									</td>
								</c:if>
								<c:if test="${achvNew.zlStatus == 3}">
								<td align="right">专利授权号</td>
								<td>
									${achvNew.zlNo }
									<c:if test="${achvNew.zlUrl == null || achvNew.zlUrl.trim() == '' }">
										<span style="color:#f60;">暂未上传专利授权扫描件</span>
									</c:if > 
									<c:if test="${achvNew.zlUrl != null || achvNew.zlUrl.trim() != '' }">
										<a href="${achvNew.zlUrl) }"
											target="_blank">查看专利授权扫描件</a>
									</c:if>
								</td>
								</c:if>
								</td>
								<td align="right">技术成果（课题）成熟度</td>
		                        <td>${fns:getTcDictLabel(achvNew.techJd,'achv_jd','暂未填写') }</td>
		                    </tr>
		                    <tr>
		                        <td align="right">适用原料分类</td>		    
		                        <td colspan="3">${fns:getDefaultVal(achvNew.materiTypeNames,"暂未填写")}</td>
		                    </tr>
		                    <tr>
		                        <td align="right">适用原料名称</td>			
		                        <td colspan="3">${fns:getDefaultVal(achvNew.materiNames,"暂未填写")}</td>
		                    </tr>
		                    <tr>
		                        <td align="right">适用产品分类</td>
		                        <td colspan="3">${fns:getDefaultVal(achvNew.prodTypeNames,"暂未填写")}</td>
		                    </tr>
		                    <tr>
		                        <td align="right">适用产品名称</td>
		                        <td colspan="3">${fns:getDefaultVal(achvNew.prodNames,"暂未填写")}</td>
		                    </tr>
		                    <tr>
		                        <td align="right">成果应用行业</td>
		                        <td colspan="3">${fns:getDefaultVal(achvNew.tradeNames,"暂未填写")}</td>
		                    </tr>
		                    <tr>
		                        <td align="right">针对的生产经营环节</td>
		                        <td colspan="3">${fns:getTcDictLabels(achvNew.gyiHjie,'achv_hj',"暂未填写")}
		                        				<c:if test = '${achvNew.otherGyiHjie != ""}'> ,${achvNew.otherGyiHjie}</c:if>
		                        </td>
		                    </tr>
		                     <tr>
		                        <td align="right">解决的主要问题</td>			
		                        <td colspan="3">${fns:getDefaultVal(achvNew.majorProblemKey,"暂未填写")}</td>
		                    </tr>
		                     <tr>
		                        <td align="right">该问题的具体症状</td>
		                        <td colspan="3">${fns:getDefaultVal(achvNew.majorProblemIntro,"暂未填写")}</td>
		                    </tr>
		                    <tr>
		                        <td align="right">技术成果（课题）的创新性</td>
		                        <td colspan="3">${fns:getDefaultVal(achvNew.achvCxInfo,"暂未填写")}</td>
		                    </tr>
		                    <tr>
		                    	<td align="right">是否已应用到哪些企业</td>
		                        <td>
		                        <c:if test = "${achvNew.isApply}">
		                        	${achvNew.applyCompName }
		                        </c:if>
		                        <c:if test = "${!achvNew.isApply}">否</c:if>
		                        </td>
		                        <td align="right">是否经过机构评价（鉴定）</td>
		                        <td>
		                        <c:if test = "${achvNew.isJd}">
		                        	${achvNew.evaluateOrgName }
		                        </c:if>
		                        <c:if test = "${!achvNew.isJd}">否</c:if>
		                        </td>
		                    </tr>
		                    
		                    </tbody>
               			 </table>
						</div>
						<div class="tab-pane fade" id="default-tab-2">
							<table class="table table-bordered">
			                    <tbody>
			                    <tr>
			                        <td align="right"  style="width: 15%">成果（课题）名称</td>
			                        <td colspan="3"><span class="badge badge-info">${achvNew.name }</span></td>
			                    </tr>
			                    <tr>
			                        <td align="right">产业化所需硬件条件</td>		    
			                        <td colspan="3"> ${fns:getDefaultVal(achvNew.hardwareDesc,"暂未填写")}</td>
			                    </tr>
			                    <tr>
			                        <td align="right">技术工艺流程</td>			
			                        <td colspan="3">${fns:getDefaultVal(achvNew.otherGyiHjie,"暂未填写")}</td>
			                    </tr>
			                    <tr>
			                        <td align="right">经济社会价值</td>			
			                        <td colspan="3">${fns:getDefaultVal(achvNew.economyDesc,"暂未填写")}</td>
			                    </tr>
			                    <tr>
			                        <td align="right">项目投资效益分析</td>			
			                        <td colspan="3">${fns:getDefaultVal(achvNew.investGs,"暂未填写")}</td>
			                    </tr>
			                    </tbody>
               				 </table>
						</div>
						<div class="tab-pane fade" id="default-tab-3">
							<table class="table table-bordered">
			                    <tbody>
			                    <tr>
			                        <td align="right" style="width: 15%">成果（课题）名称</td>
			                        <td colspan="3"><span class="badge badge-info">${achvNew.name }</span></td>
			                    </tr>
			                    <tr>
			                        <td align="right">是否愿意接受企业咨询服务</td>		    
			                        <td colspan="3">
			                        	<c:if test = "${achvNew.isAcceptAsk}">
			                        		${fns:getTcDictLabels(achvNew.askType,'expert_ask_type',"暂未填写")}
				                        </c:if>
				                        <c:if test = "${!achvNew.isAcceptAsk}">否</c:if>
									</td>
			                    </tr>
			                    <tr>
			                        <td align="right">是否愿意联合其他企业、科研单位共建技术攻关联盟</td>			
			                        <td colspan="3">
			                        	<c:if test = "${achvNew.alliance}">
			                        		愿意
				                        </c:if>
				                        <c:if test = "${!achvNew.alliance}">不愿意</c:if>
			                        </td>
			                    </tr>
			                    <tr>
			                        <td align="right">愿意采取哪种技术合作方式</td>			
			                        <td colspan="3">
			                        	${fns:getTcDictLabels(achvNew.zrWay,'zr_type',"")}
			                        	<c:if test='${achvNew.otherHzType != ""}'>,${achvNew.otherHzType }</c:if>
			                        </td>
			                    </tr>
			                    <c:if test = '${achvNew.zrWay.contains("1")}'>
			                    <tr>
			                        <td align="right">转让价(技术转让)</td>			
			                        <td colspan="3">
			                      	   		 <c:if test = '${achvNew.zrPrice == null || achvNew.zrPrice == 0}'>
			                      	   		 	面议
			                      	  		 </c:if>
			                      	  		 <c:if test = '${achvNew.zrPrice != null && achvNew.zrPrice != 0}'>
			                      	   		 	￥${achvNew.zrPrice }万
			                      	  		 </c:if>
			                        </td>
			                    </tr>
			                    </c:if>
			                    <c:if test = '${achvNew.zrWay.contains("2")}'>
			                    <tr>
			                        <td align="right">排他许可价(技术许可)</td>			
			                        <td colspan="3">
			                      	   		 <c:if test = '${achvNew.ptxkPrice == null || achvNew.ptxkPrice == 0}'>
			                      	   		 	面议
			                      	  		 </c:if>
			                      	  		 <c:if test = '${achvNew.ptxkPrice != null && achvNew.ptxkPrice != 0}'>
			                      	   		 	￥${achvNew.ptxkPrice }万
			                      	  		 </c:if>
			                        </td>
			                    </tr>
			                    </c:if>
			                    <c:if test = '${achvNew.zrWay.contains("2")}'>
			                    <tr>
			                        <td align="right">非排他许可价(技术许可)</td>			
			                        <td colspan="3">
			                      	   		 <c:if test = '${achvNew.unPtxkPrice == null || achvNew.unPtxkPrice == 0}'>
			                      	   		 	面议
			                      	  		 </c:if>
			                      	  		 <c:if test = '${achvNew.unPtxkPrice != null && achvNew.unPtxkPrice != 0}'>
			                      	   		 	￥${achvNew.unPtxkPrice }万
			                      	  		 </c:if>
			                        </td>
			                    </tr>
			                    </c:if>
			                    <c:if test = '${achvNew.zrWay.contains("3")}'>
			                    <tr>
			                        <td align="right">委托开发价(技术开发)</td>			
			                        <td colspan="3">
			                      	   		 <c:if test = '${achvNew.delegatePrice == null || achvNew.delegatePrice == 0}'>
			                      	   		 	面议
			                      	  		 </c:if>
			                      	  		 <c:if test = '${achvNew.delegatePrice != null && achvNew.delegatePrice != 0}'>
			                      	   		 	￥${achvNew.delegatePrice }万
			                      	  		 </c:if>
			                        </td>
			                    </tr>
			                    </c:if>
			                    <c:if test = '${achvNew.zrWay.contains("3")}'>
			                    <tr>
			                        <td align="right">合作开发价(技术开发)</td>			
			                        <td colspan="3">
			                      	   		 <c:if test = '${achvNew.unionPrice == null || achvNew.unionPrice == 0}'>
			                      	   		 	面议
			                      	  		 </c:if>
			                      	  		 <c:if test = '${achvNew.unionPrice != null && achvNew.unionPrice != 0}'>
			                      	   		 	￥${achvNew.unionPrice }万
			                      	  		 </c:if>
			                        </td>
			                    </tr>
			                    </c:if>
			                    <c:if test = '${achvNew.zrWay.contains("4")}'>
			                    <tr>
			                        <td align="right">服务价格(技术服务)</td>			
			                        <td colspan="3">
			                      	   		 <c:if test = '${achvNew.servicePrice == null || achvNew.servicePrice == 0}'>
			                      	   		 	面议
			                      	  		 </c:if>
			                      	  		 <c:if test = '${achvNew.servicePrice != null && achvNew.servicePrice != 0}'>
			                      	   		 	￥${achvNew.servicePrice }万
			                      	  		 </c:if>
			                        </td>
			                    </tr>
			                    </c:if>
			                    <c:if test = '${achvNew.zrWay.contains("5")}'>
			                    <tr>
			                        <td align="right">${achvNew.otherHzType }(其他)</td>			
			                        <td colspan="3">
			                      	   		${achvNew.otherHzDesc }
			                        </td>
			                    </tr>
			                    </c:if>
			                    </tbody>
               				 </table>
						</div>
						<div class="tab-pane fade" id="default-tab-4">
							<table class="table table-bordered">
			                    <tbody>
			                    <tr>
			                        <td align="right" style="width: 15%">成果（课题）名称</td>
			                        <td colspan="3"><span class="badge badge-info">${achvNew.name }</span></td>
			                    </tr>
			                    <tr>
			                        <td align="right">成果（课题）持有单位</td>		    
			                        <td colspan="3"> ${fns:getDefaultVal(achvNew.dept,"暂未填写")}</td>
			                    </tr>
			                    <tr>
			                        <td align="right">成果（课题）发明人</td>			
			                        <td colspan="3">${fns:getDefaultVal(achvNew.achvInventor,"暂未填写")}</td>
			                    </tr>
			                    <tr>
			                        <td align="right">成果（课题）联系人</td>			
			                        <td colspan="3">${fns:getDefaultVal(achvNew.ownerName,"暂未填写")}</td>
			                    </tr>
			                    <tr>
			                        <td align="right">联系电话</td>			
			                        <td colspan="3">${fns:getDefaultVal(achvNew.phone,"暂未填写")}</td>
			                    </tr>
			                    <tr>
			                        <td align="right">联系邮箱</td>			
			                        <td colspan="3">${fns:getDefaultVal(achvNew.email,"暂未填写")}</td>
			                    </tr>
			                    </tbody>
               				 </table>
						</div>
					</div>
				</div>
			    <!-- end col-6 -->
			    
			</div>
			<!-- end row -->
<!-- end row -->
</body>
</html>