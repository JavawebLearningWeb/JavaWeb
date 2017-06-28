<%--
  Created by IntelliJ IDEA.
  User: ycbhci
  Date: 2017/6/27
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="config.jsp" %>
</head>
<body>
<form class="form-horizontal" action="StuEditInfo" method="post">
    <div class="container">
        <div class="row clearfix">
            <div class="col-sm-12 column">
                <div class="row clearfix">
                    <div class="col-sm-3 column">
                        <%@include file="leftside.jsp" %>
                    </div>
                    <div class="col-sm-9 column">


                        <div class="form-group"><label for="name" class="col-sm-2 control-label"> 昵称</label>
                            <div class="col-sm-4">
                                <input type="text" id="name" class="form-control" name="name"
                                       value=" ${sessionScope.studentpage.name}">

                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-2 control-label">生日</label>
                            <div class="col-sm-4">
                                <input type="text" id="birthday" class="form-control" name="birthday"
                                       value=" ${sessionScope.studentpage.birthday}">

                            </div>
                        </div>


                        <div class="form-group">


                            <label class="col-sm-2 control-label">性别</label>
                            <c:if test="${sessionScope.studentpage.gendar=='男'}">
                                <label class="col-sm-2">男 <input type="radio" name="gendar"
                                                                 value="男" checked></label>

                                <label class="col-sm-2">女<input type="radio" name="gendar"
                                    value="女"></label>


                            </c:if>
                            <c:if test="${sessionScope.studentpage.gendar=='女'}">
                                <label class="col-sm-2">男 <input type="radio" name="gendar"
                                                                 value="男" checked></label>

                                <label class="col-sm-2">女<input type="radio" name="gendar"
                                                                value="女"></label>

                            </c:if>


                        </div>


                        <div class="form-group">

                            <label class="col-sm-2 control-label"> 学历</label>
                            <div class="col-sm-4">
                                <input type="text" id="status" class="form-control" name="status"
                                       value=" ${sessionScope.studentpage.status}">
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-2 control-label"> 年级</label>
                            <div class="col-sm-4">
                                <input type="text" id="grade" class="form-control" name="grade"
                                       value=" ${sessionScope.studentpage.grade}">

                            </div>
                        </div>

                        <div class="form-group"><label class="col-sm-2 control-label"> 邮箱</label>
                            <div class="col-sm-4">
                                <input type="text" id="eamil" class="form-control" name="email"
                                       value=" ${sessionScope.studentpage.email}">

                            </div>
                        </div>


                        <div class="form-group"><label class="col-sm-2 control-label"> 专业</label>
                            <div class="col-sm-4">
                                <input type="text" id="major" class="form-control" name="major"
                                       value=" ${sessionScope.studentpage.major}">

                            </div>
                        </div>

                        <div class="col-sm-offset-3"><input type="submit" value="确认修改" class="btn btn-danger col-sm-2">
                        </div>


                    </div>
                </div>
            </div>
        </div>
    </div>


</form>
</body>
</html>
