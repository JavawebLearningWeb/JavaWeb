<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 19:22
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
    <style>
        body {
            overflow-x: hidden;
        }
    </style>

</head>
<body>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="DAO.*" %>
<%@page import="Entity.*" %>
<%@page import="Page.*" %>
<%@ page import="java.util.List" %>

<!-- WRAPPER -->
<div id="wrapper">
    <!-- LEFT SIDEBAR -->
    <div id="sidebar-nav" class="sidebar">
        <div class="sidebar-scroll">
            <nav>
                <ul class="nav">
                    <li><a href="AdminHeadPage.jsp" class=""><span>Home</span></a></li>
                    <li><a href="Admin-StuSel.jsp" class=""> <span>Student</span></a></li>
                    <li>
                        <a href="#menu1" data-toggle="collapse" class="collapsed"><span>Course</span><i
                                class="icon-submenu fa fa-angle-double-right"></i></a>
                        <div id="menu1" class="collapse">
                            <ul class="nav">
                                <li><a href="Admin-CouSel.jsp" class="">课程信息管理</a></li>
                                <li><a href="Admin-RelSel.jsp" class="">课程关系管理</a></li>
                                <li><a href="Admin-CouAdd.jsp" class="">添加新课程</a></li>
                                <li><a href="Admin-Verify.jsp" class="">审核新课程</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#menu2" data-toggle="collapse" class="collapsed"><span>Teacher</span><i
                                class="icon-submenu fa fa-angle-double-right"></i></a>
                        <div id="menu2" class="collapse ">
                            <ul class="nav">
                                <li><a href="Admin-TeaSel.jsp" class="">教师信息管理</a></li>
                                <li><a href="Admin-TeaAdd.jsp" class="">添加新教师</a></li>
                            </ul>
                        </div>
                    </li>
                    <li><a href="Admin-VerTab.jsp" class=""><span>Record</span></a></li>
                </ul>
            </nav>
        </div>
    </div>
    <!-- END LEFT SIDEBAR -->
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">课程信息修改</h3>
                <div class="row">
                    <!-- TABLE -->
                    <div class="panel panel-info">
                        <ul class="breadcrumb">
                            <li>
                                <a href="AdminHeadPage.jsp">主页</a>
                            </li>
                            <li>
                                <a href="#">课程管理</a>
                            </li>
                            <li class="active">
                                课程信息修改
                            </li>
                        </ul>

                        <div class="panel-body">
                            <div class="container-fluid">
                                <div class="row-fluid">
                                    <div class="span12">
                                        <form action="../AdminCouUpd" method="post">
                                            <table class="table">

                                                <tbody>
                                                <%
                                                    response.setContentType("text/html;charset=UTF-8");
                                                    request.setCharacterEncoding("UTF-8");
                                                    int n;
                                                    n = Integer.valueOf(request.getParameter("ID"));

                                                    CourseDAO dao = new CourseDAO();
                                                    ArrayList<Course> list = (ArrayList<Course>) request.getSession().getAttribute("courselist");
                                                    if (list == null) {
                                                        list = new ArrayList<Course>();

                                                    } else {

                                                        Course c = (Course) list.get(n);
                                                        String cno = c.getCp().getId();
                                                        request.getSession().setAttribute("CourseCno", cno);
                                                %>
                                                <tr class="success">
                                                    <td>课程号</td>
                                                    <td><input type=text name=Cno value="<%=c.getCp().getId() %>"></td>
                                                </tr>
                                                <tr class="success">
                                                    <td>课程名</td>
                                                    <td><input type=text name=Cname value="<%=c.getCp().getName() %>">
                                                    </td>
                                                </tr>
                                                <tr class="success">
                                                    <td>课程类型</td>
                                                    <td><select name="Ckind">
                                                        <option value="<%=c.getCp().getKind() %>"
                                                                selected><%=c.getCp().getKind() %>
                                                        </option>
                                                        <option value="文学">文学</option>
                                                        <option value="历史学">历史</option>
                                                        <option value="经济学">经济学</option>
                                                        <option value="工程技术">工程技术</option>
                                                        <option value="医学">医学</option>
                                                        <option value="医学">法学</option>
                                                    </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>任课教师</td>
                                                    <td>
                                                        <%=c.getTname() %>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>教师用户名</td>
                                                    <td>
                                                        <%=c.getTusername() %>
                                                    </td>
                                                </tr>

                                                <tr class="success">
                                                    <td>课程简介</td>
                                                    <td><input type=text name=Cintroduction
                                                               value="<%=c.getCp().getIntroduction() %>"></td>
                                                </tr>
                                                <tr>
                                                    <td>现有人数</td>
                                                    <td><%=c.getCnum() %>
                                                    </td>
                                                </tr>
                                                <%
                                                    }
                                                %>
                                                </tbody>
                                            </table>
                                            <button type="submit" class="btn btn-info">确定</button>
                                        </form>
                                    </div>
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
