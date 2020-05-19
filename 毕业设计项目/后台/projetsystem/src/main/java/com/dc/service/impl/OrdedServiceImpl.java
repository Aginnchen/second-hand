package com.dc.service.impl;

import com.dc.base.em.ErrorMessageEnum;
import com.dc.base.vo.BaseModel;
import com.dc.base.vo.BusinessException;
import com.dc.dao.OrdedDao;
import com.dc.model.Orded;
import com.dc.service.CarService;
import com.dc.service.OrdedService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrdedServiceImpl implements OrdedService {
    @Autowired
    OrdedDao ordedDao;

    public BaseModel selectAllOrded(Integer curr_page, Integer page_size, BaseModel baseModel, String brand, String user_name) {
        // 编写业务
        PageHelper.startPage(curr_page, page_size);
        // 开启分页以后需要马上接入查询语句，方便pageHelper实现分页
        List<OrdedDao> users = ordedDao.selectAllOrded(brand, user_name);
        PageInfo pageInfo = new PageInfo(users, 5);
        baseModel.setResultCode(0);
        baseModel.setMessage("分页查询用户成功");
        baseModel.setData(pageInfo);
        return baseModel;
    }

    //    s删除
    public BaseModel deleteOrded(String ids, BaseModel baseModel) throws Exception {
        String[] idArry = ids.split(",");
        int result = ordedDao.deleteOrded(idArry);
        if (result <= 0) {
            throw new BusinessException(1009, "删除" + result + "个用户失败");
        }
        baseModel.setResultCode(0);
        baseModel.setMessage("删除" + result + "个成功");
        return baseModel;
    }

    //    修改
    public BaseModel updateOrded(Orded orded, BaseModel baseModel) throws Exception {
        // 调用修改的dao
        Integer result = ordedDao.updateOrded(orded);
        if (result <= 0) {
            throw new BusinessException(ErrorMessageEnum.UPDATE_ERROR);
        }
        baseModel.setResultCode(0);
        baseModel.setMessage("修改用户成功");
        return baseModel;
    }
//根据id查询
    public BaseModel selectPersonById(Integer order_id, BaseModel baseModel) throws Exception {
        Orded person=ordedDao.selectPersonById(order_id);
        baseModel.setResultCode(0);
        baseModel.setMessage("根据id查询住户成功");
        baseModel.setData(person);
        return baseModel;
    }
    //订单新增
    public BaseModel addOrded(Orded orded, BaseModel baseModel) throws Exception {
        // 调用新增用户的dao
        Integer result = ordedDao.insertOrded(orded);
        if(result <= 0){
            throw new BusinessException(ErrorMessageEnum.ADD_USER_ERROR);
        }
        baseModel.setResultCode(0);
        baseModel.setMessage("购买成功,请查看订单信息界面");

        return baseModel;
    }

}



