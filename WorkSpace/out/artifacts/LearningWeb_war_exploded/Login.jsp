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
    <%@include file="config.jsp"%>
    <style>
        body{

            margin-TOP:100PX;
            background:#3d71b8 url(img/lighthouse-2225445.jpg);
            background-position: center 0;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
            -webkit-background-size: cover;
        }
    </style>
</head>
<body>
<div class="container ">


    <form class="form-signin" name="form1" method="post" action="checklogin.jsp">
        <h2 class="form-signin-heading">Login to my account</h2>
        <input name="myusername" id="myusername" type="text" class="form-control" placeholder="Your Account" autofocus>
        <input name="mypassword" id="mypassword" type="password" class="form-control" placeholder="Password">
        <!-- The checkbox remember me is not implemented yet...
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        -->
        <button name="Submit" id="submit" class="btn btn-default btn-primary btn-block" type="submit">Sign in</button>
        <a  name="submitbtn" id="submitbtn" class="btn-sec" type="submit">Forgot Password ?</a>
        <div id="message"></div>
    </form>

</div> <!-- /container --><br><br><br><br><br><br>
<h3 class="form-signup-heading">Don't have an account ? <a href="signup.jsp">Signup</a></h3>

</body>
</html>
