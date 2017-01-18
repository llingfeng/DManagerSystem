<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2016/11/19
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>密码修改</title>
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/resources/js/jquery-3.0.0.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
    <style type="text/css">
        a{
            text-decoration: none;
            cursor: pointer;
        }
        a:hover{
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="container jumbotron">
    <%@include file="common/logout.jsp"%>
    <div class="panel panel-success">
        <div class="panel-heading">密码修改
            <a style="float: right;" href="<%=request.getContextPath()%>/showDepartmentList"><span style="font-size: 10px">返回部门列表</span></a>
        </div>
        <div class="panel-body">
            <form:form action="${pageContext.request.contextPath }/modifyPassword" cssClass="form" method="post" modelAttribute="user">
                <div class="row">
                    <div class="col-md-1">
                        <div class="form-group">
                            <label for="userName">用户</label>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <form:hidden path="userName"/>
                        ${sessionScope.userName}
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-1">
                        <div class="form-group">
                            <label for="userPassword">密码</label>
                        </div>
                    </div>
                    <div class="col-md-11">
                        <form:input path="userPassword" id="userPassword"/>
                    </div>
                </div>
                <br>
                <button type="submit" class="btn btn-primary">提交</button>
            </form:form>
        </div>
        <div class="panel-footer"></div>
    </div>
</div>
</body>
</html>
