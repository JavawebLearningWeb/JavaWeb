<%--
  Created by IntelliJ IDEA.
  User: zyl
  Date: 2017/7/2
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师主页|淘课-基于知识地图的多元化学习网站</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

    <!-- CSS -->
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/font-awesome.css">
    <link rel="stylesheet" href="../css/animate.css">
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
                    <li><a href="T-homepage.jsp" class="active"><span>Home</span></a></li>
                    <li>
                        <a href="#subPages1" data-toggle="collapse" class=""><span>Student</span> <i
                                class="icon-submenu fa fa-angle-double-right"></i></a>
                        <div id="subPages1" class="collapse">
                            <ul class="nav">
                                <li><a href="T-display.jsp" class="">查看学生信息</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#subPages2" data-toggle="collapse" class=""><span>Course</span> <i
                                class="icon-submenu fa fa-angle-double-right"></i></a>
                        <div id="subPages2" class="collapse">
                            <ul class="nav">
                                <li><a href="T-courset.jsp" class="">课程设置</a></li>
                                <li><a href="T-uploadpage.jsp" class="">课程管理</a></li>
                                <li><a href="T-applypage.jsp" class="">课程申请</a></li>
                            </ul>
                        </div>
                    </li>
                    <li><a href="T-info.jsp" class=""><span>Person Center</span></a></li>
                </ul>
            </nav>
        </div>
    </div>
    <!-- END LEFT SIDEBAR -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">个人中心</h3>
                <div class="row">
                    <!-- TABLE -->
                    <div class="panel panel-info">
                        <ul class="breadcrumb">
                            <li>
                                <a href="T-homepage.jsp">主页</a>
                            </li>
                            <li class="active">
                                个人中心
                            </li>
                        </ul>
                        <div class="panel-body">
                            <form class="form-signin" name="form1" method="post" action="../">
                                <fieldset>
                                    <legend>我的信息</legend>
                                    <form class="form-signin" name="form1" method="post" action="applyclass.do">
                                        <div class="col-md-7 column">
                                            <div><label>ID:${teacher.id}</label></div>
                                            <div><label>用户名:${teacher.username}</label></div>
                                            <div><label>姓名:${teacher.name}</label></div>
                                            <div><label>简介:${teacher.introduction}</label></div>
                                        </div>
                                        <div class="col-md-5 column">
                                            <form action="../Tinfo.do" method="post" enctype="multipart/form-data">
                                                我的头像：<img src=${teacher.picture} alt="暂无">
                                                <td><input type="file" class="btn-danger" name="myfile" value="file"
                                                           onchange=getPath()></td>
                                                <input type="submit" class="btn btn-info btn-sm" name="Submit"
                                                       value="提交">
                                            </form>
                                        </div>
                                    </form>

                                </fieldset>
                                <button name="Submit" id="submit" class="btn btn-success" type="submit">提交
                                </button>
                                <button class="btn btn-danger" type="reset">重置
                                </button>
                            </form>
                        </div>


                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
