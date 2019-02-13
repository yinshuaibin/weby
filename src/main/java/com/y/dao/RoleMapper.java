package com.y.dao;

import com.y.bean.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Repository
public interface RoleMapper {

    @Select("select * from tb_role where id in(select role_id from tb_user_role where user_id = #{userId})")
    @Results({
            @Result(column = "id",property = "roleId"),
            @Result(column = "id",property = "authcs",many = @Many(select = "com.y.dao.AuthcDao.getAuthcByRoleId"))
    })
    List<Role> getRoleByUserId(String userId);

    @Select("select * from tb_role)")
    @Results({
            @Result(column = "id",property = "roleId"),
            @Result(column = "id",property = "authcs",many = @Many(select = "com.y.dao.AuthcDao.getAuthcByRoleId"))
    })
    List<Role> getAllRole(String userId);

    int insertRole(Role role);

    int updateRole(Role role);

    int delRole(int id);
}
