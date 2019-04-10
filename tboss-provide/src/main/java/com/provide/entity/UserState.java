package com.provide.entity;

/**
 * @Description : TODO
 * @Date : 2018/8/24  10:33
 * @author : consumer
 */

public enum UserState {
    /**
     *注释
     */
    INIT(0,"初始化"),
    /**
     *注释
     */
    ACTIVE(1,"使用中"),
    /**
     *注释
     */
    FAIL(2,"禁用");

    private String desc;

    private Integer code;

    UserState(Integer code,String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
