package com.huaxin.cloud.tms.adl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *     登录接口返回视图对象包装
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-07 15:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {

    private String token;

    private String userName;

    private Long systemTime;

}
