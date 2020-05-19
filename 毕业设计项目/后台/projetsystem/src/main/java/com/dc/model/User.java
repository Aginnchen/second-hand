package com.dc.model;

import com.dc.base.em.ErrorMessageEnum;

import java.util.Date;

public class User {
    private Integer user_id;
    private String user_account;
    private String user_password;

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    private String user_name;
    private String phone ;
    private  String  sex ;
private  String create_time;
    private int is_deleted;

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }



    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("user_id=").append(user_id);
        sb.append(", user_account='").append(user_account).append('\'');
        sb.append(", user_password='").append(user_password).append('\'');
        sb.append(", user_name='").append(user_name).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", create_time='").append(create_time).append('\'');
        sb.append(", is_deleted=").append(is_deleted);
        sb.append('}');
        return sb.toString();
    }
}
