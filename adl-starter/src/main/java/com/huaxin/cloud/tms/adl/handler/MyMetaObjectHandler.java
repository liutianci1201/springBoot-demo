package com.huaxin.cloud.tms.adl.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>
 *     处理数据库插入更新时间策略
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-07 8:48
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 填充策略
     * @author Liutianci
     * @date 8:49 2021-01-07
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("create_time", new Date(), metaObject);
        this.setFieldValByName("update_time", new Date(), metaObject);
    }

    /**
     * 更新策略
     * @author Liutianci
     * @date 8:49 2021-01-07
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("update_time", new Date(), metaObject);
    }
}
