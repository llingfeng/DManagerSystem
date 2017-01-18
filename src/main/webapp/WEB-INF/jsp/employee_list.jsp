<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2016/11/18
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>员工列表</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
</head>
<body>
<div class="container jumbotron">
    <%@include file="common/logout.jsp"%>
    <div class="panel panel-success">
        <div class="panel-heading">员工列表</div>
        <div class="panel-body">
            <form id="employeeForm" class="form-inline" role="form" action="<%=request.getContextPath()%>/employeeList" method="post">
                <input type="hidden" id="employeeId" name="employeeId">
                <input type="hidden" id="basePath" value="<%=request.getContextPath()%>">
                <div class="row">
                    <div class="col-md-3">
                        <div class="form-group">
                            <button class="btn btn-primary" type="button" onclick="jumpToAdd()">增加</button>
                            <button id="deleteButton" class="btn btn-danger" type="button" onclick="batchDelete()" disabled>删除</button>
                            &nbsp;&nbsp;
                            <a class="btn btn-success" href="${pageContext.request.contextPath}/showDepartmentList">跳转到部门列表</a>
                        </div>
                    </div>
                    <div class="col-md-9" style="text-align: right;">
                        <div class="form-group">
                            <label for="employeeName">员工姓名</label>
                            <input class="form-control" name="employeeName" id="employeeName" placeholder="请输入员工姓名"
                                   value="${employeeName}">
                        </div>
                        <button class="btn btn-primary" type="submit">查询</button>
                    </div>
                </div>
                <table class="table table-striped" style="margin-top: 10px">
                    <thead>
                    <tr>
                        <th>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="selectAll" id="selectAll">
                                </label>
                            </div>
                        </th>
                        <th>序号</th>
                        <th>员工ID</th>
                        <th>员工姓名</th>
                        <th>员工性别</th>
                        <th>部门</th>
                        <th>创建时间</th>
                        <th>更新时间</th>
                        <th>编辑</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${employeeList}" var="employee" varStatus="statu">
                        <tr>
                            <td>
                                <div class="checkbox">
                                    <label>
                                        <input name="employeeId" type="checkbox" class="check_children"
                                               value="${employee.employeeId}">
                                    </label>
                                </div>
                            </td>
                            <td>${statu.index+1}</td>
                            <td>${employee.employeeId}</td>
                            <td>${employee.employeeName}</td>
                            <td>${employee.employeeSexy == 0 ? "女":"男"}</td>
                            <td>${employee.department.departmentName}</td>
                            <td><fmt:formatDate value="${employee.createTime}" pattern="yyyy-MM-dd"/></td>
                            <td><fmt:formatDate value="${employee.updateTime}" pattern="yyyy-MM-dd"/></td>
                            <td>
                                <button type="button" class="btn btn-primary"
                                        onclick="modify(${employee.employeeId})">修改
                                </button>
                                <button type="button" class="btn btn-danger"
                                        onclick="deleteOne(${employee.employeeId})">删除
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
        <div class="panel-footer"></div>
    </div>
    <div class="modal fade" id="mymodal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">提示</h4>
                </div>
                <div class="modal-body">
                    <p>确定删除该员工吗？</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" onclick="sureToDeleteOne()">确定</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div>
</div>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.0.0.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
<script type="text/javascript">
    $(function () {
        //全选
        $("#selectAll").change(function () {
            $(".check_children").prop("checked",this.checked);
            if(this.checked){
                $("#deleteButton").removeAttr("disabled");
            }else {
                $("#deleteButton").attr("disabled","disabled");
            }
        });

        //取消全选
        $(".check_children").change(function () {
            var flag = true;
            $(".check_children").each(function (index,element) {
                if(!$(this).prop("checked")){
                    $("#selectAll").prop("checked",false);
                    flag = false;
                    return false;
                }
            });
            if(flag){
                $("#selectAll").prop("checked",true);
            }
        }).change(function () {
            $(".check_children").each(function (index,element) {
                if($(this).prop("checked")){
                    $("#deleteButton").removeAttr("disabled");
                    return false;
                }else {
                    $("#deleteButton").attr("disabled","disabled");
                }
            });
        });
    });

    //提示用户是否要删除
    function deleteOne(employeeId){
        $("#employeeId").val(employeeId);
        $("#mymodal").modal("toggle");
        return false;
    }

    //确认删除单条记录
    function sureToDeleteOne() {
        var employee = {"employeeId":$("#employeeId").val(),"employeeName":$("#employeeName").val()};
        $.ajax({
            type:"delete",
            url:"deleteEmployee",
            data:JSON.stringify(employee),
            dataType:"json",
            contentType:"application/json",
            success:function (data) {
                if(data.num == 1){
                    $("#mymodal").modal("hide");
                    $("#employeeName").val(data.employeeName);
                    $("#employeeForm").submit();
                }
            }
        });
    }

    //批量删除
    function batchDelete() {
        $("#employeeForm").append('<input type="hidden" name="_method" value="delete">');
        $("#employeeForm").attr("action",$("#basePath").val()+"/batchDeleteEmployee").submit();
    }

    //跳转到新增页面
    function jumpToAdd() {
        window.location.href = "addEmployee";
    }

    //修改
    function modify(employeeId) {
        window.location.href = "updateEmployee?employeeId="+employeeId;
    }

</script>
</html>
