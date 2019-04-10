package com.provide.controller;

import com.provide.entity.User;
import com.provide.entity.UserState;
import com.provide.repository.UserRepository;
import com.provide.service.UserService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * @Description : TODO
 * @Date : 2018/8/24  11:06
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest {


    @Autowired
    private UserService userServie;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void query() throws Exception {
        Pageable pageable =PageRequest.of(0, 2);
        List<String> idList = Arrays.asList("1".split(","));
        Page<User> result= userServie.getAllUser(idList,"consumer",pageable);
        System.out.println(result);
    }

    @Test
    @Transactional
    public void save() throws Exception {

        User user = new User();
        user.setId(1);
        user.setUsername("consumer");
        user.setState(UserState.INIT.getCode());
        user.setPassword("123456");
        user.setCreateTime(new Date());
        userServie.save(user);
        System.out.println(user);
    }
    @Test
    @Transactional
    public void saveException(){
        try{
            User user = new User();
            user.setId(3);
            user.setState(UserState.INIT.getCode());
            user.setPassword("123456");
            user.setCreateTime(new Date());
            User result = userServie.save(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
            if(!e.getMessage().equals("用户名不能为空")){
                Assert.fail();
            };
        }
    }


    @Test
    public void before() {
        User user = new User();
        user.setId(18);
        user.setState(UserState.INIT.getCode());
        user.setPassword("123456");
        user.setCreateTime(new Date());
        user.setUsername("AAA");
        userRepository.save(user);
    }

    @Test
    public void test() throws Exception {

        User u1 = userRepository.findByUsername("AAA");
        System.out.println("第一次查询：" + u1.getPassword());
        Thread.sleep(100);

        User u2 = userRepository.findByUsername("AAA");
        System.out.println("第二次查询：" + u2.getPassword());

        u1.setPassword("555");
        userRepository.save(u1);
        Thread.sleep(100);
        User u3 = userRepository.findByUsername("AAA");
        System.out.println("第三次查询：" + u3.getPassword());

    }
}