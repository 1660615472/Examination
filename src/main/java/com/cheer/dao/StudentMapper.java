package com.cheer.dao;

import com.cheer.model.StudentInfo;

public interface StudentMapper {
 StudentInfo getStudentOne(Integer ecn);
boolean checkLogin(Integer ecn,String password );
int upDateStudnet(StudentInfo studentInfo);
}
