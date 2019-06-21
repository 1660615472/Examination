package com.cheer.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/*这个servlet用来存储题目的学生选择的答案 和第几题*/
@WebServlet(name = "SaveInfoServlet", urlPatterns = "/servlet/SaveInfoServlet")
public class SaveInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding ( "UTF-8" );
        response.setContentType ( "application/json;UTF-8" );
        //获取单个题目的学生选择和题目编号存储到sesion域中
      String value = request.getParameter ( "val" );
        String pageNum = request.getParameter ( "pageNum" );
       HttpSession session = request.getSession ();
       session.setAttribute ( "val",value );
       session.setAttribute ( "pageNum",pageNum );
       //跳转回考试页面
        response.sendRedirect ( "../ExaminationPage.html" );
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost ( request, response );
    }
}
