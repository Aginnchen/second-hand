package com.dc.base.em;

public enum RoleMenuEnum {
    NO_2(2, "swagger"),
    NO_203(203, "角色管理"),
    NO_204(204, "用户管理"),
    NO_102(102, "登录日志"),
    NO_103(103,"操作日志")
    ;
    int code;
    String describe;

    /**
     *  构造函数
     */
    RoleMenuEnum(int code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

}
