package com.y;


import com.github.pagehelper.Page;
import com.y.bean.User;
import com.y.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.Log;

import java.io.Serializable;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    @Autowired
    private UserService userService;


    @Test
    public void testSet(){

        stringRedisTemplate.opsForValue().set("key", "value1");
        Page<User> allUser = userService.getAllUser(1, 10);
        redisTemplate.opsForValue().set("user",allUser.get(0));
    }

    @Test
    public void testGet(){
        User user = (User)redisTemplate.opsForValue().get("user");
        log.info("user数据为:{}",user);

        String key = stringRedisTemplate.opsForValue().get("key");
        log.info("拿出来字符串数据为:{}",key);
    }
}
