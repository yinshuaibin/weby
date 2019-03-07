package com.y.test;


import com.y.bean.User;
import com.y.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void tes1(){
        User u = new User();
        u.setUsername("ss");
        u.setPassword("1");
        userService.insertUser(u);
    }
}
