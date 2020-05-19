package com.dc.service;

import com.dc.base.vo.BaseModel;
import com.dc.model.User;

public interface UserService {
    // 用户登录
    BaseModel loginUser(String account, String password, BaseModel baseModel) throws Exception;
//    用户注册
 BaseModel addUser(User user, BaseModel baseModel) throws Exception;
// 修改
BaseModel updateUser(User user,BaseModel baseModel)throws  Exception;

    //根据id
    BaseModel selectPersonById(Integer user_id, BaseModel baseModel) throws Exception;
//    分页查询
    BaseModel selectAllUser(Integer curr_page, Integer page_size, BaseModel baseModel, String user_name ,
                           String phone);
//    删除
//    删除
BaseModel deleteUser(String ids, BaseModel baseModel) throws Exception;

    //    管理员对用户新增
    BaseModel insertUser(User user, BaseModel baseModel) throws Exception;
//    管理员对用户修改
// 修改
BaseModel updateadminUser(User user,BaseModel baseModel)throws  Exception;
////    //重置用户密码
//
// void resetUserPassword(User user, BaseModel baseModel) throws Exception;
}
