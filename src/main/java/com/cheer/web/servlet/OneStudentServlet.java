package com.cheer.web.servlet;

import com.cheer.dao.StudentMapper;
import com.cheer.model.StudentInfo;
import com.cheer.service.impl.StudentMapperImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OneStudentServlet", urlPatterns = "/servlet/OneStudentServlet")
public class OneStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setCharacterEncoding ( "UTF-8" );
            response.setContentType ( "application/json");
            //实例化输出
        PrintWriter writer = response.getWriter ();
            //获取seesion中的考生信息
        HttpSession session = request.getSession ();
        Object ecn = session.getAttribute ( "ecn" );
        Integer ecn1 = Integer.valueOf ( ecn.toString () );
        //通过dao获得该考生的信息
        StudentMapper studentMapper = new StudentMapperImpl ();
        StudentInfo studentOne = studentMapper.getStudentOne (ecn1 );
        //把这个学院对象放到list集合里
        List<StudentInfo> studentInfoList = new ArrayList (  );
        studentInfoList.add ( studentOne );
        //使用json格式转换工具GSON
        Gson gson = new Gson ();
        String s = gson.toJson ( studentInfoList );
        writer.println ( s );
        writer.close ();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost ( request, response );
    }
}
