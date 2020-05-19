package com.dc.controller;

import com.dc.base.aop.AopOperation;
import com.dc.base.em.RoleMenuEnum;
import com.dc.base.vo.BaseModel;
import com.dc.model.Orded;
import com.dc.model.User;
import com.dc.service.OrdedService;
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
import java.util.Date;

@RequestMapping("Orded")
@ResponseBody
@Controller
public class OrdedController {
    @Autowired
    OrdedService ordedService;
    @AopOperation(desc = "分页查询用户操作", type = "查询", menu = RoleMenuEnum.NO_204)
    @ApiOperation(value = "分页查询用户信息",httpMethod = "GET", notes = "查询")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前页面", name = "curr_page",defaultValue = "1", dataType = "int", paramType = "query"),
            @ApiImplicitParam(value = "一页的最大条数", name = "page_size",defaultValue = "10", dataType = "int", paramType = "query"),
            @ApiImplicitParam(value = "品牌", name = "brand", dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "姓名", name = "user_name", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "selectAllOrded", method = RequestMethod.GET)
    public BaseModel selectAllOrded(int curr_page,int page_size, BaseModel baseModel, String brand,String user_name ){
        return ordedService.selectAllOrded(curr_page,page_size,baseModel,brand,user_name );
    }
//删除
@ApiOperation(value = "订单信息删除", httpMethod = "POST", notes = "删除")
@RequestMapping(value = "/deleteOrded/{ids}", method = RequestMethod.POST)
public BaseModel deleteOrded(@PathVariable(value = "ids") String ids, BaseModel baseModel, HttpServletRequest request) throws Exception {
    return ordedService.deleteOrded(ids, baseModel);
}
    //    修改
    @ApiOperation(value = "修改用户",httpMethod = "POST", notes = "修改")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "订单ID", name = "order_id",required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(value = "用户详情", name = "quantity", dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "用户姓名", name = "user_name",dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "用户订单价格", name = "money",dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "用户订单品牌", name = "brand",dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "用户订单时间", name = "order_time",dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/updateOrded", method = RequestMethod.POST)
    public BaseModel updateOrded(Orded orded, BaseModel baseModel) throws Exception {
        return ordedService.updateOrded(orded, baseModel);
    }
//根据id查询
//
@ApiOperation(value = "根据id查询",httpMethod = "GET", notes = "查询")
@RequestMapping(value = "selectPersonById/{order_id}", method = RequestMethod.GET)
public BaseModel selectPersonById(@PathVariable(value = "order_id") Integer order_id, BaseModel baseModel) throws  Exception{
    return ordedService.selectPersonById(order_id, baseModel);
}
//订单新增
//新增
@ApiOperation(value = "新增订单信息", httpMethod = "POST", notes = "新增")
@RequestMapping(value = "/addOrded", method = RequestMethod.POST)
@ResponseBody
@ApiImplicitParams({
        @ApiImplicitParam(value = "品牌", name = "brand", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "详情", name = "quantity", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "价格", name = "money", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "姓名", name = "user_name", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "订单时间", name = "order_time", required = true, dataType = "String", paramType = "query"),

})
public BaseModel addOrded(Orded orded, BaseModel baseModel) throws Exception {
    //删除？
    orded.setIs_deleted(0);
    return ordedService.addOrded(orded, baseModel);
}
}
