<%--
  Created by IntelliJ IDEA.
  User: ycbhci
  Date: 2017/6/27
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Info</title>

</head>
<body>
                <%@include file="leftside.jsp"%>
<div>

    <div class="col-sm-offset-5 "><h3>学生个人信息</h3></div>
    <form class="form-horizontal" action="#" method="post">
        <div class="form-group">
            <label class="col-sm-4 control-label">昵称</label>
            <div class="col-sm-4">
                <input type="text" name="username" value="${sessionScope.studentpage.name}" class="form-control">
            </div>

        </div>
        <div class="form-group">
            <label class="col-sm-4 control-label">密码</label>
            <div class="col-sm-4">
                <input type="text" name="password" value="${sessionScope.studentpage.name}" class="form-control">
            </div>

        </div>
        <div class="form-group">
            <label class="col-sm-4 control-label">生日</label>
            <div class="col-sm-4">
                <input type="text" name="birthday" value="${sessionScope.studentpage.birthday}" class="form-control">
            </div>

        </div>
        <div class="form-group">
            <label class="col-sm-4 control-label">性别</label>
            <div class="col-sm-4">
                <input type="text" name="username" value="${sessionScope.studentpage.gendar}" class="form-control">
            </div>

        </div>
        <div class="form-group">
            <label class="col-sm-4 control-label">学历</label>
            <div class="col-sm-4">
                <input type="text" name="status" value="${sessionScope.studentpage.status}" class="form-control">
            </div>

        </div>
        <div class="form-group">
            <label class="col-sm-4 control-label">年级</label>
            <div class="col-sm-4">
                <input type="text" name="grade" value="${sessionScope.studentpage.grade}" class="form-control">
            </div>

        </div>
        <div class="form-group">
            <label class="col-sm-4 control-label">邮箱</label>
            <div class="col-sm-4">
                <input type="text" name="email" value="${sessionScope.studentpage.email}" class="form-control">
            </div>

        </div>
        <div class="form-group">
            <label class="col-sm-4 control-label">专业</label>
            <div class="col-sm-4">
                <input type="text" name="major" value="${sessionScope.studentpage.major}" class="form-control">
            </div>

        </div>
        <div class="form-group">
            <div class="col-sm-offset-5">
                <input type="submit" value="修改"  class="btn col-sm-2 btn-danger">

            </div>
        </div>

    </form>
</div>

<div class="col-sm-offset-4" id="hint"></div>


</body>
</html>
