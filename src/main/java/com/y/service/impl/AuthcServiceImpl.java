package com.y.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.y.bean.Authc;
import com.y.dao.AuthcMapper;
import com.y.service.AuthcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthcServiceImpl implements AuthcService {

    @Autowired
    private AuthcMapper authcMapper;

    @Override
    public int insertAuthc(Authc authc) {
        return authcMapper.insertAuthc(authc);
    }

    @Override
    public int delAuthc(int id) {
        return authcMapper.delAuthc(id);
    }

    @Override
    public int updateAuthc(Authc authc) {
        return authcMapper.updateAuthc(authc);
    }

    @Override
    public Page<Authc> getAllAuthc(int pageNum,int pageSize) {
        return PageHelper.startPage(pageNum,pageSize).doSelectPage(authcMapper::getAllAuthc);
    }
}
