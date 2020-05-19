package com.dc.controller;

import com.dc.base.em.ErrorMessageEnum;
import com.dc.base.vo.BaseModel;
import com.dc.base.vo.BusinessException;
import com.dc.service.AdminService;
import com.dc.service.CarService;
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
import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;
@RequestMapping("admin")
@ResponseBody
@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @ApiOperation(value = "登录",httpMethod = "POST", notes = "查询")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "账号", name = "account",required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(value = "密码", name = "password", required = true,dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseModel selectLoginAdmin(String account, String password, BaseModel baseModel, HttpServletRequest request) throws Exception {
        String regex = "^((13[0-9]|14[5-9]|15[0-3,5-9]|16[2,5,6,7]|17[0-8]|18[0-9]|19[1,3,5,8,9]))\\d{8}$";
        if (!Pattern.matches(regex, account) || password.length() < 6) {
            // 抛出业务异常
            throw new BusinessException(ErrorMessageEnum.FORMAT_ERROR);
        }
        // 调用业务层
        baseModel = adminService.loginAdmin(account, password, baseModel);
        // 将登录用户的数据存入到session
        HttpSession session = request.getSession();
        session.setAttribute("currentUser", baseModel.getData());
        return baseModel;
    }

}
