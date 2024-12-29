package controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AServlet")
public class AServlet extends HttpServlet {

    // 已存在的用户名
    private String[] users = { "张三", "李四", "王五" };

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应类型为文本，字符编码为 UTF-8
        response.setContentType("text/plain;charset=utf-8");

        // 获取请求参数中的 "todo" 值
        String todo = request.getParameter("todo");

        if ("check".equals(todo)) {
            // 检查用户名是否已存在
            String username = request.getParameter("username");
            boolean exists = Arrays.asList(users).contains(username);
            response.getWriter().write(exists ? "用户名已存在" : "用户名可用");
        } else if ("register".equals(todo)) {
            // 模拟注册功能（此处可以扩展为数据库插入逻辑）
            response.getWriter().write("注册成功");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应类型为 HTML，字符编码为 UTF-8
        response.setContentType("text/html;charset=utf-8");

        // 随机返回一条新闻标题
        String[] news = { "新闻1", "新闻2", "新闻3" };
        int index = (int) (Math.random() * news.length);
        String title = news[index];

        // 将新闻标题返回给前端
        response.getWriter().write("<h3>" + title + "</h3>");
    }
}
