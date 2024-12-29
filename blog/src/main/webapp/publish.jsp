<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>发布博客</title>
    </head>

    <body>
        <h1>发布博客</h1>
        <form action="publish" method="post">
            标题：<input type="text" name="title"><br>
            内容：<textarea name="content" rows="5" cols="30"></textarea><br>
            <input type="submit" value="发布">
        </form>
        <% if (request.getAttribute("message") !=null) { %>
            <p style="color:red;">
                <%= request.getAttribute("message") %>
            </p>
            <% } %>
    </body>

    </html>