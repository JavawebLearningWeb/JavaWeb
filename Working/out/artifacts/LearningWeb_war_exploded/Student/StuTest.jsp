<%--
  Created by IntelliJ IDEA.
  User: 16689
  Date: 2017/7/2
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生测试</title>
    <%@include file="config.jsp"%>
    <%@include file="navbar.jsp"%>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>
        <div class="col-md-8 column">
            <h3 class="text-center text-info">
                现在进行章节测试
            </h3><img alt="题库丢失" src="${sessionScope.question.usingexampage.address}" />
            <h3 class="text-center text-success">
                请将上面的题目打在答题卡上
            </h3>
            <form class="form-horizontal" action="../Evaluate" method="post">
                <ol>
                <c:forEach var="i" begin="0"  end="${sessionScope.question.count}" step="1">
                    <c:if test="${i!=sessionScope.question.count}">
                        <div class="col-sm-offset-4">

                            <div class="form-group">
                                <label  class="col-sm-1 control-label">A <input type="radio" name="radio${i}" class="radio" value="A"></label>
                                <label  class="col-sm-1 control-label">B <input type="radio" name="radio${i}" class="radio" value="B"></label>
                                <label  class="col-sm-1 control-label">C <input type="radio" name="radio${i}" class="radio" value="C"></label>
                                <label  class="col-sm-1 control-label">D <input type="radio" name="radio${i}" class="radio" value="D"></label>
                            </div>
                        </div>




                    </c:if>

                </c:forEach>
                </ol>

                <div class="form-group">
                    <div class="col-sm-offset-5 col-sm-10">
                        <button type="submit" class="btn btn-success">提交</button>
                        <button type="reset" class="btn btn-danger">重置</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-2 column">

            </ul>
        </div>
    </div>
</div>
</body>
</html>
