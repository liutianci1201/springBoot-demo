package com.huaxin.cloud.tms.adl.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * <p>
 *     角色信息
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-05 16:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_role")
@Table(name = "t_role")
public class Role extends BaseDomain{

    @Column(name = "role_name")
    private String roleName;

}
