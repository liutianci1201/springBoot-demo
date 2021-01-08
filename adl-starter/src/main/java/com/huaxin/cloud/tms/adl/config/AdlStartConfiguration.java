package com.huaxin.cloud.tms.adl.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *     启动类注册配置
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-08 12:02
 */
@Configuration
@MapperScan(basePackages = {"com.huaxin.cloud.tms.adl.mapper"})
@ComponentScan(basePackages = {"com.huaxin.cloud.tms.adl.service",
        "com.huaxin.cloud.tms.adl.rest",
        "com.huaxin.cloud.tms.adl.config"})
public class AdlStartConfiguration {
}
