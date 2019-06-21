package com.cheer.web.servlet;

import com.cheer.service.impl.StudentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "StudentLoginServlet", urlPatterns = "/servlet/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger ( AdminLoginServlet.class );
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding ( "UTF-8" );
        response.setContentType ( "application/json" );
        String ecn = request.getParameter ( "ecn" );
        int ecn1 = Integer.valueOf ( ecn );//转换成int类型
        String passwrod = request.getParameter ( "password" );
        //判断学生数据库里有没有这个账号
        StudentServiceImpl studentMapper = new StudentServiceImpl ();
        if(studentMapper.checkStudentLogin ( ecn1,passwrod )){
            LOGGER.debug ( "登录成功！" );
            //登陆成功以后把学生准考信息写到session域中
          HttpSession studentSession = request.getSession ();
          studentSession.setAttribute ( "ecn",ecn );
          studentSession.setAttribute ( "password",passwrod );
            response.sendRedirect ( "../examinationPage1.html" );
        }else {//学号密码不对就返回学生登陆界面
            LOGGER.debug ( "登陆失败" );
            response.sendRedirect ( "../studentLogin" );
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost ( request, response );
    }
}
