package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter(filterName = "BCDFilter", urlPatterns = "/BCDFilter")
public class BFilter extends HttpFilter {

    public BFilter() {
        super();
        System.out.println("BCDFilter 的构造方法被执行");
    }

    public void destroy() {
        System.out.println("BCDFilter 的销毁方法被执行");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("BCDFilter 进入 chain.doFilter 前执行的代码");

        // pass the request along the filter chain
        chain.doFilter(request, response);

        System.out.println("BCDFilter 退出 chain.doFilter 后执行的代码");
    }

    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("BCDFilter 的初始化方法被执行");
    }

}
