package com.huaxin.cloud.tms.adl.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * Domain 基类
 * 字段注解分为两部分
 * 1.@Column(name = "XXX_XXX")、@Id、@Transient、@Table、@Entity 整合jpa自动生成字段减少部署运维
 * 2.其余注解为mybatis-plus注解作为数据库映射
 * </p>
 * @author LiuTianci
 * @date 2021-01-04 10:31
 */
@Data
@MappedSuperclass
@ApiModel(description = "Domain 基类")
public class BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false,columnDefinition="bigint(20) COMMENT '主键id'")
    private Long id;

    /**
     * 创建者
     */
    @TableField("create_by")
    @ApiModelProperty(value = "创建者")
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新者
     */
    @TableField("update_by")
    @ApiModelProperty(value = "更新者")
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "update_time")
    private Date updateTime;

    /** 删除标志
     * 	0	有效
     * 	1	无效
     */
    @TableField(value = "delete_flag", select = false)
    @ApiModelProperty(value = "删除标志")
    @Column(name = "delete_flag")
    private Integer deleteFlag = 0;

    /**
     * 备注
     */
    @TableField("remarks")
    @ApiModelProperty(value = "备注 ")
    @Column(name = "remarks")
    private String remarks;
}
