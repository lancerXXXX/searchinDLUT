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

@WebServlet(name = "DoUpdateServlet")
public class DoUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String strs[] = new String[6];
        strs[0] = request.getParameter("telephone");
        strs[1] = request.getParameter("student_id");
        strs[2] = request.getParameter("teacher_id");
        strs[3] = request.getParameter("qq");
        strs[4] = request.getParameter("name");
        strs[5] = request.getParameter("email");
        PersonDaoImpl personDao=new PersonDaoImpl();
        PrintWriter out=response.getWriter();
        try {
            personDao.UpdateInformation(strs);
            out.println("更新成功");
        } catch (SQLException e) {
            out.println("更新失败");
            e.printStackTrace();
        }
    }
}
