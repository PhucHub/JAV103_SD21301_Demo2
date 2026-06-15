package com.jav103.jav103_sum25_demo2.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "FilterDemo", urlPatterns = "/filterInput")
public class FilterDemo implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String method = request.getMethod();

        if ("GET".equalsIgnoreCase(method)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }


        String username = request.getParameter("username");
        String password = request.getParameter("password");


        if (username == null || password == null) {
            request.setAttribute("errorMessage", "Vui lòng nhập đầy đủ thông tin!");
            request.getRequestDispatcher("/views/filter/login.jsp").forward(request, response);
            return;
        }


        if (username.equals("admin") && password.equals("123456")) {

            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", username);

            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            request.setAttribute("errorMessage", "Sai tên đăng nhập hoặc mật khẩu!");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/views/filter/login.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
