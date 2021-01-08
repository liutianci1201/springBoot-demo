package com.huaxin.cloud.tms.adl.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * <p>
 *     权限信息
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-05 16:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@TableName("t_permission")
@Table(name = "t_permission")
public class Permission extends BaseDomain{

    @Column(name = "parent_permission_id")
    private Integer parentPermissionId;


    @Column(name = "permission_name")
    private String permissionName;


    @Column(name = "role_id")
    private Integer roleId;


    @Transient
    private List<Permission> children;
}
