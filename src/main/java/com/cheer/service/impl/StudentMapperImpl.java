package com.cheer.service.impl;

import com.cheer.dao.StudentMapper;
import com.cheer.model.StudentInfo;
import com.cheer.utils.MybatisUtils;
import com.cheer.utils.StringUtils;
import org.apache.ibatis.session.SqlSession;

public class StudentMapperImpl implements StudentMapper {//

    @Override
    public StudentInfo getStudentOne(Integer ecn) {
        SqlSession sqlSession = MybatisUtils.getSqlSession ();
        StudentInfo studentOne = sqlSession.getMapper ( StudentMapper.class ).getStudentOne ( ecn );
        MybatisUtils.closeSqlSession ( sqlSession );
        if(studentOne!=null){
            System.out.println("找到这个学员信息了");
        }else {
            System.out.println("没有找到该学员");
        }

        return studentOne;
    }

    @Override
    public boolean checkLogin(Integer ecn, String password) {
        SqlSession session = MybatisUtils.getSqlSession ();
        StudentInfo student = session.getMapper ( StudentMapper.class ).getStudentOne ( ecn );
        MybatisUtils.closeSqlSession ( session );
        if(student == null){
            return false;
        }

        if(StringUtils.encrypt ( password ).equals ( student.getPassword () )){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int upDateStudnet(StudentInfo studentInfo) {
        SqlSession sqlSession = MybatisUtils.getSqlSession ();
        int i = sqlSession.getMapper ( StudentMapper.class ).upDateStudnet ( studentInfo );
        MybatisUtils.closeSqlSession ( sqlSession );
        if(i==1){
            System.out.println("更新成功");
        }else {
           System.out.println("更新失败");
        }
        return i;
    }
}
