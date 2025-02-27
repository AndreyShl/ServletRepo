package com.acadamy.controller;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String path = getServletContext().getRealPath("/html/Main.html");

        String htmlContent = new String(Files.readAllBytes(Paths.get(path)));

        response.getWriter().write(htmlContent);

    }
}
