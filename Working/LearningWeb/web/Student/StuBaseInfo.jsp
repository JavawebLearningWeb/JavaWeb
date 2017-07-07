<%--
  Created by IntelliJ IDEA.
  User: ycbhci
  Date: 2017/6/27
  Time: 16:28
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
                <h3 class="page-title">个人信息</h3>
                <div class="row">
                    <!-- TABLE -->
                    <div class="panel panel-info">
                        <ul class="breadcrumb">
                            <li>
                                <a href="stu_home.jsp">主页</a>
                            </li>
                            <li>
                                <a href="#">个人中心</a>
                            </li>
                            <li class="active">
                                个人信息
                            </li>
                        </ul>

                        <div class="panel-body">
                            <table class="table table-hover table-striped">
                                <ul class="list-unstyled">
                                    <li>
                                        <div class="col-sm-offset-2"><img src="${sessionScope.studentpage.picture}"
                                                                          class="img-circle im" alt="照片丢失"></div>
                                    </li>

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
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
