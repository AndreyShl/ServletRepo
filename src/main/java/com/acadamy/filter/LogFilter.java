package com.acadamy.filter;


import com.acadamy.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class LogFilter implements Filter {
    private final Set<String> excludedPaths = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        excludedPaths.add("/login");
        excludedPaths.add("/register");
        excludedPaths.add("/public");

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String url = request.getRequestURI();
        String method = request.getMethod();

        if ((user != null) || (url.contains("/login") && "GET".equalsIgnoreCase(method))) {
            filterChain.doFilter(request, servletResponse);
        }
//        if (request instanceof HttpServletRequest httpRequest) {
//            String path = httpRequest.getServletPath();
//
//
//            if (excludedPaths.contains(path)) {
//                filterChain.doFilter(request, servletResponse);
//
//            }
//
//
//        }
//
//        filterChain.doFilter(request, servletResponse);

//        Хотел тут сделать что бы определённые url не проверялись фильтром но не работает


    }

}