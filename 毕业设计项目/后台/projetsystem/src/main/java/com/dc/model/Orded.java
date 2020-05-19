package com.dc.model;

import java.util.Date;

public class Orded {
    private  int order_id;
    private  String  quantity;
    private String  money;
    private  String user_name;
    private String  order_time;
    private  int user_id;
    private  String brand;
private  int is_deleted;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Orded{");
        sb.append("order_id=").append(order_id);
        sb.append(", quantity='").append(quantity).append('\'');
        sb.append(", money='").append(money).append('\'');
        sb.append(", user_name='").append(user_name).append('\'');
        sb.append(", order_time='").append(order_time).append('\'');
        sb.append(", user_id=").append(user_id);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", is_deleted=").append(is_deleted);
        sb.append('}');
        return sb.toString();
    }
}
