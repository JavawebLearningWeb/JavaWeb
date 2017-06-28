<%--
  Created by IntelliJ IDEA.
  User: Amos
  Date: 2017/6/28
  Time: 00:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign up|淘课-基于知识地图的多元化学习网站</title>
    <link rel='stylesheet prefetch' href='css/sign_log/reset.css'>
    <link rel="stylesheet" type="text/css" href="css/sign_log/default.css">
    <link rel="stylesheet" type="text/css" href="css/sign_log/styles.css">
    <%@include file="config.jsp" %>
    <%@include file="navbar.jsp" %>
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
                var h1 = "<p><mark>两次密码不一致请重新输入</mark>";
                document.getElementById("explain").innerHTML = h1;
                document.getElementById("password1").value = "";
                document.getElementById("password2").value = "";
                document.getElementById("password1").onfocus;
            }
        }


    </script>
</head>
<body>
<article class="htmleaf-content">
    <!-- multistep form -->
    <form id="msform" action="../Signup" method="post">
    <!-- progressbar -->
    <ul id="progressbar">
        <li class="active">Register account</li>
        <li>Self-introduction</li>
        <li>Education information</li>
    </ul>
    <!-- fieldsets -->

    <fieldset>

            <h3 class="fs-subtitle">Step One</h3>
            <h2 class="fs-title">Register account</h2>
            <input type="text" name="username" placeholder="Your Real Name"/>
            <input id="password1" type="password" name="password" placeholder="Password" onfocus="Clear()"/>

            <input id="password2" type="password" name="re-password" placeholder="Confirm your password"
                   onchange="Check()"/>
            <div id="explain"></div>
            <br><br>
            <input type="button" name="next" class="next action-button" value="Next Step"/>
            <input type="button" name="reste" class="next action-button1" value="Reset"/>
    </fieldset>
    <fieldset>
        <h3 class="fs-subtitle">Step Two</h3>
        <h2 class="fs-title">Self-introduction</h2>

        <label>男 <input type="radio" name="sex" value="男"/>

        </label>

        <label>女<input type="radio" name="sex" value="女"/></label>

        <input type="date" name="birthday" placeholder="Birthday"/>
        <input type="text" name="email" placeholder="Email/Phone"/>
        <input type="text" name="name" placeholder="Your nicknames:"/>
        <br><br>
        <input type="button" name="previous" class="previous action-button1" value="Previous Step"/>
        <input type="button" name="next" class="next action-button" value="Next Step"/>
    </fieldset>
    <fieldset>
        <h3 class="fs-subtitle">Step Three</h3>
        <h2 class="fs-title">Education information</h2>
        <input type="text" name="profession" placeholder="Profession"/>
        <input type="text" name="education background" placeholder="Education background"/>
        <input type="text" name="grade" placeholder="Grade"/>
        <br><br>
        <input type="button" name="previous" class="previous action-button1" value="Previous Step"/>
        <input type="submit"  class="action-button" value="Submit"/>


    </fieldset>
    </form>

</article>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script>window.jQuery || document.write('<script src="js/jquery-2.1.1.min.js"><\/script>')</script>
<script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
<script>
    var current_fs, next_fs, previous_fs;
    var left, opacity, scale;
    var animating;
    $('.next').click(function () {
        if (animating)
            return false;
        animating = true;
        current_fs = $(this).parent();
        next_fs = $(this).parent().next();
        $('#progressbar li').eq($('fieldset').index(next_fs)).addClass('active');
        next_fs.show();
        current_fs.animate({opacity: 0}, {
            step: function (now, mx) {
                scale = 1 - (1 - now) * 0.2;
                left = now * 50 + '%';
                opacity = 1 - now;
                current_fs.css({'transform': 'scale(' + scale + ')'});
                next_fs.css({
                    'left': left,
                    'opacity': opacity
                });
            },
            duration: 800,
            complete: function () {
                current_fs.hide();
                animating = false;
            },
            easing: 'easeInOutBack'
        });
    });
    $('.previous').click(function () {
        if (animating)
            return false;
        animating = true;
        current_fs = $(this).parent();
        previous_fs = $(this).parent().prev();
        $('#progressbar li').eq($('fieldset').index(current_fs)).removeClass('active');
        previous_fs.show();
        current_fs.animate({opacity: 0}, {
            step: function (now, mx) {
                scale = 0.8 + (1 - now) * 0.2;
                left = (1 - now) * 50 + '%';
                opacity = 1 - now;
                current_fs.css({'left': left});
                previous_fs.css({
                    'transform': 'scale(' + scale + ')',
                    'opacity': opacity
                });
            },
            duration: 800,
            complete: function () {
                current_fs.hide();
                animating = false;
            },
            easing: 'easeInOutBack'
        });
    });
    $('.submit').click(function () {
        return false;
    });
</script>
</body>
</html>