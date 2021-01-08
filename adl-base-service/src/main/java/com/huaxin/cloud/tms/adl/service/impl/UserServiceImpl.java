package com.huaxin.cloud.tms.adl.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huaxin.cloud.tms.adl.domain.*;
import com.huaxin.cloud.tms.adl.exception.HuaxinCloudException;
import com.huaxin.cloud.tms.adl.mapper.UserMapper;
import com.huaxin.cloud.tms.adl.service.*;
import com.huaxin.cloud.tms.adl.vo.LoginVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


/**
 * <p>
 *     用户业务实现
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-05 16:52
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RolePermissionService rolePermissionService;

    @Resource
    private PermissionService permissionService;



    @Override
    public LoginVO login(String userName, String password) {
        Subject subject = SecurityUtils.getSubject();
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
            throw new HuaxinCloudException("用户名或密码为空");
        }
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(true);
        subject.login(token);
        LoginVO loginVO = new LoginVO();
        loginVO.setToken(subject.getSession().getId().toString());
        loginVO.setUserName(userName);
        loginVO.setSystemTime(System.currentTimeMillis());
        return loginVO;
    }

    @Override
    public List<Permission> menuList() {
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        if (StringUtils.isEmpty(userName)){
            throw new HuaxinCloudException("获取当前用户失败，请重新登录");
        }
        User user = getOne(Wrappers.lambdaQuery(User.class).eq(User::getUserName, userName), false);
        List<UserRole> roles = userRoleService.list(Wrappers.lambdaQuery(UserRole.class).eq(UserRole::getUserId, user.getId()));
        if (roles.size() == 0){
            throw new HuaxinCloudException("当前用户未分配角色");
        }
        List<RolePermission> rolePermissions = rolePermissionService.list(
                Wrappers.lambdaQuery(RolePermission.class).
                        in(RolePermission::getRoleId,
                                roles.stream().
                                        map(role -> role.getRoleId().toString()).
                                        collect(Collectors.toList())));
        if (rolePermissions.size() == 0){
            throw new HuaxinCloudException("当前用户未分配权限");
        }
        // 非数树型结构
        List<Permission> permissions = permissionService.list(
                Wrappers.lambdaQuery(Permission.class).
                        in(Permission::getId,
                                rolePermissions.stream().
                                        map(rolePermission -> rolePermission.getPermissionId().toString()).
                                        collect(Collectors.toList())));
        // 树型结构
        return permissions.stream().filter(permission -> {
            if (permission.getParentPermissionId() == 0){
                List<Permission> childrenList = permissions.stream().filter(
                        children -> children.getParentPermissionId().equals(permission.getId())).collect(Collectors.toList());
                permission.setChildren(childrenList);
                return true;
            }
            return false;
        }).collect(Collectors.toList());
    }

    @Override
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
