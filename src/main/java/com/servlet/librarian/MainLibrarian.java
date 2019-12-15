package com.servlet.librarian;

import Beans.Book;
import DB.DBController;
import DB.DataBaseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mainLibrarian")
public class MainLibrarian extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBController controller = new DBController();
        List<Book> list = controller.ReadBooksFromDB();
        DataBaseDao.close();
        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/mainLibrarian.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addBook = request.getParameter("addBook");
        String deleteBook = request.getParameter("deleteBook");
        DBController controller = new DBController();

        if(addBook != null){
            DataBaseDao.close();
            getServletContext().getRequestDispatcher("/addBookByLibrarian.jsp").forward(request, response);
        }
        else if(deleteBook != null){
            controller.DeleteBook(deleteBook);
            DataBaseDao.close();
            getServletContext().getRequestDispatcher("/successRemoveBook.jsp").forward(request, response);
        }
        else {
            List<Book> list = controller.ReadBooksFromDB();
            request.setAttribute("list", list);
            DataBaseDao.close();
            getServletContext().getRequestDispatcher("/mainLibrarian.jsp").forward(request, response);
        }
    }
}
