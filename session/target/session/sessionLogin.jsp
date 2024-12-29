<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Session 登录页面</title>
    </head>

    <body>
        <h1>Session 登录页面</h1>
        <form action="SessionLoginServlet" method="post">
            用户名：<input type="text" name="username"><br>
            密码：<input type="password" name="password"><br><br>
            <input type="submit" value="登录">
        </form>
    </body>

    </html>