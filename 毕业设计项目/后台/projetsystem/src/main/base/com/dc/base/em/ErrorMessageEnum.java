package com.dc.base.em;

public enum  ErrorMessageEnum {
    SYS_ERROR(1001,"系统异常，请联系管理员"),
    NETWORK(1002,"网络连接失败，请联系管理员"),
    FORMAT_ERROR(1003, "账号格式不正确，或者密码错误"),
    LOGIN_ERROR(1004, "账号不存在，或者密码错误"),
    UPDATE_ERROR(1005,"修改失败"),
    ADD_USER_ERROR(1006 ,"新增失败"),
    DEFAULT_PASSWORD( 1007,"重置失败")
    ;

    private int code;
    private String mesg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    ErrorMessageEnum(int code, String mesg){
        this.code = code;
        this.mesg = mesg;
    }
}
