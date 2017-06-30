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
    <!-- Animate.css -->
    <link rel="stylesheet" href="../css/animate.css">

    <!-- Bootstrap  -->
    <link rel="stylesheet" href="../css/bootstrap.css">

    <!-- Magnific Popup -->
    <link rel="stylesheet" href="../css/magnific-popup.css">

    <!-- Theme style  -->
    <link rel="stylesheet" href="../css/style_course.css">


    <title>我的课程</title>
    <%@include file="navbar.jsp" %>
    <%@include file="config.jsp"%>
</head>
<body>
<div class="row clearfix">

    <div class="col-md-1 column">
    </div>
    <div class="col-md-9 column">
        <div class="col-md-12 column">
            <ul class="breadcrumb">
            <li>
                <a href="#">我的课程</a>
            </li>
            <li>
                <a href="#">正在学习</a>
            </li>
            </ul>
        </div>
        <div id="show_course">
            <div class="container-fluid proj-bottom">

                <div class="row">
                    <c:forEach  var="i" begin="0" end="${sessionScope.selectedcourses.count}" step="1">
                        <c:if test="${i!=sessionScope.selectedcourses.count}">
                            <div class="col-md-4 col-sm-6 fh5co-project animate-box" data-animate-effect="fadeIn">
                                <a href="../ChooseCourse?courseid=${sessionScope.selectedcourses.coursePages[i].id}"><img src="${sessionScope.selectedcourses.coursePages[i].picture}" alt="#" class="img-responsive">
                                    <p> 课程名称： ${sessionScope.selectedcourses.coursePages[i].name}</p>
                                    <p> 课程介绍： ${sessionScope.selectedcourses.coursePages[i].introduction}</p>
                                    <p> 进度:${sessionScope.selectedcourses.finishpersentage[i]}%</p>

                                    <span>View Course</span>
                                </a>
                            </div>

                        </c:if>

                    </c:forEach>







            <center><ul class="pagination">
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
    <div class="col-md-2 column">
           <p> 你已经选修${sessionScope.selectedcourses.count}门课
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
</div>

</body>
</html>
