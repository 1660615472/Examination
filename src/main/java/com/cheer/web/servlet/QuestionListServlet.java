package com.cheer.web.servlet;

import com.cheer.service.impl.QuestionServiceImpl;
import com.cheer.model.Question;
import com.cheer.service.QuestionService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuestionListServlet", urlPatterns = "/servlet/QuestionListServlet")
public class QuestionListServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding ( "UTF-8" );//设置响应编码格式
        response.setContentType ( "application/json" );//设置响应文本格式
        PrintWriter writer = response.getWriter ();//实例化打印前台界面对象
        QuestionService questionMapper = new QuestionServiceImpl ();//获得dao方法
        List<Question> questionList = questionMapper.getQuestionList ();
        Gson gson = new Gson();
        String s = gson.toJson ( questionList );//把Question集合转化成json格式的字符串发送到前台
        writer.println ( s );
        writer.close ();//关闭流

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost ( request, response );
    }
}
