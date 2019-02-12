package com.y.controller;

import com.github.pagehelper.Page;
import com.y.bean.User;
import com.y.controller.base.BaseController;
import com.y.exception.Yexception;
import com.y.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findUser")
    public Map getAllUser(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Integer pageSize){
        Page<User> allUser = userService.getAllUser(pageNum, pageSize);
        Map resultMap = new HashMap();
        resultMap.put("totalNum",allUser.getTotal());
        resultMap.put("resultList",allUser.getResult());
        return resultMap;
    }

    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public int insertUser(@RequestBody User user){
        return  userService.insertUser(user);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public int updateUser(@RequestBody User user){
        return  userService.updateUser(user);
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.DELETE)
    public int deleteUser(int id){
        return  userService.deleteUser(id);
    }
}
