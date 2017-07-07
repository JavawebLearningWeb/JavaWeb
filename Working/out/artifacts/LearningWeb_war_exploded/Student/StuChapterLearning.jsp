<%--
  Created by IntelliJ IDEA.
  User: 16689
  Date: 2017/7/1
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <!--[if IE]>
    <meta http-equiv="x-ua-compatible" content="IE=9"/><![endif]-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MAPS|淘课-基于知识地图的多元化学习网站</title>

    <!-- CSS -->
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/font-awesome.css">
    <link rel="stylesheet" href="../css/animate.css">
    <link rel="stylesheet" href="../css/chartist-custom.css">
    <link rel="stylesheet" href="../css/ad_main.css">
    <script src="https://use.fontawesome.com/61a9ff3a07.js"></script>
    <%@include file="../config.jsp" %>
    <%@include file="../navbar_blue.jsp" %>

</head>
<body>
<div id="wrapper">
    <!-- LEFT SIDEBAR -->
    <div id="sidebar-nav" class="sidebar">
        <div class="sidebar-scroll">
            <nav>
                <ul class="nav">
                    <li><a href="stu_home.jsp" class=""><span>主页</span></a></li>
                    <li>
                        <a href="#menu1" data-toggle="collapse" class="collapsed"><span>基本信息</span><i
                                class="icon-submenu fa fa-angle-double-right"></i></a>
                        <div id="menu1" class="collapse">
                            <ul class="nav">
                                <li><a href="StuBaseInfo.jsp" class="">基本信息查询</a></li>
                                <li><a href="StuEditBaseInfo.jsp" class="">基本信息修改</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#menu2" data-toggle="collapse" class="collapsed"><span>安全信息</span><i
                                class="icon-submenu fa fa-angle-double-right"></i></a>
                        <div id="menu2" class="collapse ">
                            <ul class="nav">
                                <li><a href="StuEditSecurityInfo.jsp" class="">修改密码</a></li>
                                <li><a href="StuSecurityInfo.jsp" class="">找回密码</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">章节选择</h3>
                <div class="row">
                    <!-- TABLE -->
                    <div class="panel panel-info">
                        <ul class="breadcrumb">
                            <li>
                                <a href="stu_home.jsp">主页</a>
                            </li>
                            <li>
                                <a href="#">课程中心</a>
                            </li>
                            <li class="active">
                                章节选择
                            </li>
                        </ul>
                        <div class="panel-body">
                            <div class="row clearfix">
                                <div class="col-md-6 column">
                                    <h3>
                                        视频学习
                                    </h3>
                                    <div class="panel panel-success">
                                        <c:forEach var="i" begin="0" end="${sessionScope.learningdata.mp4count}"
                                                   step="1">
                                            <c:if test="${i!=sessionScope.learningdata.mp4count}">
                                                <div class="panel-heading">
                                                    <h3 class="panel-title">
                                                        <a href="../Play?address=${sessionScope.learningdata.learningmp4[i].address}&kind=视频">${sessionScope.learningdata.learningmp4[i].name}</a>
                                                    </h3>
                                                </div>


                                            </c:if>

                                        </c:forEach>


                                    </div>
                                </div>
                                <div class="col-md-6 column">
                                    <h3>
                                        PPT学习
                                    </h3>
                                    <div class="panel panel-danger">

                                        <h3 class="panel-title">
                                            <c:forEach var="i" begin="0" end="${sessionScope.learningdata.pptcount}"
                                                       step="1">
                                                <c:if test="${i!=sessionScope.learningdata.pptcount}">
                                                    <div class="panel-heading">
                                                        <h3 class="panel-title">
                                                            <a href="../Play?address=${sessionScope.learningdata.learningppt[i].address}&kind=ppt">${sessionScope.learningdata.learningppt[i].name}</a>
                                                        </h3>
                                                    </div>


                                                </c:if>

                                            </c:forEach>
                                        </h3>


                                    </div>
                                </div>
                            </div>


                        </div>
                        <center>
                            <h4 class="color-picker"> 课后测验</h4>
                            <h4><a class="btn btn-success" href="../StuTest"> 开始测试</a></h4>
                        </center>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
