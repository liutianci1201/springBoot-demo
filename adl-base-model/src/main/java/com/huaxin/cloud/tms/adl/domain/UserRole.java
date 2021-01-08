package com.huaxin.cloud.tms.adl.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 *     用户角色关联表
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-06 15:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@TableName("t_user_role")
@Table(name = "t_user_role")
public class UserRole extends BaseDomain{

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "user_id")
    private Integer userId;

}
