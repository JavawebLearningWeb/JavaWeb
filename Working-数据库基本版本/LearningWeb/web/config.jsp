<%--
  Created by IntelliJ IDEA.
  User: ycbhci
  Date: 2017/6/24
  Time: 13:21
  To change this template use File | Settings | File Templates.

  config 可以直接在别的jsp页面通过在head 使用 <%@include file="config.jsp"%> 来使用bootstrap 以及核心标签库
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

</body>
</html>
