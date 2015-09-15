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
			<h1 class="page-header">成果详细 <small>${achvNew.name }</small></h1>
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
		                        <td align="right">成果（课题）名称</td>
		                        <td ><span class="badge badge-info">${achvNew.name }</span></td>
		                    	<td align="right">成果（课题）研究状态</td>
		                        <td>
		                     	   ${fns:getDictValue(achvNew.status,'achv_search_status','暂未填写') }
								</td>
		                    </tr>
		                    <tr>
		                    	<s:if test="vo.zlStatus == 2">
		                        <td align="right">专利受理号</td>
		                        <td>
									${achvNew.acceptNo }
									<s:if test="achvNew.acceptUrl == null || achvNew.acceptUrl.trim() == ''">
										<span style="color:#f60;">暂未上传专利受理函件</span>
									</s:if>
									<s:else>
										<a href="<s:property value='@cn.findview.util.StringTools@getFrontAchvZlThumbFile(achvNew.acceptUrl)'/>"
											target="_blank">查看专利受理函件</a>
									</s:else>
									
								</td>
								</s:if>
								<s:if test="achvNew.zlStatus == 3">
								<td align="right">专利授权号</td>
								<td>
									${achvNew.zlNo }
									<s:if test="achvNew.zlUrl == null || achvNew.zlUrl.trim() == ''">
										<span style="color:#f60;">暂未上传专利授权扫描件</span>
									</s:if> 
									<s:else>
										<a href="<s:property value='@cn.findview.util.StringTools@getFrontAchvZlThumbFile(achvNew.zlUrl)'/>"
											target="_blank">查看专利授权扫描件</a>
									</s:else>
								</td>
								</s:if>
								</td>
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
		                        <td colspan="3">${fns:getDictMultiValueWithOther(achvNew.gyiHjie, 'achv_hj','暂未填写', vo.otherGyiHjie) }</td>
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
		                        <td colspan="3">${achvNew.applyCompName }</td>
		                    </tr>
		                    <tr>
		                    	<td align="right">技术成果（课题）成熟度</td>
		                        <td>${fns:getDictMultiValue(achvNew.techJd, 'achv_jd','暂未填写') }</td>
		                        <td align="right">是否经过机构评价（鉴定）</td>
		                        <td>${achvNew.evaluateOrgName }</td>
		                    </tr>
		                    
		                    </tbody>
               			 </table>
						</div>
						<div class="tab-pane fade" id="default-tab-2">
							<table class="table table-bordered">
			                    <tbody>
			                    <tr>
			                        <td align="right">成果（课题）名称</td>
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
			                        <td align="right">成果（课题）名称</td>
			                        <td colspan="3"><span class="badge badge-info">${achvNew.name }</span></td>
			                    </tr>
			                    <tr>
			                        <td align="right">是否愿意接受企业咨询服务</td>		    
			                        <td colspan="3">
	                        			<s:if test="achvNew.isAcceptAsk">
											${fns:getDictMultiValue(achvNew.askType, 'expert_ask_type','暂未填写') }
										</s:if>
										<s:else>
											暂未提供对企业的技术指导服务
										</s:else>
									</td>
			                    </tr>
			                    <tr>
			                        <td align="right">是否愿意联合其他企业、科研单位共建技术攻关联盟</td>			
			                        <td colspan="3">
			                        	<s:if test="achvNew.alliance">
											是
										</s:if>
										<s:else>
											否
										</s:else>
			                        </td>
			                    </tr>
			                    <tr>
			                        <td align="right">愿意采取哪种技术合作方式</td>			
			                        <td colspan="3">
			                        	<s:if test="achvNew.hzType == null || achvNew.hzType.trim() == ''">暂未填写</s:if> <s:else>
											<s:iterator value="achvNew.hzTypes" var="hztype" status="st">
														${fns:getDictValue(hztype,"zr_type","暂未填写")}
													</span>&nbsp;&nbsp;
											</s:iterator>
										</s:else>	
			                        </td>
			                    </tr>
			                    </tbody>
               				 </table>
						</div>
						<div class="tab-pane fade" id="default-tab-4">
							<table class="table table-bordered">
			                    <tbody>
			                    <tr>
			                        <td align="right">成果（课题）名称</td>
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