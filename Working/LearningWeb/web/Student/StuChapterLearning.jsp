<%--
  Created by IntelliJ IDEA.
  User: 16689
  Date: 2017/7/1
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>章节学习</title>
    <%@include file="config.jsp"%>
    <%@include file="navbar.jsp"%>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-5 column">
            <h3>
              视频学习
            </h3>
            <div class="panel panel-success">
                <c:forEach var="i" begin="0" end="${sessionScope.learningdata.mp4count}" step="1">
                    <c:if test="${i!=sessionScope.learningdata.mp4count}">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                <a  href="../Play?address=${sessionScope.learningdata.learningmp4[i].address}&kind=视频">${sessionScope.learningdata.learningmp4[i].name}</a>
                            </h3>
                        </div>


                    </c:if>

                </c:forEach>


            </div>
        </div>
        <div class="col-md-5 column">
            <h3>
                PPT学习
            </h3>
            <div class="panel panel-danger">

                    <h3 class="panel-title">
                        <c:forEach var="i" begin="0" end="${sessionScope.learningdata.pptcount}" step="1">
                            <c:if test="${i!=sessionScope.learningdata.pptcount}">
                                <div class="panel-heading">
                                    <h3 class="panel-title">
                                        <a  href="../Play?address=${sessionScope.learningdata.learningppt[i].address}&kind=ppt">${sessionScope.learningdata.learningppt[i].name}</a>
                                    </h3>
                                </div>


                            </c:if>

                        </c:forEach>
                    </h3>


            </div>
        </div>
        <div class="col-md-2 column">
            <h3 class=" color-picker"> 快来测试</h3>

              <h4><a href="../Test"> 进行章节测试</a></h4>

        </div>
    </div>
</div>
</body>
</html>
