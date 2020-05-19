package com.dc.service;

import com.dc.base.vo.BaseModel;
import com.dc.model.Orded;


import java.util.Date;

public interface OrdedService {
//    查询
    BaseModel selectAllOrded(Integer curr_page, Integer page_size, BaseModel baseModel,String brand,String user_name );

//    删除
BaseModel deleteOrded(String ids, BaseModel baseModel) throws Exception;
//修改
BaseModel updateOrded(Orded orded, BaseModel baseModel)throws  Exception;

//根据id
BaseModel selectPersonById(Integer order_id, BaseModel baseModel) throws Exception;

//订单新增
//    新增
BaseModel addOrded(Orded orded, BaseModel baseModel) throws Exception;
//
}
