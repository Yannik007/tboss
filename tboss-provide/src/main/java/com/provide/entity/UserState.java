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
    INIT("初始化"),
    /**
     *注释
     */
    ACTIVE("使用中"),
    /**
     *注释
     */
    FAIL("禁用");

    private String desc;

    UserState(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

}
