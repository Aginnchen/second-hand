package com.dc.dao;

import com.dc.model.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarDao {
    //查询所有
    List<Car> selectAllCar (@Param("brand") String brand,@Param("configuration") String configuration);
//    删除
    Integer deleteCar(@Param("ids") String[] ids);
    //修改个人信息
    Integer updateCar(Car car);
    //根据id查询
    Car selectPersonById(@Param("brand_id") Integer brand_id );
//    新增
Integer insertCar(Car car);
}
