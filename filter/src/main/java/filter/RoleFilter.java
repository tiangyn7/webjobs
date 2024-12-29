package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*") // 拦截所有请求
public class RoleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 可选的初始化操作
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 权限控制
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        String role = (String) req.getSession().getAttribute("role");

        if (uri.startsWith(req.getContextPath() + "/admin/")) {
            // 需要管理员权限
            if ("admin".equals(role)) {
                chain.doFilter(request, response);
            } else {
                ((HttpServletResponse) response).sendRedirect(req.getContextPath() + "/no_permission.jsp");
            }
        } else {
            // 其他资源，无需特殊权限
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // 无需特殊处理
    }
}