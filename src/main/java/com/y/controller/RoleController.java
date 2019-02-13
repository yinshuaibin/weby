package com.y.controller;

import com.y.bean.Authc;
import com.y.bean.Role;
import com.y.controller.base.BaseController;
import com.y.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
public class RoleController extends BaseController{

	@Resource
	private RoleService roleService;

	@RequestMapping(value = "/roler", method = RequestMethod.GET)
	public List<Role> read(HttpServletRequest req) {
		List<Role> roleList = roleService.selectAllRole();
		return roleList;
	}

	@RequestMapping(value = "/getRoleByPage")
	public List<Role> getRoleByPage(@RequestParam(value = "pageNo") Integer pageNo,
			@RequestParam(value = "pageSize") Integer pageSize, HttpServletRequest req) {
		List<Role> roleList = roleService.getRoleByPage(pageNo, pageSize);
		return roleList;
	}

	/**
	 * 查询符合登录的用户的角色权限内的条数
	 */
	@RequestMapping(value = "/roleCount", method = RequestMethod.GET)
	public int roleCount() {
		int count = roleService.selectCount();
		return count;
	}

	@RequestMapping(value = "/role/authcTree", method = RequestMethod.GET)
	public List<Authc> authcTree(String roleId) {
		return roleService.getAuthcsByRoleId(roleId);
	}


	@RequestMapping(value = "roleAdd", method = RequestMethod.POST)
	public boolean roleAdd(@RequestBody Role role) {
		// 查询输入roleName是否存在 （不存在则添加role）
		Role roleName = roleService.selectByRoleName(role.getRoleName());
		if (null == roleName) {
			return roleService.addRole(role);
		}
		return false;
	}


	@RequestMapping(value = "/delRole/{roleId}", method = RequestMethod.DELETE)
	public boolean roleDelete(@PathVariable("roleId") String roleId) {
		return roleService.deleteRole(roleId);
	}


	@RequestMapping(value = "/roleUpdate", method = RequestMethod.POST)
	public boolean roleUpdate(@RequestBody Role role) {
		return roleService.updateRole(role);
	}

	@RequestMapping(value = "/getAuthcMenuName")
	public List<String> getAuthcMenuName(String roleId) {
		return roleService.getAuthcMenuName(roleId);
	}
}
