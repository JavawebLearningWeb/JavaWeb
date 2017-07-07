<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/25
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%@include file="config.jsp"%>
    <%@include file="navbar.jsp"%>
</head>
<body>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="DAO.*" %>
<%@page import="Entity.*" %>
<%@page import="Page.*" %>
<%@ page import="StudentServlst.Student.TeaCou" %>

<div class="container">
    <div class="row">
        <div class="span2">
            <ol>


            </ol>
        </div>
        <div class="span10">

         <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span12">
                        <table class="table">
                            <thead>
                            <tr>

                                <th>教师姓名</th>
                                <th>性别</th>
                                <th>专业</th>

                                <th>简介</th>
                                <th>所授课程</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                response.setContentType("text/html;charset=UTF-8");
                                request.setCharacterEncoding("UTF-8");
                                TeacherDAO dao=new TeacherDAO();
                                CourseDAO dao1=new CourseDAO();

                                List<TeacherPage> list=dao.GetAll();
                                List<TeaCou> list1=new ArrayList();
                                List<CoursePage> list2=new ArrayList();
                                for(int i=0;i<list.size();i++){
                                    TeaCou tc=new TeaCou();
                                    list2=dao1.GetAllByColumn("teacherid",list.get(i).getId());
                                    tc.setTp(list.get(i));
                                    if(list2.size()>2){
                                        tc.setC3(list2.get(2));
                                        tc.setC1(list2.get(0));
                                        tc.setC2(list2.get(1));
                                    }else if(list2.size()>1&&list2.size()<3){
                                        tc.setC1(list2.get(0));
                                        tc.setC2(list2.get(1));
                                    }else if(list2.size()==1){
                                        tc.setC1(list2.get(0));
                                    }

                                    list1.add(tc);
                                }


                                request.getSession().setAttribute("teachercoulist", list1);
                            %>
                            <c:forEach var="t" items="${sessionScope.teachercoulist}" varStatus="status">
                                <tr class="error">

                                    <td>${t.tp.name}</td>
                                    <td>${t.tp.gender}</td>
                                    <td>${t.tp.major}</td>

                                    <td>${t.tp.introduction}</td>
                                    <td>${t.c1.name}</td><td>${t.c2.name}</td><td>${t.c3.name}</td>
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
</body>
</html>
