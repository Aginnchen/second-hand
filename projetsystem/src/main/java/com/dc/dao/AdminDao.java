package com.dc.dao;

import com.dc.model.Admin;
import com.dc.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
    // 用户登录
   Admin selectLoginAdmin(@Param("account") String account, @Param("password") String password);
//   根据id查询

}
