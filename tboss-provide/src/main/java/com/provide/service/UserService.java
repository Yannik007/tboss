package com.provide.service;
/*
* @Description :
* @Date : 2018/8/24  9:38  
* */

import com.provide.entity.EsUser;
import com.provide.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User save(User user);
    Page<User> getAllUser(List<String> idList, String username, Pageable pageable);
    User getById(Integer id);
    EsUser save(EsUser user);
    Page<EsUser> getAllUser(String username, Pageable pageable);
}
