package com.zsh;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zsh on 2017/11/13.
 */
public class ServletDemo extends HttpServlet {
    public ServletDemo() {
        super();
        System.out.println("ServletDemo()...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req, resp);
        System.out.println("doGet()..........");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String action = req.getParameter("action");
        if ("login_input".equals(action)) {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
//            return;
        } else if ("login".equals(action)) {
            String name = req.getParameter("name");
            String password = req.getParameter("password");

            System.out.println("name->" + name + ",password->" + password);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy()........");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("init(config)......");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init()............");
        super.init();
    }
}
