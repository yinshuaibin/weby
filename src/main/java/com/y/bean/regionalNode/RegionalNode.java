package com.y.bean.regionalNode;

import lombok.Data;

/**
 * 区域节点实体类   y 0515
 */
@Data
public class RegionalNode {

    private int id;

    /**
     * 节点名称
     */
    private String regionalName;

    /**
     * 节点标识id
     */
    private String regionalId;

    /**
     * 节点服务器ip地址
     */
    private String nodeServerIp;

    /**
     * 节点服务器端口
     */
    private String nodeServerPort;
}
