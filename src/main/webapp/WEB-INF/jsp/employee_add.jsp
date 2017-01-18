<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
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
    <title>增加员工</title>
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
        <div class="panel-heading">增加员工
            <a style="float: right;" href="<%=request.getContextPath()%>/employeeList"><span style="font-size: 10px">返回员工列表</span></a>
        </div>
        <div class="panel-body">
            <form:form action="${pageContext.request.contextPath }/addEmployee" cssClass="form" method="post" modelAttribute="employee">
                <c:if test="${employee.employeeId == null or employee.employeeId == 0}">
                    <input type="hidden" name="_method" value="PUT"/>
                </c:if>
                <c:if test="${not empty employee.employeeId and employee.employeeId != 0}">
                    <form:hidden path="employeeId"></form:hidden>
                </c:if>
                <div class="row">
                    <div class="col-md-1">
                        <div class="form-group">
                            <label for="employeeName">员工姓名</label>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <form:input path="employeeName" id="employeeName"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-1">
                        <div class="form-group">
                            <label for="employeeSexy">员工性别</label>
                        </div>
                    </div>
                    <div class="col-md-11">
                        <%
                            Map<String,String> map = new HashMap();
                            map.put("0","女");
                            map.put("1","男");
                            request.setAttribute("genderMap",map);
                        %>
                        <form:radiobuttons path="employeeSexy" items="${genderMap}" id="employeeSexy" cssStyle="width: 30px;"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-1">
                        <div class="form-group">
                            <label for="departmentId">部门名称</label>
                        </div>
                    </div>
                    <div class="col-md-11">
                        <form:select path="departmentId" items="${departmentList}" itemLabel="departmentName"
                                     itemValue="departmentId" id="departmentId"></form:select>
                    </div>
                    <script type="text/javascript">
                        $("#departmentId").css({
                            "width":$("#employeeName").css("width"),
                            "height":$("#employeeName").css("height")
                        });
                    </script>
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
