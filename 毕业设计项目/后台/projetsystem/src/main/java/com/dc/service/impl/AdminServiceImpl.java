package com.dc.service.impl;
//g管理员

import com.dc.base.em.ErrorMessageEnum;
import com.dc.base.vo.BaseModel;
import com.dc.base.vo.BusinessException;
import com.dc.dao.AdminDao;
import com.dc.model.Admin;
import com.dc.model.User;
import com.dc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    public BaseModel loginAdmin(String account, String password, BaseModel baseModel) throws Exception {
      Admin admin = adminDao.selectLoginAdmin(account, password);
        // 没有查到数据
        if (admin == null){
            // 给出提示账号不存在或者密码错误
            throw new BusinessException(ErrorMessageEnum.LOGIN_ERROR);
        } else {
            baseModel.setResultCode(0);
            baseModel.setMessage("登录成功！");
            baseModel.setData(admin);
        }
        return baseModel;
    }


    }



