package com.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.provide.entity.User;
import com.provide.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : tboss
 * @description : TODO
 * @date : 2018/10/26
 */

@Component
public class UserDubboConsumerService {

    @Reference(check = false)
    UserService userService;

    public User save(User user) {
        return userService.save(user);
    }

    public Page<User> getAllUser(List<String> idList, String username, Pageable pageable){
        return userService.getAllUser(idList,username,pageable);
    }
    public User getById(Integer id){
        return userService.getById(id);
    }
}
