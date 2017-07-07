<%--
  Created by IntelliJ IDEA.
  User: Amos
  Date: 2017/6/27
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的课程|淘课-基于知识地图的多元化学习网站</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- CSS  -->
    <link rel="stylesheet" href="../css/style_course.css">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/font-awesome.css">
    <link rel="stylesheet" href="../css/animate.css">
    <link rel="stylesheet" href="../css/magnific-popup.css">
    <link rel="stylesheet" href="../css/ad_main.css">
    <script src="https://use.fontawesome.com/61a9ff3a07.js"></script>
    <%@include file="../config.jsp" %>
    <%@include file="../navbar_blue.jsp" %>

</head>
<body>
<div id="wrapper">
    <div id="sidebar-nav" class="sidebar" style="color: white">
            <h2>
                ${studentpage.name}
            </h2>
            <p>
                你一共选修了<font color="#6495ed" size="9px">${sessionScope.selectedcourses.count}</font>门课程
            </p>
        <a class="btn btn-default" href="../AddCourseServlet">添加课程</a>
    </div>
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div style="float: right">
                <a href="StuInfo.jsp"> 个人中心</a>
                <img src="../Student/img/PC.png" width="40" >
            </div>
            <div class="container-fluid">
                <h3 class="page-title">我的课程</h3>
                <div class="row">
                    <!-- TABLE -->
                    <div class="panel panel-info">
                        <ul class="breadcrumb">
                            <li>
                                <a href="AdminHeadPage.jsp">主页</a>
                            </li>
                            <li>
                                <a href="#">我的课程</a>
                            </li>
                            <li class="active">
                                正在学习
                            </li>
                        </ul>
                        <div id="show_course">
                            <div class="container-fluid proj-bottom">

                                <div class="row">
                                    <c:forEach var="i" begin="0" end="${sessionScope.selectedcourses.count}" step="1">
                                        <c:if test="${i!=sessionScope.selectedcourses.count}">
                                            <div class="col-md-4 col-sm-6 fh5co-project animate-box"
                                                 data-animate-effect="fadeIn">
                                                <a href="../ChooseCourse?courseid=${sessionScope.selectedcourses.coursePages[i].id}"><img
                                                        src="${sessionScope.selectedcourses.coursePages[i].picture}"
                                                        alt="#" class="img-responsive">
                                                    <p> 课程名称： ${sessionScope.selectedcourses.coursePages[i].name}</p>
                                                    <p>
                                                        课程介绍： ${sessionScope.selectedcourses.coursePages[i].introduction}</p>
                                                    <p> 进度:${sessionScope.selectedcourses.finishpersentage[i]}%</p>

                                                    <span>View Course</span>
                                                </a>
                                            </div>

                                        </c:if>

                                    </c:forEach>


                                </div>
                                <center><ul class="pagination" >
                                <li>
                                    <a href="#">Prev</a>
                                </li>
                                <li>
                                    <a href="#">1</a>
                                </li>
                                <li>
                                    <a href="#">2</a>
                                </li>
                                <li>
                                    <a href="#">3</a>
                                </li>
                                <li>
                                    <a href="#">4</a>
                                </li>
                                <li>
                                    <a href="#">5</a>
                                </li>
                                <li>
                                    <a href="#">Next</a>
                                </li>
                                </ul></center>
                            </div>

                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>
</div>


<!-- jQuery -->
<script src="../js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="../js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="../js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="../js/jquery.waypoints.min.js"></script>
<!-- Stellar Parallax -->
<script src="../js/jquery.stellar.min.js"></script>
<!-- countTo -->
<script src="../js/jquery.countTo.js"></script>
<!-- Magnific Popup -->
<script src="../js/jquery.magnific-popup.min.js"></script>
<script src="../js/magnific-popup-options.js"></script>
<!-- Main -->
<script src="../js/main_stu.js"></script>

</body>
</html>
