<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>

    <body>
        <form action="ABCServlet" method="post" enctype="multipart/form-data">
            姓名：
            <input type="text" name="name" placeholder="请输入姓名">
            <br><br>
            兴趣爱好：
            <br>
            <input type="checkbox" name="hobby" value="唱">唱
            <input type="checkbox" name="hobby" value="跳">跳
            <input type="checkbox" name="hobby" value="rap">rap
            <input type="checkbox" name="hobby" value="打篮球">打篮球
            <br><br>
            上传文件：
            <input type="file" name="file" multiple>
            <br><br>
            <input type="submit" value="提交">
        </form>
    </body>

    </html>