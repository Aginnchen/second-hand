package com.dc.dao;

import com.dc.base.vo.BaseModel;
import com.dc.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    // 用户登录
    User selectLoginUser(@Param("account") String account, @Param("password") String password);
//注册
    int addUser(User user)throws  Exception;
    //修改个人信息
    Integer updateUser(User user);
    //根据id查询
    User selectPersonById(@Param("user_id") Integer user_id );
//    分页查询
//查询所有
List<User> selectAllUser (@Param("user_name") String user_name, @Param("phone") String phone);
//删除

Integer deleteUser(@Param("ids") String[] ids);
//新增
Integer insertUser(User user);
//管理员对用户修改
Integer updateadminUser(User user);
//
//////重置密码
//Integer resetUserPassword(User user);
}
