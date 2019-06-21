package com.cheer.web.servlet;

import com.cheer.service.AdminService;

import com.cheer.service.impl.AdminServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", urlPatterns = "/servlet/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger ( AdminLoginServlet.class );

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding ( "UTF-8" );
        String username = request.getParameter ( "username" );
        String password = request.getParameter ( "password" );
        //判断数据库里面有没有这个账号密码
        AdminService adminService = new AdminServiceImpl ();
        if (adminService.checkLogin ( username, password )) {
            LOGGER.debug ( "登陆成功！" );
            //登陆成功以后把用户名信息写到session域中
            HttpSession session = request.getSession ();
            session.setAttribute ( "username", username );
            //登陆成功跳转到管理者界面（绝对路径）
           /*String absoultPath = request.getContextPath ();
            request.getRequestDispatcher ( absoultPath + "/admin_index.html" ).forward ( request, response );*/
           response.sendRedirect ( "../questionList.html" );


        } else {//账号密码不对就返回管理者登陆界面
            LOGGER.debug ( "登陆失败" );
            response.sendRedirect ( "../adminLogin.html" );
        }
    }
        @Override
        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            this.doPost ( request, response );
        }
    }

