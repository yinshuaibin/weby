package com.y.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.y.bean.User;
import com.y.config.shiro.MyRealm;
import com.y.dao.UserMapper;
import com.y.service.UserService;
import com.y.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;

    @Override
    public Page<User> getAllUser(Integer pageNum, Integer pageSize) {
        // 查询并分页,普通写法
        Page<User> page = PageHelper.startPage(pageNum,pageSize).doSelectPage(userDao::getAllUser);
        // 查询并分页, PageHelper的lambda写法
        return PageHelper.startPage(pageNum,pageSize)
                         .doSelectPage(()->{ userDao.getAllUser(); });
    }

    @Override
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    @Override
    public int insertUser(User user) {
        // 首先添加对应的角色
        // 将密码加密
        user.setPassword(Md5Utils.md5Encryption(Md5Utils.md5Encryption(user.getPassword())));
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
