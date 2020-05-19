package com.dc.model;

import java.util.Date;

public class Admin {
    private Integer user_id;
    private String user_account;
    private String user_password;
    private String user_name;
    private String phone ;
    private  String  sex ;
    private Date registration_time;

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

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
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

    public Date getRegistration_time() {
        return registration_time;
    }

    public void setRegistration_time(Date registration_time) {
        this.registration_time = registration_time;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Admin{");
        sb.append("user_id=").append(user_id);
        sb.append(", user_account='").append(user_account).append('\'');
        sb.append(", user_password='").append(user_password).append('\'');
        sb.append(", user_name='").append(user_name).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", registration_time=").append(registration_time);
        sb.append('}');
        return sb.toString();
    }
}
