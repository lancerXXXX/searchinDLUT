package com.lancer.servlet;

import Util.PaginationUtil;
import dao.impl.PersonDaoImpl;
import entity.InformationTable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "search")
public class search extends HttpServlet {

    private PersonDaoImpl personDao;
    private PaginationUtil paginationUtil;
    private int countPerPage;

    @Override
    public void init() throws ServletException {
        personDao = new PersonDaoImpl();
        paginationUtil = new PaginationUtil();
        countPerPage = 5;
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        String strs[] = new String[6];
        strs[0] = request.getParameter("telephone");
        strs[1] = request.getParameter("student_id");
        strs[2] = request.getParameter("teacher_id");
        strs[3] = request.getParameter("qq");
        strs[4] = request.getParameter("name");
        strs[5] = request.getParameter("email");
        //获取当前页码,如果没有获取到就赋值为1
        int page;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
            page = 1;
        }
        //获取用户设置的每页结果数,如果没有获取到就赋值为5
        try {
            if (request.getParameter("countPerPage") != null)
                countPerPage = Integer.parseInt(request.getParameter("countPerPage"));
        } catch (NumberFormatException e) {
            countPerPage = 5;
        }
        //判断搜索模式
        int search_type = 0;
        if (strs[1].length() > 0 && strs[2].length() > 0) {
            search_type = 1;
        }
        //判断用户是否没有输入内容
        int strs_flag = 0;
        for (String str : strs) {
            if (str.length() > 0) {
                strs_flag = 1;
            }
        }
        //判断为何搜索
        String type = request.getParameter("type") == null ? "" : request.getParameter("type");
        //如果用户输入了内容,进行搜索
        if (1 == strs_flag || 1 == search_type) {
            List<InformationTable> informationTableList = personDao.ListAll(strs);
            paginationUtil.setTotalCount(informationTableList.size());
            paginationUtil.setCountPerPage(countPerPage);
            Enumeration e = request.getParameterNames();
            String p = null;
            StringBuffer buffer = new StringBuffer();
            StringBuffer buffer1 = new StringBuffer();
            while (e.hasMoreElements()) {
                p = (String) e.nextElement();
                if (!p.equals("page")) {
                    buffer.append(p + "=" + request.getParameter(p) + "&");
                }
                if (!p.equals("page") && !p.equals("countPerPage")) {
                    buffer1.append(p + "=" + request.getParameter(p) + "&");
                }
            }
            request.setAttribute("url", request.getServletPath() + "?" + buffer.toString());
            request.setAttribute("perpageurl", request.getServletPath() + "?" + buffer1.toString());
            request.setAttribute("updateurl", "?" + buffer1.toString());
            request.setAttribute("pagination", paginationUtil);
            request.setAttribute("page", page);
            request.setAttribute("informationList", informationTableList.subList(paginationUtil.getCurrentPageStart(page), paginationUtil.getCurrentPageEnd(page)));
            if (type.equals("delete")) {
                request.getRequestDispatcher("jsp/deletesearch.jsp").forward(request, response);
            } else if (type.equals("update")) {
                request.getRequestDispatcher("jsp/updatesearch.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/jspnofilter/result.jsp").forward(request, response);
            }
        } else {
            PrintWriter out = response.getWriter();
            out.println("请不要什么都不输入或者同时输入教师id和学生id");
        }
    }
}
