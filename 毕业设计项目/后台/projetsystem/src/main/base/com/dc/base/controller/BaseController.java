package com.dc.base.controller;

import com.dc.base.em.ErrorMessageEnum;
import com.dc.base.vo.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class BaseController {
    /*
    * @title:<h3>统一处理业务异常</h3>
    * @author:Alex
    * @date:2019-12-03
    * @params [ex]
    * */
    @ExceptionHandler({BusinessException.class})
    public BusinessException businessException (BusinessException ex){
        return ex;
    }
    /*
     * @title:<h3>统一处理系统异常</h3>
     * @author:Alex
     * @date:2019-12-03
     * @params [ex]
     * */
    @ExceptionHandler({Exception.class})
    public BusinessException exception(Exception ex){
        BusinessException businessException = new BusinessException(ErrorMessageEnum.SYS_ERROR);
        return businessException;
    }
}
