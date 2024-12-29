package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter(filterName = "AFilter", urlPatterns = { "/AFilter", "*.do", "/test/*" })
public class AFilter extends HttpFilter {

    public AFilter() {
        super();
        System.out.println("filter 的构造方法被执行");
    }

    @Override
    public void destroy() {
        System.out.println("filter 的销毁方法被执行");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // place your code here

        System.out.println("doFilter 前的代码");
        // pass the request along the filter chain
        chain.doFilter(request, response);
        System.out.println("doFilter 后的代码");
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("filter 的初始化方法");
    }
}