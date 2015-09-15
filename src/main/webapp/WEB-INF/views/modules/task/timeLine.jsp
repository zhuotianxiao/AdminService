<%--
  Created by IntelliJ IDEA.
  User: WangJian
  Date: 2015/5/19
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="decorator" content="default"/>
    <title>任务时间轴</title>
    <script src="${ctxStatic}/js/apps.min.js"></script>
    <script>

        function changeTimeLineUser(userId){
            $.ajax({
                type: "POST",   //访问WebService使用Post方式请求
                url: "getTimeLineData", //调用WebService的地址和方法名称组合 ---- WsURL/方法名
                data: {
                    page:1,
                    userId:userId
                },//这里是要传递的参数，格式为 data: "{paraName:paraValue}",下面将会看到
                success: function(html) {     //回调函数，result，返回值
                    $("#timeline-content").html(html);
                }
            });
        }

        function changeTimeLineOrder(orderId){
            $.ajax({
                type: "POST",   //访问WebService使用Post方式请求
                url: "getTimeLineData", //调用WebService的地址和方法名称组合 ---- WsURL/方法名
                data: {
                    page:1,
                    orderId:orderId
                },//这里是要传递的参数，格式为 data: "{paraName:paraValue}",下面将会看到
                success: function(html) {     //回调函数，result，返回值
                    $("#timeline-content").html(html);
                }
            });
        }

        $(document).ready(function() {
            $("#menu li").removeClass("active");
            $("#200").addClass("active");
            $("#203").addClass("active");

            App.init();

            $.ajax({
                type: "POST",   //访问WebService使用Post方式请求
                url: "getTimeLineData", //调用WebService的地址和方法名称组合 ---- WsURL/方法名
                data: {
                    page:1
                },//这里是要传递的参数，格式为 data: "{paraName:paraValue}",下面将会看到
                success: function(html) {     //回调函数，result，返回值
                    $("#timeline-content").append(html);
                }
            });
        });
    </script>
</head>
<body>
<div class="row">
    <div class="col-md-12">
        <ul class="timeline" id="timeline-content">
        </ul>
    </div>
</div>
</body>
</html>

