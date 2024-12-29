package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie; // 导入 Cookie 类
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet") // Servlet 的访问路径
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 模拟正确的用户名和密码
    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "123456";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 设置请求和响应的编码格式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取表单提交的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sessionControl = request.getParameter("session");
        String scope = request.getParameter("scope");

        // 验证用户名和密码
        if (CORRECT_USERNAME.equals(username) && CORRECT_PASSWORD.equals(password)) {
            // 登录成功，创建用户名的 Cookie
            Cookie usernameCookie = new Cookie("username", username);

            System.out.println("Cookies的 username 已设置：" + username);
            // 设置会话控制
            if ("persistent".equals(sessionControl)) {
                // 持久性 Cookie，过期时间为1小时（3600秒）
                usernameCookie.setMaxAge(3600);
            } else if ("delete".equals(sessionControl)) {
                // 删除 Cookie，设置 MaxAge 为 0
                usernameCookie.setMaxAge(0);
            } else {
                // 会话级别的 Cookie（浏览器关闭后失效）
                usernameCookie.setMaxAge(-1);
            }
            System.out.println("Cookies的过期时间已设置：" + sessionControl);

            // 设置生效范围
            if ("current".equals(scope)) {
                // 当前路径
                usernameCookie.setPath(request.getContextPath());
            } else if ("root".equals(scope)) {
                // 根路径
                usernameCookie.setPath("/");
            } else if ("domain".equals(scope)) {
                // 当前域名
                usernameCookie.setDomain(request.getServerName());
            }
            System.out.println("Cookies的生效范围已设置：" + scope);

            // 添加 Cookie 到响应
            response.addCookie(usernameCookie);

            // 重定向到欢迎页面。这里实际的过程是：服务器发送一个重定向响应，让浏览器重新请求欢迎页面
            response.sendRedirect("welcome.jsp");
        } else {
            System.out.println("用户登录失败，登录用户名：" + username + "，登录密码：" + password);
            // 登录失败，提示错误信息并返回登录页面
            response.getWriter().println("<script>alert('用户名或密码错误！');window.location.href='login.jsp';</script>");
        }
    }
}
