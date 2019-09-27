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

@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String[] informations=new String[6];
        String p=null;
        Enumeration enumeration=request.getParameterNames();
        int i=0;
        while (enumeration.hasMoreElements()){
            p= (String) enumeration.nextElement();
            informations[i]=request.getParameter(p);
            i++;
        }
        PrintWriter out=response.getWriter();
        if (request.getParameter("student_id").length()>0&&request.getParameter("teacher_id").length()>0){
            out.println("请不要同时填写   学生id和教师id");
        }else{
            PersonDaoImpl personDao=new PersonDaoImpl();
            try {
                personDao.AddInformation(informations);
                out.println("添加成功");
            } catch (SQLException e) {
                out.println("添加失败");
                e.printStackTrace();
            }
        }
    }
}
