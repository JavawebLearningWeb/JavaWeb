<%--
  Created by IntelliJ IDEA.
  User: 16689
  Date: 2017/7/1
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加课程</title>
    <%@include file="config.jsp"%>
    <%@include file="navbar.jsp"%>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-3 column">
            <h3>
               已选课程
            </h3>

                <c:if test="${sessionScope.course.choosedcount==0}">
                    <h3>快添加右侧课程</h3>
                </c:if>
                <c:if test="${sessionScope.course.choosedcount!=0}">
                    <ul>
                   <c:forEach var="i" begin="0" end="${sessionScope.course.choosedcount}" step="1">
                       <c:if test="${i!=sessionScope.course.choosedcount}">
                           <li>
                           <a href="../ChooseCourse?courseid=${sessionScope.course.choosedcourses[i].id}">${sessionScope.course.choosedcourses[i].name}</a>
                           </li>
                       </c:if>

                   </c:forEach>
                    </ul>
                </c:if>



        </div>
        <div class="col-md-6 column">
            <h3>
               可选课程
            </h3>
            <c:if test="${sessionScope.course.canchoosecount==0}">
                <h2>
                    系统资源库故障，等待恢复
                </h2>

            </c:if>
            <c:if test="${sessionScope.course.canchoosecount!=0}">
                <c:forEach var="i" begin="0" end="${sessionScope.course.canchoosecount}" step="1">
                    <c:if test="${i!=sessionScope.course.canchoosecount}">
                        <div class="row clearfix">
                            <div class="col-md-6 column">
                                <img alt="图片丢失" src="${sessionScope.course.canchoosecourses[i].picture}" />
                            </div>
                            <div class="col-md-6 column">
                                <dl class="dl-horizontal">
                                    <dt>
                                    名称：
                                    </dt>
                                    <dd>
                                     ${sessionScope.course.canchoosecourses[i].name}
                                    </dd>
                                    <dt>
                                    介绍：
                                    </dt>
                                    <dd>
                                            ${sessionScope.course.canchoosecourses[i].introduction}
                                    </dd>

                                    <dt>
                                        类型：
                                    </dt>
                                    <dd>
                                            ${sessionScope.course.canchoosecourses[i].kind}
                                    </dd>
                                    <dt>
                                       老师姓名：
                                    </dt>
                                    <dd>
                                      ${sessionScope.course.canteacherPages[i].name}
                                    </dd>
                                    <dt>
                                        老师介绍：
                                    </dt>
                                    <dd>
                                            ${sessionScope.course.canteacherPages[i].introduction}
                                    </dd>
                                    <c:if test="${sessionScope.course.suggestCourses[i].suggestcount!=0}">
                                        <dt>
                                            你需要准备：
                                        </dt>
                                        <c:forEach var="j" begin="0" end="${sessionScope.course.suggestCourses[i].suggestcount-1}" step="1">

                                            <dd>
                                                    <a href="../AddCourseToDb?courseid=${sessionScope.course.suggestCourses[i].suggestcourse[j].id}">${sessionScope.course.suggestCourses[i].suggestcourse[j].name}</a>
                                            </dd>
                                        </c:forEach>

                                    </c:if>


                                    <dt>
                                        我要学习：
                                    </dt>
                                    <dd>
                                        <a href="../AddCourseToDb?courseid=${sessionScope.course.canchoosecourses[i].id}">添加学习</a>
                                    </dd>
                                </dl>
                            </div>
                        </div>


                    </c:if>
               </c:forEach>

            </c:if>


        </div>
        <div class="col-md-3 column">
            <h3>
               推荐课程
            </h3><img alt="图片丢失" src="${sessionScope.course.suggestcoursepage.picture}" />
            <dl class="dl-horizontal">
                <dt>
                    名称：
                </dt>
                <dd>
                    ${sessionScope.course.suggestcoursepage.name}
                </dd>
                <dt>
                    类型：
                </dt>
                <dd>
                    ${sessionScope.course.suggestcoursepage.kind}
                </dd>
                <dt>
                    介绍：
                </dt>
                <dd>
                    ${sessionScope.course.suggestcoursepage.introduction}
                </dd>
                <dt>
                    我要学习：
                </dt>
                <dd>
                  <a href="../AddCourseToDb?courseid=${sessionScope.course.suggestcoursepage.id}">添加学习</a>
                </dd>
            </dl>
        </div>
    </div>
</div>
</body>
</html>
