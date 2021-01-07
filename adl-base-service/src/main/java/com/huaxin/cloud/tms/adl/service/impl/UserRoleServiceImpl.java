package com.huaxin.cloud.tms.adl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huaxin.cloud.tms.adl.domain.UserRole;
import com.huaxin.cloud.tms.adl.mapper.UserRoleMapper;
import com.huaxin.cloud.tms.adl.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     用户角色业务
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-06 15:10
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
}
