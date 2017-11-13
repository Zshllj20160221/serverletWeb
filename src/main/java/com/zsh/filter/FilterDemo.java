package com.zsh.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zsh on 2017/11/13.
 */
public class FilterDemo implements Filter{

    private String encoding;
    private Map<String,String> params = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterDemo init(FilterConfig filterConfig)........");
        encoding = filterConfig.getInitParameter("encoding");
        for(Enumeration e = filterConfig.getInitParameterNames();e.hasMoreElements();){
            String name = (String) e.nextElement();
            String value = filterConfig.getInitParameter(name);
            params.put(name,value);
        }

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FilterDemo doFilter(ServletRequest request, ServletResponse response, FilterChain chain).....");
        System.out.println("before encoding ...");
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType("text/html; charset=utf-8");
        chain.doFilter(request,response);
        System.out.println("after encoding......");

    }

    @Override
    public void destroy() {
        System.out.println("FilterDemo destroy().....");
        params = null;
        encoding = null;
        System.out.println();
    }
}
