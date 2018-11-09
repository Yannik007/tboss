package com.provide.entity;

/**
* @Description :
* @Date : 2018/8/24  9:58  
* */

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.io.Serializable;

@Document(indexName = "student", type = "user")
public class EsUser implements Serializable {

    @Id
    private Integer id;

    private String username;

    private String password;


    public EsUser() {
    }

    @Override
    public String toString() {
        return "EsUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
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
}
