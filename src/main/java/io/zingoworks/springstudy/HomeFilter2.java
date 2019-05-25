package io.zingoworks.springstudy;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeFilter2 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("HomeFilter2 호출 전");

        ((HttpServletResponse)servletResponse).setHeader("FilterTest", "in response header");
        filterChain.doFilter(servletRequest, servletResponse);


        System.out.println("HomeFilter2 호출 후");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("HomeFilter2 init");
    }

    @Override
    public void destroy() {

    }
}
