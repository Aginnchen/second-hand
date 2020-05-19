package com.dc.service;

import com.dc.base.vo.BaseModel;
import com.dc.model.Car;

public interface CarService {

    BaseModel selectAllCar(Integer curr_page, Integer page_size, BaseModel baseModel, String brand ,
                           String configuration);
//    删除
    BaseModel deleteCar(String ids, BaseModel baseModel) throws Exception;
    //修改
    BaseModel updateCar(Car car, BaseModel baseModel)throws  Exception;
    //根据id
    BaseModel selectPersonById(Integer brand_id, BaseModel baseModel) throws Exception;
//    新增
    BaseModel addCar(Car car, BaseModel baseModel) throws Exception;
}
