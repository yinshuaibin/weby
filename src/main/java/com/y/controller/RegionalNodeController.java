package com.y.controller;


import com.y.bean.regionalNode.RegionalNode;
import com.y.controller.base.BaseController;
import com.y.service.RegionalNodeService;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *  y
 *  0515
 */
@RestController
@Slf4j
@RequestMapping("/regional")// 继承了BaseController但是自己类上又有@requestMapping时, 继承类中的会被忽略
public class RegionalNodeController extends BaseController {

    @Autowired
    private RegionalNodeService regionalNodeService;

    @RequestMapping("/findNodeByPage")
    public Map findRegionalNodeByPage(int pageNum, int pageSize) {
        Page<RegionalNode> regionalNodeByPage =  regionalNodeService.findRegionalNodeByPage(pageNum, pageSize);
        Map resultMap = new HashMap();
        resultMap.put("totalNum", regionalNodeByPage.getTotal());
        resultMap.put("resultList", regionalNodeByPage.getResult());
        return resultMap;
    }

    @RequestMapping(value = "/insertNode", method = RequestMethod.POST)
    public int insertRegionalNode(@RequestBody RegionalNode regionalNode) {
        return regionalNodeService.insertRegionalNode(regionalNode);
    }

    @RequestMapping(value = "/updateNode", method = RequestMethod.POST)
    public int updateRegionalNode(@RequestBody RegionalNode regionalNode) {
        return regionalNodeService.updateRegionalNode(regionalNode);
    }

    @RequestMapping("/deleteNode")
    public int deleteRegionalNode(int id) {
        return regionalNodeService.deleteRegionalNode(id);
    }

    @RequestMapping("checkoutRegionalId")
    public int checkoutRegionalId(Integer id, String regionalNodeId){
        if(id == null) id =0;
        return regionalNodeService.checkoutRegionalNodeId(id ,regionalNodeId);
    };

}
