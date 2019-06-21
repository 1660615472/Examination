package com.cheer.dao;

import com.cheer.model.Admin;


/*管理员dao接口*/
public interface AdminMapper {
 Admin getAdmin(String username);
}
