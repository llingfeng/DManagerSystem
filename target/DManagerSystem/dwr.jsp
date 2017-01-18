<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/1/11
  Time: 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DWR测试</title>
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/dwr/interface/demo.js"></script>
    <script type="text/javascript" src="resources/js/jquery-3.0.0.js"></script>
    <script type="text/javascript" src="resources/js/bootstrap.js"></script>
</head>
<body>
<div class="container jumbotron">
    <div class="panel panel-success">
        <div class="panel-heading">DWR测试<%=request.getContextPath()%></div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-2">
                    <input type="text" class="form-control" id="name">
                </div>
                <div class="col-md-2">
                    <button class="btn bg-primary" type="button" id="text">测试</button>
                </div>
                <div class="col-md-6">
                    <span id="area"></span>
                </div>
            </div>
        </div>
        <div class="panel-footer"></div>
    </div>
</div>
<script>
    $(function () {
        dwr.engine.setActiveReverseAjax(true);
        $("#text").on('click',function () {
            demo.test($("#name").val());
        });
    })

    function callback(msg) {
        $("#area").html(decodeURI(msg));
    }
</script>
</body>
</html>
