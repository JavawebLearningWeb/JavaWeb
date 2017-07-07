<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Amos
  Date: 2017/6/26
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MAPS|淘课-基于知识地图的多元化学习网站</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css"  href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/responsive.css">

    <!-- Stylesheet
    ================================================== -->
    <link rel="stylesheet" type="text/css"  href="css/style.css">
    <link rel="stylesheet" type="text/css"  href="css/style2.css">
    <link rel="stylesheet" type="text/css" href="css/responsive.css">

    <!-- font -->
    <link href='css/fonts.css?family=Raleway:500,600,700,100,800,900,400,200,300' rel='stylesheet' type='text/css'>
    <link href='css/fonts.css?family=Playball' rel='stylesheet' type='text/css'>
    <script src="https://use.fontawesome.com/61a9ff3a07.js"></script>

    <script type="text/javascript" src="js/modernizr.custom.js"></script>


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="js/html5shiv.min.js"></script>
    <script type="text/javascript" src="js/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div id="tf-home">
    <div class="overlay">
        <div id="sticky-anchor"></div>
        <nav id="tf-menu" class="navbar navbar-default">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand logo" href="home.jsp"><img src="img/logo.png" width="80"></a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="home.jsp"> Home</a></li>
                        <li><a href="showcourse.jsp"> Course</a></li>
                        <li><a href="Teacher.jsp"> Teacher</a></li>
                        <li><a href="#"> About</a></li>

                        <c:if test="${studentpage==null}">
                            <li><a href="login.jsp"> Login</a></li>
                            <li><a href="signup.jsp"> Sign up</a></li>
                        </c:if>
                        <c:if test="${studentpage!=null}"><li><a href="Student/stu_home.jsp"><font color="white"size="12px">${studentpage.name}</font></a></li></c:if>

                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <div class="container">
            <div class="content">
                <h1>Knowledge Map</h1>
                <h2>a new and efficient way of learning</h2>
                <h3>It connects the knowledge points by means of map</h3>
                <h3>so that you can study more clear and efficient</h3>
                <br>
                <a href="login.jsp" class="btn btn-primary my-btn">Start Now</a>
                <a href="http://baike.baidu.com/link?url=mATZtjbez9vNb15gNBNT7Ku0rNMCn5msWiLlQm3tPorZLbjHwIX2MfTz202yWALyvG36B3w-e2DGFnYGoIiX5wWMGsP3gP0Y-A_Y2I3rqwS8GuBMLOArkAsUQdOpZo4r" class="btn btn-primary my-btn2">Learn More</a>
            </div>
        </div>
    </div>
</div>

<div id="tf-service">
    <div class="container">
        <div class="section-title">
            <h2><font color="black">What we provide</font></h2>
            <hr>
        </div>
        <br><br>
        <div class="col-md-4">
            <div class="media">
                <div class="media-left media-middle">
                    <i class="fa fa-play-circle-o"></i>
                </div>
                <div class="media-body">
                    <h4 class="media-heading">在线学习</h4>
                    <p> 丰富课程资源随时学习</p>
                    <p> 知识地图呈现知识体系结构</p>
                </div>
            </div>

        </div>

        <div class="col-md-4">

            <div class="media">
                <div class="media-left media-middle">
                    <i class="fa fa-tags"></i>
                </div>
                <div class="media-body">
                    <h4 class="media-heading">名师答疑</h4>
                    <p> 资深教师在线答疑解惑</p>
                    <p> 360度掌握新知识不留死角</p>
                </div>
            </div>

        </div>

        <div class="col-md-4">

            <div class="media">
                <div class="media-left media-middle">
                    <i class="fa fa-tasks"></i>
                </div>
                <div class="media-body">
                    <h4 class="media-heading">课后交流</h4>
                    <p> 课程论坛交流学习经验</p>
                    <p> 和小伙伴一起打怪升级上王者</p>
                </div>
            </div>

        </div>

    </div>
</div>

<div id="tf-portfolio">
    <div class="container">
        <div class="row">
            <div class="col-md-12 column">
                <div class="carousel slide" id="carousel-16881">
                    <ol class="carousel-indicators">
                        <li class="active" data-slide-to="0" data-target="#carousel-16881">
                        </li>
                        <li data-slide-to="1" data-target="#carousel-16881">
                        </li>
                        <li data-slide-to="2" data-target="#carousel-16881">
                        </li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="item active">
                            <img alt="" src="img/book-1623578_1280.jpg" />
                            <div class="carousel-caption">

                            </div>
                        </div>
                        <div class="item">
                            <img alt="" src="img/technology-2082642_1280.jpg" />
                            <div class="carousel-caption">

                            </div>
                        </div>
                        <div class="item">
                            <img alt="" src="img/large-895567_1280.jpg" />
                            <div class="carousel-caption">

                            </div>
                        </div>
                    </div> <a class="left carousel-control" href="#carousel-16881" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-16881" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                </div>
            </div>
        </div>

    </div>
</div>

