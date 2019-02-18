package com.y.dao;

import com.y.bean.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Repository
public interface RoleMapper {

    @Select("select * from tb_role where id in(select role_id from tb_user_role where user_id = #{userId})")
    @Results({
            @Result(column = "id",property = "roleId"),
            @Result(column = "id",property = "authcs",many = @Many(select = "com.y.dao.AuthcMapper.getAuthcByRoleId"))
    })
    List<Role> getRoleByUserId(String userId);

    @Select("select * from tb_role)")
    @Results({
            @Result(column = "id",property = "roleId"),
            @Result(column = "id",property = "authcs",many = @Many(select = "com.y.dao.AuthcDao.getAuthcByRoleId"))
    })
    List<Role> getAllRole();

    @Insert("insert into tb_role (role_name,role_desc) values(#{roleName},#{roleDesc})")
    int insertRole(Role role);

    @Update("update tb_role set role_name =#{roleName},role_desc=#{roleDesc}) where id = #{roleId}")
    int updateRole(Role role);

    @Delete("delete from tb_role where id = #{id})")
    int delRole(int id);
}
