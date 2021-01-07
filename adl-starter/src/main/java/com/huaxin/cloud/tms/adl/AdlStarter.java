package com.huaxin.cloud.tms.adl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 *     adl启动类
 * </p>
 *
 * @author LiuTianci
 * @date 2020-12-29 14:22
 */
@MapperScan(basePackages = "com.huaxin.cloud.tms.adl.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class AdlStarter {
    public static void main(String[] args) {
        SpringApplication.run(AdlStarter.class, args);
    }
}
