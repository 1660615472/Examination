package com.cheer.web.servlet;

import com.cheer.service.impl.QuestionServiceImpl;
import com.cheer.service.impl.StudentServiceImpl;
import com.cheer.model.StudentInfo;
import com.cheer.service.QuestionService;
import com.cheer.service.StudentInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AnswerServlet", urlPatterns = "/servlet/AnswerServlet")
public class AnswerServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger ( AdminLoginServlet.class );
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码格式:
        request.setCharacterEncoding("utf-8");
        //设置响应编码格式
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //获取session对象
        HttpSession session=request.getSession();
        Object ecn = session.getAttribute ( "ecn" );//通过session获取这个学生的学号
        Integer ecn1 = Integer.valueOf ( ecn.toString () );
        String password = (String)session.getAttribute ( "password" );
        QuestionService questionService = new QuestionServiceImpl ();

        String[] answer = request.getParameterValues("answer");//获取前台ajax的答案数组
        for(int i =0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
        if(answer!=null){
            System.out.println("获取成功");
        }else {
            System.out.println ("获取失败");
        }

        //拿到数据库的答案和数组里的答案做对比
        List<String> answerList = questionService.getKey ();
        int t=0;//答对数量
        int f=0;//打错数量
        double score=0;//总分
        String qualified =null;//是否合格
        for(int i =0 ;i<answer.length;i++){
            if(answer[i].equals ( answerList.get ( i ).split("：")[1]) ){
                t++;
                score+=16.6;//答对一次总分+16.6
            }else {
                f++;
            }
        }
        if(score>=66){
            qualified="合格";
        }else {
            qualified="不合格";
        }

        StudentInfo studentInfo = new StudentInfo (t,f,score,qualified,ecn1);
        StudentInfoService studentService = new StudentServiceImpl ();
        int update = studentService.update ( studentInfo );
         writer.println(update);
        writer.close();



    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost ( request, response );
    }
}
