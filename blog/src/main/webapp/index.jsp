<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>博客主页</title>
    </head>

    <body>
        <h1>欢迎来到博客系统</h1>
        <% HttpSession session=request.getSession(); model.User user=(model.User) session.getAttribute("currentUser");
            if (user !=null) { %>
            欢迎你，<%= user.getUsername() %>！<br>
                <a href="publish.jsp">发布博客</a> | <a href="login.jsp?logout=true">注销</a>
                <% } else { %>
                    <a href="login.jsp">登录</a> | <a href="register.jsp">注册</a>
                    <% } %>

                        <p>这里将来可以显示博客列表...</p>
    </body>

    </html>