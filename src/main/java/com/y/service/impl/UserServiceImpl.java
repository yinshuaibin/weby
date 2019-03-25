package com.y.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.y.bean.User;
import com.y.config.shiro.MyRealm;
import com.y.dao.UserMapper;
import com.y.service.UserService;
import com.y.utils.Md5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Cacheable(value = "user")
    @Override
    public Page<User> getAllUser(Integer pageNum, Integer pageSize) {
        log.debug("缓存中无参数为pageNum:{}, pageSize: {}数据, 第一次访问",pageNum, pageSize);
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        Object o = operations.get("user" + pageNum + pageSize);
        if( null != o) return (Page<User>)o;

        log.debug("redis中无此查询数据, 重新查询并存入redis中");
        // 查询并分页,普通写法
        Page<User> page = PageHelper.startPage(pageNum,pageSize).doSelectPage(userDao::getAllUser);
        redisTemplate.opsForValue().set("user"+pageNum+pageSize, page);
        // 查询并分页, PageHelper的lambda写法
        return PageHelper.startPage(pageNum,pageSize)
                         .doSelectPage(()->{ userDao.getAllUser(); });
    }

    @Cacheable(value = "user")
    @Override
    public User getUserByUserName(String userName) {
        log.debug("缓存中无参数为userName:{}数据, 第一次访问",userName);
        return userDao.getUserByUserName(userName);
    }

    @Override
    public int insertUser(User user) {
        // 首先添加对应的角色
        // 将密码加密
        user.setPassword(Md5Utils.md5Encryption(user.getPassword()));
        return userDao.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        // 首先修改对应的角色

        // 将密码加密
        user.setPassword(Md5Utils.md5Encryption(Md5Utils.md5Encryption(user.getPassword())));
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        // 首先删除对应的角色

        // 删除用户
        return userDao.deleteUser(id);
    }

    public static void main(String[] args) {
        String s = Md5Utils.md5Encryption("1");
        System.out.println(s);
    }
}
