package com.huaxin.cloud.tms.adl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huaxin.cloud.tms.adl.domain.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *     权限信息交互
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-05 16:48
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
}
