
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student Info</title>
  <script type="text/javascript" >
      function Clear() {
          var ex=document.getElementById("explain");
          ex.innerHTML="";


      }
      function Check(){

          var ps1,ps2;

          ps1=document.getElementById("password1").value;
          ps2=document.getElementById("password2").value;
          if(ps1!=ps2)
          {
              var h1="<mark>两次密码不一致请重新输入</mark>";
              document.getElementById("explain").innerHTML=h1;
             document.getElementById("password1").value="";
              document.getElementById("password2").value="";
              document.getElementById("password1").onfocus;
          }
      }


  </script>
    <%@include file="navbar.jsp"%>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-3 column">
                    <%@include file="leftside.jsp"%>
                </div>
                <div class="col-md-9 column">
                <div class="col-sm-offset-3">
                    <h2> 正在修改密码注意环境安全</h2>
                    <form class="form-horizontal" action="../StuEditSecurityInfo" method="post">
                        <div class="form-group">
                            <label class="col-sm-3 control-label"> 用户名</label>
                            <div class="col-sm-5">
                            <input type="password" class="form-control" value="${sessionScope.studentpage.username}" readonly>
                            </div>


                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label"> 新密码</label>
                            <div class="col-sm-5">
                                <input type="text" id="password1" class="form-control" name="password" placeholder="Please input new password" onfocus="Clear()" >
                            </div>


                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"> 重复密码</label>
                            <div class="col-sm-5">
                                <input type="password" id="password2" class="form-control" name="password" placeholder="Please copy new password" onchange="Check()">
                                <div id="explain"> <p></div>
                            </div>


                        </div>
                        <div class="form-group">

                            <div class="col-sm-offset-4 col-sm-2">
                               <input type="submit" value="提交" class="btn btn-danger">
                            </div>


                        </div>


                    </form>


                </div>


                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
