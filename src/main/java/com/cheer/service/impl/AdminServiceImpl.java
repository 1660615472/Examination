package com.cheer.service.impl;

import com.cheer.dao.AdminMapper;
import com.cheer.model.Admin;
import com.cheer.service.AdminService;
import com.cheer.utils.MybatisUtils;
import com.cheer.utils.StringUtils;
import org.apache.ibatis.session.SqlSession;

/*admin dao实现类*/
public class AdminServiceImpl implements AdminService {


    //通过username找到admin
    public Admin getAdmin(String username) throws Exception {
        SqlSession session = MybatisUtils.getSqlSession ();
        Admin admin = session.getMapper ( AdminMapper.class ).getAdmin ( username );
        MybatisUtils.closeSqlSession ( session );
        if (admin == null) {
            throw new Exception ( "数据库中没有这个管理者" );
        }
        return admin;
    }

    //通过username找到admin对象 判断密码是否相等
    public boolean checkLogin(String username,String password){
       SqlSession session = MybatisUtils.getSqlSession ();
      Admin admin = session.getMapper ( AdminMapper.class ).getAdmin ( username );
        MybatisUtils.closeSqlSession ( session );
        if(admin == null){
            return false;
        }

        //如果找到了比较该账号的密码是否相同
        if(StringUtils.encrypt ( password ).equals ( admin.getPassword () )){
            return true;
        }else {
            return false;
        }
    }



}
