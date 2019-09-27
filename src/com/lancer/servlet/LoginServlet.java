package com.lancer.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String password=request.getParameter("password");

        if ("admin".equals(name)&&"123".equals(password)){
            HttpSession session=request.getSession();
            session.setAttribute("user","admin");
            request.getRequestDispatcher("/jsp/success.jsp").forward(request,response);
        }else{
            response.setStatus(301);
            response.setHeader("Location",request.getContextPath()+"/jsp/fail.jsp");
        }

    }
}
