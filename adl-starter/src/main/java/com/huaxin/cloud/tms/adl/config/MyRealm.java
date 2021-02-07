package com.huaxin.cloud.tms.adl.config;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.huaxin.cloud.tms.adl.domain.RolePermission;
import com.huaxin.cloud.tms.adl.domain.User;
import com.huaxin.cloud.tms.adl.domain.UserRole;
import com.huaxin.cloud.tms.adl.service.RolePermissionService;
import com.huaxin.cloud.tms.adl.service.UserRoleService;
import com.huaxin.cloud.tms.adl.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *     自定义realm
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-05 16:31
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RolePermissionService rolePermissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取用户名
        User user = (User) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 给该用户设置角色，角色信息存在 t_role 表中取
        List<UserRole> userRoleList = userRoleService.
                list(Wrappers.lambdaQuery(UserRole.class).
                        eq(UserRole::getUserId, user.getId())
                );
        authorizationInfo.addRoles(userRoleList.
                stream().
                map(userRole -> userRole.getRoleId().toString()).
                collect(Collectors.toList())
        );
        for (UserRole userRole : userRoleList){
            List<RolePermission> rolePermissionList = rolePermissionService.list(Wrappers.lambdaQuery(RolePermission.class).
                    eq(RolePermission::getRoleId, userRole.getRoleId())
            );
            authorizationInfo.addStringPermissions(rolePermissionList.stream().
                    map(rolePermission -> rolePermission.getPermissionId().toString()).collect(Collectors.toList())
            );
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 根据 Token 获取用户名，如果您不知道该 Token 怎么来的，先可以不管，下文会解释
        String username = (String) token.getPrincipal();
        // 根据用户名从数据库中查询该用户
        User user = userService.getOne(Wrappers.lambdaQuery(User.class).eq(User::getUserName, username), false);
        if(user != null) {
            // 把当前用户存到 Session 中
            SecurityUtils.getSubject().getSession().setAttribute("user", user);
            // 传入用户名和密码进行身份认证，并返回认证信息
            return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), "myRealm");
        } else {
            return null;
        }
    }
}
