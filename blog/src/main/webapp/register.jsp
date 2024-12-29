<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>用户注册</title>
    </head>

    <body>
        <h1>用户注册</h1>
        <form action="register" method="post">
            用户名：<input type="text" name="username"><br>
            密 码：<input type="password" name="password"><br>
            邮 箱：<input type="text" name="email"><br>
            <input type="submit" value="注册">
        </form>
        <% if (request.getAttribute("message") !=null) { %>
            <p style="color:red;">
                <%= request.getAttribute("message") %>
            </p>
            <% } %>
    </body>

    </html>