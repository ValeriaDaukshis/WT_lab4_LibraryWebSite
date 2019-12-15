package com.servlet.reader;

import Beans.Book;
import DB.DBController;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mainReader")
public class MainReader extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBController controller = new DBController();
        List<Book> list = controller.ReadBooksFromDB();
        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/mainReader.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String book = request.getParameter("book");
        String remove = request.getParameter("remove");
        DBController controller = new DBController();

        if(book != null){
            //controller.AddBookToUser();
            getServletContext().getRequestDispatcher("/successAddBook.jsp").forward(request, response);
        }
        else if(remove != null){
            //controller.DeleteBookFromUser();
            getServletContext().getRequestDispatcher("/successRemoveBook.jsp").forward(request, response);
        }
        else {
            List<Book> list = controller.ReadBooksFromDB();
            request.setAttribute("list", list);
            getServletContext().getRequestDispatcher("/mainReader.jsp").forward(request, response);
        }
    }
}
