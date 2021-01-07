package com.huaxin.cloud.tms.adl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huaxin.cloud.tms.adl.domain.Permission;
import com.huaxin.cloud.tms.adl.domain.User;
import com.huaxin.cloud.tms.adl.vo.LoginVO;

import java.util.List;

/**
 * <p>
 *     用户业务
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-05 16:49
 */
public interface UserService extends IService<User> {

    /**
     * 登录接口
     * @author Liutianci
     * @date 15:11 2021-01-07
     * @param userName 用户名
     * @param password 密码
     * @return 视图对象
     */
    LoginVO login(String userName, String password);


    /**
     * 获取用户的所有权限
     * @author Liutianci
     * @date 16:09 2021-01-07
     * @return 权限集合
     */
    List<Permission> menuList();

    /**
     * 登出
     * @author Liutianci
     * @date 16:09 2021-01-07
     */
    void logout();
}
