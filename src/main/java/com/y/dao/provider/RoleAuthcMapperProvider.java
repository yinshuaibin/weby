package com.y.dao.provider;

import org.apache.ibatis.annotations.Param;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RoleAuthcMapperProvider {
	/**
	 * 根据页面传递过来的角色权限数据,将角色权限数据入库   字段名 authorityIds 格式authority_id-parent_id
	 * 修改人:y
	 * 修改时间:0724
	 * @param authorityIds
	 * @param roleId
	 * @return String
	 */
	public String insertAuthorityIds(@Param("authorityIds")List<String> authorityIds,@Param("roleId") String roleId) {
		StringBuilder sql = new StringBuilder("INSERT INTO tb_role_authc (role_id, authority_id) VALUES ");
		Set<String> authority_ids=new HashSet<>();
		for (String authorityId : authorityIds) {
			String[] authority_idAndParent_id = authorityId.split("-");
			authority_ids.add(authority_idAndParent_id[0]);
			authority_ids.add(authority_idAndParent_id[1]);
		}
		for (String authorityId : authority_ids) {
			sql.append(" ('" + roleId + "','" + authorityId + "'),");
		}
		sql.deleteCharAt(sql.lastIndexOf(","));
		return sql.toString();
	}
}
