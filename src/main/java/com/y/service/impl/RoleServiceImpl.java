package com.y.service.impl;


import com.y.bean.Authc;
import com.y.bean.Role;
import com.y.dao.AuthcMapper;
import com.y.dao.RoleAuthcMapper;
import com.y.dao.RoleMapper;
import com.y.dao.UserMapper;
import com.y.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/**
 * 修改人:y 修改时间:0724 修改原因:因页面变动,修改后台逻辑 从树-->列表形式,后台手动添加父节点
 * 
 * @author bin
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper roleMapper;
	@Resource
	private RoleAuthcMapper roleAuthcMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private AuthcMapper authcMapper;

	@Override
	public boolean addRole(Role role) {

		return true;
	}

	/**
	 * 修改人:y
	 * 修改原因:因插入角色权限规则改变,修改权限的方法也改变了
	 * 修改日期:0724
	 */
	@Override
	public boolean updateRole(Role role) {
		return true;
	}

	/**
	 * 修改人:y 修改时间:0724 修改原因:删除roleTreeMap
	 */
	@Override
	public boolean deleteRole(String roleId) {
		return true;
	}

	@Override
	public List<Role> getRoleByPage(Integer pageNo, Integer pageSize) {
		return null;
	}

	@Override
	public int selectCount() {
		return 0;
	}

	@Override
	public Role selectByRoleName(String roleName) {
		return  null;
	}

	@Override
	public List<Role> selectAllRole() {
		return null;
	}

	/**
	 * 根据roleId查询对应的authc里页面跳转路径的名称
	 */
	@Override
	public List<String> getAuthcMenuName(String roleId) {
		return null;
	}

	/**
	 * 根绝roleId查询对应的权限
	 * 修改人:y
	 * 修改原因:因页面变动,更改此逻辑
	 * @param roleId
	 * @return
	 */
	@Override
	public List<Authc> getAuthcsByRoleId(String roleId) {
		return  null;
	}
}
