package com.cheer.service;

import com.cheer.model.StudentInfo;

public interface StudentInfoService {
    StudentInfo getStudentInfo(Integer ecn);

    boolean checkStudentLogin(Integer ecn,String password);

    int update(StudentInfo studentInfo);
}
