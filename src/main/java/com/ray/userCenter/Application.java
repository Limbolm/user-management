package com.ray.userCenter;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import javax.sql.DataSource;

/**
 * 程序启动入口
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.ray.userCenter.*"})
@MapperScan("com.ray.userCenter.mapper")
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
