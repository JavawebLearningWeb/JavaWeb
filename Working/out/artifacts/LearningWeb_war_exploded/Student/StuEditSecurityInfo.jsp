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

    <script type="text/javascript">
        function Clear() {
            var ex = document.getElementById("explain");
            ex.innerHTML = "";


        }
        function Check() {

            var ps1, ps2;

            ps1 = document.getElementById("password1").value;
            ps2 = document.getElementById("password2").value;
            if (ps1 != ps2) {
                var h1 = "<p>两次密码不一致,请重新输入</p>";
                document.getElementById("explain").innerHTML = h1;
                document.getElementById("password1").value = "";
                document.getElementById("password2").value = "";
                document.getElementById("password1").onfocus;
            }
        }


    </script>

</head>
<body>
<div id="wrapper">
    <!-- LEFT SIDEBAR -->
    <div id="sidebar-nav" class="sidebar">
        <div class="sidebar-scroll">
            <nav>
                <ul class="nav">
                    <li><a href="stu_home.jsp" class=""><span>主页</span></a></li>
                    <li>
                        <a href="#menu1" data-toggle="collapse" class="collapsed"><span>基本信息</span><i
                                class="icon-submenu fa fa-angle-double-right"></i></a>
                        <div id="menu1" class="collapse">
                            <ul class="nav">
                                <li><a href="StuBaseInfo.jsp" class="">基本信息查询</a></li>
                                <li><a href="StuEditBaseInfo.jsp" class="">基本信息修改</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#menu2" data-toggle="collapse" class="collapsed"><span>安全信息</span><i
                                class="icon-submenu fa fa-angle-double-right"></i></a>
                        <div id="menu2" class="collapse ">
                            <ul class="nav">
                                <li><a href="StuEditSecurityInfo.jsp" class="">修改密码</a></li>
                                <li><a href="StuSecurityInfo.jsp" class="">找回密码</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">修改密码</h3>
                <div class="row">
                    <!-- TABLE -->
                    <div class="panel panel-info">
                        <ul class="breadcrumb">
                            <li>
                                <a href="stu_home.jsp">主页</a>
                            </li>
                            <li>
                                <a href="#">个人中心</a>
                            </li>
                            <li class="active">
                                修改密码
                            </li>
                        </ul>
                        <div class="panel-body">
                            <table class="table table-hover table-striped">
                                <form class="form-horizontal" action="../StuEditSecurityInfo" method="post">
                                    <div class="col-md-3 column">
                                    </div>
                                    <div class="col-md-9 column">

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">用户名</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control"
                                                       value="${sessionScope.studentpage.username}" readonly>
                                            </div>
                                        </div><br/><br>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label"> 新密码</label>
                                            <div class="col-sm-5">
                                                <input type="password" id="password1" class="form-control"
                                                       name="password"
                                                       placeholder="Please input new password" onfocus="Clear()">
                                            </div>
                                        </div><br><br>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label"> 重复密码</label>
                                            <div class="col-sm-5">
                                                <input type="password" id="password2" class="form-control"
                                                       name="password"
                                                       placeholder="Please copy new password" onchange="Check()">
                                                <div id="explain"><p></div>
                                            </div>
                                        </div><br/>
                                        <div class="form-group">

                                            <div class="col-sm-offset-4 col-sm-2">
                                                <input type="submit" value="提交" class="btn btn-success">
                                            </div>
                                        </div>
                                    </div>
                                </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
