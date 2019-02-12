package com.y.config.spring;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * druid数据库连接属性配置
 * @author y;
 * @since 2018/3/26;
 * @version 1.0
 */
@Slf4j
@Configuration
public class DruidConfiguration {

    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }

}
