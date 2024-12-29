package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求编码格式
        request.setCharacterEncoding("UTF-8");
        // 设置响应编码格式
        response.setContentType("text/html;charset=UTF-8");
        // 获取请求参数
        String name = request.getParameter("name");
        // 获取响应输出流
        response.getWriter().append("<h1>你好！" + name + "</h1>");
        // 获取多个同名参数
        String[] hobbies = request.getParameterValues("hobby");
        if (hobbies != null) {
            response.getWriter().append("<h2>爱好：</h2>");
            response.getWriter().append("<ul>");
            for (String hobby : hobbies) {
                response.getWriter().append("<li>" + hobby + "</li>");
            }
            response.getWriter().append("</ul>");
        }
    }
}
