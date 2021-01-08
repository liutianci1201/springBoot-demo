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
 *     用户
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-05 16:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@TableName("t_user")
@Table(name = "t_user")
public class User extends BaseDomain{

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "role_id")
    private Integer roleId;
}
