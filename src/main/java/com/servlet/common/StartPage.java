package com.servlet.common;

import Beans.Librarian;
import Beans.User;
import DB.DBController;
import DB.DataBaseDao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/index")
public class StartPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("name");
        String userPassword = request.getParameter("password");

        DBController controller = new DBController();
        if(controller.CompareLibrarian(new Librarian(userName, userPassword))){
            HttpSession session = request.getSession();
            session.setAttribute("name", userName);
            session.setAttribute("password", userPassword);
            getServletContext().getRequestDispatcher("/mainLibrarian.jsp").forward(request, response);
        }

        if(controller.CompareUser(new User(userName, userPassword))){
            HttpSession session = request.getSession();
            session.setAttribute("name", userName);
            session.setAttribute("password", userPassword);
            getServletContext().getRequestDispatcher("/mainReader.jsp").forward(request, response);
        }
        request.setAttribute("error", "Wrong name or password");
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
