package io.zingoworks.springstudy;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import java.io.IOException;

public class HomeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("HomeFilter1 init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("HomeFilter1 호출 전");

        servletRequest.setAttribute("test", "test test");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println(servletRequest.getAttribute("test"));

        System.out.println("HomeFilter1 호출 후");
    }

    @Override
    public void destroy() {

    }
}
