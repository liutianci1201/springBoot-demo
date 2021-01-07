package com.huaxin.cloud.tms.adl.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 *     shiro 配置
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-07 10:16
 */
@Slf4j
@Component
public class ShiroConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;


    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/login.do", "anon");
        filterChainDefinitionMap.put("/menu.do", "anon");
        filterChainDefinitionMap.put("/function.do", "anon");
        filterChainDefinitionMap.put("/bill/checkPrintHYReport.do", "anon");
        filterChainDefinitionMap.put("/bill/printHYReport.do", "anon");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/deliveryOrderPick/PickOrderSap.do", "anon");
        filterChainDefinitionMap.put("/ztLines/getZtlinesByType", "anon");
        filterChainDefinitionMap.put("/outnumInfo/getOutNumAndFactory", "anon");
        filterChainDefinitionMap.put("/bill/getBillByCardNo", "anon");
        filterChainDefinitionMap.put("/bill/getTruckPost.do", "anon");

        filterChainDefinitionMap.put("/websocket/**", "anon");
        // 称重等消息推送
        filterChainDefinitionMap.put("/websocketMsg/**", "anon");
        // 自动称重
        filterChainDefinitionMap.put("/autoPound/**", "anon");
        // 硬件刷卡
        filterChainDefinitionMap.put("/make/**", "anon");
        // 硬件刷卡
        filterChainDefinitionMap.put("/ztLines/**", "anon");
        // 硬件刷卡
        filterChainDefinitionMap.put("/ztTrucksInfo/**", "anon");
        // 硬件刷卡
        filterChainDefinitionMap.put("/hardware/**", "anon");
        // tms查询接口
        filterChainDefinitionMap.put("/tms/**", "anon");

        filterChainDefinitionMap.put("/poundRoomInquiry/**", "anon");
        filterChainDefinitionMap.put("/print/**", "anon");
        filterChainDefinitionMap.put("/selfHelpMachine/**", "anon");

        // 文件访问
        filterChainDefinitionMap.put("/static/image/**", "anon");

        //swagger2免拦截
        filterChainDefinitionMap.put("/swagger-ui.html**", "anon");
        filterChainDefinitionMap.put("/v2/api-docs", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");

        // 过滤链定义，从上向下顺序执行，一般将*放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        // authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "authc");
        filterChainDefinitionMap.put("/todo/**", "anon");

        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/toIndex.do");
        //未授权界面;
        shiroFilterFactoryBean.setLoginUrl("/un_auth");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm());
        securityManager.setCacheManager(cacheManager());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean
    public MyRealm myRealm() {
        return new MyRealm();
    }

    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }


    @Bean
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setTimeout(timeout);
        return redisManager;
    }

    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new MySessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        return sessionManager;
    }

    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        return hashedCredentialsMatcher;
    }

}
