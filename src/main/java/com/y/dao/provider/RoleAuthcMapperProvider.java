package com.y.dao.provider;

import org.apache.ibatis.annotations.Param;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RoleAuthcMapperProvider {

	public String insertAuthcIds(@Param("authcIds")List<Integer> authcIds,@Param("roleId") int roleId) {
		StringBuilder sql = new StringBuilder("INSERT INTO tb_role_authc (role_id, authc_id) VALUES ");
		for (int authorityId : authcIds) {
			sql.append(" ('" + roleId + "','" + authorityId + "'),");
		}
		sql.deleteCharAt(sql.lastIndexOf(","));
		return sql.toString();
	}
}
