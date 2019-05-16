package com.y.service;

import com.github.pagehelper.Page;
import com.y.bean.regionalNode.RegionalNode;

import java.util.Map;

/**
 * y
 * 0515
 */
public interface RegionalNodeService {

    Page<RegionalNode> findRegionalNodeByPage(int pageNum, int pageSize);

    int insertRegionalNode(RegionalNode regionalNode);

    int updateRegionalNode(RegionalNode regionalNode);

    int deleteRegionalNode(int id);

    /**
     * 获取所有区域节点数据, map返回, 格式:  key: 区域节点id  value: 区域节点实体类
     * @return
     */
    Map<String, RegionalNode> findAllRegionalNode();

    /**
     * 根据主键id以及节点id校验此id是否重复
     * @param regionalId  节点id
     * @param id 主键自增id
     * @return
     */
    int checkoutRegionalNodeId(int id, String regionalId);
}
