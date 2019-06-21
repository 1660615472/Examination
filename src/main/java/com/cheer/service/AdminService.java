package com.cheer.service;

import com.cheer.model.Admin;

import org.apache.ibatis.annotations.Param;

public interface AdminService {
    Admin getAdmin(String username) throws Exception;

    boolean checkLogin(String username,String password);
}
