package com.lancer.servlet;

import entity.InformationTable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        InformationTable informationTable=new InformationTable();
        informationTable.setTelephone(request.getParameter("telephone"));
        informationTable.setStudentId(request.getParameter("student_id"));
        informationTable.setTeacherId(request.getParameter("teacher_id"));
        informationTable.setQq(request.getParameter("qq"));
        informationTable.setName(request.getParameter("name"));
        informationTable.setEmail(request.getParameter("email"));
        request.setAttribute("information",informationTable);
        request.getRequestDispatcher("/jsp/doupdate.jsp").forward(request,response);
    }
}
