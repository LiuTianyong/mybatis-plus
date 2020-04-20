package com.usy.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @PackgeName: com.pojo
 * @Author: LiuTianyong
 * Date: 2020/4/14 17:27
 * @Version:
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -62849176196485653L;
    /**
     * 主键ID
     */
    // 加入自增主键，默认为雪花算法
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 邮箱
     */
    private String email;

    /**
     * 乐观锁 版本 version
     */
    @Version    //乐观锁version注解
    private Integer version;

    /**
     * 逻辑删除
     */
    @TableLogic   // 逻辑删除注解
    private Integer deleted;

    private Date createTime;

    private Date updateTime;

}