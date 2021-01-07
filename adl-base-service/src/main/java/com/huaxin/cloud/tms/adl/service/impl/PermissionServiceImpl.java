package com.huaxin.cloud.tms.adl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huaxin.cloud.tms.adl.domain.Permission;
import com.huaxin.cloud.tms.adl.mapper.PermissionMapper;
import com.huaxin.cloud.tms.adl.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     权限业务实现
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-05 16:56
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
}
