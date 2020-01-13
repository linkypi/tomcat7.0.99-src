package com.lynch.simple;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SimpleServlet implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("my servlet init ...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)req;
        System.out.println("request method: "+ request.getMethod());
        PrintWriter pw = res.getWriter();
        pw.println("hello my servlet");
        pw.flush();
        pw.close();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
