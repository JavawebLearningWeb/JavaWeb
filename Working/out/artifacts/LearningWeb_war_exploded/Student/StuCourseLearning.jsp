<%@ page import="net.sf.json.JSONArray" %>
<%@ page import="StudentServlst.Student.Graph" %>
<%@ page import="net.sf.json.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: 16689
  Date: 2017/6/30
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学习进度情况</title>
    <%@include file="config.jsp" %>
    <%@include file="navbar.jsp" %>
    <div style="height: 500px;" id="canvas"/>
    <script src="http://demo.qunee.com/lib/qunee-min.js"></script>
    <script type="text/javascript">
        var graph = new Q.Graph("canvas");
        var nodes=[];
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


                createRandomEdge(node[i],node[j]);

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
</head>
<body>


<c:forEach var="i" begin="0" end="${sessionScope.graph.chaptercount}" step="1">


    <c:if test="${i!=sessionScope.graph.chaptercount}">
        <script>

            Drawnode("${sessionScope.graph.chapterPageArrayList[i].name}", "${i}", "${sessionScope.graph.finishchapter[i]}");</script>

    </c:if>

</c:forEach>

<c:forEach var="i" begin="0" end="${sessionScope.graph.chaptercount}" step="1">

    <c:forEach var="j" begin="0" end="${sessionScope.graph.chaptercount}" step="1">
<c:if test="${(i!=sessionScope.graph.chaptercount)&&(j!=sessionScope.graph.chaptercount)}">
    <c:if test="${sessionScope.graph.graph[i][j]==1}">
        <script>
            DrawEdge("${i}","${j}");</script>

    </c:if>


</c:if>

    </c:forEach>
</c:forEach>
<script> Star();</script>
<%--<c:forEach var="i" begin="0" end="${sessionScope.graph.chaptercount}" step="1">--%>
<%--<c:if test="${i!=sessionScope.graph.chaptercount}">--%>
<%--<c:forEach var="j" begin="0" end="${sessionScope.graph.chaptercount}" step="1">--%>
<%--<c:if test="${j!=sessionScope.graph.chaptercount}">--%>
<%--<script>--%>
<%--DrawEdge("${sessionScope.graph.graph}", "${i}", "${j}")--%>

<%--</script>--%>


<%--</c:if>--%>

<%--</c:forEach>--%>


<%--</c:if>--%>

<%--</c:forEach>--%>


</body>
</html>
