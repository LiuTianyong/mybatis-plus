package com.usy.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @PackgeName: com.usy.handler
 * @Author: LiuTianyong
 * Date: 2020/4/19 20:52
 * @Version:
 * @Description:
 */

@Slf4j
@Component  // 将处理器加入ico组件中
public class MyMetaObjectHandler implements MetaObjectHandler {

    // 插入时填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ...");
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    // 更新时填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ...");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }


}
