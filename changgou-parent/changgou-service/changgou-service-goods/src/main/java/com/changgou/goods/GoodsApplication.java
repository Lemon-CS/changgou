package com.changgou.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * description: GoodsApplication <br>
 * date: 2020/3/3 8:22 下午 <br>
 * author: fangpeng <br>
 * version: 1.0 <br>
 */
@SpringBootApplication
@EnableEurekaClient  // 开启Eureka客户端
@MapperScan(basePackages = {"com.changgou.goods.dao"}) // 开启tk的Mapper包扫描
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }

}
