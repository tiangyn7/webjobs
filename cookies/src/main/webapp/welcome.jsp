<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="javax.servlet.http.Cookie" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>欢迎页面</title>
        </head>

        <body>
            <% // 获取请求中的 Cookies Cookie[] cookies=request.getCookies(); String username=null; // 查找名为 "username" 的
                Cookie if (cookies !=null) { for (Cookie cookie : cookies) { if ("username".equals(cookie.getName())) {
                username=cookie.getValue(); break; } } } if (username !=null) { // 用户已登录，显示欢迎信息 %>
                <h1>欢迎你，<%= username %>！</h1>
                <p>这是我的博客首页</p>
                <% } else { // 用户未登录，提示并倒计时跳转到登录页面 %>
                    <h1>您尚未登录！</h1>
                    <p>页面将在 <span id="countdown">5</span> 秒后跳转到登录页面。</p>
                    <script type="text/javascript">
                        var count = 5;
                        var countdown = document.getElementById("countdown");
                        var interval = setInterval(function () {
                            count--;
                            countdown.textContent = count;
                            if (count <= 0) {
                                clearInterval(interval);
                                window.location.href = "login.jsp";
                            }
                        }, 1000);
                    </script>
                    <% } %>
        </body>

        </html>