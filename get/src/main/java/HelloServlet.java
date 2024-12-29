
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码格式
        req.setCharacterEncoding("UTF-8");
        // 设置响应编码格式
        resp.setContentType("text/html;charset=UTF-8");
        // 获取请求参数
        String name = req.getParameter("name");
        // 获取响应输出流
        resp.getWriter().append("<h1>你好！" + name + "</h1>");
        // 获取多个同名参数
        String[] hobbies = req.getParameterValues("hobby");
        if (hobbies != null) {
            resp.getWriter().append("<h2>爱好：</h2>");
            resp.getWriter().append("<ul>");
            for (String hobby : hobbies) {
                resp.getWriter().append("<li>" + hobby + "</li>");
            }
            resp.getWriter().append("</ul>");
        }
    }
}
