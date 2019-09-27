package com.lancer.servlet;

import dao.impl.PersonDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String[] informations=new String[2];
        String student_id=request.getParameter("student_id");
        String teacher_id=request.getParameter("teacher_id");
        informations[0]=request.getParameter("student_id").length()==0?"-1":request.getParameter("student_id");
        informations[1]=request.getParameter("teacher_id").length()==0?"-1":request.getParameter("teacher_id");
        PersonDaoImpl personDao=new PersonDaoImpl();
        PrintWriter out=response.getWriter();
        try {
            personDao.DeleteInformation(informations);
            out.println("删除成功");
        } catch (SQLException e) {
            out.println("删除失败");
            e.printStackTrace();
        }
    }
}