<div id="tf-about">
    <div class="overlay">
        <div class="container">
            <div class="section-title">
                <h2><font color="black">Our Teachers</font></h2>
                <hr>
            </div>
            <div class="row">
                <div class="col-md-12 column">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="thumbnail">
                                <img src="img/zack.jpeg" class="img-circle" width="140" height="140"/>
                                <div class="caption">
                                    <h3><font color="black"> Mark Zuckerberg</font></h3>
                                    <p>
                                        Mark Elliot Zuckerberg is an American computer programmer, Internet entrepreneur, and philanthropist. He is best known as one of five co-founders of the social networking website Facebook.
                                    </p>
                                    <p>
                                    <center><a class="btn btn-success" href="#">Follow</a></center>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="thumbnail">
                                <img src="img/bill.jpeg" class="img-circle" width="140" height="140"/>
                                <div class="caption">
                                    <h3><font color="black">Bill Gates</font></h3>
                                    <p>
                                        Bill Gates is the head of the software company Microsoft and one of the world's wealthiest men. Gates and Paul Allen founded Microsoft in the 1970s, though Allen left the company in 1983.In 1975, Gates and Paul Allen co-founded Microsoft
                                    </p>
                                    <p>
                                    <center><a class="btn btn-success" href="#">Follow</a></center>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="thumbnail">
                                <img src="img/google.jpg" class="img-circle" width="140" height="140"/>
                                <div class="caption">
                                    <h3><font color="black">Sundar Pichai</font></h3>
                                    <p>
                                        Pichai is the chief executive officer of Google Inc.Formerly the Product Chief of Google, Pichai's current role was announced on 10 August 2015, as part of the restructuring process that made Alphabet Inc. into Google's parent company.
                                    </p>
                                    <p>
                                    <center><a class="btn btn-success" href="#">Follow</a></center>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="section-title">
    <h2><font color="black">What we had done</font></h2>
    <hr>
</div>

<section class="overlay-dark bg-img1 dark-bg short-section">
    <div class="container text-center">
        <div class="row">
            <div class="col-md-3 mb-sm-30">
                <div class="counter-item">
                    <i class="fa fa-book fa-3x"></i>
                    <h2 data-count="59">132</h2>
                    <h6>courses</h6>
                </div>
            </div>
            <div class="col-md-3 mb-sm-30">
                <div class="counter-item">
                    <i class="fa fa-user fa-3x"></i>
                    <h2 data-count="1054">1054</h2>
                    <h6>students</h6>
                </div>
            </div>
            <div class="col-md-3 mb-sm-30">
                <div class="counter-item">
                    <i class="fa fa-user-circle fa-3x"></i>
                    <h2 data-count="34">34</h2>
                    <h6>teachers</h6>
                </div>
            </div>
            <div class="col-md-3 mb-sm-30">
                <div class="counter-item">
                    <i class="fa fa-building-o fa-3x"></i>
                    <h2 data-count="154">17</h2>
                    <h6>schools</h6>
                </div>
            </div>
        </div>
    </div>
</section>
<br><br><br>

<div class="container">
    <div class="section-title">
        <h2><font color="black">About Knowledge Map</font></h2>
        <hr>
    </div>
    <div class="row">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-7 column">
                    <img alt="140x140" src="img/map-1301054.jpg" width="600" height="250"/>
                </div>
                <div class="col-md-5 column">
                    <blockquote>
                        <p>
                            知识地图是一种知识导航系统，并显示不同的知识存储之间重要的动态联系。它是知识管理系统的输出模块，输出的内容包括知识的来源，整合后的知识内容，知识流和知识的汇聚。
                        </p>
                        <p>
                            知识地图是对概念和知识关联的切实表述或分类，它起到了一种搜索导航的功能，可以使用户快速找到他们所需要的知识点，然后重新返回到相关的知识源。知识源可能指人，文献资料，非出版的原始资料，甚至可以是推动某一事务进展的原动力（特定的环境，职位，地位等）。在这一过程中你可能会成为别人的知识源，而你自己的知识源又会与其它知识相联。另外知识地图还支持用户的模糊查询，它可以将相毗邻的知识单元联系起来并进行详细的描述。用户使用隐喻的方法可以找到他们需要的却无法详细描述的知识。通常这样的知识地图是可视化的并通过所谓的“语义入口”进行浏览，使用户很容易地定位于与他们的利益相关的信息。
                        </p>
                    </blockquote>
                </div>
            </div>
        </div>
    </div>
</div>


<nav id="tf-footer">
    <div class="container">
        <div class="pull-left">
            <img src="img/logo.png" width="100">
            <p>基于知识地图的多元化学习网站 © 软件协同设计第五组</p>
        </div>
        <div class="pull-right">
            <ul class="social-media list-inline">
                <li><a href="#"><span class="fa fa-wechat"></span></a></li>
                <li><a href="#"><span class="fa fa-qq"></span></a></li>
                <li><a href="#"><span class="fa fa-github"></span></a></li>
                <li><a href="login_ad.jsp"><span class="fa fa-lock"></span></a></li>
            </ul>
        </div>
    </div>
</nav>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

<!-- Javascripts
================================================== -->
<script type="text/javascript" src="js/main.js"></script>


</body>
</html>
