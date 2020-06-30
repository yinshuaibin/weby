package com.y.dao;

import org.apache.ibatis.annotations.Select;

/**
 * @author yinshuaibin
 * @date 2020/6/28 9:21
 */
public interface ControlpeopleMapper {

    @Select("select feature from jh_controlpeople where id = 1")
    String getOne();
}
