package com.dc.service.impl;

import com.dc.base.em.ErrorMessageEnum;
import com.dc.base.vo.BaseModel;
import com.dc.base.vo.BusinessException;
import com.dc.dao.CarDao;
import com.dc.model.Car;
import com.dc.service.CarService;
import com.dc.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl  implements CarService {
    @Autowired
    CarDao carDao;

    public BaseModel selectAllCar(Integer curr_page, Integer page_size, BaseModel baseModel, String brand,String configuration) {
        // 编写业务
        PageHelper.startPage(curr_page, page_size);
        // 开启分页以后需要马上接入查询语句，方便pageHelper实现分页
        List<Car> users = carDao.selectAllCar(brand ,configuration);
        PageInfo pageInfo = new PageInfo(users,5);
        baseModel.setResultCode(0);
        baseModel.setMessage("分页查询用户成功");
        baseModel.setData(pageInfo);
        return baseModel;
    }
//删除
    public BaseModel deleteCar(String ids, BaseModel baseModel) throws Exception {
        String[] idArry = ids.split(",");
        int result = carDao.deleteCar(idArry);
        if (result <= 0){
            throw new BusinessException(1009,"删除"+result+"个用户失败");
        }
        baseModel.setResultCode(0);
        baseModel.setMessage("删除"+result+"个成功");
        return baseModel;
    }
//修改
    public BaseModel updateCar(Car car, BaseModel baseModel) throws Exception {
        // 调用修改的dao
        Integer result = carDao.updateCar(car);
        if (result <= 0) {
            throw new BusinessException(ErrorMessageEnum.UPDATE_ERROR);
        }
        baseModel.setResultCode(0);
        baseModel.setMessage("修改用户成功");
        return baseModel;
    }
    //根据id查询
    public BaseModel selectPersonById(Integer brand_id, BaseModel baseModel) throws Exception {
        Car person=carDao.selectPersonById(brand_id);
        baseModel.setResultCode(0);
        baseModel.setMessage("根据id查询住户成功");
        baseModel.setData(person);
        return baseModel;
    }
//新增
    public BaseModel addCar(Car car, BaseModel baseModel) throws Exception {
        // 调用新增用户的dao
        Integer result = carDao.insertCar(car);
        if(result <= 0){
            throw new BusinessException(ErrorMessageEnum.ADD_USER_ERROR);
        }
        baseModel.setResultCode(0);
        baseModel.setMessage("新增车品详情成功");
        return baseModel;
    }


}
