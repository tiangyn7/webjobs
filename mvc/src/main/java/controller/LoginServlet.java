package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 设置请求编码
        request.setCharacterEncoding("UTF-8");

        // 获取请求参数
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        // 封装成 User 对象
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);

        // 调用业务逻辑
        if (userService.validateUser(user)) {
            // 登录成功，跳转到欢迎页面
            request.setAttribute("userName", userName);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            // 登录失败，返回登录页面
            request.setAttribute("errorMsg", "用户名或密码错误！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}