package com.castlzl.sendmail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(value = "com.castlzl.sendmail.dao")
@EnableSwagger2
public class SendMailApplication {

    public static void main(String[] args) {
        SpringApplication.run(SendMailApplication.class, args);
    }

}
