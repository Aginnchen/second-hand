package com.dc.dao;


import com.dc.model.Orded;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrdedDao {
//    查询
    List<OrdedDao> selectAllOrded (@Param("brand") String brand ,@Param("user_name")String user_name);
//    删除
Integer deleteOrded(@Param("ids") String[] ids);
//修改
//修改个人信息
Integer updateOrded(Orded orded);
//根据id查询
   Orded selectPersonById(@Param("order_id") Integer order_id );
//   订单新增
Integer insertOrded(Orded orded);
}
