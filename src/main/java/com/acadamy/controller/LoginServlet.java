package com.acadamy.controller;



import com.acadamy.servise.LogService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;


public class LoginServlet extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException  {



            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            String pathToFile = getServletContext().getRealPath("/html/Login.html");

            String htmlContent = new String(Files.readAllBytes(Paths.get(pathToFile)));

            response.getWriter().write(htmlContent);


        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LogService logService = new LogService();

        String login = req.getParameter("username");
        String password = req.getParameter("password");


        if (logService.authenticate(login,password)) {

            resp.sendRedirect("/WebInterpriceTest/main");
        } else {

            resp.setContentType("text/html");
            resp.getWriter().write("<html><body>");
            resp.getWriter().write("<h1>Invalid User or Password</h1>");
            resp.getWriter().write("<a href='/WebInterpriceTest/login'>login again</a>");
            resp.getWriter().write("</body></html>");
        }
    }

}
