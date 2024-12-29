package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/submitForm") // 拦截表单提交请求
public class ValidationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 可选的初始化操作
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 表单参数校验
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        if (username == null || username.isEmpty()) {
            request.setAttribute("error", "用户名不能为空");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }

        if (email == null || !email.matches("\\w+@\\w+\\.\\w+")) {
            request.setAttribute("error", "邮箱格式不正确");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }

        // 放行请求
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 无需特殊处理
    }
}