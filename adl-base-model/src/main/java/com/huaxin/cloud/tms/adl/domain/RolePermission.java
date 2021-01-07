package com.huaxin.cloud.tms.adl.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * <p>
 *     角色权限关联表
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-06 15:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_role_permission")
@Table(name = "t_role_permission")
public class RolePermission extends BaseDomain{

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "permission_id")
    private Integer permissionId;
}
