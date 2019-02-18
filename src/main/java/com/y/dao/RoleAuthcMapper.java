package com.y.dao;

import com.y.dao.provider.RoleAuthcMapperProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleAuthcMapper {

	@Delete("DELETE FROM tb_role_authc WHERE role_id = #{roleId}")
	int deleteByRoleId(int roleId);

	@InsertProvider(type = RoleAuthcMapperProvider.class, method = "insertAuthcIds")
	int insertAuthorityIds(@Param("authcIds") List<Integer> authcIds, @Param("roleId") int roleId);
}
