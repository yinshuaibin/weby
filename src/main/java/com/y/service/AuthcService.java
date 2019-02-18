package com.y.service;

import com.github.pagehelper.Page;
import com.y.bean.Authc;


public interface AuthcService {

    int insertAuthc(Authc authc);

    int delAuthc(int id);

    int updateAuthc(Authc authc);

    Page<Authc> getAllAuthc(int pageNum, int pageSize);
}
