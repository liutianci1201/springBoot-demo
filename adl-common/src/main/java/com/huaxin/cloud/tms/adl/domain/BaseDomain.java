package com.huaxin.cloud.tms.adl.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *     Domain 基类
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-04 10:31
 */
@Data
@ApiModel(description = "Domain 基类")
public class BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 创建者
     */
    @TableField("create_by")
    @ApiModelProperty(value = "创建者")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新者
     */
    @TableField("update_by")
    @ApiModelProperty(value = "更新者")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField("update_time")
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    /** 删除标志
     * 	0	有效
     * 	1	无效
     */
    @TableField(value = "delete_flag", select = false)
    @ApiModelProperty(value = "删除标志")
    private Integer deleteFlag = 0;

    /**
     * 备注
     */
    @TableField("remarks")
    @ApiModelProperty(value = "备注 ")
    private String remarks;
}
