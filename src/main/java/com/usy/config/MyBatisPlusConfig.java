package com.usy.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @PackgeName: com.usy.config
 * @Author: LiuTianyong
 * Date: 2020/4/19 21:25
 * @Version:
 * @Description:
 */
@EnableTransactionManagement //事务
@Configuration //配置类
public class MyBatisPlusConfig {

    // 注册乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    // 分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }

    /**
     * 注册 Bean(3.1.1开始不再需要这一步)：
     */
    //    @Bean
    //    public ISqlInjector sqlInjector() {
    //        return new LogicSqlInjector();
    //    }

    /**
     * SQL执行效率插件 3.2.0版本  官方移除该插件 改用其他插件
     */
    //    @Bean
    //    @Profile({"dev","test"})// 设置 dev test 环境开启
    //    public PerformanceInterceptor performanceInterceptor() {
    //        PerformanceInterceptor performanceInterceptor = new PaginationInterceptor();
    //        performanceInterceptor.setMaxTime(1);
    //        performanceInterceptor.setFormat(true);
    //        return new PerformanceInterceptor();
    //    }

}
