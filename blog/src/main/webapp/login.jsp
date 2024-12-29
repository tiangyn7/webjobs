<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>用户登录</title>
    </head>

    <body>
        <h1>用户登录</h1>
        <form action="login" method="post">
            用户名：<input type="text" name="username"><br>
            密 码：<input type="password" name="password"><br>
            <input type="submit" value="登录">
        </form>
        <% if (request.getAttribute("message") !=null) { %>
            <p style="color:red;">
                <%= request.getAttribute("message") %>
            </p>
            <% } %>
    </body>

    </html>