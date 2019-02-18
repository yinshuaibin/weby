package com.y.controller;

import com.y.controller.base.BaseController;
import com.y.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class RoleController extends BaseController{

	@Autowired
	private RoleService roleService;

}
