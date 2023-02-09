package com.jxd.orderfood;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName OrderFoodApplication
 * @Description TODO
 * @Author wanglichao
 * @Date 2023/1/28
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.jxd.orderfood.dao")
public class OrderFoodApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderFoodApplication.class);
    }
}
