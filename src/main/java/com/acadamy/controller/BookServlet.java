package com.acadamy.controller;

import com.acadamy.model.Book;
import com.acadamy.servise.BookService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


public class BookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = String.valueOf(Integer.parseInt(request.getParameter("id")));
        response.setContentType("text/html");

        BookService bookService = new BookService();
        Book book=bookService.getBookById(Integer.parseInt(id));


        PrintWriter out =response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Book Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Book Page</h1>");
        out.println(book);

        out.println("</body>");
        out.println("</html>");
    }
}
