<%--
  Created by IntelliJ IDEA.
  User: 16689
  Date: 2017/7/1
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
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
                <h3 class="page-title">课程选择</h3>
                <div class="row">
                    <!-- TABLE -->
                    <div class="panel panel-info">
                        <ul class="breadcrumb">
                            <li>
                                <a href="stu_home.jsp">主页</a>
                            </li>
                            <li>
                                <a href="#">课程中心</a>
                            </li>
                            <li class="active">
                                课程选择
                            </li>
                        </ul>
                        <div class="panel-body">
                            <div class="row clearfix">
                                <div class="col-md-6 column">
                                    <div style="height: 500px;" id="canvas">
                                        <script src="http://demo.qunee.com/lib/qunee-min.js"></script>
                                        <script type="text/javascript">
                                            var graph = new Q.Graph("canvas");
                                            var nodes = [];
                                            var node = new Array();

                                            function createRandomEdge(from, to) {


                                                return graph.createEdge(from, to);

                                            }
                                            function Drawnode(name, i, key) {

                                                if (key == 1) {
                                                    node[i] = graph.createNode(name);
                                                    node[i].size = {width: 30};
                                                    node[i].image = "img/model2.png";
                                                    nodes.push(node[i]);
                                                }
                                                else {
                                                    node[i] = graph.createNode(name);
                                                    node[i].size = {width: 30};
                                                    node[i].image = "img/model.png";
                                                    nodes.push(node[i]);
                                                }

                                            }
                                            function DrawEdge(i, j) {


                                                createRandomEdge(node[i], node[j]);

                                            }


                                            function Star() {//设置布局

                                                var layouter = new Q.SpringLayouter(graph);
                                                layouter.repulsion = 70;
                                                layouter.attractive = 0.5;
                                                layouter.elastic = 5;
                                                layouter.start();
                                                /*#elasticity - 弹性系数
                                                 数值越大，连线收缩越短，参考值0-10
                                                 #attractive - 中心吸引力系数
                                                 数值越大，整体分布越密集，参考值0-1
                                                 #repulsion - 斥力系数
                                                 数值越大，节点之间的间距越大，参考值0-100*/
                                            }

                                        </script>

                                        <c:forEach var="i" begin="0" end="${sessionScope.graph.chaptercount}" step="1">


                                            <c:if test="${i!=sessionScope.graph.chaptercount}">
                                                <script>

                                                    Drawnode("${sessionScope.graph.chapterPageArrayList[i].name}", "${i}", "${sessionScope.graph.finishchapter[i]}");</script>

                                            </c:if>

                                        </c:forEach>

                                        <c:forEach var="i" begin="0" end="${sessionScope.graph.chaptercount}" step="1">

                                            <c:forEach var="j" begin="0" end="${sessionScope.graph.chaptercount}"
                                                       step="1">
                                                <c:if test="${(i!=sessionScope.graph.chaptercount)&&(j!=sessionScope.graph.chaptercount)}">
                                                    <c:if test="${sessionScope.graph.graph[i][j]==1}">
                                                        <script>
                                                            DrawEdge("${i}", "${j}");</script>

                                                    </c:if>


                                                </c:if>

                                            </c:forEach>
                                        </c:forEach>
                                        <script> Star()</script>
                                    </div>

                                </div>
                                <div class="col-md-6 column" style="color: #00aa00">
                                    <div class="row clearfix">
                                        <div class="col-md-6 column">
                                            <h3>已学习的章节</h3>
                                            <ul>

                                                <c:forEach var="i" begin="0" end="${sessionScope.graph.finishedcount}"
                                                           step="1">
                                                    <c:if test="${i!=sessionScope.graph.finishedcount}">
                                                        <li>
                                                            <a
                                                                    href="../LearnChapter?id=${sessionScope.graph.finishedchapter[i].id}">${sessionScope.graph.finishedchapter[i].name} </a>
                                                        </li>


                                                    </c:if>

                                                </c:forEach>
                                            </ul>
                                        </div>
                                        <div class="col-md-6 column" style="color: red">
                                            <h3>可选章节</h3>
                                            <ul>
                                                <c:forEach var="i" begin="0" end="${sessionScope.graph.learncount}"
                                                           step="1">
                                                    <c:if test="${i!=sessionScope.graph.learncount}">
                                                        <li>
                                                            <a href="../LearnChapter?id=${sessionScope.graph.learnchapter[i].id}">${sessionScope.graph.learnchapter[i].name} </a>
                                                        </li>

                                                    </c:if>

                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>


</html>
