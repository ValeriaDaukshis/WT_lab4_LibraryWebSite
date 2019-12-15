package com.servlet.reader;

import Beans.Book;
import DB.DBController;
import DB.DataBaseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        HttpSession session = request.getSession();

        if(book != null){
            controller.AddBookToUser(session.getAttribute("name").toString(), book);
            Book b = controller.GetBook(book);
            if(b.getCount() > 0){
                controller.UpdateBook(b.getCount()-1, b.getName(), b.getAuthor());
                DataBaseDao.close();
                getServletContext().getRequestDispatcher("/successAddBook.jsp").forward(request, response);
            }
            else{
                DataBaseDao.close();
                getServletContext().getRequestDispatcher("/notSuccessAddBook.jsp").forward(request, response);
            }

        }
        else if(remove != null){
            controller.DeleteBookFromUser(session.getAttribute("name").toString(), remove);
            Book b = controller.GetBook(book);
            controller.UpdateBook(b.getCount()+1, b.getName(), b.getAuthor());
            DataBaseDao.close();
            getServletContext().getRequestDispatcher("/successRemoveBook.jsp").forward(request, response);
        }
        else {
            List<Book> list = controller.ReadBooksFromDB();
            DataBaseDao.close();
            request.setAttribute("list", list);
            getServletContext().getRequestDispatcher("/mainReader.jsp").forward(request, response);
        }
    }
}
