<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/25
  Time: 22:37
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

    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">教师信息修改</h3>
                <div class="row">
                    <!-- TABLE -->
                    <div class="panel panel-info">
                        <ul class="breadcrumb">
                            <li>
                                <a href="AdminHeadPage.jsp">主页</a>
                            </li>
                            <li>
                                <a href="#">教师管理</a>
                            </li>
                            <li class="active">
                                教师信息修改
                            </li>
                        </ul>
                        <div class="panel-body">

                            <div class="container-fluid">
                                <div class="row-fluid">
                                    <div class="span12">
                                        <form action="../AdminTeaUpd" method="post">
                                            <table class="table">

                                                <tbody>
                                                <%
                                                    response.setContentType("text/html;charset=UTF-8");
                                                    request.setCharacterEncoding("UTF-8");
                                                    int n;
                                                    n = Integer.valueOf(request.getParameter("ID"));
                                                    ArrayList<TeacherPage> list = (ArrayList<TeacherPage>) request.getSession().getAttribute("teacherlist");
                                                    if (list == null) {
                                                        list = new ArrayList<TeacherPage>();

                                                    } else {

                                                        TeacherPage t = (TeacherPage) list.get(n);
                                                        String tid = t.getId();
                                                        request.getSession().setAttribute("teacherTno", tid);
                                                %>
                                                <tr class="info">
                                                    <td>教师用户名</td>
                                                    <td>
                                                        <input type=text name=Tno value="<%=t.getUsername() %>">
                                                    </td>
                                                </tr>
                                                <tr class="success">
                                                    <td>教师姓名</td>
                                                    <td>
                                                        <input type=text name=Tname value="<%=t.getName() %>">
                                                    </td>
                                                </tr>
                                                <tr class="info">
                                                    <td>密码</td>
                                                    <td>
                                                        <input type=text name=Tpswd value="<%=t.getPassword()%>">
                                                    </td>
                                                </tr>
                                                <tr class="success">
                                                    <td>性别</td>
                                                    <td>
                                                        <select name="Tsex">
                                                            <option value="<%=t.getGender() %>"
                                                                    selected><%=t.getGender() %>
                                                            </option>
                                                            <option value="男">男</option>
                                                            <option value="女">女</option>
                                                        </select>
                                                    </td>
                                                </tr>
                                                <tr class="info">
                                                    <td>专业</td>
                                                    <td><input type=text name=Tprofession value="<%=t.getMajor()%>">
                                                    </td>
                                                </tr>

                                                <tr class="success">
                                                    <td>学历</td>
                                                    <td><select name="Tstatus">
                                                        <option value="<%=t.getStatus()%>" selected><%=t.getStatus()%>
                                                        </option>
                                                        <option value="本科">本科</option>
                                                        <option value="硕士">硕士</option>
                                                        <option value="博士">博士</option>
                                                    </select></td>
                                                </tr>
                                                <tr class="info">
                                                    <td>邮箱</td>
                                                    <td><input type="text" name="Temail" value="<%=t.getEmail() %>"/>
                                                    </td>
                                                </tr>
                                                <tr class="success">
                                                    <td>简介</td>
                                                    <td><input type="text" name="Tintroduction"
                                                               value="<%=t.getIntroduction()%>"/></td>
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
