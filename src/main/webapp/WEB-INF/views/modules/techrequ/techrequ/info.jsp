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
    <title>需求基本信息</title>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <script>
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
			<!-- begin page-header -->
			<h1 class="page-header">${techrequ.name }<small></small></h1>
			<!-- end page-header -->
			
			<!-- begin row -->
			<div class="row" >
			    <!-- begin col-6 -->
			    <div class="col-md-6" style="height:80%;width:1250px;">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#default-tab-1" data-toggle="tab">技术针对性和导向性</a></li>
						<li class=""><a href="#default-tab-2" data-toggle="tab">技术合作方式及价格</a></li>
						<li class=""><a href="#default-tab-3" data-toggle="tab">负责人信息</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane fade active in" id="default-tab-1">
						<table class="table table-bordered">
		                    <tbody>
		                    <tr>
		                        <td align="right" style="width: 15%">技术需求标题</td>
		                        <td colspan="3"><span class="badge badge-info">${techrequ.name }</span></td>
		                    </tr>
		                    <tr>
		                        <td align="right">适用原料分类</td>		     
		                        <td colspan="3">${fns:getDefaultVal(techrequ.materialTypeNames,"暂未填写")}</td>
		                    </tr>
		                    <tr>
		                        <td align="right">适用原料名称</td>			 
		                        <td colspan="3">${fns:getDefaultVal(techrequ.materialNames,"暂未填写")}</td>
		                    </tr>
		                    <tr>
		                        <td align="right">适用产品分类</td>
		                        <td colspan="3">${fns:getDefaultVal(techrequ.prodTypeNames,"暂未填写")}</td>
		                    </tr>
		                    <tr>
		                        <td align="right">适用产品名称</td>		     
		                        <td colspan="3">${fns:getDefaultVal(techrequ.productNames,"暂未填写")}</td>
		                    </tr>
		                    <tr>
		                        <td align="right">针对的生产经营环节</td>
		                        <td colspan="3">${fns:getTcDictLabels(techrequ.requHj,'achv_hj',"暂未填写")}
		                        				<c:if test = '${techrequ.otherRequHj != ""}'>,${techrequ.otherRequHj}</c:if>
		                        				
		                        </td>
		                    </tr>
		                     <tr>
		                        <td align="right">针对的主要问题</td>
		                        <td colspan="3">${fns:getDefaultVal(techrequ.target,"暂未填写")}</span></td>
		                    </tr>
		                     <tr>
		                        <td align="right">主要问题具体表现</td>
		                        <td colspan="3">${fns:getDefaultVal(techrequ.intro,"暂未填写")}</span></td>
		                    </tr>
		                     <tr>
		                        <td align="right">希望在哪些方面有所创新</td>
		                        <td colspan="3">${fns:getDefaultVal(techrequ.achvInnovate,"暂未填写")}</span></td>
		                    </tr>
		                     <tr>
		                        <td align="right">其他要求</td>
		                        <td colspan="3">${fns:getDefaultVal(techrequ.otherRequ,"暂未填写")}</span></td>
		                    </tr>
		                    </tbody>
               			 </table>
						</div>
						<div class="tab-pane fade" id="default-tab-2">
							<table class="table table-bordered">
			                    <tbody>
			                    <tr>
			                        <td align="right" style="width: 15%">技术需求标题</td>
			                        <td colspan="3"><span class="badge badge-info">${techrequ.name }</span></td>
			                    </tr>
			                    <tr>
			                        <td align="right">是否愿意接受企业咨询服务</td>		    
			                        <td colspan="3">
			                        	<c:if test = "${techrequ.expertConsult}">
			                        		${fns:getTcDictLabels(techrequ.expertConsultIntro,'expert_ask_type',"暂未填写")}
				                        </c:if>
				                        <c:if test = "${!techrequ.expertConsult}">否</c:if>
									</td>
			                    </tr>
			                    <tr>
			                        <td align="right">是否愿意联合其他企业、科研单位共建技术攻关联盟</td>			
			                        <td colspan="3">
			                        	<c:if test = "${techrequ.uniteExpertCompany}">
			                        		愿意
				                        </c:if>
				                        <c:if test = "${!techrequ.uniteExpertCompany}">不愿意</c:if>
			                        </td>
			                    </tr>
			                    <tr>
			                        <td align="right">愿意采取哪种技术合作方式</td>			
			                        <td colspan="3">
			                        	${fns:getTcDictLabels(techrequ.hzfs,'zr_type',"")}
			                        	<c:if test= '${techrequ.otherHzfs != "" }'>,${techrequ.otherHzfs }</c:if>
			                        </td>
			                    </tr>
			                    <c:if test = '${techrequ.hzfs.contains("1")}'>
			                    <tr>
			                        <td align="right">企业拟投入资金(技术转让)</td>			
			                        <td colspan="3">
			                      	   		 <c:if test = '${techrequ.allmoneyMoney == null || techrequ.allmoneyMoney == 0}'>
			                      	   		 	面议
			                      	  		 </c:if>
			                      	  		 <c:if test = '${techrequ.allmoneyMoney != null && techrequ.allmoneyMoney != 0}'>
			                      	   		 	￥${techrequ.allmoneyMoney }万
			                      	  		 </c:if>
			                        </td>
			                    </tr>
			                    </c:if>
			                    <c:if test = '${techrequ.hzfs.contains("2")}'>
			                    <tr>
			                        <td align="right">排他许可价(技术许可)</td>			
			                        <td colspan="3">
			                      	   		 <c:if test = '${techrequ.alonePerMoney == null || techrequ.alonePerMoney == 0}'>
			                      	   		 	面议
			                      	  		 </c:if>
			                      	  		 <c:if test = '${techrequ.alonePerMoney != null && techrequ.alonePerMoney != 0}'>
			                      	   		 	￥${techrequ.alonePerMoney }万
			                      	  		 </c:if>
			                        </td>
			                    </tr>
			                    </c:if>
			                    <c:if test = '${techrequ.hzfs.contains("2")}'>
			                    <tr>
			                        <td align="right">非排他许可价(技术许可)</td>			
			                        <td colspan="3">
			                      	   		 <c:if test = '${techrequ.rejectPerMoney == null || techrequ.rejectPerMoney == 0}'>
			                      	   		 	面议
			                      	  		 </c:if>
			                      	  		 <c:if test = '${techrequ.rejectPerMoney != null && techrequ.rejectPerMoney != 0}'>
			                      	   		 	￥${techrequ.rejectPerMoney }万
			                      	  		 </c:if>
			                        </td>
			                    </tr>
			                    </c:if>
			                    <c:if test = '${techrequ.hzfs.contains("3")}'>
			                    <tr>
			                        <td align="right">企业拟投入资金(技术开发)</td>			
			                        <td colspan="3">
			                      	   		 <c:if test = '${techrequ.entrustOrgMoney == null || techrequ.entrustOrgMoney == 0}'>
			                      	   		 	面议
			                      	  		 </c:if>
			                      	  		 <c:if test = '${techrequ.entrustOrgMoney != null && techrequ.entrustOrgMoney != 0}'>
			                      	   		 	￥${techrequ.entrustOrgMoney }万
			                      	  		 </c:if>
			                        </td>
			                    </tr>
			                    </c:if>
			                    <c:if test = '${techrequ.hzfs.contains("3")}'>
			                    <tr>
			                        <td align="right">企业拟投入资金(技术开发)</td>			
			                        <td colspan="3">
			                      	   		 <c:if test = '${techrequ.entrustOrgMoney == null || techrequ.entrustOrgMoney == 0}'>
			                      	   		 	面议
			                      	  		 </c:if>
			                      	  		 <c:if test = '${techrequ.entrustOrgMoney != null && techrequ.entrustOrgMoney != 0}'>
			                      	   		 	￥${techrequ.entrustOrgMoney }万
			                      	  		 </c:if>
			                        </td>
			                    </tr>
			                    </c:if>
			                    <c:if test = '${techrequ.hzfs.contains("4")}'>
			                    <tr>
			                        <td align="right">企业拟投入资金(技术服务)</td>			
			                        <td colspan="3">
			                      	   		 <c:if test = '${techrequ.serveMoney == null || techrequ.serveMoney == 0}'>
			                      	   		 	面议
			                      	  		 </c:if>
			                      	  		 <c:if test = '${techrequ.serveMoney != null && techrequ.serveMoney != 0}'>
			                      	   		 	￥${techrequ.serveMoney }万
			                      	  		 </c:if>
			                        </td>
			                    </tr>
			                    </c:if>
			                    <c:if test = '${techrequ.hzfs.contains("5")}'>
			                    <tr>
			                        <td align="right">${techrequ.otherHzfs }(其他)</td>			
			                        <td colspan="3">
			                      	   		${techrequ.hzfsIntro }
			                        </td>
			                    </tr>
			                    </c:if>
			                    </tbody>
               				 </table>
						</div>
						<div class="tab-pane fade" id="default-tab-3">
							<table class="table table-bordered">
			                    <tbody>
			                    <tr>
			                        <td align="right" style="width: 15%">负责人姓名</td>
			                        <td colspan="3"><span class="badge badge-info">${techrequ.techMan }</span></td>
			                    </tr>
			                    <tr>
			                        <td align="right">负责人职务</td>		    
			                        <td colspan="3"> ${fns:getDefaultVal(techrequ.duty,"暂未填写")}</td>
			                    </tr>
			                    <tr>
			                        <td align="right">负责人手机</td>			
			                        <td colspan="3">${fns:getDefaultVal(techrequ.phone,"暂未填写")}</td>
			                    </tr>
			                    <tr>
			                        <td align="right">负责人座机</td>			
			                        <td colspan="3">${fns:getDefaultVal(techrequ.tel,"暂未填写")}</td>
			                    </tr>
			                    <tr>
			                        <td align="right">负责人邮箱</td>			
			                        <td colspan="3">${fns:getDefaultVal(techrequ.email,"暂未填写")}</td>
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