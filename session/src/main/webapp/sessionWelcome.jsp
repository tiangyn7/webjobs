<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Session 欢迎页面</title>
        <script type="text/javascript">
            var count = 5;
            function countdown() {
                if (count == 0) {
                    window.location.href = "sessionLogin.jsp";
                } else {
                    document.getElementById("countdown").innerHTML = count;
                    count--;
                    setTimeout(countdown, 1000);
                }
            }
        </script>
    </head>

    <body>
        <h1>Session 欢迎页面</h1>
        <% // 获取 Session 对象 HttpSession session=request.getSession(false); // 参数为 false 时，如果没有 Session，不会创建新的 if
            (session !=null && session.getAttribute("username") !=null) { String username=(String)
            session.getAttribute("username"); %>
            <p>欢迎你，<b>
                    <%= username %>
                </b>！</p>
            <p>你已成功登录。</p>
            <% } else { %>
                <p>你还未登录！</p>
                <p><span id="countdown">5</span> 秒后跳转到登录页面。</p>
                <script type="text/javascript">
                    countdown();
                </script>
                <% } %>
    </body>

    </html>