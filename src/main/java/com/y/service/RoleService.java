package com.y.service;


import com.y.bean.Authc;
import com.y.bean.Role;

import java.util.List;

public interface RoleService {
	
	/**
	 * 新增角色
	 * @param role
	 * @return
	 */
	boolean addRole(Role role);
	
	/**
	 * 修改角色信息
	 * @param role
	 * @return
	 */
	boolean updateRole(Role role);
	
	/**
	 * 删除角色
	 * @param roleId
	 * @return
	 */
	boolean deleteRole(String roleId);
	
	/**
	 * 查询roleName角色
	 * @return
	 */
	Role selectByRoleName(String roleName);

	/**
	 *
	 * @return
	 */
	int selectCount();

	/**
	 * 分页查询所有role
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Role> getRoleByPage(Integer pageNo, Integer pageSize);

	/**
	 * 查询所有角色信息
	 * @return
	 */
	List<Role> selectAllRole();

	List<String> getAuthcMenuName(String roleId);

	/**
	 * 根绝roleId查询对应的权限
	 * 修改人:y
	 * 修改原因:因页面变动,更改此逻辑
	 * @param roleId
	 * @return
	 */
	List<Authc> getAuthcsByRoleId(String roleId);


}
