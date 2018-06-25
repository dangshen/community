package com.example.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.example.community.dao.mapper")
@SpringBootApplication
public class CommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
    }
    /*@Bean
    public MapperScannerConfigurer create(){
        MapperScannerConfigurer config = new MapperScannerConfigurer();

        //设置mapper文件的包
        config.setBasePackage("com.example.community.dao.mapper");

        //固定配置
        Properties p = new Properties();
        p.setProperty("mappers","tk.mybatis.mapper.common.Mapper");
        config.setProperties(p);
        return config;
    }*/
}
