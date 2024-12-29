package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; // 导入 HttpSession 类

@WebServlet("/SessionLoginServlet")
public class SessionLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 假定的用户名和密码
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123456";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置请求和响应的编码格式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 验证用户名和密码
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            // 获取或创建 Session 对象
            HttpSession session = request.getSession();
            // 将用户名保存到 Session 中
            session.setAttribute("username", username);
            // 跳转到欢迎页面
            response.sendRedirect("sessionWelcome.jsp");
        } else {
            // 登录失败，跳转回登录页面
            response.sendRedirect("sessionLogin.jsp");
        }
    }
}