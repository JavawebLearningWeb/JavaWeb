<%--
  Created by IntelliJ IDEA.
  User: 16689
  Date: 2017/7/1
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试页面</title>
    <%@include file="navbar.jsp" %>
    <%@include file="config.jsp" %>
<script type="text/javascript">
    function info() {
        setInterval("load()",3000);
        alert("抱歉考试失败，点击确认后5秒后跳转学习页面，继续加油");
        
    }
    function load() {
      window.location.href="Test.jsp";
      window.close();
    }
    
    window.onload=info;
</script>
</head>

<body>

</body>



</html>
