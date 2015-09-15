<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%@ attribute name="input" type="java.lang.String" required="true" description="输入框" %>
<%@ attribute name="type" type="java.lang.String" required="true" description="files、images、flash、thumb" %>
<%@ attribute name="uploadPath" type="java.lang.String" required="true" description="打开文件管理的上传路径" %>
<%@ attribute name="selectMultiple" type="java.lang.Boolean" required="false" description="是否允许多选" %>
<%@ attribute name="readonly" type="java.lang.Boolean" required="false" description="是否查看模式" %>
<%@ attribute name="maxWidth" type="java.lang.String" required="false" description="最大宽度" %>
<%@ attribute name="maxHeight" type="java.lang.String" required="false" description="最大高度" %>
<ul id="${input}Preview" class="attached-document clearfix">
    <li>
        <div class="document-name"><a href="#">front_end_mockup.jpg</a></div>
        <div class="document-file">
            <a href="#">
                <img src="${ctxStatic}/img/login-bg/bg-1.jpg" alt="" />
            </a>
        </div>
    </li>
</ul>
<c:if test="${!readonly}">
    <a href="javascript:" onclick="${input}FinderOpen();" class="btn btn-primary">${selectMultiple?'添加':'选择'}</a>
    <a href="javascript:" onclick="${input}DelAll();" class="btn btn-danger">清除</a>
</c:if>
<script type="text/javascript">
    // 打开一个窗体
    function windowOpen(url, name, width, height) {
        var top = parseInt((window.screen.height - height) / 2, 10), left = parseInt((window.screen.width - width) / 2, 10),
                options = "location=no,menubar=no,toolbar=no,dependent=yes,minimizable=no,modal=yes,alwaysRaised=yes," +
                        "resizable=yes,scrollbars=yes," + "width=" + width + ",height=" + height + ",top=" + top + ",left=" + left;
        window.open(url, name, options);
    }

    function ${input}FinderOpen() {//<c:if test="${type eq 'thumb'}"><c:set var="ctype" value="images"/></c:if><c:if test="${type ne 'thumb'}"><c:set var="ctype" value="${type}"/></c:if>
        var date = new Date(), year = date.getFullYear(), month = (date.getMonth() + 1) > 9 ? date.getMonth() + 1 : "0" + (date.getMonth() + 1);
        var url = "${ctxStatic}/ckfinder/ckfinder.html?type=${ctype}&start=${ctype}:${uploadPath}/" + year + "/" + month +
                "/&action=js&func=${input}SelectAction&thumbFunc=${input}ThumbSelectAction&cb=${input}Callback&dts=${type eq 'thumb'?'1':'0'}&sm=${selectMultiple?1:0}";
        windowOpen(url, "文件管理", 1000, 700);
        //top.$.jBox("iframe:"+url+"&pwMf=1", {title: "文件管理", width: 1000, height: 500, buttons:{'关闭': true}});
    }
    function ${input}SelectAction(fileUrl, data, allFiles) {
        var url = "", files = ckfinderAPI.getSelectedFiles();
        for (var i = 0; i < files.length; i++) {//<c:if test="${type eq 'thumb'}">
            url += files[i].getThumbnailUrl();//</c:if><c:if test="${type ne 'thumb'}">
            url += files[i].getUrl();//</c:if>
            if (i < files.length - 1) url += "|";
        }//<c:if test="${selectMultiple}">
        $("#"+"${input}").val($("#"+"${input}").val() + ($("#"+"${input}").val(url) == "" ? url : "|" + url));//</c:if><c:if test="${!selectMultiple}">
        $("#"+"${input}").val(url);//</c:if>
        ${input}Preview();
        //top.$.jBox.close();
    }
    function ${input}ThumbSelectAction(fileUrl, data, allFiles) {
        var url = "", files = ckfinderAPI.getSelectedFiles();
        for (var i = 0; i < files.length; i++) {
            url += files[i].getThumbnailUrl();
            if (i < files.length - 1) url += "|";
        }//<c:if test="${selectMultiple}">
        $("#"+"${input}").val($("#"+"${input}").val() + ($("#"+"${input}").val(url) == "" ? url : "|" + url));//</c:if><c:if test="${!selectMultiple}">
        $("#"+"${input}").val(url);//</c:if>
        ${input}Preview();
        //top.$.jBox.close();
    }
    function ${input}Callback(api) {
        ckfinderAPI = api;
    }
    function ${input}Del(obj) {
        var url = $(obj).prev().attr("url");
        $("#"+"${input}").val($("#"+"${input}").val().replace("|" + url, "", "").replace(url + "|", "", "").replace(url, "", ""));
        ${input}Preview();
    }
    function ${input}DelAll() {
        $("#"+"${input}").val("");
        ${input}Preview();
    }
    function ${input}Preview() {
        var li, urls = $("#"+"${input}").val().split("|");
        $("#"+"${input}Preview").children().remove();
        for (var i = 0; i < urls.length; i++) {
            if (urls[i] != "") {
                <c:if test="${type eq 'thumb' || type eq 'images'}">
                    li = "<li><img src=\"" + urls[i] + "\" url=\"" + urls[i] + "\" />";
                    li = "<li>";
                    li +="<div class=\"document-name\"><a href=\"" + urls[i] + "\" target=\"_blank\">" + decodeURIComponent(urls[i].substring(urls[i].lastIndexOf("/") + 1)) + "</a></div>";
                    li +="<div class=\"document-file\" style=\"height:${empty maxHeight ? 200 : maxHeight}px\">";
                    li +="<a href=\"" + urls[i] + "\" target=\"_blank\">";
                    li +="<img src=\"" + urls[i] + "\" style=\"max-width:${empty maxWidth ? 200 : maxWidth}px;max-height:${empty maxHeight ? 200 : maxHeight}px;_height:${empty maxHeight ? 200 : maxHeight}px;border:0;padding:3px;\"/>";
                    li +="</a>";
                    li +="</div>";
                    li +="</li>";
                </c:if>
                <c:if test="${type ne 'thumb' && type ne 'images'}">

                    li = "<li><img src=\"" + urls[i] + "\" url=\"" + urls[i] + "\" />";
                    li = "<li>";
                    li +="<div class=\"document-name\"><a href=\"" + urls[i] + "\" target=\"_blank\">" + decodeURIComponent(urls[i].substring(urls[i].lastIndexOf("/") + 1)) + "</a></div>";
                    li +="<div class=\"document-file\">";
                    li +="<a href=\"" + urls[i] + "\" target=\"_blank\">";
                    li +="<i class=\"fa fa-file-pdf-o\"></i>";
                    li +="</a>";
                    li +="</div>";
                    li +="</li>";
                </c:if>


                $("#"+"${input}Preview").append(li);
            }
        }
        if ($("#"+"${input}Preview").text() == "") {
            $("#"+"${input}Preview").html("<li style='list-style:none;padding-top:5px;'>无</li>");
        }
    }
    ${input}Preview();
</script>