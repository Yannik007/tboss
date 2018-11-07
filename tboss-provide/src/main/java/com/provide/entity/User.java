package com.provide.entity;

/**
* @Description :
* @Date : 2018/8/24  9:58  
* */

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class User implements Serializable {

    @Id
    private Integer id;

    private String username;

    private String password;

    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    private Date updateTime;

    /**
    * @see com.provide.entity.UserState
    * */
    private String state;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", state='" + state + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
