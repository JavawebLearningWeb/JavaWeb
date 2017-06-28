<%--
  Created by IntelliJ IDEA.
  User: ycbhci
  Date: 2017/6/24
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="Student/config.jsp"%>
    <style>
        body{

            margin-TOP:150PX;
            background:#3d71b8 url(img/lighthouse-2225445.jpg);
            background-position: center 0;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
            -webkit-background-size: cover;
        }
    </style>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/museo.css">
    <link rel="stylesheet" href="css/font-sl.css">
</head>
<body>
<div class="container ">

    <h2 class="form-signin-heading">Login to my account</h2>
    <form  action="StuLogin"  method="post" class="form-signin" name="form1"  >

        <input name="myusername" id="myusername" type="text" class="form-control" placeholder="Your Account" autofocus>
        <input name="mypassword" id="mypassword" type="password" class="form-control" placeholder="Password">

        <button   class="btn btn-default btn-primary btn-block" type="submit"> Sign in</button>
        <a  name="submitbtn" id="submitbtn" class="btn-sec" type="submit">Forgot Password ?</a>
        <div id="message"></div>
        </form>

</div> <!-- /container --><br><br><br><br><br><br>
<h3 class="form-signup-heading">Don't have an account ? <a href="signup.jsp">Signup</a></h3>
<script src="js/login.js"></script>
<script src="js/forgetpassword.js"></script>
</body>
</html>
