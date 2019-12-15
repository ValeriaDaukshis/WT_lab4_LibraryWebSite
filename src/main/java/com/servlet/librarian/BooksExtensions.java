package com.servlet.librarian;

import Beans.Book;
import DB.DBController;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/booksExtensions")
public class BooksExtensions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String description = request.getParameter("description");
        int count = Integer.parseInt(request.getParameter("count"));
        int pages = Integer.parseInt(request.getParameter("pages"));

        DBController controller = new DBController();
        controller.InsertBook(new Book(name, author, count, description, pages));

        ServletOutputStream out = response.getOutputStream();
        out.println("Book was inserted to db");
    }
}
