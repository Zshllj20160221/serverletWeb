package com.zsh.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by zsh on 2017/11/13.
 */
public class LogFilter implements Filter {
    FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter init(FilterConfig filterConfig).....");
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("LogFilter doFilter(ServletRequest request, ServletResponse response, FilterChain chain).....");
//        ServletContext context = this.filterConfig.getServletContext();
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("获取到用户的请求地址："+req.getServletPath());
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("LogFilter destroy()......");
    }
}
