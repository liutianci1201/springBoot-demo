package com.huaxin.cloud.tms.adl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huaxin.cloud.tms.adl.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *     用户交互
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-05 16:46
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
