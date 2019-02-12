package com.y.dao;

import com.y.bean.Authc;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthcDao {

    @Select("select * from tb_authc where id in(select authc_id from tb_role_authc where role_id = #{roleId})")
    @Results({
            @Result(column = "id",property = "authcId")
    })
    List<Authc> getAuthcByRoleId(Integer roleId);

    int insertAuthc(Authc authc);

    int delAuthc(int id);

    int updateAuthc(Authc authc);

    @Select("select * from tb_authc)")
    @Results({
            @Result(column = "id",property = "authcId")
    })
    List<Authc> getAllAuthc(Integer roleId);
}
