package com.y.dao;


import com.y.bean.regionalNode.RegionalNode;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * y  0515
 */
@Repository
public interface RegionalNodeMapper {

    @Select("select id, regional_name, regional_id,node_server_ip, node_server_port from tb_regional_node")
    List<RegionalNode> findAllNode();

    @Insert("insert into tb_regional_node (regional_name, regional_id,node_server_ip, node_server_port) values (#{regionalName},#{regionalId},#{nodeServerIp},#{nodeServerPort})")
    int insertRegionalNode(RegionalNode regionalNode);

    @Update("update tb_regional_node set regional_name = #{regionalName}, regional_id = #{regionalId} ,node_server_ip = #{nodeServerIp}, node_server_port = #{nodeServerPort} where id = #{id}")
    int updateRegionalNode(RegionalNode regionalNode);

    @Delete("delete from tb_regional_node where id = #{id}")
    int deleteRegionalNode(int id);

    @Select("select count(id) from tb_regional_node where regional_id = #{regionalNodeId} and id != #{id}")
    int checkoutRegionalNodeId(@Param("id") int id, @Param("regionalNodeId") String regionalNodeId);
}
