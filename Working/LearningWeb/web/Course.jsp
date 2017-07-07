<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/25
  Time: 21:11
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
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/chartist-custom.css">
    <link rel="stylesheet" href="css/ad_main.css">
    <script src="https://use.fontawesome.com/61a9ff3a07.js"></script>
    <%@include file="/config.jsp" %>
    <%@include file="/navbar_blue.jsp" %>

</head>
<body>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="DAO.*" %>
<%@page import="Entity.*" %>
<%@page import="Page.*" %>
<%@ page import="java.util.List" %>

<div id="wrapper">
    <!-- LEFT SIDEBAR -->
    <div id="sidebar-nav" class="sidebar">
        <div class="sidebar-scroll">
        </div>
    </div>
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">课程信息</h3>
                <div class="row">
                    <!-- TABLE -->
                    <div class="panel panel-info">
                        <ul class="breadcrumb">

                            <li>
                                <a href="#">课程管理</a>
                            </li>
                            <li class="active">
                                课程信息
                            </li>
                        </ul>

                        <div class="panel-body">
                            <table class="table table-hover table-striped">
                                <thead>
                                <tr>

                                    <th>课程名</th>
                                    <th>课程类型</th>
                                    <th>教师用户名</th>
                                    <th>任课教师</th>
                                    <th>课程简介</th>
                                    <th>现有人数</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    response.setContentType("text/html;charset=UTF-8");
                                    request.setCharacterEncoding("UTF-8");
                                    CDAO dao = new CDAO();
                                    List<Course> list = dao.Get();
                                    int t = list.size();
                                    request.getSession().setAttribute("courselist", list);
                                %>
                                <c:forEach var="c" items="${sessionScope.courselist}" varStatus="status">
                                    <tr class="warning">

                                        <td>${c.cp.name}</td>
                                        <td>${c.cp.kind}</td>
                                        <td>${c.tusername}</td>
                                        <td>${c.tname}</td>
                                        <td>${c.cp.introduction}</td>
                                        <td>${c.cnum}</td>

                                    </tr>
                                </c:forEach>
                                </tbody>
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
