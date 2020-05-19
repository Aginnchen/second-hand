package com.dc.service;

import com.dc.base.vo.BaseModel;

public interface AdminService {
    // 管理员登录
    BaseModel loginAdmin(String account, String password, BaseModel baseModel) throws Exception;

}
