package com.dc.service.impl;

import com.dc.base.em.ErrorMessageEnum;
import com.dc.base.vo.BaseModel;
import com.dc.base.vo.BusinessException;
import com.dc.dao.UserDao;

import com.dc.model.Orded;
import com.dc.model.User;
import com.dc.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    // 用户登录
    public BaseModel loginUser(String account, String password, BaseModel baseModel) throws Exception {
        User user = userDao.selectLoginUser(account, password);
        // 没有查到数据
        if (user == null){
            // 给出提示账号不存在或者密码错误
            throw new BusinessException(ErrorMessageEnum.LOGIN_ERROR);
        } else {
            baseModel.setResultCode(0);
            baseModel.setMessage("登录成功！");
            baseModel.setData(user);
        }
        return baseModel;
    }


//    用户注册
    public BaseModel addUser(User user, BaseModel baseModel) throws Exception {
        int count = userDao.addUser(user);
        if(count > 0){
            baseModel.setMessage("新增用户成功");
        }else {
            baseModel.setResultCode(1);
            baseModel.setMessage("新增用户失败，请联系管理员");
        }
        return baseModel;
    }

    public BaseModel updateUser(User user, BaseModel baseModel) throws Exception {
        // 调用修改的dao
        Integer result = userDao.updateUser(user);
        if(result <= 0) {
            throw new BusinessException(ErrorMessageEnum.UPDATE_ERROR);
        }
        baseModel.setResultCode(0);
        baseModel.setMessage("修改用户成功");
        return baseModel;
    }

    public BaseModel selectPersonById(Integer user_id, BaseModel baseModel) throws Exception {
        User person=userDao.selectPersonById(user_id);
        baseModel.setResultCode(0);
        baseModel.setMessage("根据id查询住户成功");
        baseModel.setData(person);
        return baseModel;
    }
//分页查询
    public BaseModel selectAllUser(Integer curr_page, Integer page_size, BaseModel baseModel, String user_name, String phone) {
        // 编写业务
        PageHelper.startPage(curr_page, page_size);
        // 开启分页以后需要马上接入查询语句，方便pageHelper实现分页
        List<User> users = userDao.selectAllUser(user_name ,phone);
        PageInfo pageInfo = new PageInfo(users,5);
        baseModel.setResultCode(0);
        baseModel.setMessage("分页查询用户成功");
        baseModel.setData(pageInfo);
        return baseModel;
    }
//删除
    public BaseModel deleteUser(String ids, BaseModel baseModel) throws Exception {
        String[] idArry = ids.split(",");
        int result = userDao.deleteUser(idArry);
        if (result <= 0){
            throw new BusinessException(1009,"删除"+result+"个用户失败");
        }
        baseModel.setResultCode(0);
        baseModel.setMessage("删除"+result+"个成功");
        return baseModel;
    }
//用户新增
    public BaseModel insertUser(User user, BaseModel baseModel) throws Exception {
        // 调用新增用户的dao
        Integer result = userDao.insertUser(user);
        if(result <= 0){
            throw new BusinessException(ErrorMessageEnum.ADD_USER_ERROR);
        }
        baseModel.setResultCode(0);
        baseModel.setMessage("新增用户成功");
        return baseModel;
    }

    public BaseModel updateadminUser(User user, BaseModel baseModel) throws Exception {
        // 调用修改的dao
        Integer result = userDao.updateadminUser(user);
        if(result <= 0) {
            throw new BusinessException(ErrorMessageEnum.UPDATE_ERROR);
        }
        baseModel.setResultCode(0);
        baseModel.setMessage("修改用户成功");
        return baseModel;
    }
////重置密码
//    public void resetUserPassword(User user, BaseModel baseModel) throws Exception {
//        user.setUser_password(ErrorMessageEnum.UPDATE_ERROR);
//        int count=userDao.resetUserPassword(user);
//        if(count>0){
//            baseModel.setMessage("重置密码成功，密码为最初6位数原始密码");
//        }else{
//            baseModel.setMessage("重置密码失败");
//        }
//
//    }
}




