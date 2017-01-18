<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2016/11/20
  Time: 5:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="width: 100%;height: 50px">
    <div><a href="dwr.jsp">DWR</a></div>
    <div style="float: right">
        用户：${userName}&nbsp;
        <a href="<%=request.getContextPath()%>/modifyPassword" style="font-size: 20px;margin-right: 10px">修改密码</a>
        <a href="<%=request.getContextPath()%>/logout" style="font-size: 20px;margin-right: 10px">注销</a>
    </div>
</div>
