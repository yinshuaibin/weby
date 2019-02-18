package com.y.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.y.bean.Authc;
import com.y.bean.Role;
import com.y.dao.RoleAuthcMapper;
import com.y.dao.RoleMapper;
import com.y.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * 修改人:y 修改时间:0724 修改原因:因页面变动,修改后台逻辑 从树-->列表形式,后台手动添加父节点
 * 
 * @author bin
 *
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper roleMapper;
	@Resource
	private RoleAuthcMapper roleAuthcMapper;

	@Override
	public Page<Role> getAllRole(int pageNum,int pageSize) {
		return PageHelper.startPage(pageNum,pageSize).doSelectPage(roleMapper::getAllRole);
	}

	@Override
	public int insertRole(Role role) {
		List<Integer> ids = new ArrayList<>();
		for (Authc authc:role.getAuthcs()){
			ids.add(authc.getAuthcId());
		}
		roleAuthcMapper.insertAuthorityIds(ids,role.getRoleId());
		return roleMapper.insertRole(role);
	}

	@Override
	public int updateRole(Role role) {
		roleAuthcMapper.deleteByRoleId(role.getRoleId());
		List<Integer> ids = new ArrayList<>();
		for (Authc authc:role.getAuthcs()){
			ids.add(authc.getAuthcId());
		}
		roleAuthcMapper.insertAuthorityIds(ids,role.getRoleId());
		return roleMapper.updateRole(role);
	}

	@Override
	public int delRole(int id) {
		roleAuthcMapper.deleteByRoleId(id);
		return roleMapper.delRole(id);
	}
}
