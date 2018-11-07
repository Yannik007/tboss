package com.provide.repository;

import com.provide.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description : TODO
 * @Date : 2018/8/24  11:32
 */
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User>{

    @Cacheable(key = "#p0", condition = "#p0.length() < 10")
    User findByUsername(String username);

}
