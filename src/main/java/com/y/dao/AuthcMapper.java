package com.y.dao;

import com.y.bean.Authc;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthcMapper {

    @Select("select * from tb_authc where id in(select authc_id from tb_role_authc where role_id = #{roleId})")
    @Results({
            @Result(column = "id",property = "authcId")
    })
    List<Authc> getAuthcByRoleId(Integer roleId);

    @Insert("insert into tb_authc (authc_name) values(#{authcName})")
    int insertAuthc(Authc authc);

    @Delete("delete from tb_authc where id = #{id}")
    int delAuthc(int id);

    @Update("update tb_authc set authc_name = #{authcName} where id = {#authcId})")
    int updateAuthc(Authc authc);

    @Select("select * from tb_authc)")
    @Results({
            @Result(column = "id",property = "authcId")
    })
    List<Authc> getAllAuthc();
}
