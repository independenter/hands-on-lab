package com.dbapp.core;

import com.alibaba.fastjson.parser.ParserConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.dbapp.core.mapper"})
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class);
        ParserConfig.getGlobalInstance().setSafeMode(true);
    }
}
