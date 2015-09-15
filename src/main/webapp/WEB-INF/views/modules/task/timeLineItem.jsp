<%--
  Created by IntelliJ IDEA.
  User: WangJian
  Date: 2015/5/19
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<c:forEach items="${taskDetails}" var="taskDetail">
  <li>
    <div class="timeline-time">
      <span class="date">${fns:formatDateDefault(taskDetail.workDate)}</span>
      <span class="time">${taskDetail.workTime}h</span>
    </div>
    <div class="timeline-icon">
      <a href="javascript:;"><i class="fa fa-paper-plane"></i></a>
    </div>
    <div class="timeline-body">
      <div class="timeline-header">
        <span class="userimage"><img src="${taskDetail.user.photo}" alt="" /></span>
        <span class="username"><a href="javascript:changeTimeLineUser('${taskDetail.userId}')">${taskDetail.user.name}</a> <small></small></span>
        <span class="pull-right text-muted">${taskDetail.user.office.name}</span>
      </div>
      <div class="timeline-content">
        <p>
            ${taskDetail.description}
        </p>
      </div>
      <div class="timeline-footer">
        <a href="javascript:changeTimeLineOrder('${taskDetail.orderId}')" class="m-r-15"><i class="fa fa-tasks fa-fw"></i>${taskDetail.insideTask.title}</a>
      </div>
    </div>
  </li>
</c:forEach>
