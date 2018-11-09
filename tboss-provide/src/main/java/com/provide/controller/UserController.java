package com.provide.controller;

import com.provide.entity.EsUser;
import com.provide.entity.User;
import com.provide.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @Description : 用户控制类
 * @Date : 2018/8/24  10:43
 * @author Administrator
 */

@RestController
@RequestMapping("/user")
public class UserController {

    public static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userServie;

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody User user){
        log.info("创建用户，参数：{}",user);
        User result= userServie.save(user);
        log.info("创建用户，结果：{}",result);
        return result.toString();
    }

    @RequestMapping(value = "/es",method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody EsUser esUser){
        log.info("创建用户，参数：{}",esUser);
        EsUser result= userServie.save(esUser);
        log.info("创建用户，结果：{}",result);
        return result.toString();
    }

    @RequestMapping(value = "/es",method = RequestMethod.GET)
    @ResponseBody
    public Page<EsUser> query(String username, @RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "10") int pageSize){
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize, Sort.unsorted());
        Page<EsUser> result = userServie.getAllUser(username,pageRequest);
        return result;
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    @ResponseBody
    public Page<User> query(String ids, String username,
                     @RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "10") int pageSize){
        List<String> idList = null;
        if (!StringUtils.isEmpty(ids)) {
            idList = Arrays.asList(ids.split(","));
        }
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize, Sort.unsorted());
        Page<User> result = userServie.getAllUser(idList,username,pageRequest);
        return result;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String query(@PathVariable Integer id){
        User result = userServie.getById(id);
        return result.toString();
    }


}
