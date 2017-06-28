<%--
  Created by IntelliJ IDEA.
  User: ycbhci
  Date: 2017/6/27
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="config.jsp" %>
</head>
<body>
<form class="form-group">
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="row clearfix">
                    <div class="col-md-3 column">
                        <%@include file="leftside.jsp" %>
                    </div>
                    <div class="col-md-9 column">

                        <ul class="list-unstyled">

                            <li>
                                <label class="col-sm-offset-2 control-label"> 昵称</label>
                                <label class="col-sm-offset-2 control-label"> ${sessionScope.studentpage.name}</label>
                            </li>
                            <br>
                            <li>
                                <label class="col-sm-offset-2 control-label"> 生日</label>
                                <label class="col-sm-offset-2 control-label"> ${sessionScope.studentpage.birthday}</label>

                            </li>
                            <br>
                            <li>
                                <label class="col-sm-offset-2 control-label"> 性别</label>
                                <label class="col-sm-offset-2 control-label"> ${sessionScope.studentpage.gendar}</label>

                            </li>
                            <br>
                            <li>
                                <label class="col-sm-offset-2 control-label"> 学历</label>
                                <label class="col-sm-offset-2 control-label"> ${sessionScope.studentpage.status}</label>

                            </li>
                            <br>
                            <li>
                                <label class="col-sm-offset-2 control-label"> 年级</label>
                                <label class="col-sm-offset-2 control-label"> ${sessionScope.studentpage.grade}</label>

                            </li>
                            <br>
                            <li>
                                <label class="col-sm-offset-2 control-label"> 邮箱</label>
                                <label class="col-sm-offset-2 control-label"> ${sessionScope.studentpage.email}</label>

                            </li>
                            <br>
                            <li>
                                <label class="col-sm-offset-2 control-label"> 专业</label>
                                <label class="col-sm-offset-2 control-label"> ${sessionScope.studentpage.major}</label>

                            </li>
                        </ul>


                    </div>
                </div>
            </div>
        </div>
    </div>


</form>
</body>
</html>
