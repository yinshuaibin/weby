package com.y.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.y.bean.regionalNode.RegionalNode;
import com.y.dao.RegionalNodeMapper;
import com.y.service.RegionalNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * y
 * 0515
 */
@Service
public class RegionalNodeServiceImpl implements RegionalNodeService {

    @Autowired
    private RegionalNodeMapper regionalNodeMapper;

    @Override
    public Page<RegionalNode> findRegionalNodeByPage(int pageNum, int pageSize) {
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()-> regionalNodeMapper.findAllNode());
    }

    @Override
    public int insertRegionalNode(RegionalNode regionalNode) {
        return regionalNodeMapper.insertRegionalNode(regionalNode);
    }

    @Override
    public int updateRegionalNode(RegionalNode regionalNode) {
        return regionalNodeMapper.updateRegionalNode(regionalNode);
    }

    @Override
    public int deleteRegionalNode(int id) {
        return regionalNodeMapper.deleteRegionalNode(id);
    }

    /**
     * 获取所有区域节点数据, map返回, 格式:  key: 区域节点id  value: 区域节点实体类
     * @return
     */
    @Override
    public Map<String, RegionalNode> findAllRegionalNode() {
        Map<String, RegionalNode> resultMap = new HashMap<>();
        List<RegionalNode> allNode = regionalNodeMapper.findAllNode();
        if(allNode != null && allNode.size() > 0){
            for(RegionalNode node: allNode){
                resultMap.put(node.getRegionalId(), node);
            }
        }
        return resultMap;
    }

    /**
     * @param regionalId  节点id
     * @param id 主键自增id
     * @return
     */
    @Override
    public int checkoutRegionalNodeId(int id, String regionalId) {
        return regionalNodeMapper.checkoutRegionalNodeId(id, regionalId);
    }
}
