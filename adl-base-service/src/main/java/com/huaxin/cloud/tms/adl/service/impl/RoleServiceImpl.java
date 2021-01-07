package com.huaxin.cloud.tms.adl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huaxin.cloud.tms.adl.domain.Role;
import com.huaxin.cloud.tms.adl.mapper.RoleMapper;
import com.huaxin.cloud.tms.adl.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     角色实现
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-05 16:54
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
