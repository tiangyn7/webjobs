<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>登录页面</title>
    </head>

    <body>
        <h1>用户登录</h1>
        <form action="LoginServlet" method="post">
            用户名：<input type="text" name="username"><br><br>
            密码：<input type="password" name="password"><br><br>

            <!-- 会话控制选项 -->
            <fieldset>
                <legend>会话控制：</legend>
                <input type="radio" name="session" value="session" checked> 会话（Session）<br>
                <input type="radio" name="session" value="persistent"> 持久（Persistent）<br>
                <input type="radio" name="session" value="delete"> 删除（Delete）<br>
            </fieldset><br>

            <!-- 生效范围选项 -->
            <fieldset>
                <legend>生效范围：</legend>
                <input type="radio" name="scope" value="current" checked> 当前路径<br>
                <input type="radio" name="scope" value="root"> 根路径<br>
                <input type="radio" name="scope" value="domain"> 当前域名<br>
            </fieldset><br>

            <input type="submit" value="登录">
        </form>
    </body>

    </html>