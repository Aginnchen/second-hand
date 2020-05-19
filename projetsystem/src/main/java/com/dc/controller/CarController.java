package com.dc.controller;

import com.dc.base.aop.AopOperation;
import com.dc.base.em.RoleMenuEnum;
import com.dc.base.vo.BaseModel;
import com.dc.model.Car;
import com.dc.service.CarService;
import com.dc.service.UserService;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("Car")
@ResponseBody
@Controller
public class CarController {
    @Autowired
    CarService carService;
    @AopOperation(desc = "分页查询用户操作", type = "查询", menu = RoleMenuEnum.NO_204)
    @ApiOperation(value = "分页查询用户信息",httpMethod = "GET", notes = "查询")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前页面", name = "curr_page",defaultValue = "1", dataType = "int", paramType = "query"),
            @ApiImplicitParam(value = "一页的最大条数", name = "page_size",defaultValue = "10", dataType = "int", paramType = "query"),
            @ApiImplicitParam(value = "品牌", name = "brand", dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "配置", name = "configuration", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "selectAllCar", method = RequestMethod.GET)
    public BaseModel selectAllCar(int curr_page, int page_size, BaseModel baseModel, String brand,String configuration){
        return carService.selectAllCar(curr_page,page_size,baseModel,brand,configuration);
    }
//    删除
    @ApiOperation(value = "车辆信息删除", httpMethod = "POST", notes = "删除")
    @RequestMapping(value = "/deleteCar/{ids}", method = RequestMethod.POST)
    public BaseModel deleteCar(@PathVariable(value = "ids") String ids, BaseModel baseModel, HttpServletRequest request) throws Exception {
        return carService.deleteCar(ids, baseModel);
    }
    //    修改
    @ApiOperation(value = "修改用户",httpMethod = "POST", notes = "修改")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "brand_id", name = "brand_id",required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(value = "品牌", name = "brand", dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "价格", name = "money",dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "型号", name = "model",dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "配置", name = "configuration",dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "颜色", name = "color",dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "出产那个国家", name = "state",dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "上市时间", name = "market_time",dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/updateCar", method = RequestMethod.POST)
    public BaseModel updateCar(Car car, BaseModel baseModel) throws Exception {
        return carService.updateCar(car, baseModel);
    }
//    根据id查询
@ApiOperation(value = "根据id查询",httpMethod = "GET", notes = "查询")
@RequestMapping(value = "selectPersonById/{brand_id}", method = RequestMethod.GET)
public BaseModel selectPersonById(@PathVariable(value = "brand_id") Integer brand_id, BaseModel baseModel) throws  Exception{
    return carService.selectPersonById(brand_id, baseModel);
}
//新增
//新增购买成功
@ApiOperation(value = "购买成功，请查看订单信息界面", httpMethod = "POST", notes = "新增")
@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
@ResponseBody
@ApiImplicitParams({
        @ApiImplicitParam(value = "品牌", name = "brand", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "型号", name = "model", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "配置", name = "configuration", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "价格", name = "money", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "颜色", name = "color", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "出产那个国家", name = "state", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "上市时间", name = "market_time", required = true, dataType = "String", paramType = "query"),

})
public BaseModel addCar(Car car, BaseModel baseModel) throws Exception {
    //删除？
    car.setIs_deleted(0);
    return carService.addCar(car, baseModel);
}
}
