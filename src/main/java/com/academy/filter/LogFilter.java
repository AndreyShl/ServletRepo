package com.academy.filter;


import com.academy.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("username");

        String url = request.getRequestURI();
        String method = request.getMethod();

        if ((user != null) || (url.contains("/login") && "GET".equalsIgnoreCase(method))) {
            filterChain.doFilter(request, servletResponse);
        }


    }

}