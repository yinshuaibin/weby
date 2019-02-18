package com.y.dao;

import com.y.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("select * from tb_user")
    @Results({
            @Result(column = "id",property = "userId"),
            @Result(column = "id",property = "roles",many = @Many(select = "com.y.dao.RoleMapper.getRoleByUserId"))
    })
    List<User> getAllUser() ;

    @Select("select * from tb_user where user_name = #{userNmae}")
    @Results({
            @Result(column = "id",property = "userId"),
            @Result(column = "id",property = "roles",many = @Many(select = "com.y.dao.RoleDao.getRoleByUserId"))
    })
    User getUserByUserName(String userName) ;

    @Insert("insert into tb_user (user_name, pass_word, user_desc) values(#{userName},#{passWord},#{userDesc})")
    int insertUser(User user);

    @Update("update tb_user set user_name = #{userName} , pass_word = #{passWord}, user_desc = #{userDesc} where id = #{userId}")
    int updateUser(User user);

    @Delete("delete from tb_user where id = #{userId}")
    int deleteUser(int id);
}
