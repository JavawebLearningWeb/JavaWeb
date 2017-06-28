<%--
  Created by IntelliJ IDEA.
  User: ycbhci
  Date: 2017/6/28
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Security Info</title>
</head>
<body>
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
                            <div class="col-sm-offset-2">
                                <h2> 此项操作涉及到你的安全信息！谨慎操作</h2>
                            </div>
                        </li>
                        <li>
                            <div class=" col-sm-offset-3 form-group">
                                <label class="col-sm-2 control-label">用户名</label>
                                <div class="col-sm-4"><input type="text" class="form-control"
                                                             value="${sessionScope.studentpage.username}" readonly>
                                </div>

                            </div>


                        </li>
                        <br>
                        <br>
                        <li>
                            <div class=" col-sm-offset-3 form-group">
                                <label class="col-sm-2 control-label">密码</label>
                                <div class="col-sm-4"><input type="text" class="form-control"
                                                             value="${sessionScope.studentpage.password}" readonly>
                                </div>

                            </div>


                        </li>

                    </ul>


                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
