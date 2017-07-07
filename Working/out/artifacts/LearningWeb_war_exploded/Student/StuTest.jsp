<%--
  Created by IntelliJ IDEA.
  User: 16689
  Date: 2017/7/2
  Time: 12:51
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
                <h3 class="page-title">测试</h3>
                <div class="row">
                    <!-- TABLE -->
                    <div class="panel panel-info">
                        <ul class="breadcrumb">
                            <li>
                                <a href="stu_home.jsp">主页</a>
                            </li>
                            <li>
                                <a href="#">学习</a>
                            </li>
                            <li class="active">
                                章节测试
                            </li>
                        </ul>

                        <div class="panel-body">
                            <h3>正在进行章节测试，请将答案填写在右侧答题卡上</h3>
                            <div class="col-md-8 column">
                                <img alt="#" src="${sessionScope.question.usingexampage.address}"/>
                            </div>
                            <div class="col-md-4 column">
                                <form class="form-horizontal" action="../Evaluate" method="post">
                                    <ol>
                                        <c:forEach var="i" begin="0" end="${sessionScope.question.count}" step="1">
                                            <c:if test="${i!=sessionScope.question.count}">
                                                <div class="col-sm-offset-4">

                                                    <div class="form-group">
                                                        <label class="col-sm-1 control-label">A <input type="radio"
                                                                                                       name="radio${i}"
                                                                                                       class="radio"
                                                                                                       value="A"></label>
                                                        <label class="col-sm-1 control-label">B <input type="radio"
                                                                                                       name="radio${i}"
                                                                                                       class="radio"
                                                                                                       value="B"></label>
                                                        <label class="col-sm-1 control-label">C <input type="radio"
                                                                                                       name="radio${i}"
                                                                                                       class="radio"
                                                                                                       value="C"></label>
                                                        <label class="col-sm-1 control-label">D <input type="radio"
                                                                                                       name="radio${i}"
                                                                                                       class="radio"
                                                                                                       value="D"></label>
                                                    </div>
                                                </div>


                                            </c:if>

                                        </c:forEach>
                                    </ol>
                                </form>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-offset-5 col-sm-10">
                                    <button type="submit" class="btn btn-success">提交</button>
                                    <button type="reset" class="btn btn-danger">重置</button>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
