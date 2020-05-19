package com.dc.controller;

import com.dc.base.aop.AopOperation;
import com.dc.base.controller.BaseController;
import com.dc.base.em.ErrorMessageEnum;
import com.dc.base.em.RoleMenuEnum;
import com.dc.base.vo.BaseModel;
import com.dc.base.vo.BusinessException;
import com.dc.model.User;
import com.dc.service.UserService;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.regex.Pattern;

@RequestMapping("user")
@ResponseBody
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "登录", httpMethod = "POST", notes = "查询")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "账号", name = "account", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "密码", name = "password", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseModel selectLoginUser(String account, String password, BaseModel baseModel, HttpServletRequest request) throws Exception {
        String regex = "^((13[0-9]|14[5-9]|15[0-3,5-9]|16[2,5,6,7]|17[0-8]|18[0-9]|19[1,3,5,8,9]))\\d{8}$";
        if (!Pattern.matches(regex, account) || password.length() < 6) {
            // 抛出业务异常
            throw new BusinessException(ErrorMessageEnum.FORMAT_ERROR);
        }
        // 调用业务层
        baseModel = userService.loginUser(account, password, baseModel);
        // 将登录用户的数据存入到session
        HttpSession session = request.getSession();
        session.setAttribute("currentUser", baseModel.getData());
        return baseModel;
    }

    //注册
    @ApiOperation(value = "用户新增", httpMethod = "POST", notes = "新增")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "密码", name = "user_password", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "账号", name = "user_account", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "姓名", name = "user_name", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "手机号", name = "phone", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "性别", name = "sex", required = true, dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public BaseModel addUser(User user, BaseModel baseModel, HttpServletRequest request) throws Exception {
        user.setCreate_time(new String());
        return userService.addUser(user, baseModel);
    }

    //    修改
    @ApiOperation(value = "修改用户", httpMethod = "POST", notes = "修改")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "user_id", name = "user_id", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(value = "密码", name = "user_password", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "账号", name = "user_account", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "姓名", name = "user_name", required = true, dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public BaseModel updateUser(User user, BaseModel baseModel) throws Exception {
        user.setIs_deleted(0);
        return userService.updateUser(user, baseModel);
    }

    //根据id查询
//根据id查询
//
    @ApiOperation(value = "根据id查询", httpMethod = "GET", notes = "查询")
    @RequestMapping(value = "selectPersonById/{user_id}", method = RequestMethod.GET)
    public BaseModel selectPersonById(@PathVariable(value = "user_id") Integer user_id, BaseModel baseModel) throws Exception {
        return userService.selectPersonById(user_id, baseModel);
    }
//    分页查询
@AopOperation(desc = "分页查询用户操作", type = "查询", menu = RoleMenuEnum.NO_204)
@ApiOperation(value = "分页查询用户信息",httpMethod = "GET", notes = "查询")
@ApiImplicitParams({
        @ApiImplicitParam(value = "当前页面", name = "curr_page",defaultValue = "1", dataType = "int", paramType = "query"),
        @ApiImplicitParam(value = "一页的最大条数", name = "page_size",defaultValue = "10", dataType = "int", paramType = "query"),
        @ApiImplicitParam(value = "姓名", name = "user_name", dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "手机号码", name = "phone", dataType = "String", paramType = "query")
})
@RequestMapping(value = "selectAllUser", method = RequestMethod.GET)
public BaseModel selectAllUser(int curr_page, int page_size, BaseModel baseModel, String user_name,String phone){
    return userService.selectAllUser(curr_page,page_size,baseModel,user_name,phone);
}
    //    删除
    @ApiOperation(value = "用户信息删除", httpMethod = "POST", notes = "删除")
    @RequestMapping(value = "/deleteUser/{ids}", method = RequestMethod.POST)
    public BaseModel deleteUser(@PathVariable(value = "ids") String ids, BaseModel baseModel, HttpServletRequest request) throws Exception {
        return userService.deleteUser(ids, baseModel);
    }
//    新增用户成功
//管理员对用户新增

@ApiOperation(value = "管理员新增用户成功，", httpMethod = "POST", notes = "新增")
@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
@ResponseBody
@ApiImplicitParams({
        @ApiImplicitParam(value = "账号", name = "user_account", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "姓名", name = "user_name", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "密码", name = "user_password", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "性别", name = "sex", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "手机号", name = "phone", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "注册时间", name = "create_time", required = true, dataType = "String", paramType = "query"),


})
public BaseModel insertUser(User user, BaseModel baseModel) throws Exception {
    //删除？
    user.setIs_deleted(0);
    return userService.insertUser(user, baseModel);
}
//管理员对用户修改
//    修改
@ApiOperation(value = "管理员修改用户", httpMethod = "POST", notes = "修改")
@ApiImplicitParams({
        @ApiImplicitParam(value = "user_id", name = "user_id", required = true, dataType = "Integer", paramType = "query"),
        @ApiImplicitParam(value = "密码", name = "user_password", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "账号", name = "user_account", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "姓名", name = "user_name", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "性别", name = "sex", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "手机号", name = "phone", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(value = "注册时间", name = "create_time", required = true, dataType = "String", paramType = "query"),

})
@RequestMapping(value = "/updateadminUser", method = RequestMethod.POST)
public BaseModel updateadminUser(User user, BaseModel baseModel) throws Exception {
        user.setIs_deleted(0);
    return userService.updateadminUser(user, baseModel);
}
//重置密码
//重置用户密码
//@ApiOperation(value = "重置用户密码", httpMethod = "GET")
//@RequestMapping("resetUserPassword/{pk}")
//public BaseModel resetUserPassword(@PathVariable("pk") int pk, BaseModel baseModel) throws Exception {
//    User user = new User();
//    user.setUser_id(pk);
//    userService.resetUserPassword(user, baseModel);
//    baseModel.setMessage("重置密码成功");
//        return baseModel;
//        }
        }