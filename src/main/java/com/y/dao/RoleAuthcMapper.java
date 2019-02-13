package com.y.dao;

import com.y.dao.provider.RoleAuthcMapperProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleAuthcMapper {

	/**
	 * 删除: 删除指定角色权限
	 * @param roleId
	 * @return
	 */
	@Delete("DELETE FROM tb_role_authc WHERE role_id = #{roleId}")
	int deleteByRoleId(String roleId);

	/**
	 * 根据页面传递过来的角色权限数据,将角色权限数据入库   字段名 authorityIds 格式authority_id-parent_id
	 * 修改人:y
	 * 修改时间:0724
	 * @param authorityIds
	 * @param roleId
	 * @return
	 */
	@InsertProvider(type = RoleAuthcMapperProvider.class, method = "insertAuthorityIds")
	int insertAuthorityIds(@Param("authorityIds") List<String> authorityIds, @Param("roleId") String roleId);
}
