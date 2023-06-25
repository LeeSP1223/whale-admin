package com.lsp;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

/**
 * @Author: Lee.
 * @Description: TODO
 * @DateTime: 2023/6/3 18:20
 **/
public class CodeGennerator {
    public static void main(String[] args) {
        String url = "jdbc:mysql:///whaledb";
        String username = "root";
        String password = "root";
        String moduleName = "system";
        String mapperLocation = "D:\\Code\\项目\\my-project\\vue-admin\\src\\main\\resources\\mapper\\" + moduleName;
        String tables = "whale_user,whale_menu,whale_role,whale_user_role,whale_role_menu";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("Lee.") // 设置作者
                            // .enableSwagger() // 开启 swagger 模式
                            // .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\Code\\项目\\my-project\\vue-admin\\src\\main\\java"); // 指定输出目录
                })
                // .packageConfig(builder -> builder.parent((globalConfig, typeRegistry, metaInfo) -> {
                //     int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                //     if (typeCode == Types.SMALLINT) {
                //         // 自定义类型转换
                //         return DbColumnType.INTEGER;
                //     }
                //     return typeRegistry.getColumnType(metaInfo);
                //
                // }))
                .packageConfig(builder -> {
                    builder.parent("com.lsp") // 设置父包名
                            .moduleName(moduleName) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables) // 设置需要生成的表名
                            .addTablePrefix("whale_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
