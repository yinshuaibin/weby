package com.y.dao.provider;

import org.apache.ibatis.annotations.Param;

public class UserMapperProvider {
	public String findByArea(@Param("areaId") String areaId) {
		StringBuffer sb = new StringBuffer(
				"select r.role_desc,u.* from tb_role r left join tb_user u on r.role_id = u.role_id where u.enabled = 1 AND u.area_id REGEXP");
		sb.append("'^" + areaId + "'");
		return sb.toString();
	}

	public String findCountByArea(@Param("areaId") String areaId) {
		StringBuffer sb = new StringBuffer(
				"select count(*) from tb_role r left join tb_user u on r.role_id = u.role_id where u.enabled = 1 AND u.area_id REGEXP");
		sb.append("'^" + areaId + "'");
		return sb.toString();
	}
}
