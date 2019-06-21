package com.cheer.service.impl;

import com.cheer.dao.QuestionMapper;
import com.cheer.model.Question;
import com.cheer.web.servlet.AdminLoginServlet;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class QuestionMapperImpl implements QuestionMapper {
    private static final Logger LOGGER = LogManager.getLogger ( AdminLoginServlet.class );
    @Override
    public int insertQuestion(Question question) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSession session = null;
        int i=0;
        try {

            //1、获取SqlSessionFactory
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder ().build(inputStream);
            //2.获取Sqlsession对象
            session = sqlSessionFactory.openSession();
            QuestionMapper empMapper = session.getMapper(QuestionMapper.class);
            i=empMapper.insertQuestion ( question );
            session.commit();
            LOGGER.info(i);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    @Override //获取题目集合的方法
    public List<Question> getQuestionList() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSession session = null;
        List<Question> question=null;
        try {

            //1、获取SqlSessionFactory
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //2.获取Sqlsession对象
            session = sqlSessionFactory.openSession();
           QuestionMapper empMapper = session.getMapper(QuestionMapper.class);
            question=empMapper.getQuestionList ();
            session.commit();
            LOGGER.info(question);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return question;
    }





    @Override
    public int update(Question question) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSession session = null;
        int i=0;
        try {

            //1、获取SqlSessionFactory
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //2.获取Sqlsession对象
            session = sqlSessionFactory.openSession();
            QuestionMapper empMapper = session.getMapper(QuestionMapper.class);
            i=empMapper.update(question);
            session.commit();
            LOGGER.info(question);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }






    @Override
    public List<String> getKey() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSession session = null;
        List<String> x=null;//得到的正确答案集合
        try {

            //1、获取SqlSessionFactory
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //2.获取Sqlsession对象
            session = sqlSessionFactory.openSession();
            QuestionMapper empMapper = session.getMapper(QuestionMapper.class);
            x=empMapper.getKey();

            LOGGER.info(x);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return x;
    }
}
