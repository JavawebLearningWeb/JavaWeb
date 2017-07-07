<%--
  Created by IntelliJ IDEA.
  User: 16689
  Date: 2017/7/2
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试失败</title>
    <script type="text/javascript">
        function info() {
            setInterval("load()",3000);
            alert("抱歉测试未通过，点击确认5秒后跳转学习页面");

        }
        function load() {
            window.location.href="StuChapterLearning.jsp";
            window.close();
        }

        window.onload=info;
    </script>
</head>
<body>
<h1>继续加油</h1>
</body>
</html>
