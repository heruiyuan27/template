package com.template.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class Generator {
    public static void main(String[] args) {
        //获取项目所在路径
        String path = System.getProperty("user.dir");
        String url = "jdbc:mysql://localhost:3306/java?useSSL=false";
        String username = "root";
        String password = "123456";
        String table_to_generate = "user";
        // 数据库配置(DataSourceConfig)
        FastAutoGenerator.create(new DataSourceConfig.Builder(url, username, password)
                        .dbQuery(new MySqlQuery()))
                // 全局配置(GlobalConfig)
                .globalConfig(builder -> {
                    builder.author("hry") // 注释作者
                            .commentDate("yyyy-MM-dd hh:mm:ss")//注释日期
                            .dateType(DateType.ONLY_DATE)
                            .enableSpringdoc()
                            .outputDir(path + "/src/main/java")// 指定输出目录
                            .build();
                })
                // 包配置(PackageConfig)
                .packageConfig(builder -> {
                    builder.parent("com.template") // 设置父包名
                            .mapper("dao.mapper")
                            .entity("model.entity")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, path + "/src/main/resources/mapper"))
                            .build(); // 设置mapperXml生成路径;
                })
                // 策略配置(strategyConfig)
                .strategyConfig(builder -> {
                    builder.addInclude(table_to_generate)// 设置需要生成的数据表名
                            .addTablePrefix("t_"); //增加过滤表前缀
                    builder.entityBuilder() // 实体层操作
                            .naming(NamingStrategy.underline_to_camel) //数据库表映射到实体的命名策略.默认下划线转驼峰命名:NamingStrategy.underline_to_camel
                            .enableTableFieldAnnotation() // 开启生成实体时生成字段注解
                            .enableLombok()//开启 lombok 模型
                            .disableSerialVersionUID()
                            .enableFileOverride();  //不实现 Serializable 接口，不生产 SerialVersionUID
                    builder.mapperBuilder()
                            .enableBaseResultMap() // 启用 BaseResultMap生成
                            .enableBaseColumnList()
                            .enableFileOverride(); //启用 BaseColumnList
                    builder.build();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateConfig(builder -> {
                    builder.disable(TemplateType.CONTROLLER)
                            .disable(TemplateType.SERVICE)
                            .disable(TemplateType.SERVICE_IMPL);
                })
                .execute();
    }
}

