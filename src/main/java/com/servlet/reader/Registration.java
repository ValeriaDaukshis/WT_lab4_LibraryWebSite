package com.servlet.reader;

import Beans.User;
import DB.DBController;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class Registration extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("name");
        String userPassword = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");
        byte age = Byte.parseByte(request.getParameter("age"));
        ServletOutputStream out = response.getOutputStream();

        if(!userPassword.equals(repeatPassword)){
            out.println("Passwords are not same!");
        }
        else{
            DBController controller = new DBController();
            if(controller.CompareUser(new User(userName, userPassword))){
                out.println("Change password!");
            }
            else{
                controller.InsertUser(new User(userName, age, userPassword));
            }
            getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
        }
    }
}
