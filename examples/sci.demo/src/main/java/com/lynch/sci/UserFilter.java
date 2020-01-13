package com.lynch.sci;

import javax.servlet.*;
import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("user filter init ....");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("user filter doFilter ....");
    }

    @Override
    public void destroy() {
        System.out.println("user filter destroy ....");
    }
}
