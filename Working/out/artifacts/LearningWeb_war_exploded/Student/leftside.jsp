<%--
  Created by IntelliJ IDEA.
  User: ycbhci
  Date: 2017/6/27
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%@include file="config.jsp"%>

</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-3 column">
                    <ul class="nav nav-tabs nav-stacked">
                        <li >
                            <a href="StuBaseInfo.jsp">学生基本信息查询</a>
                        </li>
                        <li >
                            <a href="StuEditBaseInfo.jsp">学生基本信息管理</a>
                        </li>
                        <li >
                            <a href="StuSecurityInfo.jsp">学生安全信息查询</a>
                        </li>

                        <li >
                            <a href="StuEditSecurityInfo.jsp">学生安全信息管理</a>
                        </li>
                        <li >
                            <a href="stu_home.jsp">返回主页面</a>
                        </li>

                    </ul>
                </div>

            </div>
        </div>
    </div>
</div>


</body>
</html>
