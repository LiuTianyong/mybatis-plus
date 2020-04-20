package com.usy;

/**
 * @PackgeName: com.usy
 * @Author: LiuTianyong
 * Date: 2020/4/20 10:44
 * @Version:
 * @Description:
 */

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * 代码生成器
 */
public class UsyCode {
    public static void main(String[] args) {
        // 构建一个代码生成器对象
        AutoGenerator autoGenerator = new AutoGenerator();
        // 配置策略

        // 1.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java");      //生成路径
        globalConfig.setAuthor("LiuTianyong");      // 作者
        globalConfig.setOpen(false);        // 是否打开资源管理器
        globalConfig.setFileOverride(false);        // 是否覆盖
        globalConfig.setServiceName("%sService");       // 生成service 去除I的前缀
        globalConfig.setIdType(IdType.AUTO);
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setSwagger2(true);
        // 将全局配置放入生成器
        autoGenerator.setGlobalConfig(globalConfig);

        // 2.设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/lianxi?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("xiaoyuv587..");
        dataSourceConfig.setDbType(DbType.MYSQL);
        // 将数据源配置放入 代码生成器
        autoGenerator.setDataSource(dataSourceConfig);

        // 3.配置生成包
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName("blog");
        packageConfig.setParent("com.usy");

        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setController("controller");

        // 将包配置给生成器
        autoGenerator.setPackageInfo(packageConfig);

        // 4.策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("user");        // 映射表名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //  strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);            // 支持lombok
        strategy.setRestControllerStyle(true);          //  支持链式编程

        // 自动填充
        strategy.setLogicDeleteFieldName("deleted");    // 逻辑删除字段
        TableFill gmtCreate = new TableFill("gmt_create",FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified",FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);

        // 乐观锁配置
        strategy.setVersionFieldName("version");

        // 驼峰命名
        strategy.setRestControllerStyle(true);      // restController 风格
        strategy.setControllerMappingHyphenStyle(true);     // 如 localhost:8080/hello_id_2

        autoGenerator.setStrategy(strategy);
        // 执行
        autoGenerator.execute();
    }
}
