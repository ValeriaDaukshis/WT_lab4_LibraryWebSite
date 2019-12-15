package com.servlet.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class StartPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("file");
        HttpSession session = request.getSession();
        session.setAttribute("fileName", fileName);
        getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
