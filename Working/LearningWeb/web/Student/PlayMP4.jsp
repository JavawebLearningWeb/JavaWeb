<%--
  Created by IntelliJ IDEA.
  User: 16689
  Date: 2017/7/1
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
    <%@include file="config.jsp"%>
    <%@include file="navbar.jsp"%>
</head>
<body>
<div class="container">
    <div class="row clearfix">

        <div class="col-md-10 column">
            <div>  <video width="943" height="547" controls="controls">
                <source src="${sessionScope.address}" type="video/mp4" />
                <source src="${sessionScope.address}" type="video/ogg" />
                <source src="${sessionScope.address}" type="video/webm" />
                <object data="${sessionScope.address}" width="943" height="547">
                    <embed src="${sessionScope.address}" width="943" height="547" />
                </object>
            </video>
            </div></div>

        <div class="col-md-2 column">
            <a href="StuChapterLearning.jsp">返回学习界面</a>
        </div>
    </div>
</div>
</body>
</html>
