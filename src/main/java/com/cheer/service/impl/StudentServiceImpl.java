package com.cheer.service.impl;

import com.cheer.dao.QuestionMapper;
import com.cheer.dao.StudentMapper;
import com.cheer.model.StudentInfo;
import com.cheer.service.StudentInfoService;
import com.cheer.utils.MybatisUtils;
import com.cheer.utils.StringUtils;
import org.apache.ibatis.session.SqlSession;

/*学生信息dao实现类*/
public class StudentServiceImpl implements StudentInfoService {
    QuestionMapper subjectMapper = new QuestionMapperImpl ();

    StudentMapper studentMapper = new StudentMapperImpl ();

    @Override
    public StudentInfo getStudentInfo(Integer ecn) {
       SqlSession session = MybatisUtils.getSqlSession ();
     StudentInfo studentInfo = session.getMapper ( StudentMapper.class ).getStudentOne ( ecn );
     MybatisUtils.closeSqlSession ( session );
     return studentInfo;
    }

    //检查登录，实现dao接口
    public boolean checkStudentLogin(Integer ecn,String password){
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

    //跟新学生信息 插到数据库方法
    @Override
    public int update(StudentInfo studentInfo) {
        int i = studentMapper.upDateStudnet ( studentInfo );
        return i;
    }
}
