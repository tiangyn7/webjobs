package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求编码格式
        request.setCharacterEncoding("UTF-8");
        // 设置响应编码格式
        response.setContentType("text/html;charset=UTF-8");

        // 手动设置响应头 
        response.setHeader("Content-Type", "text/html; charset=UTF-8");   // 设置响应数据的类型和编码格式
        response.setHeader("Content-Length", "1024");   // 设置响应数据的长度
        response.setHeader("Content-Encoding", "gzip");  // 设置响应数据的编码格式
        response.setHeader("Content-Language", "zh-CN");    // 设置响应数据的语言
        response.setHeader("Transfer-Encoding", "chunked");      // 设置响应数据的传输编码
        response.setHeader("Location", "http://example.com");  // 设置响应数据的重定向地址
        response.setHeader("Refresh", "5");           // 设置响应数据的刷新时间
        response.setHeader("Set-Cookie", "name=abc");                   // 设置响应数据的 Cookie 信息
        response.setHeader("Expires", "Thu, 01 Dec 2022 16:00:00 GMT");  // 设置响应数据的过期时间
        response.setHeader("Cache-Control", "no-cache"); // 设置响应数据的缓存策略
        response.setHeader("Pragma", "no-cache");       // 设置响应数据的缓存策略
        response.setHeader("Connection", "keep-alive");    // 设置响应数据的连接类型
        response.setHeader("Date", new Date().toString()); // 设置响应数据的日期
        response.setHeader("Server", "Apache");                             // 设置响应数据的服务器类型

        // 获取响应输出流
        PrintWriter writer = response.getWriter();
        // 生成HTML代码
        writer.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>HTTP响应</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>HTTP响应</h1>")
                .append("</body>")
                .append("</html>");
    }
}