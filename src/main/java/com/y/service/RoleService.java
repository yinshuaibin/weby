package com.y.service;


import com.github.pagehelper.Page;
import com.y.bean.Role;

import java.util.List;

public interface RoleService {

	Page<Role> getAllRole(int pageNum,int pageSize);


	int insertRole(Role role);


	int updateRole(Role role);


	int delRole(int id);

}
