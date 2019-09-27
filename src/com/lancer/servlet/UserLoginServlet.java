package com.lancer.servlet;

import dao.impl.PersonDaoImpl;
import entity.InformationTable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String student_id=request.getParameter("student_id");
        String teacher_id=request.getParameter("teacher_id");
        PersonDaoImpl personDao=new PersonDaoImpl();
        try {
            List<InformationTable> informationTableList=new ArrayList<>();
            informationTableList=personDao.find(student_id,teacher_id);
            if (informationTableList.size()==0){
                out.println("登录失败");
            }else {
                HttpSession session=request.getSession();
                session.setAttribute("client",student_id+teacher_id);
                request.setAttribute("informationtable", informationTableList.get(0));
                request.getRequestDispatcher("/userjsp/userinformation.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
